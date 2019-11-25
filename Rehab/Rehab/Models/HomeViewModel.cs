using System.Collections.Generic;

namespace Rehab.Models
{
    public class HomeViewModel
    {
        public string userName { get; set; }

        public List<UserDocumentImageViewModel> imagesToBeEvalueted { get; set; }

        public HomeViewModel(List<UserDocumentImageViewModel> imagesToBeEvalueted1, string name)
        {
            this.imagesToBeEvalueted = imagesToBeEvalueted1;
            this.userName = name;
        }

 
    }
}
