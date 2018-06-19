package ModelSMBG;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity 
@Table(name = "Funcionario")
@AttributeOverride(name = "id", column = @Column(name="Cod_Funcionario"))
public class Funcionario extends Persistivel implements Serializable {
    
    @Embedded
    private Identidade funcionarioIdentidade;
    
    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;
    
    @Embedded
    private Endereco funcionarioEndereco;
    
    @Embedded
    private CNH funcionarioCNH;
    
    @Column(name = "pis", nullable = true, unique = false)
    private String pis;
    
    @Embedded
    private Titulo funcionarioTitulo;
    
    @Embedded
    private CTPS funcionarioCTPS;
    
    @Embedded
    private Reservista funcionarioReservista;
     
    @ElementCollection
    @CollectionTable(name="email_Funcionario", joinColumns = @JoinColumn(name="Cod_Funcionario"))
    @Column (name = "email_funcionario")
    private List<String> emailFuncionario;
    
    @ElementCollection
    @CollectionTable(name="telefone_Funcionario", joinColumns = @JoinColumn(name="Cod_Funcionario"))
    @Column (name = "telefone")
    private List<String> numeroTelefoneFuncionario;
    
    @Column(name = "estadoCivil")
    private String estadoCivil;

    @JoinColumn(name = "Cod_admissao", referencedColumnName = "Cod_Admissao")
    @OneToOne(cascade = CascadeType.ALL)
    private Admissao admissao;

    public Funcionario() {
        
    }
    
    public Identidade getFuncionarioIdentidade() {
        return funcionarioIdentidade;
    }

    public void setFuncionarioIdentidade(Identidade funcionarioIdentidade) {
        this.funcionarioIdentidade = funcionarioIdentidade;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cPF) {
        cpf = cPF;
    }

    public Endereco getFuncionarioEndereco() {
        return funcionarioEndereco;
    }

    public void setFuncionarioEndereco(Endereco funcionarioEndereco) {
        this.funcionarioEndereco = funcionarioEndereco;
    }

    public CNH getFuncionarioCNH() {
        return funcionarioCNH;
    }

    public void setFuncionarioCNH(CNH funcionarioCNH) {
        this.funcionarioCNH = funcionarioCNH;
    }

    public String getPIS() {
        return pis;
    }

    public void setPIS(String pIS) {
        pis = pIS;
    }

    public Titulo getFuncionarioTitulo() {
        return funcionarioTitulo;
    }

    public void setFuncionarioTitulo(Titulo funcionarioTitulo) {
        this.funcionarioTitulo = funcionarioTitulo;
    }

    public CTPS getFuncionarioCTPS() {
        return funcionarioCTPS;
    }

    public void setFuncionarioCTPS(CTPS funcionarioCTPS) {
        this.funcionarioCTPS = funcionarioCTPS;
    }

    public void setFuncionarioReservista(Reservista funcionarioReservista) {
        this.funcionarioReservista = funcionarioReservista;
    }

    public Reservista getFuncionarioReservista() {
        return funcionarioReservista;
    }

    public List<String> getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(List<String> emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

     public List<String> getNumeroTelefoneFuncionario() {
        return numeroTelefoneFuncionario;
    }

    public void setNumeroTelefoneFuncionario(List<String> numeroTelefoneFuncionario) {
        this.numeroTelefoneFuncionario = numeroTelefoneFuncionario;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public Admissao getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Admissao admissao) {
        this.admissao = admissao;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Funcionario)) {
            return false;
        }

        Funcionario funcionario = (Funcionario) o;
        return this.cpf.equals(funcionario.getCPF());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, estadoCivil, funcionarioIdentidade.getNumeroIdentidade(), 
                funcionarioIdentidade.getNome(), funcionarioIdentidade.getDataDeEmissao(), 
                funcionarioIdentidade.getOrgaoEmissor(), funcionarioIdentidade.getNomeDaMae(),
                funcionarioIdentidade.getUFIdentidade() ,funcionarioEndereco);
    }
}
