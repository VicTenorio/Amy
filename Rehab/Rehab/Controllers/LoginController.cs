using System.Linq;
using System.Security.Cryptography;
using Amy.Core.Data;
using Amy.Infra;
using Amy.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Rehab.Models;

namespace Rehab.Controllers
{
    public class LoginController : Controller
    {
        private readonly AmyDataContext _context;
        private readonly Authenticated _authentication;

        public LoginController(AmyDataContext context, IHttpContextAccessor processor)
        {
            _context = context;
            _authentication = new Authenticated(processor);
        }
        public IActionResult Index()
        {
            return View();
        }

        private IActionResult Index(LoginFormModel credentials)
        {
            return View("../Login", credentials);
        }

        public IActionResult doLogin(LoginFormModel credentials)
        {
            if(string.IsNullOrEmpty(credentials.Email) || string.IsNullOrEmpty(credentials.Password))
            {                
                return Index(credentials);
            }

            using (MD5 md5Hash = MD5.Create())
            {
                credentials.Password = Encrypt.GetMd5Hash(md5Hash, credentials.Password);
            };

            var user = _context.Usuario.Where(x => string.Equals(x.Email, credentials.Email) && string.Equals (x.Password, credentials.Password)).FirstOrDefault();

            if(user != null)
            {
                _authentication.SetSession((User)user);
                return Redirect("../Home");

            }
            else
            {               
                return Index(credentials);
            }


        }
    }
}