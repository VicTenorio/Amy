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
        private readonly Authenticated authentication;

        public LoginController(AmyDataContext context, HttpContextAccessor processor)
        {
            _context = context;
            authentication = new Authenticated(processor);
        }
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult doLogin(LoginFormModel credentials)
        {
            if(string.IsNullOrEmpty(credentials.Email) || string.IsNullOrEmpty(credentials.Password))
            {
                ViewBag["autenticated"] = false;
                return View();
            }

            using (MD5 md5Hash = MD5.Create())
            {
                credentials.Password = Encrypt.GetMd5Hash(md5Hash, credentials.Password);
            };

            var user = _context.Usuario.Where(x => string.Equals(x.Email, credentials.Email) && string.Equals (x.Password, credentials.Password)).FirstOrDefault();

            if(user != null)
            {
                authentication.SetSession((User)user);
            }
            else
            {
                ViewBag["autenticated"] = false;
                return View();
            }

            return View();

        }
    }
}