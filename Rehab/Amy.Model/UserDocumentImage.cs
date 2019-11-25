using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text;

namespace Amy.Model
{
    [Table("Imagem_Documento_Usuario")]
    public class UserDocumentImage
    {
        [Column("id_imagem_documento_usuario")]
        public int Id { get; set; }

        [Column("id_usuario")]
        public int IdUser { get; set; }

        [Column("imagem_url")]
        public string ImageURL { get; set; }

        [Column("data_upload")]
        [DataType(DataType.Date)]
        public DateTime UploadedDate { get; set; }

        [Column("data_avaliacao")]
        [DataType(DataType.Date)]
        public DateTime? EvaluatedDate { get; set; }

        [Column("avaidado")]
        public bool Evaluated { get; set; }


    }
}
