package modelSMBG;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PrestConta")
public class PrestacaoDeConta extends Persistivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @JoinColumn(name = "Cod_Funcionario", referencedColumnName = "Cod_Funcionario")
    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;
    
    @Column(name = "valorBruto", nullable = false)
    private double valorTotalArrecadadoNoDia;
    
    @Column(name = "valorLiquido", nullable = false)
    private double valorArrecadadoDescontado;
    
    @Column(name = "valorTotalDoCombustivel", nullable = false)
    private double valorTotalDoCombustivel;
    
    @Column(name = "valorCombustivel", nullable = false)
    private double valorDoLitroDeCombustivel;
    
    @Column(name = "quantidadeLitros", nullable = false)
    private double quantidadeDeLitrosAbastecido;
    
    @Column(name = "valorTroco", nullable = false)
    private double valorTroco;
    
    @Column(name = "valorCobrador", nullable = false)
    private double salarioDoCobrador;
    
    @Column(name = "valorMotorista", nullable = false)
    private double salarioDoMotorista;
 
    public PrestacaoDeConta(Funcionario funcionario, double valorTotalArrecadadoNoDia, double valorArrecadadoDescontado,
            double valorTotalDoCombustivel, double valorDoLitroDeCombustivel, double quantidadeDeLitrosAbastecido,
            double valorTroco, double salarioDoCobrador, double salarioDoMotorista) {

        this.funcionario = funcionario;
        this.valorTotalArrecadadoNoDia = valorTotalArrecadadoNoDia;
        this.valorArrecadadoDescontado = valorArrecadadoDescontado;
        this.valorTotalDoCombustivel = valorTotalDoCombustivel;
        this.valorDoLitroDeCombustivel = valorDoLitroDeCombustivel;
        this.quantidadeDeLitrosAbastecido = quantidadeDeLitrosAbastecido;
        this.valorTroco = valorTroco;
        this.salarioDoCobrador = salarioDoCobrador;
        this.salarioDoMotorista = salarioDoMotorista;
    }

    public PrestacaoDeConta() {

    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getValorTotalArrecadadoNoDia() {
        return valorTotalArrecadadoNoDia;
    }

    public void setValorTotalArrecadadoNoDia(double valorTotalArrecadadoNoDia) {
        this.valorTotalArrecadadoNoDia = valorTotalArrecadadoNoDia;
    }

    public double getValorArrecadadoDescontado() {
        return valorArrecadadoDescontado;
    }

    public void setValorArrecadadoDescontado(double valorArrecadadoDescontado) {
        this.valorArrecadadoDescontado = valorArrecadadoDescontado;
    }

    public double getValorTotalDoCombustivel() {
        return valorTotalDoCombustivel;
    }

    public void setValorTotalDoCombustivel(double valorTotalDoCombustivel) {
        this.valorTotalDoCombustivel = valorTotalDoCombustivel;
    }

    public double getValorDoLitroDeCombustivel() {
        return valorDoLitroDeCombustivel;
    }

    public void setValorDoLitroDeCombustivel(double valorDoLitroDeCombustivel) {
        this.valorDoLitroDeCombustivel = valorDoLitroDeCombustivel;
    }

    public double getQuantidadeDeLitrosAbastecido() {
        return quantidadeDeLitrosAbastecido;
    }

    public void setQuantidadeDeLitrosAbastecido(double quantidadeDeLitrosAbastecido) {
        this.quantidadeDeLitrosAbastecido = quantidadeDeLitrosAbastecido;
    }

    public double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(double valorTroco) {
        this.valorTroco = valorTroco;
    }

    public double getSalarioDoCobrador() {
        return salarioDoCobrador;
    }

    public void setSalarioDoCobrador(double salarioDoCobrador) {
        this.salarioDoCobrador = salarioDoCobrador;
    }

    public double getSalarioDoMotorista() {
        return salarioDoMotorista;
    }

    public void setSalarioDoMotorista(double salarioDoMotorista) {
        this.salarioDoMotorista = salarioDoMotorista;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrestacaoDeConta)) {
            return false;
        }

        PrestacaoDeConta prestacaoDeConta = (PrestacaoDeConta) obj;
        return this.funcionario.getCPF().equals(prestacaoDeConta.funcionario.getCPF())
                || this.funcionario.getFuncionarioIdentidade().equals(prestacaoDeConta.funcionario.getFuncionarioIdentidade())
                || this.funcionario.getFuncionarioCNH().equals(prestacaoDeConta.funcionario.getFuncionarioCNH());
    }

}
