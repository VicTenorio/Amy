using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Amy.Model
{
    [Table("contrato")]
    public class Contract
    {
        [Key]
        [Column("id_contrato")]
        public int IdContract { get; set; }

        [Column("id_usuario_consumidor")]
        public int IdUserConsumer { get; set; }

        [Column("id_usuario_prestador")]
        public int IdUserProvider { get; set; }
    }
}
