 
import com.sun.org.apache.bcel.internal.generic.InstructionConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
// Clases añadidas para el correcto funcionamiento del programa
import java.util.Calendar;
import java.util.GregorianCalendar;
// Para los numeros aleatorios
import java.util.Random;

public class Juego {
  //Creo una variable de clase para almacenar el total. Esta variable es visible para el resto de métodos de la clase
    static  String fechacadena;
    static  Date fecha;
    static double totalapuestas=0;
 
    private static void borrar_pantalla()
    {
      for ( int i=0;i<50;i++)
            System.out.println("\n");
       
    }
    private static void tecla_para_continuar() throws IOException
    {
        String texto;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nPulse una tecla para continuar ...");
        texto=teclado.readLine();
    }
    
    
    public static String sumar_fechas_dias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        // Direccion  para ver los delimitadores http://javatechniques.com/blog/dateformat-and-simpledateformat-examples/
        SimpleDateFormat formateador = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
        String formateada = formateador.format(cal.getTime());
      return formateada;
       
    }
       
    // Metodo de clase que calcula el dia del sorteo.
    private static String dia_del_sorteo (Date dia_actual, int tipo_sorteo)
    {
       
      Date fecha;
      fecha=new Date();
      int Dias_A_Anadir=0;
      String fechacadena,diaactual;
      fechacadena=fecha.toString();
      fechacadena=fechacadena.substring(0,3).toLowerCase();
      
      if (tipo_sorteo==1) // Sorteo de la primitiva
      {
         if (fechacadena.equals("thu"))
         { 
       
          return fecha.toString();
         }
        else
         {
            if (fechacadena.equals("mon"))
             Dias_A_Anadir=3;
            if (fechacadena.equals("tue"))
             Dias_A_Anadir=2;
            if (fechacadena.equals("wed"))
             Dias_A_Anadir=1;
            if (fechacadena.equals("fri"))
             Dias_A_Anadir=6;
            if (fechacadena.equals("sat"))
             Dias_A_Anadir=5;
            if (fechacadena.equals("sun"))
             Dias_A_Anadir=4;  
         }
      }
      
      if (tipo_sorteo==2) // Sorteo de la Quiniela
      {
         if (fechacadena.equals("sun"))
         { 
          System.out.println(fechacadena);
          return fecha.toString();
         }
        else
         {
            if (fechacadena.equals("mon"))
             Dias_A_Anadir=6;
            if (fechacadena.equals("tue"))
             Dias_A_Anadir=5;
            if (fechacadena.equals("wed"))
             Dias_A_Anadir=4;
            if (fechacadena.equals("thu"))
             Dias_A_Anadir=3;
            if (fechacadena.equals("fri"))
             Dias_A_Anadir=2;
            if (fechacadena.equals("sat"))
             Dias_A_Anadir=1;  
         }
      }
      
        if (tipo_sorteo==3) // Sorteo de la Loteria Nacional
      {
         if (fechacadena.equals("sat"))
         { 
          System.out.println(fechacadena);
          return fecha.toString();
         }
        else
         {
            if (fechacadena.equals("mon"))
             Dias_A_Anadir=5;
            if (fechacadena.equals("tue"))
             Dias_A_Anadir=4;
            if (fechacadena.equals("wed"))
             Dias_A_Anadir=3;
            if (fechacadena.equals("thu"))
             Dias_A_Anadir=2;
            if (fechacadena.equals("fri"))
             Dias_A_Anadir=1;
            if (fechacadena.equals("sun"))
             Dias_A_Anadir=6;  
         }
      }
    
    return sumar_fechas_dias(fecha, Dias_A_Anadir); 
    
    }
     
    public static void primitiva() throws IOException{//En este método de clase resolveremos el problema de la Primitiva   
      borrar_pantalla();
      fechacadena = dia_del_sorteo(fecha,1).toString();
      // Seguimos con lo que pide el enunciado.
       System.out.println("Próximo Sorteo :" + fechacadena);  
       int NumerosPrimitiva;
       
       //inicializamos los numeros del array
        System.out.print("Apuesta: ");
       for (int i=0;i<=7;i++)
       {
           NumerosPrimitiva=(int) Math.floor(Math.random()*49 +1);
           if (i<6)
               System.out.print(Integer.toString(NumerosPrimitiva)+ " ");
           if (i==6) // Para el complementario
               System.out.println("\nComplementario:" +  Integer.toString(NumerosPrimitiva)+ " ");
           if (i==7)  
           {
               NumerosPrimitiva=(int) Math.floor(Math.random()*9 );
               System.out.print("Reintegro:" + Integer.toString(NumerosPrimitiva)+ " ");
           }
       }
        // Sumamos el coste de la apuesta
         totalapuestas++;
         tecla_para_continuar();
    }
  
    //En este método de clase resolveremos el problema de la Quiniela.
    public static void quiniela() throws IOException
    {
      borrar_pantalla();
      fechacadena = dia_del_sorteo(fecha,2).toString();
      System.out.println("Próxima Jornada :" + fechacadena);  
      System.out.print("¿Cuántas apuestas quieres (2-8)?");
      BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
      int opcion=0;
      String texto="";
      char caracter;
      do
      {
      texto=teclado.readLine();
      caracter= texto.charAt(0);
      opcion=caracter-48; // 48 es el valor ASCII de 0
      if (opcion<=1 || opcion>=8)
               System.out.println("Número de apuestas incorrecto");
               System.out.println(caracter);
      }
      while (opcion<=1 || opcion>=8);
      
      int ApuestasX12;
      //ApuestasX12 = new int [15];
      for(int i=0;i<opcion;i++)
         {
             System.out.print("Apuesta " + Integer.toString(i+1) + ":");
             for (int j=0;j<=14;j++)
               {
                 ApuestasX12=(int) Math.floor(Math.random()*3+1 );
                 if (ApuestasX12==1)
                       System.out.print("1 ");
                 if (ApuestasX12==2)
                      System.out.print("X ");
                 if (ApuestasX12==3)
                      System.out.print("3 ");
               }
             System.out.println("");
         }
      //Calculamos las apuestas en función del numero de opciones introducido
      tecla_para_continuar();
      totalapuestas=totalapuestas + (0.5)*opcion;
    }
    
    //En este método de clase resolveremos el problema de la Loteria Nacional
    public static void loteria_nacional() throws IOException
    {
      borrar_pantalla();
      fechacadena = dia_del_sorteo(fecha,3).toString();
      System.out.println("Próximo Sorteo :" + fechacadena);  
      System.out.println("Elige la terminación hasta 3 cifras: (ENTER si te da igual):");
      BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
      String texto="";
      texto=teclado.readLine();
      int numero;
      // En caso de ser ENTER, todos los numeros, controlo si ya ha aparecido, numeros hasta el 70000
      if (texto.isEmpty())
            {
                
                numero=(int) Math.floor(Math.random()*70000+1);
                       
            }   
      else
            {
                // Comprobamos cuantos digitos ha metido
                if (texto.length()== 3)  
                {
                    String numeroconstruido;
                    int numero1,numero2;
                    numero1=(int)(Math.floor(Math.random()*9));
                    numero2=(int)(Math.floor(Math.random()*9));
                    numeroconstruido= Integer.toString(numero1)+ Integer.toString(numero2)+ texto;
                    System.out.println("Numero con el que juegas: " + numeroconstruido);
                }
                if (texto.length()== 2)  
                {
                    String numeroconstruido;
                    int numero1,numero2,numero3;
                    numero1=(int)(Math.floor(Math.random()*9));
                    numero2=(int)(Math.floor(Math.random()*9));
                    numero3=(int)(Math.floor(Math.random()*9));
                    numeroconstruido= Integer.toString(numero1)+ Integer.toString(numero2)+ Integer.toString(numero3)+ texto;
                    System.out.println("Numero con el que juegas: " + numeroconstruido);
                }
                if (texto.length()== 1)  
                {
                    String numeroconstruido;
                    int numero1,numero2,numero3, numero4;
                    numero1=(int)(Math.floor(Math.random()*9));
                    numero2=(int)(Math.floor(Math.random()*9));
                    numero3=(int)(Math.floor(Math.random()*9));
                    numero4=(int)(Math.floor(Math.random()*9));
                    numeroconstruido= Integer.toString(numero1)+ Integer.toString(numero2)+ Integer.toString(numero3)+  Integer.toString(numero4)+texto;
                    System.out.println("Numero con el que juegas: " + numeroconstruido);
                    
                    
                }
            }
      tecla_para_continuar(); 
      totalapuestas=totalapuestas + 12;
    }
    

}