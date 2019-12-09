using Amy.Model;
using Microsoft.EntityFrameworkCore;

namespace Amy.Core.Data
{
    public class AmyDataContext : DbContext
    {
        public AmyDataContext(DbContextOptions<AmyDataContext> options)
            : base(options)
        {

        }

        public DbSet<User> Usuario { get; set; }

        public DbSet<UserDocumentImage> Imagens {get;set;}

        public DbSet<AmyUser> SystemUsers { get; set; }
    }
}
