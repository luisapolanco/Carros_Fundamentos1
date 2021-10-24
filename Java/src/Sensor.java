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
        Sensores[posAnadir] = this;
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
        String texto = "Tipo: " + this.getTipo() + " Valor: " + this.getValor();
        return texto;
    }

    public static String toStringSensores(){
        String texto = "";
        for(int i = 0; i < Sensores.length; i++){
            String mensaje = " ----- Tipo: " + Sensores[i].getTipo() + " Valor: " + Sensores[i].getValor();
            texto = texto + mensaje;
        }
        return texto;
    }

    public static String toStringSensores666(ArrayList<Sensor> sensores666){
        String texto = "";
        for(int i = 0; i < sensores666.size(); i++){
            String mensaje = " ----- Tipo: " + sensores666.get(i).getTipo() + " Valor: " + sensores666.get(i).getValor();
            texto = texto + mensaje;
        }
        return texto;
    }

    public static int cantidadSensores(){
        return posAnadir + 1;
    }

    public static void getTipoTemperatura(){
        for(int i = 0; i < Sensores.length; i++){
            if(Sensores[i].getTipo().toLowerCase(Locale.ROOT).equals("temperatura")){
                Sensores[i].toString();
            }
        }
    }

    public static ArrayList<Sensor> get666(){
        ArrayList<Sensor> sensores666 = new ArrayList();

        for(int i = 0; i < Sensores.length; i++){
            if(Sensores[i].getTipo().toLowerCase(Locale.ROOT).equals("temperatura")){
                sensores666.add(Sensores[i]);
                for (int x = 0; x < sensores666.size(); x++) {
                    for (int p = 0; p < sensores666.size()-x-1; p++) {
                        if(sensores666.get(p).getValor() < sensores666.get(p+1).getValor()){
                            Sensor tmp = sensores666.get(p+1);
                            sensores666.add(p+1,sensores666.get(p) );
                            sensores666.add(p, tmp);
                        }
                    }
                }
            }
        }
        return sensores666;
    }

}
