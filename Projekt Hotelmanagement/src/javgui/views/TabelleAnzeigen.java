package javgui.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;


public class TabelleAnzeigen extends JInternalFrame {
	JTable table;
	private JPanel jtablepanel;
	/**
	 * Launch the application.
	 */
	public TabelleAnzeigen() {
		setResizable(true);
		//setMaximum(true);
		//setIcon(true);
		jtablepanel = new JPanel();
		setContentPane(jtablepanel);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setLayout(new BorderLayout());
		
		setBounds(0, 0, 720, 500);

		
		JButton btnOk = new JButton("OK");
		btnOk.setHorizontalAlignment(SwingConstants.LEFT);
		btnOk.setIcon(new ImageIcon(Gastanlegen.class.getResource("/java/guiresources/Valid.png")));
		btnOk.setBounds(23, 343, 138, 39);
		jtablepanel.add(btnOk, BorderLayout.SOUTH);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setIcon(new ImageIcon(Gastanlegen.class.getResource("/java/guiresources/Error.png")));
		btnAbbrechen.setHorizontalAlignment(SwingConstants.LEFT);
		btnAbbrechen.setBounds(158, 343, 138, 39);
		jtablepanel.add(btnAbbrechen, BorderLayout.SOUTH);
		
		
		/*
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};*/
		
		table = new JTable();
		table.setBounds(160, 160, 300, 300);
		table = model.Gast.initTable(table);
		jtablepanel.add(table, BorderLayout.CENTER);
		//getContentPane().add(Gast.initTable());
		//getContentPane().add(table);
	

	}
}
