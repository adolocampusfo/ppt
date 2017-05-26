import java.io.*;
import java.util.Date;
 
import com.sun.org.apache.bcel.internal.generic.InstructionConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AplicacionJuego {
    
     static  Date fecha;
     static double totalapuestas=0;
   
     public static void main(String[] args) {
        try { 
            Juego mijuego = new Juego();
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String texto="";
            char opcion=' ';
            do {
                fecha=new Date();
                System.out.println("**********************");
                System.out.println("LOTERIAS Y APUESTAS");
                System.out.println("**********************");
                System.out.println("1 - Quiniela.");
                System.out.println("\nElige juego:");
                texto=teclado.readLine();
                opcion=texto.charAt(0);
                if (opcion=='1'){
                    //Llamo al método juego de la Quiniela          
                    mijuego.quiniela();
                    }
               
            } while ( opcion!='0' );
            
            // Mostramos el total mediante la variable de clase tipo static (no se han instanciado objetos.
            System.out.println("........................");
            System.out.println("Total a Pagar: " + Double.toString(mijuego.totalapuestas) + " €");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}