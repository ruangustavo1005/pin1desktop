package dao;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Query;
import model.Agendamento;

/**
 * @author Ruan
 */
public class DaoAgendamento extends Dao<Agendamento> {

    public DaoAgendamento() {
        super(Agendamento.class);
    }

    public ArrayList<Agendamento> buscaAgendamentosAtrasados() {
        Query query = em.createQuery("SELECT agendamento\n" +
                                     "  FROM Agendamento agendamento\n" +
                                     " WHERE agendamento.dataHora <= :dataHora\n" +
                                     "   AND agendamento.situacao IN (" + Agendamento.SITUACAO_ABERTO + ", " + Agendamento.SITUACAO_CONFIRMADO + ")");
        query.setParameter("dataHora", (new Date(System.currentTimeMillis())));
        return (ArrayList<Agendamento>) query.getResultList();
    }
    
}