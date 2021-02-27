package dao;

import javax.persistence.Query;
import model.Funcionario;

/**
 *
 * @author Ruan
 */
public class DaoLogin extends Dao<Funcionario> {
    
    public DaoLogin() {
        super(Funcionario.class);
    }
    
    public int dadosLoginCorretos(Funcionario funcionario) {
        Query query = em.createQuery("select funcionario.codigo from Funcionario funcionario where funcionario.login = :login and funcionario.senha = :senha");
        query.setParameter("login", funcionario.getLogin());
        query.setParameter("senha", funcionario.getSenha());
        if (query.getResultList().size() == 1) {
            return (int) query.getSingleResult();
        }
        else {
            return 0;
        }
    }
    
}