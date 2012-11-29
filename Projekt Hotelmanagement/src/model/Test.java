package model;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;


//allgemeine Testklassen zur Überprüfung von GUI Varbiablen
// und Exception werfen
public class Test {

	public static void testGastAnlegen(String vorname, String nachname, String strasse, String telenr,
			String mobilnr, String email, String dOB, String geschlecht,
			String ausweisnr, String staatsangehoerigkeit, int plz, String ort,
			String land, String kreditinstitut, int kontonr, int blz,
			String iban){
		
		try{
			testLeer(vorname);
			testLeer(nachname);
			testLeer(strasse);
			testLeer(telenr);
			testLeer(mobilnr);
			testLeer(email);
			testLeer(dOB);
			testLeer(geschlecht);
			testLeer(ausweisnr);
			testLeer(staatsangehoerigkeit);
			testLeer(plz);
			testLeer(ort);
			testLeer(land);
			testLeer(kreditinstitut);
			testLeer(blz);
			testLeer(kontonr);
			testLeer(iban);

		}catch(IllegalArgumentException e){
			System.out.println("Mindestens eine Variable war leer");
		}finally{
			System.out.println("Wurde überprüft");
		}
		
	}
	
	public static void testDatum(String datum){
		try {
            //Test if Dataformat is correct
            if (Pattern.matches(".*[0-9]{4}-[01][0-9]-[0-3][0-9].([0-2][0-9]):[0-5][0-9]:[0-5][0-9].0", datum)) {
               //Datum ist gültig
            	return;
                
            } else {
            	//Datum ist ungültig
                JOptionPane.showMessageDialog(null, "Falsches Datum eingegeben", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please type in valid values!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Error occured!" + a.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	//Prüft ob String leer ist
	public static void testLeer(String text) 
	{
		if (text.isEmpty()){
			//String ist leer
			throw new IllegalArgumentException();
		}
		
	}
		
	//prüft ob Integer leer ist
	public static void testLeer(Integer text) 
	{
		String name = "" + text;
		
		if ( name.isEmpty() ){
			//String ist leer
			throw new IllegalArgumentException();
		}
		
	}
	
}
