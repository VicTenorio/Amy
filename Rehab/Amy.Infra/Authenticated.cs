using Amy.Model;
using Microsoft.AspNetCore.Http;
using Newtonsoft.Json;
using System.Text;

namespace Amy.Infra
{
    [System.AttributeUsage(System.AttributeTargets.Class |
                       System.AttributeTargets.Struct)]
    public class Authenticated : System.Attribute
    {
        private readonly IHttpContextAccessor _httpContextAccessor;
        private ISession _session => _httpContextAccessor.HttpContext.Session;

        public Authenticated(IHttpContextAccessor httpContextAccessor)
        {
            _httpContextAccessor = httpContextAccessor;
        }

        public void SetSession(User user)
        {
            _httpContextAccessor.HttpContext.Session.Set("userData", Encoding.ASCII.GetBytes(JsonConvert.SerializeObject(user)));
        }

        public User GetSession()
        {
            User user = null;
            byte[] userBinary;

            _httpContextAccessor.HttpContext.Session.TryGetValue("userData",out userBinary);

            if(userBinary != null)
            {
                string jsonUser = Encoding.ASCII.GetString(userBinary);
                user = JsonConvert.DeserializeObject<User>(jsonUser);
            }

            return user;
        }
    }
}
