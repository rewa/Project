package javgui.views;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Mitarbeiter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mitarbeiteranlegen extends JInternalFrame {

	private JTextField vorName;
	private JTextField nachName;
	private JTextField straße;
	private JTextField plz;
	private JTextField land;
	private JTextField stadt;
	private JTextField festnetz;
	private JTextField mobil;
	private JTextField email;
	private JTextField textField;
	JComboBox geschlecht = new JComboBox();
	public JComboBox cbxmonth = new JComboBox();
	public JComboBox cbxyear = new JComboBox();
	public JComboBox cbxinsday = new JComboBox();
	private JTextField beruf;
	private JTextField gehalt;

	/**
	 * Create the panel.
	 */
	public Mitarbeiteranlegen() {
		setResizable(true);
		//setMaximum(true);
		//setIcon(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(0, 0, 720, 500);
/*		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}*/
		
		JLabel lblText = new JLabel("Vorname");
		lblText.setBounds(10, 55, 62, 14);
		getContentPane().add(lblText);
		
		vorName = new JTextField();
		vorName.setBounds(72, 52, 153, 20);
		getContentPane().add(vorName);
		vorName.setColumns(10);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(10, 80, 62, 14);
		getContentPane().add(lblNachname);
		
		nachName = new JTextField();
		nachName.setBounds(72, 77, 153, 20);
		getContentPane().add(nachName);
		nachName.setColumns(10);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe");
		lblStrae.setBounds(10, 108, 45, 14);
		getContentPane().add(lblStrae);
		
		straße = new JTextField();
		straße.setBounds(72, 105, 153, 20);
		getContentPane().add(straße);
		straße.setColumns(10);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setBounds(10, 133, 46, 14);
		getContentPane().add(lblPlz);
		
		plz = new JTextField();
		plz.setBounds(72, 130, 153, 20);
		getContentPane().add(plz);
		plz.setColumns(10);
		
		JLabel lblStadt = new JLabel("Stadt");
		lblStadt.setBounds(10, 158, 46, 14);
		getContentPane().add(lblStadt);
		
		JLabel lblLand = new JLabel("Land");
		lblLand.setBounds(10, 183, 46, 14);
		getContentPane().add(lblLand);
		
		land = new JTextField();
		land.setBounds(72, 180, 153, 20);
		getContentPane().add(land);
		land.setColumns(10);
		
		stadt = new JTextField();
		stadt.setBounds(72, 155, 153, 20);
		getContentPane().add(stadt);
		stadt.setColumns(10);
		
		JLabel lblTelefonnummer = new JLabel("Festnetz");
		lblTelefonnummer.setBounds(10, 208, 45, 14);
		getContentPane().add(lblTelefonnummer);
		
		festnetz = new JTextField();
		festnetz.setBounds(72, 205, 153, 20);
		getContentPane().add(festnetz);
		festnetz.setColumns(10);
		
		JLabel lblMobil = new JLabel("Mobil");
		lblMobil.setBounds(9, 233, 46, 14);
		getContentPane().add(lblMobil);
		
		mobil = new JTextField();
		mobil.setBounds(72, 230, 153, 20);
		getContentPane().add(mobil);
		mobil.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(9, 258, 46, 14);
		getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setBounds(72, 255, 153, 20);
		getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setBounds(10, 30, 63, 14);
		getContentPane().add(lblGeschlecht);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"W\u00E4hlen Sie Geschlecht", "M\u00E4nnlich", "Weiblich"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(72, 24, 153, 20);
		getContentPane().add(comboBox);
		
		JLabel lblAusweisnr = new JLabel("Ausweisnr.");
		lblAusweisnr.setBounds(10, 283, 62, 14);
		getContentPane().add(lblAusweisnr);
		
		textField = new JTextField();
		textField.setBounds(72, 280, 153, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		cbxmonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		
		cbxmonth.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				updateDayDropdown();
			}
		});
		cbxmonth.setBounds(383, 24, 110, 20);
		getContentPane().add(cbxmonth);
		cbxyear.setModel(new DefaultComboBoxModel(new String[] {"1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012"}));
		
		
		cbxyear.setBounds(496, 24, 111, 20);
		getContentPane().add(cbxyear);
		cbxinsday.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		
		cbxinsday.setBounds(334, 24, 46, 20);
		getContentPane().add(cbxinsday);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){//mobil machen,Date casten,Staatsanghörigkeit
				try {
				Mitarbeiter mit=new Mitarbeiter(vorName.getText(),nachName.getText(),straße.getText(),festnetz.getText(),mobil.getText(),email.getText(),(Date)model.GUIhilfsklasse.ComboBoxDatum(cbxinsday,cbxmonth,cbxyear),(String)geschlecht.getSelectedItem(),plz.getText(),email.getText(),gehalt.getText(),beruf.getText(),(String)geschlecht.getSelectedItem());
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
		});
		btnOk.setHorizontalAlignment(SwingConstants.LEFT);
		btnOk.setIcon(new ImageIcon(Gastanlegen.class.getResource("/java/guiresources/Valid.png")));
		btnOk.setBounds(23, 343, 138, 39);
		getContentPane().add(btnOk);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAbbrechen.setIcon(new ImageIcon(Gastanlegen.class.getResource("/java/guiresources/Error.png")));
		btnAbbrechen.setHorizontalAlignment(SwingConstants.LEFT);
		btnAbbrechen.setBounds(171, 343, 138, 39);
		getContentPane().add(btnAbbrechen);
		
		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(255, 30, 79, 14);
		getContentPane().add(lblGeburtsdatum);
		
		JLabel lblBeruf = new JLabel("Beruf");
		lblBeruf.setBounds(255, 55, 74, 14);
		getContentPane().add(lblBeruf);
		
		JLabel lblGehalt = new JLabel("Gehalt");
		lblGehalt.setBounds(255, 80, 46, 14);
		getContentPane().add(lblGehalt);
		
		beruf = new JTextField();
		beruf.setBounds(334, 52, 86, 20);
		getContentPane().add(beruf);
		beruf.setColumns(10);
		
		gehalt = new JTextField();
		gehalt.setBounds(334, 77, 86, 20);
		getContentPane().add(gehalt);
		gehalt.setColumns(10);

	}
	
	public void updateDayDropdown()
	{
		
		int year, month, max = 0,panel = 0;
		JComboBox cyear;
		JComboBox cmonth;
		cmonth=cbxmonth;
		cyear=cbxyear;
		
	year = Integer.parseInt(cyear.getSelectedItem().toString());
	month = Integer.parseInt(cmonth.getSelectedItem().toString());
	
	month--; // because januar is the month 0 :)
	
	GregorianCalendar cal = new GregorianCalendar(year, month, 1);
	max = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	
	
	
	if( Integer.parseInt(cbxinsday.getSelectedItem().toString())>max) {	
		
	String[] arr = new String[max];
	for(int i = 0; i < max; i++)
		{	
			while(i < 9)
				{
					arr[i] = "0"+(i+1);
					i++;
				}
			arr[i] = ""+(i+1);
		}
	
	cbxinsday.setModel(new DefaultComboBoxModel(arr));	}
		
	}
}
