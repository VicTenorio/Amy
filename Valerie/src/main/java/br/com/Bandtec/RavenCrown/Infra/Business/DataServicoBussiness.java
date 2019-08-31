package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Web.Model.DataServicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class DataServicoBussiness {

    @Autowired
    ServicoBussiness servicoBussiness;


    public boolean ValidateDate(DataServicoModel data) {
        boolean available = true;

        ServicoEntity servico = servicoBussiness.getById(data.getidServico());

        for (DataServicoEntity x : servico.getDatas()) {
            if (x.getDtAgendamento() != (data.getDtAgendamento())) {
                if (x.getDtAgendamento().getDayOfMonth() == data.getDtAgendamento().getDayOfMonth()) {

                    if(data.getDtAgendamento().getHour() > x.getDtAgendamento().getHour()+servico.getTempoExecucao().getHour() || x.getDtAgendamento().getHour()+servico.getTempoExecucao().getHour() <  data.getDtAgendamento().getHour())

                        available = false;
                        break;
                    }
            }else {
                available = false;
            }
        }

         return available;





    }
}
