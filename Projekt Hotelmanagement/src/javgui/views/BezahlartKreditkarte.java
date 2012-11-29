package javgui.views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class BezahlartKreditkarte extends JPanel {
	private JTextField textFieldKartennr;
	private JTextField textFieldKarteninh;
	private JTextField textFieldCVCCode;

	/**
	 * Create the panel.
	 */
	public BezahlartKreditkarte() {
		setLayout(null);
		
		JLabel lblKreditkartennummer = new JLabel("Kreditkartennummer");
		lblKreditkartennummer.setBounds(22, 54, 97, 14);
		this.add(lblKreditkartennummer);
		
		textFieldKartennr = new JTextField();
		textFieldKartennr.setBounds(159, 51, 152, 20);
		add(textFieldKartennr);
		textFieldKartennr.setColumns(10);
		
		textFieldKarteninh = new JTextField();
		textFieldKarteninh.setColumns(10);
		textFieldKarteninh.setBounds(159, 23, 152, 20);
		add(textFieldKarteninh);
		
		JLabel lblKarteninhaber = new JLabel("Karteninhaber");
		lblKarteninhaber.setBounds(22, 26, 97, 14);
		add(lblKarteninhaber);
		
		textFieldCVCCode = new JTextField();
		textFieldCVCCode.setColumns(10);
		textFieldCVCCode.setBounds(159, 104, 152, 20);
		add(textFieldCVCCode);
		
		JLabel lblCvccvvCode = new JLabel("CVC/CVV Code");
		lblCvccvvCode.setBounds(22, 107, 97, 14);
		add(lblCvccvvCode);
		
		JLabel lblGltigBis = new JLabel("g\u00FCltig bis:");
		lblGltigBis.setBounds(22, 79, 97, 14);
		add(lblGltigBis);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(159, 76, 37, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox_1.setBounds(206, 76, 37, 20);
		add(comboBox_1);
		
		JLabel label = new JLabel("/");
		label.setBounds(199, 79, 46, 14);
		add(label);
		
		JLabel lblMmjj = new JLabel("MM/JJ");
		lblMmjj.setBounds(253, 79, 46, 14);
		add(lblMmjj);

	}
}
