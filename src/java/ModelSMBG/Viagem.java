package modelSMBG;

import java.io.Serializable;
import java.util.List;

public class Viagem extends Persistivel implements Serializable {

    private Onibus onibus;
    private Rota rota;
    private List<Funcionario> listaDeFuncionarios;
    private String data;
    private String diaDaSemana;

    public Viagem(Onibus onibus, Rota rota, List<Funcionario> listaDeFuncionarios, String data, String diaDaSemana) {
        this.onibus = onibus;
        this.rota = rota;
        this.listaDeFuncionarios = listaDeFuncionarios;
        this.data = data;
        this.diaDaSemana = diaDaSemana;
    }

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

    public List<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public void setListaDeFuncionarios(List<Funcionario> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        
        if(!(obj instanceof Viagem))
            return false;
        
        Viagem viagem = (Viagem) obj;
        
        for(int i = 0; i < this.listaDeFuncionarios.size(); i++) {
            if(viagem.equals(listaDeFuncionarios.get(i).getCPF())){
                return true;
            }
        }
        
        return this.data.equals(viagem.data)
                && this.onibus.getPlaca().equals(viagem.onibus.getPlaca())
                && this.rota.equals(viagem.rota);
    }
    
}
