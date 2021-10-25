import java.util.Arrays;
import java.util.Locale;

public class Vehiculo {

    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    public static Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;

    public Vehiculo() {
    }

    public Vehiculo(int modelo, String marca, double valorComercial) {
        this(modelo, marca, valorComercial, "verde");
    }

    public Vehiculo(int modelo, String marca, double valorComercial, String color) {
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valorComercial;
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public static void setVehiculos(Vehiculo[] vehiculos) {
        Vehiculo.vehiculos = vehiculos;
    }

    public static int getTamano() {
        return tamano;
    }

    public static void setTamano(int tamano) {
        Vehiculo.tamano = tamano;
    }

    public static int getPosAnadir() {
        return posAnadir;
    }

    public static void setPosAnadir() {
        Vehiculo.posAnadir = posAnadir + 1;
    }

    public String toString(){
        String texto = "------Modelo: " + this.getModelo() + " Marca: " + this.getMarca() + " Valor comercial: " + this.getValorComercial() + " Color: " + this.getColor();
        return texto;
    }

    public static String toStringVehiculos(){
        String texto = "";
        for(int i = 0; i < posAnadir; i++){
            String mensaje = " ----- Modelo: " + vehiculos[i].getModelo() + " Marca: " + vehiculos[i].getMarca() + " Valor comercial: " + vehiculos[i].getValorComercial() + " Color: " + vehiculos[i].getColor();
            texto = texto.concat(mensaje);
        }
        return texto;
    }

    public static String getVerdes(){
        String texto = "";
        for(int i = 0; i < posAnadir; i++){
            if(vehiculos[i].getColor().toLowerCase(Locale.ROOT).equals("verde")){
                texto = texto.concat(vehiculos[i].toString());
            }
        }
        return texto;
    }

    public static int cantidadVehiculos(){
        return posAnadir;
    }

    public static String getNuevos(){
        String texto = "";
        for(int i = 0; i < posAnadir; i++){
            if(vehiculos[i].getModelo() >= 2000 && vehiculos[i].getModelo() <= 2021){
                texto = texto.concat(vehiculos[i].toString());
            }
        }
        return texto;
    }

}
