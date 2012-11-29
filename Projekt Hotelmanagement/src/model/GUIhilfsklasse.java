package model;


import javax.swing.JComboBox;

public class GUIhilfsklasse {
	
	
	public static String ComboBoxDatum(JComboBox tag,JComboBox monat, JComboBox jahr) {
		String datum=null;
		datum=jahr.getSelectedItem()+"-"+monat.getSelectedItem()+"-"+tag.getSelectedItem();
		return datum;
		
	}

}
