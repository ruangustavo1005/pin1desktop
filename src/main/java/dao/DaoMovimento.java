package dao;

import javax.persistence.Query;
import model.Movimento;

/**
 * @author Ruan
 */
public class DaoMovimento extends Dao<Movimento> {

    public DaoMovimento() {
        super(Movimento.class);
    }

    @Override
    public boolean remove(Movimento movimento) {
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Movimento movimento where movimento.codigo = :codigo");
        query.setParameter("codigo", movimento.getCodigo());
        boolean retorno = query.executeUpdate() == 1;
        if (retorno) {
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().rollback();
        }
        return retorno;
    }
    
}