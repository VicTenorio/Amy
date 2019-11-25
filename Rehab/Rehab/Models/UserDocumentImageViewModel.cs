using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Rehab.Models
{
    public class UserDocumentImageViewModel
    {
        public int Id { get; set; }

        public int IdUser { get; set; }

        public DateTime UploadedDate { get; set; }

        public DateTime? EvaluatedDate { get; set; }

        public bool Evaluated { get; set; }

        public byte[] Image { get; set; }

        public UserViewModel User { get; set;}
    }
}
