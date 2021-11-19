import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String [] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        boolean nio = true;
        while(nio){
            System.out.println("----Por favor ingrese un numero: ----");
            System.out.println(" - Si se ingresa 0: Finalizará el programa");
            System.out.println(" - Si se ingresa 1: Deberás ingresar los 4 parametros del Vehiculo");
            System.out.println(" - Si se ingresa 2: Se mostrará por pantalla la información de los vehiculos existentes");
            System.out.println(" - Si se ingresa 3: Se mostrará por pantalla la cantidad de vehiculos existentes");
            System.out.println(" - Si se ingresa 4: Se mostrará la información de los vehiculos cuyo color sea el VERDE");
            System.out.println(" - Si se ingresa 5: Deberás ingresar el ID de un vehiculo para luego mostrar su información");
            System.out.println(" - Si se ingresa 6: Deberás ingresar un ID de un vehiculo para luego ingresar 2 parametros de sensor");
            System.out.println(" - Si se ingresa 7: Deberás ingresar un ID de un vehiculo para ver sus sensores existentes");
            System.out.println(" - Si se ingresa 8: Se mostrará la información de los sensores cuyo tipo sea TEMPERATURA");
            System.out.println(" - Si se ingresa 9: Se mostrará la info del vehiculo que tiene mas sensores");
            System.out.println(" - Si se ingresa 10: Se cargará la info de 5 vehiculos desde el TXT y se asignaran a 5 objetos");
            System.out.println(" - Si se ingresa 666: Se mostrará la información de los sensores cuyo tipo sea TEMPERATURA ordenados por valor");
            System.out.println(" ---- POR FAVOR INGRESA UN NUMERO VALIDO ----");
            Scanner scanner = new Scanner(System.in);
            int numeroIngresado = scanner.nextInt();

            switch(numeroIngresado){
                case 0: nio = false;
                    break;
                case 1:
                        System.out.println("Ingrese el modelo del nuevo vehiculo: ");
                        int modelo = scanner.nextInt();

                        System.out.println("Ingrese la marca del nuevo vehiculo: ");
                        String marca = scanner.next();

                        System.out.println("Ingrese el valor comercial del nuevo vehiculo: ");
                        double valorComercial = scanner.nextDouble();

                        System.out.println("Ingrese el color del nuevo vehiculo: ");
                        String color = scanner.next();

                        var nuevoVehiculo = new Vehiculo(modelo, marca, valorComercial, color);
                    break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 3:
                    System.out.println("Existen: " + Vehiculo.cantidadVehiculos() + " vehiculo(s)");
                    break;
                case 4:
                    System.out.println(Vehiculo.getVerdes());
                    break;
                case 5:
                    System.out.println("Ingrese el id del vehiculo: ");
                    int id = scanner.nextInt();
                    var vehiculo = Vehiculo.obtenerVehiculoPorId(id);
                    if(vehiculo == null){
                        System.out.println("No existe ningún vehiculo asociado a este Id");
                    }else{
                        System.out.println(vehiculo.toString());
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el id del vehiculo: ");
                    int id2 = scanner.nextInt();
                    var vehiculoPorId = Vehiculo.obtenerVehiculoPorId(id2);

                    if(vehiculoPorId == null){
                        System.out.println("ERROR : No existe ningún vehiculo asociado a este Id");
                    }else{
                        System.out.println("Ingrese el tipo del nuevo sensor: ");
                        String tipo = scanner.next();

                        System.out.println("Ingrese el valor del nuevo sensor: ");
                        double valor = scanner.nextDouble();

                        var nuevoSensor = new Sensor(tipo, valor);
                        vehiculoPorId.anadirSensor(nuevoSensor);
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el id del vehiculo: ");
                    int id3 = scanner.nextInt();
                    String texto = "";
                    var vehiculoPorId2 = Vehiculo.obtenerVehiculoPorId(id3);
                    if(vehiculoPorId2 == null){
                        System.out.println("ERROR : No existe ningún vehiculo asociado a este Id");
                    }else{
                        for(int i = 0; i < vehiculoPorId2.getSensores().size(); i++){
                            String textoSensores = vehiculoPorId2.getSensores().get(i).toString();
                            texto = texto.concat(textoSensores);
                        }
                    }
                    System.out.println(texto);
                    break;
                case 8:
                    System.out.println(Sensor.getTipoTemperaturaEnVehiculos());
                    break;
                case 9:
                    System.out.println("El vehiculo que tiene más sensores es: "+ "\n" + Vehiculo.masSensores());
                    break;
                case 10:
                    File file = new File("vehiculos.txt");
                    try{
                        Scanner input = new Scanner(file);
                        String line;
                        int i = 1;
                        while(input.hasNextLine()){
                            line = input.nextLine();
                            String[] infoVehiculo = line.split(",");
                            var modeloVehiculo =  infoVehiculo[0];
                            var marcaVehiculo = infoVehiculo[1];
                            var precioVehiculo =  infoVehiculo[2];
                            var colorVehiculo = infoVehiculo[3];
                            Vehiculo vehiculoNuevo = new Vehiculo(Integer.parseInt(modeloVehiculo), marcaVehiculo, Double.parseDouble(precioVehiculo), colorVehiculo);
                            i = i+1;
                        }
                    }catch(IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 666:
                    Sensor[] sensores =  Sensor.get666();
                    System.out.println(Sensor.toStringSensores666(sensores));

            }
        }
    }
}
