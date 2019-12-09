using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text;

namespace Amy.Model
{
    [Table("amy_usuario")]
    public class AmyUser
    {
        [Column("id_amy_usuario")]
        public int Id { get; set; }

        [Column("nome")]
        public string Name { get; set; }

        [Column("email")]
        public string Email { get; set; }

        [Column("telefone")]
        public string Phone { get; set; }

        [Column("senha")]
        public string Password { get; set; }

        [Column("sexo")]
        public char Sex { get; set; }
    }
}
