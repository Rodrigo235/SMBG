package ModelSMBG;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
@Table(name = "Viagem")
@AttributeOverride(name = "id", column = @Column(name = "Cod_Viagem"))
public class Viagem extends Persistivel implements Serializable {
    
    @JoinColumn(name = "Cod_Motorista", referencedColumnName = "Cod_funcionario")
    @OneToOne(fetch = FetchType.EAGER)
    private Funcionario funcionarioMotorista;
    
    @JoinColumn(name = "Cod_Cobrador", referencedColumnName = "Cod_funcionario")
    @OneToOne(fetch = FetchType.EAGER)
    private Funcionario funcionarioCobrador;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cod_onibus", referencedColumnName = "Cod_Onibus")
    private Onibus onibus;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cod_rota", referencedColumnName = "Cod_Rota")
    private Rota rota;
    
    @Column(name = "dataViagem", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    @Column(name="diaDaSemana", length = 12, nullable = false)
    private String diaDaSemana;

    public Viagem() {
        
    }
    
    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Funcionario getFuncionarioMotorista() {
        return funcionarioMotorista;
    }

    public void setFuncionarioMotorista(Funcionario funcionarioMotorista) {
        this.funcionarioMotorista = funcionarioMotorista;
    }

    public Funcionario getFuncionarioCobrador() {
        return funcionarioCobrador;
    }

    public void setFuncionarioCobrador(Funcionario funcionarioCobrador) {
        this.funcionarioCobrador = funcionarioCobrador;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        
        if(!(obj instanceof Viagem))
            return false;
        
        Viagem viagem = (Viagem) obj;
        
//        for(int i = 0; i < this.listaDeFuncionarios.size(); i++) {
//            if(this.listaDeFuncionarios.get(i).getCPF().equals(viagem.getListaDeFuncionarios().get(i).getCPF())){
//                return true;
//            }
//        }
        
        return this.data.equals(viagem.data)
                && this.onibus.getPlaca().equals(viagem.onibus.getPlaca())
                && this.rota.equals(viagem.rota);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(onibus, rota, data, diaDaSemana);
    }
     
}
