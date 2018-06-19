package ModelSMBG;

import ModelSMBG.Conta;
import ModelSMBG.Funcionario;
import ModelSMBG.Persistivel;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
@Table(name = "Admissao")
@AttributeOverride(name = "id", column = @Column(name="Cod_Admissao"))
public class Admissao extends Persistivel implements Serializable {

    @Column(name = "dataAdmissao", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAdmissao;

    @Column(name = "valorSalario", nullable = false)
    private double valorSalario;

    @Column(name = "funcao", nullable = false)
    private String funcao;

    @Column(name = "horas", nullable = false)
    private int horas;

    @Column(name = "instrucao", nullable = false)
    private String instrucao;

    @Column(name = "numeroFilhos", nullable = false)
    private int numeroDeFilhos;

    @Embedded
    private Conta conta;

    public Admissao() {

    } 

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(double valorSalario) {
        this.valorSalario = valorSalario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public int getNumeroDeFilhos() {
        return numeroDeFilhos;
    }

    public void setNumeroDeFilhos(int numeroDeFilhos) {
        this.numeroDeFilhos = numeroDeFilhos;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Admissao)) {
            return false;
        }
        Admissao admissao = (Admissao) o;
        return this.id.equals(admissao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataAdmissao, valorSalario, funcao, horas, instrucao, numeroDeFilhos, conta);
    }

    
}
