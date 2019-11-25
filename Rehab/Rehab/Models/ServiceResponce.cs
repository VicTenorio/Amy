using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Rehab.Models
{
    public class ServiceResponce<T>
    {
        public int Status { get; set; }

        public string Menssage { get; set; }

        public T Data { get; set; }

        public ServiceResponce(int Status, string Message,T Data)
        {
            this.Status = Status;
            this.Menssage = Menssage;
            this.Data = Data;
        }
    }
}
