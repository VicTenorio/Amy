using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Amy.Infra
{
    public class ImageFileReading
    {
        public static byte[] GetImageFile(string URL)
        {
            Byte[] bytes = File.ReadAllBytes(URL);
            return bytes;
        }

        public static string SaveImageFile(byte[] image,int userId)
        {
            Byte[] bytes = image;//Convert.FromBase64String(image);

            string fileName = FileFolders.IMAGE_DOCUMENT_FOLDER + (DateTime.UtcNow.ToString().Replace("/","-").Replace(":", ".").Replace(" ","")) + "-" + userId + ".png";
            
            File.WriteAllBytes(fileName, bytes);

            return fileName;
        }
    }
}
