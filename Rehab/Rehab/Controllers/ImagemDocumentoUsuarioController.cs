using System;
using System.Threading.Tasks;
using Amy.Core.Data;
using Amy.Infra;
using Amy.Model;
using Microsoft.AspNetCore.Mvc;
using Rehab.Models;

namespace Rehab.Controllers
{
    public class ImagemDocumentoUsuarioController : Controller
    {
        private readonly AmyDataContext _context;
        public ImagemDocumentoUsuarioController(AmyDataContext context)
        {
            _context = context;
        }

        [HttpPost]
        [Route("api/document")]
        public async Task<ActionResult<ServiceResponce<UserDocumentImageFormModel>>> PostUserDocumentImage([FromBody]UserDocumentImageFormModel image)
        {
            var user = _context.Usuario.Find(image.iduser);

            if(user == null)
            {
                return new ServiceResponce<UserDocumentImageFormModel>(401, "Usuario Não Existe", null);
            }
            else
            {
                UserDocumentImage newImage = new UserDocumentImage()
                {
                    ImageURL = ImageFileReading.SaveImageFile(image.imagem, user.Id),
                    IdUser = user.Id,
                    Evaluated = false,
                    UploadedDate = DateTime.Now
                };

                _context.Add(newImage);

                try
                {
                    await _context.SaveChangesAsync();
                }
                catch (Exception ex)
                {
                    return new ServiceResponce<UserDocumentImageFormModel>(500, ex.Message, null);
                }
                image.id = newImage.Id;

                return new ServiceResponce<UserDocumentImageFormModel>(200, "Created", image);
            }            
        }
    }
}
