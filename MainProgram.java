import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram{
   
    public static void main(String[] args){

        Calc calculadora = new Calc();
        Lector lector = new Lector();

        Scanner scan = new Scanner(System.in);

        ArrayList<String> documento;
        String direccion;


        System.out.println("\nBienvenido");

        System.out.println("\nProfavor ingrese el Txt");
        direccion = scan.nextLine();
        scan.close();
        documento = lector.leerTxt(direccion);

        










    }
}