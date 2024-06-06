import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ProductoServicio productoServicio;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.productoServicio = new ProductoServicio();
    }

    public void start() {

        int command = 0;
        do {

            if (command != 1) {
                limpiarPantalla();
            }
            printMenu();
            command = leerCommandInt();

            if (command == 1) {
                limpiarPantalla();
                listarProductos();
            } else if (command == 2) {
                agregarProducto();
            } else if (command == 3) {
                exportatDatos();
            } else if (command == 4) {
                limpiarPantalla();
                System.out.println("Cerrando...");
            } else {
                System.out.println("Comando Inválido");
            }
        } while (command!=4);
    }

    public void printMenu() {
        System.out.println("1 Listar Producto");
        System.out.println("2 Agregar Producto");
        System.out.println("3 Exportar Datos");
        System.out.println("4 Salir");
        System.out.println("Ingrese una opción:");
    }

    public int leerCommandInt() {
        return Integer.valueOf(this.scanner.nextLine());
    }

    public void listarProductos() {
        this.productoServicio.listarProductos();
    }

    public void agregarProducto() {
        System.out.println("Crear Producto");

        System.out.println("Ingresar nombre articulo:");
        String nombreProducto = this.scanner.nextLine();
        System.out.println("Ingresar precio:");
        String precioProducto = this.scanner.nextLine();
        System.out.println("Ingresar descripción:");
        String descripcionProducto = this.scanner.nextLine();
        System.out.println("Ingresar código:");
        String codigoProducto = this.scanner.nextLine();
        System.out.println("Ingresar talla:");
        String tallaProducto = this.scanner.nextLine();
        System.out.println("Ingresar marca:");
        String marcaProducto = this.scanner.nextLine();
        System.out.println("Ingresar color:");
        String colorProducto = this.scanner.nextLine();

        productoServicio.agregarProductos(new Producto(nombreProducto,precioProducto,descripcionProducto,codigoProducto,tallaProducto,marcaProducto,colorProducto));
    }

    public void exportatDatos() {
        ExportarTxt exportador = new ExportarTxt("registroProductos",this.productoServicio.getListaProductos());
        exportador.exportar();
    }

    public void limpiarPantalla() {
        Utilidad.limpiarPantalla();
    }

}
