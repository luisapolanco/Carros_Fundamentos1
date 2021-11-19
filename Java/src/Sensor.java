import java.util.ArrayList;
import java.util.Locale;

public class Sensor {

    private String tipo;
    private double valor;

    public Sensor() {
    }

    public Sensor(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString(){
        String texto = "\n" + "------Tipo: " + this.getTipo() + "\n" + " Valor: " + this.getValor();
        return texto;
    }

    public static String toStringSensores666(Sensor[] sensores666){
        String texto = "";
        for(int i = 0; i < sensores666.length; i++){
            String mensaje = "\n" + "-----Tipo: " + sensores666[i].getTipo() +  "\n" + " Valor: " + sensores666[i].getValor();
            texto = texto.concat(mensaje);
        }
        return texto;
    }

    public static String getTipoTemperaturaEnVehiculos(){
        String texto = "";
        for(int i = 0; i < Vehiculo.vehiculos.size();  i++){
            for(int j = 0; j < Vehiculo.vehiculos.get(i).getSensores().size(); j++){
                if(Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().toLowerCase(Locale.ROOT).equals("temperatura")){
                    texto = texto.concat( Vehiculo.vehiculos.get(i).getSensores().get(j).toString());
                }
            }
        }
        return texto;
    }


    public static Sensor[] get666(){
        int contador = 0;
        int contador666 = 0;
        for(int i = 0; i <  Vehiculo.vehiculos.size(); i++){
            for(int j = 0; j <  Vehiculo.vehiculos.get(i).getSensores().size(); j++){
                if(Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().toLowerCase(Locale.ROOT).equals("temperatura")){
                    contador = contador + 1;
                }
            }
        }

        Sensor[] sensores666 = new Sensor[contador];

        for(int i = 0; i <  Vehiculo.vehiculos.size(); i++){
            for(int j = 0; j <  Vehiculo.vehiculos.get(i).getSensores().size(); j++) {
                if (Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().toLowerCase(Locale.ROOT).equals("temperatura")) {
                    sensores666[contador666] = Vehiculo.vehiculos.get(i).getSensores().get(j);
                    contador666 = contador666 + 1;
                }
            }
        }

        if(sensores666.length > 1) {
            for (int x = 0; x < sensores666.length; x++) {
                for (int p = 0; p < sensores666.length - x - 1; p++) {
                    if (sensores666[p+1].getValor() < sensores666[p].getValor()) {
                        Sensor tmp = sensores666[p+1];
                        sensores666[p+1] = sensores666[p];
                        sensores666[p] = tmp;
                    }
                }
            }
        }
        return sensores666;
    }

}
