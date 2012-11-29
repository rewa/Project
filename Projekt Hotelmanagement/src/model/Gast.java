package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.JTable;

//import com.mysql.jdbc.ResultSetMetaData;
//import com.mysql.jdbc.Statement;

import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Gast {

	private int idGast = -1;		//id
	private String vorname = null;
	private String nachname = null;
	private String strasse = null;

	private String telenr;
	private String mobilnr = null;
	private String email = null;
	private String DOB ; //Geburtsdatum
	private String geschlecht;
	private String ausweisnr ;
	private String staatsangehoerigkeit = null;
	//private String passwort = "leer";

	//private int idGAdresse = -1;  //id
	private int plz = -1;
	private String ort = null;
	private String land = null;

	//private int bankknt = -1;  //ist die id
	private String kreditinstitut = null;
	private int kontonr = -1;
	private int blz = -1;
	private String iban = null;

//Konstuktor für Gastanlegen
	public Gast(String vorname, String nachname, String strasse, String telenr,
			String mobilnr, String email, String dOB, String geschlecht,
			String ausweisnr, String staatsangehoerigkeit, int plz, String ort,
			String land, String kreditinstitut, int kontonr, int blz,
			String iban)  {
		super();
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.telenr = telenr;
		this.mobilnr = mobilnr;
		this.email = email;
		DOB = dOB;
		this.geschlecht = geschlecht;
		this.ausweisnr = ausweisnr;
		this.staatsangehoerigkeit = staatsangehoerigkeit;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.kreditinstitut = kreditinstitut;
		this.kontonr = kontonr;
		this.blz = blz;
		this.iban = iban;
		
		//TODO prüft nicht alle felder, evtl auch nicht nötig
		Test.testGastAnlegen(vorname, nachname, strasse, telenr, mobilnr, email, dOB, geschlecht, ausweisnr, staatsangehoerigkeit, plz, ort, land, kreditinstitut, kontonr, blz, iban);
	}

	//mit id
	public Gast(int idGast, String vorname, String nachname, String strasse,
			String telenr, String mobilnr, String email, String dOB,
			String geschlecht, String ausweisnr, String staatsangehoerigkeit,
			 int plz, String ort, String land,
			int bankknt, String kreditinstitut, int kontonr, int blz,
			String iban) {
		super();
		this.idGast = idGast;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.telenr = telenr;
		this.mobilnr = mobilnr;
		this.email = email;
		DOB = dOB;
		this.geschlecht = geschlecht;
		this.ausweisnr = ausweisnr;
		this.staatsangehoerigkeit = staatsangehoerigkeit;
		//this.idGAdresse = idGAdresse;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		//this.bankknt = bankknt;
		this.kreditinstitut = kreditinstitut;
		this.kontonr = kontonr;
		this.blz = blz;
		this.iban = iban;
		
		//TODO prüft nicht alle felder, evtl auch nicht nötig
		Test.testGastAnlegen(vorname, nachname, strasse, telenr, mobilnr, email, dOB, geschlecht, ausweisnr, staatsangehoerigkeit, plz, ort, land, kreditinstitut, kontonr, blz, iban);
	
	}

	//ohne id
	public Gast(String vorname, String nachname, String strasse, String telenr,
			String mobilnr, String email, String dOB, String geschlecht,
			String ausweisnr, String staatsangehoerigkeit, 
			 int plz, String ort, String land, int bankknt,
			String kreditinstitut, int kontonr, int blz, String iban) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.telenr = telenr;
		this.mobilnr = mobilnr;
		this.email = email;
		DOB = dOB;
		this.geschlecht = geschlecht;
		this.ausweisnr = ausweisnr;
		this.staatsangehoerigkeit = staatsangehoerigkeit;
		//this.idGAdresse = idGAdresse;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		//this.bankknt = bankknt;
		this.kreditinstitut = kreditinstitut;
		this.kontonr = kontonr;
		this.blz = blz;
		this.iban = iban;
		
		
		//TODO prüft nicht alle felder, evtl auch nicht nötig
		Test.testGastAnlegen(vorname, nachname, strasse, telenr, mobilnr, email, dOB, geschlecht, ausweisnr, staatsangehoerigkeit, plz, ort, land, kreditinstitut, kontonr, blz, iban);
	}



	// TODO
	//legt Gast mit Procedure an
	public void GastAnlegenProcedure() {
		Connection c = ConnectionFactory.createConnection();

		try {
			PreparedStatement s = c
					.prepareStatement("call gastanlegen (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			s.setString(1, this.vorname);
			s.setString(2, this.nachname);
			s.setString(3, this.strasse);
			s.setString(4, this.telenr);
			s.setString(5, this.mobilnr);
			s.setString(6, this.email);
			//s.setDate(7, this.DOB);
			s.setString(7, this.DOB);
			s.setString(8, this.geschlecht);
			s.setString(9, this.ausweisnr);
			s.setString(10, this.staatsangehoerigkeit);

			//s.setInt(11, this.idGAdresse);
			s.setInt(11, this.plz);
			s.setString(12, this.ort);
			s.setString(13, this.land);
			//s.setInt(15, this.bankknt);
			s.setString(14, this.kreditinstitut);
			s.setInt(15, this.kontonr);
			s.setInt(16, this.blz);
			s.setString(17, this.iban);

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
	public void GastLoeschenProcedure(){
		Connection c = ConnectionFactory.createConnection();

		try {
			PreparedStatement s = c
					.prepareStatement("call gastloeschen (?);");
	
			s.setInt(1, this.idGast);
	

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
	public void GastUpdate(){
		
	}
	
//	//zeigt alles von Gast an und alle Gäste
//
//	public static void initTable() {
//		Showdata<Object[][], Object[]> t = Showdata.initTable("select * from Gast");
//		return null;
//	}
	

	//alle Get und Setter
	public int getIdGast() {
		return idGast;
	}

	public void setIdGast(int idGast) {
		this.idGast = idGast;
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

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getAusweisnr() {
		return ausweisnr;
	}

	public void setAusweisnr(String ausweisnr) {
		this.ausweisnr = ausweisnr;
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

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	

	
}
