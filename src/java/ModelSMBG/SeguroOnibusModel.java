package ModelSMBG;

import ModelSMBG.Entity.SeguroOnibus;
import ModelSMBG.DAO.SeguroOnibusDAO;
import ModelSMBG.DAO.SeguroOnibusHibernate;
import ModelSMBG.DAO.DAO;
import java.util.List;

public class SeguroOnibusModel {
	
	private DAO<SeguroOnibus> daoSeguroOnibus = new SeguroOnibusHibernate();
	
	public void cadastrarSeguroOnibus (SeguroOnibus seguroOnibus) {
		daoSeguroOnibus.inserir(seguroOnibus);
		
	}
	
	public void atualizarSeguroOnibus (SeguroOnibus seguroOnibus) {
		daoSeguroOnibus.atualizar(seguroOnibus);
	}

	public void removerSeguroOnibus(SeguroOnibus seguroOnibus) {
		daoSeguroOnibus.deletar(seguroOnibus);
	}

	public List<SeguroOnibus> listarTodoOsSegurosDosOnibus() {
		return daoSeguroOnibus.listarTodos();
	}


	public SeguroOnibus buscarPeloCodigoSusepDoCorretor(int codigoSusepDoCorretor) {
		return ((SeguroOnibusDAO) daoSeguroOnibus).buscarPeloCodigoSusepDoCorretor(codigoSusepDoCorretor);
	}

	public SeguroOnibus buscarSeguroDoOnibusPeloCodigoCpdDoCorretor(int codigoCpdDoCorretor) {
		return ((SeguroOnibusDAO) daoSeguroOnibus).buscarPeloCodigoCpdDoCorretor(codigoCpdDoCorretor);
	}

	public SeguroOnibus buscarSeguroDoOnibusPeloCodigoSusep(int codigoSusep) {
		return ((SeguroOnibusDAO) daoSeguroOnibus).buscarPeloCodigoSusep(codigoSusep);
	}

	public SeguroOnibus buscarSeguroDoOnibusPeloCnpjDaEmpresaDoSeguro(String cpnj) {
		return ((SeguroOnibusDAO) daoSeguroOnibus).buscarPeloCnpjDaEmpresaDoSeguro(cpnj);
	}

	public SeguroOnibus buscarSeguroDoOnibusPeloCpfOuCnpjDoSegurado(String cpfOuCnpjDoSegurado) {
		return ((SeguroOnibusDAO) daoSeguroOnibus).buscarPeloCpfOuCnpjDoSegurado(cpfOuCnpjDoSegurado);
	}

	
	public SeguroOnibus buscarSeguroDoOnibusPeloNumeroEndosso(int numeroEndosso) {
		return ((SeguroOnibusDAO) daoSeguroOnibus).buscarPeloNumeroEndosso(numeroEndosso);
	}

}
