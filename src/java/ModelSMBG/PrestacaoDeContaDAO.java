package modelSMBG;

public interface PrestacaoDeContaDAO extends DAO<PrestacaoDeConta> {

	public PrestacaoDeConta buscarPeloCpfDoFuncionario(String cpf);

	public PrestacaoDeConta buscarPelaIdentidadeDoFuncionario(String numeroIdentidade);

	public PrestacaoDeConta buscarPelaCnhDoFuncionario(String cnh);

}
