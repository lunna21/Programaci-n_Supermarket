//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import com.sun.tools.javac.Main;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		//		try(Writer w =new FileWriter("hola.txt")){
		//			w.write("Hola\n");
		//			w.write("Como estas\n");
		//			w.append('h');
		//		}	catch(IOException ex) {
		//			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,ex);
		//		}


		/**
		 *video: Curso Java #38 - FileReader y FileWriter
		 * FileReader lee por caracteres
		 */

		try {
			//Abro stream, crea el fichero si no existe
			FileWriter fw = new FileWriter("C:\\Users\\pc\\Desktop\\UPTC\\TERCER SEMESTRE\\PROGRAMACIÓN II\\Chain Supermarket\\src\\persistence\\fichero1.txt",true);
			FileReader fr = new FileReader("C:\\Users\\pc\\Desktop\\UPTC\\TERCER SEMESTRE\\PROGRAMACIÓN II\\Chain Supermarket\\src\\persistence:\\fichero1.txt");
			//Escribimos en el fichero un String y un caracter 97 (a)
			fw.write("esto es una prueba");
			fw.write(97);
			fw.write("\r\n");//SALTO DE LÏNEA
			//Cierro el stream
			fw.flush();//recarga
			//Abro el Stream, el fichero debe existir
			
			//Leemos el fichero y lo mostramos por pantalla 
			int valor= fr.read();//Lee por caracteres
			while (valor!=-1) {//Hay caracter
				System.out.println((char)valor);
				valor=fr.read();
			}
			fr.close();            
		} catch (IOException e) {
			System.out.println("Error e/S: " +e);
		}


	}

}

