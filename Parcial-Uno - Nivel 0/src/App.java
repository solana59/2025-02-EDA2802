import java.util.List;
import java.util.Scanner;

import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) {

        ServiceCuenta serviceCuenta = new ServiceCuenta();
        
        List<Cuenta> cuentas = serviceCuenta.obtenerCuentas();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- MENU ---");
            System.out.println("1. Listar todas las cuentas");
            System.out.println("2. Buscar cuenta por nÃºmero");
            System.out.println("3. Crear cuenta ahorro");
            System.out.println("4. Crear cuenta corriente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opciÃ³n: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    for (Cuenta c : cuentas) {
                        System.out.println(c);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese nÃºmero de cuenta: ");
                    String numBuscar = sc.nextLine();
                    Cuenta cuentaEncontrada = serviceCuenta.obtenerNumeroCuenta(numBuscar);
                    if (cuentaEncontrada != null) {
                        System.out.println("Cuenta encontrada: " + cuentaEncontrada);
                    } else {
                        System.out.println("No existe cuenta con ese nÃºmero.");
                    }
                    break;

                case 3:
                    
                    System.out.print("NÃºmero de cuenta: ");
                    String numAhorro = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniAhorro = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoAhorro = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Fecha creaciÃ³n: ");
                    String fecha = sc.nextLine();
                    Ahorro nuevaAhorro = new Ahorro(numAhorro, dniAhorro, saldoAhorro, fecha);
                    serviceCuenta.crearCuenta(nuevaAhorro);
                    System.out.println("Cuenta ahorro creada.");
                    break;

                case 4:
                   
                    System.out.print("NÃºmero de cuenta: ");
                    String numCorriente = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniCorriente = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoCorriente = sc.nextDouble();
                    System.out.print("Impuesto: ");
                    double impuesto = sc.nextDouble();
                    Corriente nuevaCorriente = new Corriente(numCorriente, dniCorriente, saldoCorriente, impuesto);
                    serviceCuenta.crearCuenta(nuevaCorriente);
                    System.out.println("Cuenta corriente creada.");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("OpciÃ³n no vÃ¡lida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

