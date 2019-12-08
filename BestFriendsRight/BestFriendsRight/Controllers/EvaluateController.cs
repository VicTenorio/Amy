using System;
using System.Threading.Tasks;
using Amy.Core.Data;
using Amy.Model;
using BestFriendsRight.ModelView;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace BestFriendsRight.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EvaluateController : ControllerBase
    {
        private readonly AmyDataContext _context;

        public EvaluateController(AmyDataContext context)
        {
            this._context = context;
        }

        [HttpPost]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]

        public async Task<IActionResult> AvaliarServico([FromBody]ServiceAvaliationModel avaliacao)
        {

            if(avaliacao.Avaliacao < 0 || avaliacao.IdContrato < 0 || avaliacao.IdContrato < 0)
            {
                return BadRequest("Informe Todos os dados necessarios");
            }
            else
            {
                ServiceAvaliation avaliation = new ServiceAvaliation();

                avaliation.IdContract = avaliacao.IdContrato;
                avaliation.IdUserAvaliator = avaliacao.IdAvaliador;
                avaliation.Avaliation = avaliacao.Avaliacao;
                avaliation.AvaliationDate = DateTime.Now;

                _context.Avaliations.Add(avaliation);
                await _context.SaveChangesAsync();

                return Ok("Avaliado com Sucesso");
            }


        }
    }
}