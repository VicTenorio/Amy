using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Amy.Core.Data;
using Amy.Infra;
using Amy.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Rehab.Models;

namespace Rehab.Controllers
{
    public class HomeController : Controller
    {
        private readonly Authenticated _authentication;
        private readonly AmyDataContext _context;

        public HomeController(AmyDataContext context, IHttpContextAccessor processor)
        {
            _authentication = new Authenticated(processor);
            _context = context;
        }
        public IActionResult Index()
        {
            if (_authentication.GetSession() != null)
            {
                List<UserDocumentImageViewModel> imagesView = new List<UserDocumentImageViewModel>();

                var imagesToBeEvalueted = _context.Imagens.Where(x => !x.Evaluated).OrderBy(x => x.UploadedDate);                

                foreach (UserDocumentImage image in imagesToBeEvalueted)
                {
                    var imageOwner = _context.Usuario.Find(image.IdUser);

                    imagesView.Add(
                        new UserDocumentImageViewModel()
                        {
                            Id = image.Id,
                            IdUser = image.IdUser,
                            UploadedDate = image.UploadedDate,
                            EvaluatedDate = image.EvaluatedDate,
                            Evaluated = image.Evaluated,
                            Image = ImageFileReading.GetImageFile(image.ImageURL),
                            User = new UserViewModel()
                            {
                                Id = imageOwner.Id,
                                Name = imageOwner.Name,
                                Email = imageOwner.Email,
                                cpfCnpj = imageOwner.cpfCnpj,
                                RG = imageOwner.RG,
                                Phone = imageOwner.Phone,
                                Provider = imageOwner.Provider,
                                Sex = imageOwner.Sex,
                                MaritalStatus = imageOwner.MaritalStatus,
                                BirthDay = imageOwner.BirthDay
                            }
                        }
                        ); 
                }

                HomeViewModel model = new HomeViewModel(imagesView, _authentication.GetSession().Name);
                return View(model);
            }
            else
            {
                return Redirect("./Login");
            }

        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }

        [HttpPost]
        [Route("/AproveProvider")]
        public async Task<JsonResult> AproveProvider([FromBody] string id)
        {
            int idNumeber = int.Parse(id);

            var image = _context.Imagens.Find(idNumeber);

            if(image != null)
            {
                image.Evaluated = true;
                image.EvaluatedDate = DateTime.Now;

                var user = _context.Usuario.Find(image.IdUser);

                user.Provider = true;

                _context.Update(image);
                _context.Update(user);

                try
                {
                    await _context.SaveChangesAsync();
                    return new JsonResult((new ServiceResponce<bool>(200, "Prestador Aprovado com Sucesso", true))) { StatusCode = 200};
                }catch(Exception ex)
                {
                    return new JsonResult(new ServiceResponce<bool>(500, "Não foi possivel aprovar", false));
                }
            }

            return new JsonResult(new ServiceResponce<bool>(401, "Não foi localizado prestador", false));

        }

        [HttpPost]
        [Route("/NegateProvider")]
        public async Task<JsonResult> NegateProvider([FromBody] string id)
        {
            var image = _context.Imagens.Find(id);

            if (image != null)
            {
                image.Evaluated = true;
                image.EvaluatedDate = DateTime.Now;

                var user = _context.Usuario.Find(image.IdUser);

                user.Provider = false;

                _context.Update(image);
                _context.Update(user);

                try
                {
                    await _context.SaveChangesAsync();
                    return new JsonResult(new ServiceResponce<bool>(200, "Prestador Regeitado com Sucesso", true));
                }
                catch (Exception ex)
                {
                    return new JsonResult(new ServiceResponce<bool>(500, "Não foi possivel regeitar", false));
                }
            }

            return new JsonResult(new ServiceResponce<bool>(401, "Não foi localizado prestador", false));
        }
    }
}
