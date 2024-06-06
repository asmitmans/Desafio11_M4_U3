import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExportarTxt extends Exportador{
    private String archivo;
    private ArrayList<Producto> productos;

    public ExportarTxt(String archivo, ArrayList<Producto> productos) {
        setArchivo(archivo);
        this.productos = productos;
    }

    @Override
    public void exportar() {

        File archivoObj = new File("src/" + this.getArchivo());
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            // Crear el archivo y exportar productos
            archivoObj.createNewFile();
            fw = new FileWriter(archivoObj);
            bw = new BufferedWriter(fw);

            Iterator<Producto> iterator = productos.iterator();
            while(iterator.hasNext()) {
                bw.write(iterator.next().toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw!=null) {
                    bw.close();
                }
                if (fw!=null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        if(!archivo.endsWith(".txt")) {
            archivo += ".txt";
        }
        this.archivo = archivo;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

}
