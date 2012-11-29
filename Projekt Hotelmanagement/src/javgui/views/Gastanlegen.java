package javgui.views;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyVetoException;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import model.Gast;

import java.awt.Color;

public class Gastanlegen extends JInternalFrame {
	private JTextField vorName;
	private JTextField nachName;
	private JTextField straße;
	private JTextField plz;
	private JTextField land;
	private JTextField stadt;
	private JTextField festnetz;
	private JTextField mobil;
	private JTextField email;
	private JTextField Ausweisnr;
	JComboBox geschlecht = new JComboBox();
	public JComboBox cbxmonth = new JComboBox();
	public JComboBox cbxyear = new JComboBox();
	public JComboBox cbxinsday = new JComboBox();
	private JTextField Staatsangeh;

	/**
	 * Create the panel.
	 */
	public Gastanlegen() {
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
		
/*		final JPanel panelBezahlung = new JPanel();
		panelBezahlung.setBounds(255, 162, 404, 170);
		getContentPane().add(panelBezahlung);
*/		
		JLabel lblText = new JLabel("Vorname");
		lblText.setBounds(10, 55, 62, 14);
		getContentPane().add(lblText);
		
		final JPanel panel = new JPanel();
		panel.setBounds(255, 158, 409, 166);
		getContentPane().add(panel);
		panel.setLayout( new CardLayout(0, 0));
		BezahlartKreditkarte bezahlartKreditkarte=new BezahlartKreditkarte();
		panel.add(bezahlartKreditkarte,"Kreditkarte");
		final BezahlartBankeinzug bezahlartBankeinzug=new BezahlartBankeinzug();
		panel.add(bezahlartBankeinzug, "Bankeinzug");
		final CardLayout c1 = (CardLayout) (panel.getLayout());
		c1.show(panel, "Kreditkarte");
		
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
		
		
		geschlecht.setModel(new DefaultComboBoxModel(new String[] {"W\u00E4hlen Sie Geschlecht", "M\u00E4nnlich", "Weiblich"}));
		geschlecht.setSelectedIndex(0);
		geschlecht.setBounds(72, 24, 153, 20);
		getContentPane().add(geschlecht);
		
		JLabel lblAusweisnr = new JLabel("Ausweisnummer");
		lblAusweisnr.setBounds(255, 105, 110, 14);
		getContentPane().add(lblAusweisnr);
		
		Ausweisnr = new JTextField();
		Ausweisnr.setBounds(385, 105, 153, 20);
		getContentPane().add(Ausweisnr);
		Ausweisnr.setColumns(10);
		cbxmonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		
		cbxmonth.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				updateDayDropdown();
			}
		});
		cbxmonth.setBounds(434, 49, 110, 20);
		getContentPane().add(cbxmonth);
		cbxyear.setModel(new DefaultComboBoxModel(new String[] {"1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012"}));
		
		
		cbxyear.setBounds(547, 49, 111, 20);
		getContentPane().add(cbxyear);
		cbxinsday.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		
		cbxinsday.setBounds(385, 49, 46, 20);
		getContentPane().add(cbxinsday);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try {Gast ga=new Gast(vorName.getText(),nachName.getText(),straße.getText(),festnetz.getText(),mobil.getText(),email.getText(),model.GUIhilfsklasse.ComboBoxDatum(cbxinsday,cbxmonth,cbxyear),(String)geschlecht.getSelectedItem(),Ausweisnr.getText(),Staatsangeh.getText(),1,1,plz.getText(),stadt.getText(),land.getText(),1,bezahlartBankeinzug.getKreditinst(),bezahlartBankeinzug.getKontonr(),bezahlartBankeinzug.getBLZ(),bezahlartBankeinzug.getIBAN());
			  ga.GastanlegenProcedure();}
				catch (Error e){
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
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
		btnAbbrechen.setBounds(179, 343, 138, 39);
		getContentPane().add(btnAbbrechen);
		
		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(255, 55, 74, 14);
		getContentPane().add(lblGeburtsdatum);
		
		JLabel lblStaatsangehrigkeit = new JLabel("Staatsangeh\u00F6rigkeit");
		lblStaatsangehrigkeit.setBounds(255, 80, 110, 14);
		getContentPane().add(lblStaatsangehrigkeit);
		
		JLabel lblKreditinstitut = new JLabel("Bezahlart");
		lblKreditinstitut.setBounds(255, 133, 110, 14);
		getContentPane().add(lblKreditinstitut);
		
		JRadioButton rdbtnKreditkarte = new JRadioButton("Kreditkarte");
		rdbtnKreditkarte.setSelected(true);
		rdbtnKreditkarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panel, "Kreditkarte");
			/*		BezahlartKreditkarte panelBezahlung1 = new BezahlartKreditkarte();
					panelBezahlung1.setBounds(255, 162, 404, 170);
					getContentPane().add(panelBezahlung1);
					panelBezahlung1.setVisible(true);
					getContentPane().repaint(); */
	//				System.out.println("Hallo");
					
				
			}
		});
		rdbtnKreditkarte.setBounds(376, 129, 109, 23);
		getContentPane().add(rdbtnKreditkarte);
		
		JRadioButton rdbtnBankeinzug = new JRadioButton("Bankeinzug");
		rdbtnBankeinzug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panel, "Bankeinzug");
/*				BezahlartBankeinzug panelBezahlung2 = new BezahlartBankeinzug();
				panelBezahlung2.setBounds(255, 162, 404, 170);
				getContentPane().add(panelBezahlung2);
				panelBezahlung2.setVisible(true);
				getContentPane().repaint();
//				System.out.println("Hallo"); */
			}
		});
		rdbtnBankeinzug.setBounds(494, 129, 109, 23);
		getContentPane().add(rdbtnBankeinzug);
		
		ButtonGroup b1 = new ButtonGroup();
		b1.add(rdbtnBankeinzug);
		b1.add(rdbtnKreditkarte);
		
		Staatsangeh = new JTextField();
		Staatsangeh.setColumns(10);
		Staatsangeh.setBounds(385, 77, 153, 20);
		getContentPane().add(Staatsangeh);
		


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
