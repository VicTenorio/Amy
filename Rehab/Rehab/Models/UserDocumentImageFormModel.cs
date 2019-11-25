namespace Rehab.Models
{
    public class UserDocumentImageFormModel
    {
        public int id { get; set; }
        public int iduser { get; set; }
        public byte[] imagem { get; set; }
               
        public UserDocumentImageFormModel(byte[] imagem, int idUser, int id)
        {
            this.imagem = imagem;
            this.iduser = idUser;
            this.id = id;
        }

        public UserDocumentImageFormModel(byte[] imagem, int idUser)
        {
            this.imagem = imagem;
            this.iduser = idUser;
        }

        public UserDocumentImageFormModel()
        {
        }
    }
}
