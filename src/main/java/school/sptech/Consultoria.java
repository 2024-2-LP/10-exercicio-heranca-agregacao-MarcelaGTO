package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){

        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }

    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){

        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){

        Double total = 0.0;

        for (Desenvolvedor devDaVez : desenvolvedores){
            if (devDaVez instanceof DesenvolvedorMobile){
                total += devDaVez.calcularSalario();
            } else {
                total += devDaVez.calcularSalario();
            }
        }

        return total;
    }

    public Integer qtdDesenvolvedoresMobile(){

        Integer totalMobile = 0;

        for (int i = 0; i < desenvolvedores.size(); i++) {

            Desenvolvedor devDaVez = desenvolvedores.get(i);

            if (devDaVez instanceof DesenvolvedorMobile){
                totalMobile ++;
            }
        }

        return totalMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){

        List<Desenvolvedor> devList = new ArrayList<>();

        for (Desenvolvedor devDaVez : desenvolvedores){
            if (devDaVez.calcularSalario() >= salario){
                devList.add(devDaVez);
            }
        }

        return devList;
    }

    public Desenvolvedor buscarMenorSalario(){

        if (desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor menorSalario = desenvolvedores.get(0);

        for (Desenvolvedor devDaVez : desenvolvedores){
            if (devDaVez.calcularSalario() < menorSalario.calcularSalario()){
                menorSalario = devDaVez;
            }
        }

        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {

        List<Desenvolvedor> devList = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {

                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) dev;
                if (tecnologia.equalsIgnoreCase(devWeb.getBackend()) || tecnologia.equalsIgnoreCase(devWeb.getFrontend()) || tecnologia.equalsIgnoreCase(devWeb.getSgbd())){
                    devList.add(dev);
                }
            } else if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMobile = (DesenvolvedorMobile) dev;
                if (tecnologia.equalsIgnoreCase(devMobile.getPlataforma()) ||
                        tecnologia.equalsIgnoreCase(devMobile.getLinguagem())) {
                    devList.add(dev);
                }
            }
        }

        return devList;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {

        Double totalSalarios = 0.0;

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {

                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) dev;

                if (tecnologia.equalsIgnoreCase(devWeb.getBackend()) ||
                        tecnologia.equalsIgnoreCase(devWeb.getFrontend()) ||
                        tecnologia.equalsIgnoreCase(devWeb.getSgbd())) {
                    totalSalarios += devWeb.calcularSalario();
                }
            } else if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMobile = (DesenvolvedorMobile) dev;

                if (tecnologia.equalsIgnoreCase(devMobile.getPlataforma()) ||
                        tecnologia.equalsIgnoreCase(devMobile.getLinguagem())) {
                    totalSalarios += devMobile.calcularSalario();
                }
            }
        }

        return totalSalarios;
    }
}
