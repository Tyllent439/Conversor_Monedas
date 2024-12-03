import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        int opcionUsuario = 0;
        while (opcionUsuario != 7) {
            System.out.println("""
                    ---------------------------------------
                    Bienvenido al conversor de monedas
                    Por favor seleccione una opción:
                    
                    1. Dólar a Peso argentino
                    2. Peso argentino a Dólar
                    3. Dólar a Real brasileño
                    4. Real brasileño a Dólar
                    5. Dólar a Peso colombiano
                    6. Peso colombiano a Dólar
                    7. Salir
                    ---------------------------------------
                    """);

            System.out.print("Seleccione una opción: ");
            opcionUsuario = lectura.nextInt();
            lectura.nextLine(); // Consumir salto de línea

            if (opcionUsuario >= 1 && opcionUsuario <= 6) {
                System.out.print("Ingrese el monto que desea convertir: ");
                double monto = lectura.nextDouble();
                lectura.nextLine(); // Consumir salto de línea

                String monedaBase = "";
                String monedaDestino = "";

                switch (opcionUsuario) {
                    case 1 -> {
                        monedaBase = "USD";
                        monedaDestino = "ARS";
                    }
                    case 2 -> {
                        monedaBase = "ARS";
                        monedaDestino = "USD";
                    }
                    case 3 -> {
                        monedaBase = "USD";
                        monedaDestino = "BRL";
                    }
                    case 4 -> {
                        monedaBase = "BRL";
                        monedaDestino = "USD";
                    }
                    case 5 -> {
                        monedaBase = "USD";
                        monedaDestino = "COP";
                    }
                    case 6 -> {
                        monedaBase = "COP";
                        monedaDestino = "USD";
                    }
                }

                // Obtener la tasa de cambio
                double tasa = BuscarMoneda.tasaCambio(monedaBase, monedaDestino);
                if (tasa != -1) {
                    double resultado = monto * tasa;
                    System.out.printf("El resultado de la conversión es: %.2f %s%n", resultado, monedaDestino);
                } else {
                    System.out.println("No se pudo realizar la conversión. Intente nuevamente.");
                }
            } else if (opcionUsuario == 7) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta pronto!");
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        lectura.close();
    }
}