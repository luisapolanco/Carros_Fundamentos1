import java.util.ArrayList;
import java.util.Locale;

public class Sensor {

    private String tipo;
    private double valor;
    public static Sensor[] Sensores = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;

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

    public static Sensor[] getSensores() {
        return Sensores;
    }

    public static void setSensores(Sensor[] sensores) {
        Sensores = sensores;
    }

    public static int getTamano() {
        return tamano;
    }

    public static void setTamano(int tamano) {
        Sensor.tamano = tamano;
    }

    public static int getPosAnadir() {
        return posAnadir;
    }

    public static void setPosAnadir() {
        Sensor.posAnadir = posAnadir + 1;
    }

    public String toString(){
        String texto = "------ Tipo: " + this.getTipo() + " Valor: " + this.getValor();
        return texto;
    }

    public static String toStringSensores(){
        String texto = "";
        for(int i = 0; i < posAnadir; i++){
            String mensaje = " ----- Tipo: " + Sensores[i].getTipo() + ". Valor: " + Sensores[i].getValor();
            texto = texto + mensaje;
        }
        return texto;
    }

    public static String toStringSensores666(Sensor[] sensores666){
        String texto = "";
        for(int i = 0; i < sensores666.length; i++){
            String mensaje = " ----- Tipo: " + sensores666[i].getTipo() + " Valor: " + sensores666[i].getValor();
            texto = texto.concat(mensaje);
        }
        return texto;
    }

    public static int cantidadSensores(){
        return posAnadir;
    }

    public static String getTipoTemperatura(){
        String texto = "";
        for(int i = 0; i < posAnadir;  i++){
            if(Sensores[i].getTipo().toLowerCase(Locale.ROOT).equals("temperatura")){
                texto = texto.concat( Sensores[i].toString());
            }
        }
        return  texto;
    }

    public static Sensor[] get666(){
        int contador = 0;
        int contador666 = 0;
        for(int i = 0; i < posAnadir; i++){
            if(Sensores[i].getTipo().toLowerCase(Locale.ROOT).equals("temperatura")){
                contador = contador + 1;
            }
        }

        Sensor[] sensores666 = new Sensor[contador];

        for(int i = 0; i < posAnadir; i++){
            if(Sensores[i].getTipo().toLowerCase(Locale.ROOT).equals("temperatura")){

                sensores666[contador666] = Sensores[i];
                contador666 = contador666 +1;
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
