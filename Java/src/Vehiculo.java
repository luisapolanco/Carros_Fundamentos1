import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Vehiculo {

    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    public static int idActual = 1;
    private int id;

    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Vehiculo() {
        this.id = idActual - 1;
        idActual ++;
        Vehiculo.vehiculos.add(this);
    }

    public Vehiculo(int modelo, String marca, double valorComercial) {
        this(modelo, marca, valorComercial, "verde");
    }


    public Vehiculo(int modelo, String marca, double valorComercial, String color) {
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valorComercial;
        this.color = color;
        this.id = idActual - 1;
        idActual ++;
        Vehiculo.vehiculos.add(this);
    }

    public int getModelo() {
        return this.modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorComercial() {
        return this.valorComercial;
    }

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Sensor> getSensores() {
        return this.sensores;
    }

    public void setSensores(ArrayList<Sensor> sensores) {
        this.sensores = sensores;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        String texto = "\n" + "-------Id: " + this.getId() + "\n" + " Modelo: " + this.getModelo() + "\n" + " Marca: " + this.getMarca() + "\n" + " Valor comercial: " + this.getValorComercial() + "\n"  +" Color: " + this.getColor();
        for(int i = 0; i < this.sensores.size(); i++){
            String textoSensores = this.sensores.get(i).toString();
            texto = texto.concat(textoSensores);
        }
        return texto;
    }

    public static String toStringVehiculos(){
        String texto = "";
        for(int i = 0; i < vehiculos.size(); i++){
            String textoVehiculos = vehiculos.get(i).toString();
            texto = texto.concat(textoVehiculos);
        }
        return texto;
    }

    public static String getVerdes(){
        String texto = "";
        for(int i = 0; i < cantidadVehiculos(); i++){
            if(vehiculos.get(i).getColor().toLowerCase(Locale.ROOT).equals("verde")){
                texto = texto.concat(vehiculos.get(i).toString());
            }
        }
        return texto;
    }

    public static int cantidadVehiculos(){
        return vehiculos.size();
    }

    public int cantidadSensores(){
        return this.sensores.size();
    }

    public void anadirSensor(Sensor sensor){
        this.sensores.add(sensor);
    }

    public static Vehiculo obtenerVehiculoPorId(int id){
        Vehiculo vehiculo = null;
        for(int i = 0; i < cantidadVehiculos(); i++){
            if(vehiculos.get(i).getId() == id){
                vehiculo = vehiculos.get(i);
            }
        }
        return vehiculo;
    }

    public static String masSensores(){
        var mayor = vehiculos.get(0);
        for (int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getSensores().size() > mayor.getSensores().size()){
               mayor = vehiculos.get(i);
            }
        }
        return mayor.toString();
    }

    /*public static String getNuevos(){
        String texto = "";
        for(int i = 0; i < posAnadir; i++){
            if(vehiculos[i].getModelo() >= 2000 && vehiculos[i].getModelo() <= 2021){
                texto = texto.concat(vehiculos[i].toString());
            }
        }
        return texto;
    }*/

}
