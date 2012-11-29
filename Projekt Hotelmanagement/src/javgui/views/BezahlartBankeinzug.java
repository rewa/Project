package javgui.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BezahlartBankeinzug extends JPanel {
	private JTextField textFieldKontoinh;
	private JTextField textFieldKreditinst;
	private JTextField textFieldBLZ;
	private JTextField textFieldKtoNr;
	private JTextField textFieldIban;

	/**
	 * Create the panel.
	 */
	public BezahlartBankeinzug() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kontoinhaber");
		lblNewLabel.setBounds(21, 14, 86, 14);
		add(lblNewLabel);
		
		textFieldKontoinh = new JTextField();
		textFieldKontoinh.setBounds(139, 11, 158, 20);
		add(textFieldKontoinh);
		textFieldKontoinh.setColumns(10);
		
		JLabel lblKreditinstitut = new JLabel("Kreditinstitut");
		lblKreditinstitut.setBounds(21, 42, 86, 14);
		add(lblKreditinstitut);
		
		textFieldKreditinst=new JTextField();
		textFieldKreditinst.setColumns(10);
		textFieldKreditinst.setBounds(139, 39, 158, 20);
		add(textFieldKreditinst);
		
		JLabel lblBankleitzahl = new JLabel("Bankleitzahl");
		lblBankleitzahl.setBounds(21, 70, 86, 14);
		add(lblBankleitzahl);
		
		textFieldBLZ = new JTextField();
		textFieldBLZ.setColumns(10);
		textFieldBLZ.setBounds(139, 67, 158, 20);
		add(textFieldBLZ);
		
		JLabel lblKontonummer = new JLabel("Kontonummer");
		lblKontonummer.setBounds(21, 100, 86, 14);
		add(lblKontonummer);
		
		textFieldKtoNr = new JTextField();
		textFieldKtoNr.setColumns(10);
		textFieldKtoNr.setBounds(139, 97, 158, 20);
		add(textFieldKtoNr);
		
		JLabel lblIban = new JLabel("IBAN");
		lblIban.setBounds(21, 128, 86, 14);
		add(lblIban);
		
		textFieldIban = new JTextField();
		textFieldIban.setColumns(10);
		textFieldIban.setBounds(139, 125, 158, 20);
		add(textFieldIban);

	}
	
	public String getKreditinst() {
		return textFieldKreditinst.getText();
	}

	public String getKontonr(){
		return textFieldKtoNr.getText();
	}
	
	public String getKontoin(){
		return textFieldKontoinh.getText();
	}
	
	public String getBLZ(){
		return textFieldBLZ.getText();
	}
	
	public String getIBAN(){
		return textFieldIban.getText();
	}
}
