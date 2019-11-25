using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Rehab.Models
{
    public class UserViewModel
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }
        public string cpfCnpj { get; set; }
        public string RG { get; set; }
        public string Phone { get; set; }
        public bool Provider { get; set; }
        public char Sex { get; set; }
        public string MaritalStatus { get; set; }
        public DateTime BirthDay { get; set; }
    }
}
