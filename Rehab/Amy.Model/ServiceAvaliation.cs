using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Amy.Model
{
    [Table("avaliacao_servico")]
    public class ServiceAvaliation
    {
        [Key]
        [Column("id_avaliacao_servico")]
        public int IdServiceAvaliation { get; set; }

        [Column("id_contrato")]
        public int IdContract { get; set; }

        [Column("id_servico")]
        public int IdService { get; set; }

        [Column("id_usuario_avaliador")]
        public int IdUserAvaliator { get; set; }

        [Column("avaliacao")]
        public Double Avaliation { get; set; }

        [Column("data_avaliacao")]
        [DataType(DataType.DateTime)]
        public DateTime AvaliationDate { get; set; }

    }
}
