package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosContratosDAL  extends JpaRepository<ContratoEntity,Integer> {

    @Query("from ContratoEntity where id_Usuario_Consumidor = ?1")
    List<ContratoEntity> GetByConsumer(int id);

    @Query("from ContratoEntity where id_Usuario_Prestador = ?1")
    List<ContratoEntity> GetByProvider(int id);
}
