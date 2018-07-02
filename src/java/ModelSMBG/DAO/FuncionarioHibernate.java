package ModelSMBG.DAO;

import ModelSMBG.Entity.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;

public class FuncionarioHibernate implements FuncionarioDAO {

    private EntityManager em = GeradorDeEntityManager.getEntityManager();

    @Override
    public void inserir(Funcionario funcionario) {
        
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    @Override
    public void atualizar(Funcionario funcionario) {

        try {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    @Override
    public void deletar(Funcionario funcionario) {

        try {
            em.getTransaction().begin();
            em.remove(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios;

        funcionarios = this.em.createQuery("from Funcionario").getResultList();

        return funcionarios;
    }

    @Override
    public Funcionario buscarPeloCpf(String cpf) {
        Funcionario funcionario;
        try {
            funcionario = (Funcionario) em.createQuery("from Funcionario WHERE cpf = ?").setParameter(1, cpf).getSingleResult();
            return funcionario;
        } catch (Exception erro) {
            funcionario = null;
        }
        return funcionario;
    }

    public Funcionario buscarPelaIdentidade(String numeroIdentidade) {
        return (Funcionario) em.createQuery("from Funcionario WHERE numeroidentidade = ?").setParameter(1, numeroIdentidade).getSingleResult();

    }

    public Funcionario buscarPelaCnh(String numeroCnh) {
        return (Funcionario) em.createQuery("from Funcionario WHERE numerocnh = ?").setParameter(1, numeroCnh).getSingleResult();
    }

}
