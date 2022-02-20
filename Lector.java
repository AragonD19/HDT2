import java.io.*;
import java.util.ArrayList;


public class Lector{
    

    public ArrayList<String> leerTxt(String direccion){
        ArrayList<String> texto = new ArrayList<String>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String line;
            while ((line = bf.readLine()) != null) {
                texto.add(line);
            }
            return texto;

        } catch(Exception e){                
            texto.clear();
            texto.add("No hay archivo");
            }

        return texto;
    }
}