package ModelSMBG.DAO;

import ModelSMBG.Entity.SeguroOnibus;
import java.util.List;
import javax.persistence.EntityManager;

public class SeguroOnibusHibernate implements SeguroOnibusDAO {

    private EntityManager em = GeradorDeEntityManager.getEntityManager();

    @Override
    public void inserir(SeguroOnibus seguroOnibus) {
        try {
            em.getTransaction().begin();
            em.persist(seguroOnibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void atualizar(SeguroOnibus seguroOnibus) {
        try {
            em.getTransaction().begin();
            em.merge(seguroOnibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deletar(SeguroOnibus seguroOnibus) {
        try {
            em.getTransaction().begin();
            em.remove(seguroOnibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<SeguroOnibus> listarTodos() {
        
        List<SeguroOnibus> lista;
        try{
            lista = this.em.createQuery("from SeguroOnibus").getResultList();
            return lista;
        } catch (Exception erro) {
            lista = null;
        }
       return lista;
    }

    @Override
    public SeguroOnibus buscarPeloCodigoSusepDoCorretor(int codigoSusepDoCorretor) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE codigoSusepDoCorretor = ?").
                    setParameter(1, codigoSusepDoCorretor).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    @Override
    public SeguroOnibus buscarPeloCodigoCpdDoCorretor(int codigoCpdDoCorretor) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE codigoCpdDoCorretor = ?").
                    setParameter(1, codigoCpdDoCorretor).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    @Override
    public SeguroOnibus buscarPeloCodigoSusep(int codigoSusep) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE codigoSusep = ?").
                    setParameter(1, codigoSusep).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    @Override
    public SeguroOnibus buscarPeloCnpjDaEmpresaDoSeguro(String cpnj) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE cpnj = ?").
                    setParameter(1, cpnj).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    @Override
    public SeguroOnibus buscarPeloCpfOuCnpjDoSegurado(String cpfOuCnpjDoSegurado) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE cpfOuCnpjDoSegurado = ?").
                    setParameter(1, cpfOuCnpjDoSegurado).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    @Override
    public SeguroOnibus buscarPeloNumeroEndosso(int numeroEndosso) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE numeroEndosso = ?").
                    setParameter(1, numeroEndosso).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

}
