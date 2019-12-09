using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Amy.Model
{
    [Table("contrato")]
    public class Contract
    {
        [Key]
        [Column("id_contrato")]
        public int Id { get; set; }

        [Column("id_servico")]
        public int? IdService { get; set; }

        [Column("id_endereco")]
        public int? IdAdress { get; set; }

        [Column("id_Usuario_prestador")]
        public int IdProvider { get; set; }

        [Column("id_Usuario_consumidor")]
        public int IdConsumer { get; set; }

        [Column("id_demanda")]
        public int? IdNeed { get; set; }
    }
}
