import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String [] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        boolean nio = true;
        while(nio){
            System.out.println("----Ingrese un numero: ----");
            System.out.println(" - Si se ingresa 0: Finalizará el programa");
            System.out.println(" - Si se ingresa 1: Deberás ingresar los 4 parametros del Vehiculo");
            System.out.println(" - Si se ingresa 2: Se mostrará por pantalla la información de los vehiculos existentes");
            System.out.println(" - Si se ingresa 3: Se mostrará por pantalla la cantidad de vehiculos existentes");
            System.out.println(" - Si se ingresa 4: Se mostrará la información de los vehiculos cuyo color sea el VERDE");
            System.out.println(" - Si se ingresa 5: Se mostrará la información de los vehiculos cuyo modelo sea 2000-2021");
            System.out.println(" - Si se ingresa 6: Deberás ingresar 2 parametros para un sensor");
            System.out.println(" - Si se ingresa 7: Se mostrará por pantalla la información de los sensores existentes");
            System.out.println(" - Si se ingresa 8: Se mostrará por pantalla la cantidad de sensores existentes");
            System.out.println(" - Si se ingresa 9: Se mostrará la información de los sensores cuyo tipo sea TEMPERATURA");
            System.out.println(" - Si se ingresa 666: Se mostrará la información de los sensores cuyo tipo sea TEMPERATURA ordenados por valor");
            System.out.println(" ---- POR FAVOR INGRESA UN NUMERO VALIDO ----");
            Scanner scanner = new Scanner(System.in);
            int numeroIngresado = scanner.nextInt();

            switch(numeroIngresado){
                case 0: nio = false;
                    break;
                case 1:
                    if(Vehiculo.posAnadir < Vehiculo.vehiculos.length - 1 ){
                        System.out.println("Ingrese el modelo del nuevo vehiculo: ");
                        int modelo = scanner.nextInt();

                        System.out.println("Ingrese la marca del nuevo vehiculo: ");
                        String marca = scanner.next();

                        System.out.println("Ingrese el valor comercial del nuevo vehiculo: ");
                        double valorComercial = scanner.nextDouble();

                        System.out.println("Ingrese el color del nuevo vehiculo: ");
                        String color = scanner.next();

                        var nuevoVehiculo = new Vehiculo(modelo, marca, valorComercial, color);
                        Vehiculo.vehiculos[Vehiculo.posAnadir] = nuevoVehiculo;
                        Vehiculo.setPosAnadir();
                    }else{
                        System.out.println("Error base de datos llena");
                    }
                    break;

                case 2:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 3:
                    System.out.println(Vehiculo.cantidadVehiculos());
                    break;
                case 4:
                    System.out.println(Vehiculo.getVerdes());
                    break;
                case 5:
                    System.out.println(Vehiculo.getNuevos());
                    break;
                case 6:
                    if(Sensor.posAnadir < Sensor.Sensores.length - 1 ){
                        System.out.println("Ingrese el tipo del nuevo sensor: ");
                        String tipo = scanner.next();

                        System.out.println("Ingrese el valor del nuevo sensor: ");
                        double valor = scanner.nextDouble();

                        var nuevoSensor = new Sensor(tipo, valor);
                        Sensor.Sensores[Sensor.posAnadir] = nuevoSensor;
                        Sensor.setPosAnadir();
                    }else{
                        System.out.println("Error base de datos llena");
                    }
                    break;
                case 7:
                    System.out.println(Sensor.toStringSensores());
                    break;
                case 8:
                    System.out.println(Sensor.cantidadSensores());
                    break;
                case 9:
                    System.out.println(Sensor.getTipoTemperatura());
                    break;
                case 666:
                    Sensor[] sensores =  Sensor.get666();
                    System.out.println(Sensor.toStringSensores666(sensores));

            }
        }
    }
}
