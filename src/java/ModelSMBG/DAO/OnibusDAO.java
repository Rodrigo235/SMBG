package ModelSMBG.DAO;

import ModelSMBG.Entity.Onibus;


public interface OnibusDAO extends DAO<Onibus> {

	public Onibus buscarPeloOnibusPeloCodigoRenavam(String codigoRenavam);
	
	public Onibus buscarPeloOnibusChassis(String chassi);
	
	public Onibus buscarPelaOnibusPlaca(String placa);
	
}
