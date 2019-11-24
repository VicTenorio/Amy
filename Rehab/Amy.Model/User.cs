using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Amy.Model
{
    [Table("Usuario")]
    public class User
    {
        [Column("id_usuario")]
        public int Id { get; set; }  
        
        [Column("nome")]
        public string Name { get; set; }

        [Column("email")]
        public string Email { get; set; }
        [Column("cpf_cnpj")]
        public string cpfCnpj { get; set; }

        [Column("RG")]
        public string RG { get; set; }

        [Column("telefone")]
        public string Phone { get; set; }

        [Column("senha")]
        public string Password { get; set; }

        [Column("prestador")]
        public bool Provider { get; set; }

        [Column("sexo")]
        public char Sex { get; set; }

        [Column("estado_civil")]
        public string MaritalStatus { get; set; }

        [Column("data_nascimento")]
        [DataType(DataType.Date)]
        public DateTime BirthDay { get; set; }
    }
}
