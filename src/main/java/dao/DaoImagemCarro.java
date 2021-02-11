package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ImagemCarro;
import model.Veiculo;

/**
 * @author Ruan
 */
public class DaoImagemCarro extends Dao<ImagemCarro> {

    public DaoImagemCarro() {
        super(ImagemCarro.class);
    }

    public List<ImagemCarro> getAllFromVeiculo(Veiculo veiculo) {
        Query query = em.createQuery("select imagemCarro from ImagemCarro imagemCarro where imagemCarro.veiculo.placa = :placa");
        query.setParameter("placa", veiculo.getPlaca());
        return (ArrayList<ImagemCarro>) query.getResultList();
    }

    @Override
    public boolean remove(ImagemCarro imagemCarro) {
        em.getTransaction().begin();
        Query query = em.createQuery("delete from ImagemCarro imagemCarro where imagemCarro.codigo = :codigo");
        query.setParameter("codigo", imagemCarro.getCodigo());
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