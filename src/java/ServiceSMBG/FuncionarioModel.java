package ServiceSMBG;

import java.util.List;
import DaoSMBG.DAO;
import modelSMBG.Funcionario;
import DaoSMBG.FuncionarioDAO;
import DaoHibernate.FuncionarioHibernate;

public class FuncionarioModel {

	private DAO<Funcionario> daoFuncionario = new FuncionarioHibernate();

	public void cadastrarFuncionario(Funcionario funcionario) {
		daoFuncionario.inserir(funcionario);
	}

	public void atualizarFuncionario(Funcionario funcionario) {
		daoFuncionario.atualizar(funcionario);
	}

	public void removerFuncionario(Funcionario funcionario) {
		daoFuncionario.deletar(funcionario);
	}

	public List<Funcionario> buscaTodosOsFuncionarios() {
		return daoFuncionario.listarTodos();
	}
	
	public Funcionario buscarFuncionarioPeloCpf(String cpf) {
		return ((FuncionarioDAO) daoFuncionario).buscarPeloCpf(cpf);
	}

	public Funcionario buscarFuncionarioPelaIdentidade(String numeroIdentidade) {
		return ((FuncionarioDAO) daoFuncionario).buscarPelaIdentidade(numeroIdentidade);
	}

	public Funcionario buscarFuncionarioPelaCnh(String cnh) {
		return ((FuncionarioDAO) daoFuncionario).buscarPelaCnh(cnh);
	}

}
