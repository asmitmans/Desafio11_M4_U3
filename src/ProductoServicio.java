import java.util.ArrayList;

public class ProductoServicio {
    private ArrayList<Producto> listaProductos;

    public ProductoServicio() {
        this.listaProductos = new ArrayList<>();
    }

    public void listarProductos() {
        for (Producto producto : listaProductos) {
            System.out.println(producto.toString());
        }
    }

    public void agregarProductos(Producto producto) {
        this.listaProductos.add(producto);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
