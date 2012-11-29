package javgui.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.ComponentOrientation;

public class MainGui extends JFrame {
    private static final long serialVersionUID = 1L;
    private JDesktopPane desktopPane;
    private CardLayout cl;
    private static MainGui view;
    private Gastanlegen gasta;
    private Mitarbeiteranlegen mita;
    private TabelleAnzeigen taba;
    private JPanel contentPane;
    private static Dimension d;
    private JMenuItem mnEdit_1;
   // private NewReservation rs;
  
      
    public static void guishow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGui frame = new MainGui();
                    view = frame;
                    d = Toolkit.getDefaultToolkit().getScreenSize();
                    view.setSize(d.width, d.height);
                    frame.setVisible(true);
                }catch (Exception e){e.printStackTrace();}
            }
        });
        }
    

    
      
	/**
	 * Create the frame.
	 */
	public MainGui() {
	
		setFrameproperties();
		
		createMenu();
		
		createContentPane();
		
		createToolbar();
		
		createDesktopPane();

        

		
	}
	private void createMenu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		JMenuItem mnEdit=new JMenuItem();
		
		mnEdit_1 = new JMenu("Bearbeiten");
		menuBar.add(mnEdit_1);
		
		
		
		JMenuItem mntmBenutzerAnlegen = new JMenuItem("Gast anlegen");
		mntmBenutzerAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        if ((gasta == null) || (gasta.isClosed())	){
					gasta=new Gastanlegen();
					desktopPane.add(gasta,"anlegenGast");
					gasta.setMaximumSize(d);
					gasta.show();
					}
			}
		});
		
	
		
		
		
		mntmBenutzerAnlegen.setIcon(new ImageIcon(MainGui.class.getResource("/java/guiresources/User.png")));
		mnEdit_1.add(mntmBenutzerAnlegen);
		
		JMenuItem mntmMitarbeiterAnlegen = new JMenuItem("Mitarbeiter anlegen");
		mntmMitarbeiterAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        if ((mita == null) || (mita.isClosed())	){
					mita=new Mitarbeiteranlegen();
					desktopPane.add(mita,"anlegenMitarbeiter");
					mita.setMaximumSize(d);
					mita.show();
					}
			}
		});
		mntmMitarbeiterAnlegen.setIcon(new ImageIcon(MainGui.class.getResource("/java/guiresources/User2.png")));
		mnEdit_1.add(mntmMitarbeiterAnlegen);
		
		JMenuItem mntmTabelleanzeigen = new JMenuItem("TabelleAnzeigen");
	    mntmTabelleanzeigen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    	        if ((taba == null) || (taba.isClosed())	){
    					taba = new TabelleAnzeigen();
    					desktopPane.add(taba,"anzeigenTabelle");
    					taba.show();
    					}
        	}
        });
		mntmTabelleanzeigen.setIcon(new ImageIcon(MainGui.class.getResource("/java/guiresources/Application_Design.png")));
		mnEdit_1.add(mntmTabelleanzeigen);
		
		JMenuItem mntmEinstellungen = new JMenuItem("Einstellungen");
		mnEdit_1.add(mntmEinstellungen);
		
		JMenu mnberUns = new JMenu("\u00DCber Uns");
		menuBar.add(mnberUns);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		
	}

	private void setFrameproperties(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGui.class.getResource("/java/guiresources/icon_klein_XTREME.png")));
		setTitle("XTreme Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		
	}

	private void createContentPane(){
		contentPane = new JPanel();
//		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
//		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
//		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
	}
	
	private void createToolbar(){
        JToolBar toolBar = new JToolBar();
        toolBar.setOrientation(SwingConstants.VERTICAL);
        toolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        toolBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        toolBar.setLayout(new GridLayout (20,1));
        contentPane.add(toolBar);
        
        JButton btnMitarbeiteranlegen = new JButton("Mitarbeiteranlegen");
        btnMitarbeiteranlegen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    	        if ((mita == null) || (mita.isClosed())	){
    					mita = new Mitarbeiteranlegen();
    					desktopPane.add(mita,"anlegenGast");
    					mita.show();
    					}
        	}
        });
        btnMitarbeiteranlegen.setHorizontalAlignment(SwingConstants.LEFT);
//        btnMitarbeiteranlegen.setVerticalAlignment(SwingConstants.TOP);
//      btnMitarbeiteranlegen.setAlignmentY(Component.TOP_ALIGNMENT);
        btnMitarbeiteranlegen.setIcon(new ImageIcon(MainGui.class.getResource("/java/guiresources/User2.png")));
        toolBar.add(btnMitarbeiteranlegen);
        
        JButton btnGastanlegen = new JButton("Gastanlegen");
        btnGastanlegen.setHorizontalAlignment(SwingConstants.LEFT);
//        btnGastanlegen.setVerticalAlignment(SwingConstants.TOP);
        toolBar.add(btnGastanlegen);
//        btnGastanlegen.setAlignmentY(Component.TOP_ALIGNMENT);
        btnGastanlegen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    	        if ((gasta == null) || (gasta.isClosed())	){
    					gasta=new Gastanlegen();
    					desktopPane.add(gasta,"anlegenGast");
    					gasta.show();
    					}
        	}
        });
        btnGastanlegen.setIcon(new ImageIcon(MainGui.class.getResource("/java/guiresources/User.png")));
        
        JButton btnTabelleanzeigen = new JButton("Tabelleanzeigen");
        btnTabelleanzeigen.setHorizontalAlignment(SwingConstants.LEFT);
        btnTabelleanzeigen.setIcon(new ImageIcon(MainGui.class.getResource("/java/guiresources/Application_Design.png")));
        toolBar.add(btnTabelleanzeigen);
        btnTabelleanzeigen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    	        if ((taba == null) || (taba.isClosed())	){
    					taba = new TabelleAnzeigen();
    					desktopPane.add(taba,"anzeigenTabelle");
    					taba.show();
    					}
        	}
        });
		
	}

	private void createDesktopPane(){
        desktopPane = new JDesktopPane();
        desktopPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        desktopPane.setBackground(SystemColor.menu);
        contentPane.add(desktopPane);
        desktopPane.setLayout(null);
	}
}


