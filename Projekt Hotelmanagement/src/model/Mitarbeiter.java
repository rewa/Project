package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;


public class Mitarbeiter {
	// TODO anpassen mit Datenbank inkl allen MEthoden

	private int mitarbeiterId = -1;
	private String vorname = null;
	private String nachname = null;
	private String strasse = null;

	private String telenr = null;
	private String mobilnr = null;
	private String email = null;
	private Date DOB = null;
	private String geschlecht = null;
	private String staatsangehoerigkeit = null;

	// private int idMAdresse = -1;
	private int plz = 0;
	private String ort = null;
	private String land = null;
	
	//private int idBankkonto = -1;
	private String kreditinstitut = null;
	private int kontonr;
	private int blz;

	
	public Mitarbeiter(String vorname, String nachname, String strasse,
			String telenr, String mobilnr, String email, Date dOB,
			String geschlecht, String staatsangehoerigkeit,
			int plz, String ort, String land,
			String kreditinstitut, int kontonr, int blz) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.telenr = telenr;
		this.mobilnr = mobilnr;
		this.email = email;
		DOB = dOB;
		this.geschlecht = geschlecht;
		this.staatsangehoerigkeit = staatsangehoerigkeit;
		//this.idMAdresse = idMAdresse;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		//this.idBankkonto = idBankkonto;
		this.kreditinstitut = kreditinstitut;
		this.kontonr = kontonr;
		this.blz = blz;
	}

	public Mitarbeiter(int mitarbeiterId, String vorname, String nachname,
			String strasse, String telenr, String mobilnr, String email,
			Date dOB, String geschlecht, String staatsangehoerigkeit,
			 int plz, String ort, String land, 
			String kreditinstitut, int kontonr, int blz) {
		super();
		this.mitarbeiterId = mitarbeiterId;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.telenr = telenr;
		this.mobilnr = mobilnr;
		this.email = email;
		DOB = dOB;
		this.geschlecht = geschlecht;
		this.staatsangehoerigkeit = staatsangehoerigkeit;
		//this.idMAdresse = idMAdresse;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		//this.idBankkonto = idBankkonto;
		this.kreditinstitut = kreditinstitut;
		this.kontonr = kontonr;
		this.blz = blz;
	}

	//TODO Parameter mit Procedures abgleichen
	public void MAanlegenProcedure() {
		Connection c = ConnectionFactory.createConnection();

		try {
			PreparedStatement s = c
					.prepareStatement("call mitarbeiteranlegen (?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?);");
			s.setInt(1, this.mitarbeiterId);
			s.setString(2, this.vorname);
			s.setString(3, this.nachname);
			s.setString(4, this.strasse);
			s.setString(5, this.telenr);
			s.setString(6, this.mobilnr);
			s.setString(7, this.email);
			s.setDate(8, this.DOB);
			s.setString(9, this.geschlecht);
			s.setString(11, this.staatsangehoerigkeit);
			
			//s.setInt(12, this.idMAdresse);
			s.setInt(12, this.plz);
			s.setString(13, this.ort);
			s.setString(14, this.land);

//			s.setInt(16, this.idBankkonto);
			s.setString(15, this.kreditinstitut);
			s.setInt(16, this.kontonr);
			s.setInt(17, this.blz);


			s.execute();
			c.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//TODO
	public void MitarbeiterLoeschen(){
		
	}
	
	//TODO
	public void MitarbeiterUpdate(){
		
	}
	
	//zeigt alles von MA an
	//TODO Query darf nicht mit * sein
	public static JTable initTable(JTable table) {

		String query = "select * from mitarbeiter";
		Connection c = ConnectionFactory.createConnection();

		try {
			// statement creation
			Statement state = (Statement) c.createStatement();
			// Query execution
			ResultSet res = state.executeQuery(query);

			// retrieve of the meta data in order to retrieve the columns names
			ResultSetMetaData meta = (ResultSetMetaData) res.getMetaData();

			// Initialization of an array for the titles of the array columns
			Object[] column = new Object[meta.getColumnCount()];

			for (int i = 1; i <= meta.getColumnCount(); i++) {
				column[i - 1] = meta.getColumnName(i);
			}

			// retrieving the number of lines (Results)
			res.last();

			Object[][] data = new Object[res.getRow()][meta.getColumnCount()];

			// getting the cursor to the first line :)
			res.beforeFirst();
			int j = 1;

			// we fill the array with objects (Object[][])
			while (res.next()) {
				for (int i = 1; i <= meta.getColumnCount(); i++)
					data[j - 1][i - 1] = res.getObject(i);
				j++;
			}

			res.close();
			state.close();

			table = new JTable(data, column) {

				public boolean isCellEditable(final int row, final int column) {
					return false;
				}
			};

			//TODO
			// for(int i=0; i<20 ;i++)
			// {
			// table.getColumnModel().getColumn(i);
			// }

			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(160);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(160);
			table.getColumnModel().getColumn(4).setPreferredWidth(130);
			table.getColumnModel().getColumn(5).setPreferredWidth(130);
			table.getColumnModel().getColumn(6).setPreferredWidth(300);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setPreferredWidth(130);
			table.getColumnModel().getColumn(9).setPreferredWidth(170);
			table.getColumnModel().getColumn(10).setPreferredWidth(200);
			table.getColumnModel().getColumn(11).setPreferredWidth(90);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERROR in initTable! ", JOptionPane.ERROR_MESSAGE);
		}
		catch (NullPointerException nl){
			JOptionPane.showMessageDialog(null,nl.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
		}
		return table;
	}
	
	
	/*
	public void MAanlegen(String vorName, String nachName, String ort,
			String teleNR, Date dOB, String strasse, int plz, String email,
			double gehalt, String taetigkeit, Boolean geschlecht) {
		// getText von Gui
		Mitarbeiter newM = new Mitarbeiter(vorName, nachName, ort, teleNR, dOB,
				strasse, plz, email, gehalt, taetigkeit, geschlecht);

		Connection c = ConnectionFactory.createConnection();

		try {
			PreparedStatement s = c
					.prepareStatement(
							"INSERT INTO mitarbeiter (vorName, nachName, ort,teleNR,"
									+ "	dOB, strasse, plz, email,gehalt, taetigkeit, geschlecht) "
									+ " values (?, ?, ?, ?,?, ?, ?, ?,?, ?, ? );",
							Statement.RETURN_GENERATED_KEYS);
			s.setString(1, this.getVorName());
			s.setString(2, this.getNachName());
			s.setString(3, this.getOrt());
			s.setString(4, this.getTeleNR());
			s.setString(5, this.getDOB());
			s.setString(6, this.getStrasse());
			s.setInt(7, this.getPlz());
			s.setString(8, this.getEmail());
			s.setDouble(9, this.getGehalt());
			s.setString(10, this.getTaetigkeit());
			s.setBoolean(11, this.getGeschlecht());

			s.execute();
			ResultSet erg = s.getGeneratedKeys();
			if (erg.next()) {
				this.setMitarbeiterId(erg.getInt(1));
			}
			c.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}*/

/*
	// zeigt alles von MA an und alle MA
	public static JTable initTable(JTable table) {

		String query = "select * from mitarbeiter";
		Connection c = ConnectionFactory.createConnection();

		try {
			// statement creation
			Statement state = (Statement) c.createStatement();
			// Query execution
			ResultSet res = state.executeQuery(query);

			// retrieve of the meta data in order to retrieve the columns names
			ResultSetMetaData meta = (ResultSetMetaData) res.getMetaData();

			// Initialization of an array for the titles of the array columns
			Object[] column = new Object[meta.getColumnCount()];

			for (int i = 1; i <= meta.getColumnCount(); i++) {
				column[i - 1] = meta.getColumnName(i);
			}

			// retrieving the number of lines (Results)
			res.last();

			Object[][] data = new Object[res.getRow()][meta.getColumnCount()];

			// getting the cursor to the first line :)
			res.beforeFirst();
			int j = 1;

			// we fill the array with objects (Object[][])
			while (res.next()) {
				for (int i = 1; i <= meta.getColumnCount(); i++)
					data[j - 1][i - 1] = res.getObject(i);
				j++;
			}

			res.close();
			state.close();

			table = new JTable(data, column) {

				public boolean isCellEditable(final int row, final int column) {
					return false;
				}
			};

			// TODO
			// for(int i=0; i<20 ;i++)
			// {
			// table.getColumnModel().getColumn(i);
			// }

			// TODO
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(160);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(160);
			table.getColumnModel().getColumn(4).setPreferredWidth(130);
			table.getColumnModel().getColumn(5).setPreferredWidth(130);
			table.getColumnModel().getColumn(6).setPreferredWidth(300);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setPreferredWidth(130);
			table.getColumnModel().getColumn(9).setPreferredWidth(170);
			table.getColumnModel().getColumn(10).setPreferredWidth(200);
			table.getColumnModel().getColumn(11).setPreferredWidth(90);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ERROR in initTable! ", JOptionPane.ERROR_MESSAGE);
		}
		return table;
	}*/

	public int getMitarbeiterId() {
		return mitarbeiterId;
	}

	public void setMitarbeiterId(int mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getTelenr() {
		return telenr;
	}

	public void setTelenr(String telenr) {
		this.telenr = telenr;
	}

	public String getMobilnr() {
		return mobilnr;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getStaatsangehoerigkeit() {
		return staatsangehoerigkeit;
	}

	public void setStaatsangehoerigkeit(String staatsangehoerigkeit) {
		this.staatsangehoerigkeit = staatsangehoerigkeit;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getKreditinstitut() {
		return kreditinstitut;
	}

	public void setKreditinstitut(String kreditinstitut) {
		this.kreditinstitut = kreditinstitut;
	}

	public int getKontonr() {
		return kontonr;
	}

	public void setKontonr(int kontonr) {
		this.kontonr = kontonr;
	}

	public int getBlz() {
		return blz;
	}

	public void setBlz(int blz) {
		this.blz = blz;
	}

	
	
}
