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
    
    public boolean dadosLoginCorretos(Funcionario funcionario) {
        Query query = em.createQuery("select 1 from Funcionario funcionario where funcionario.login = :login and funcionario.senha = :senha");
        query.setParameter("login", funcionario.getLogin());
        query.setParameter("senha", funcionario.getSenha());
        return query.getResultList().size() > 0;
    }
    
}