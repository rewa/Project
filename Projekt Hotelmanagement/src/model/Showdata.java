/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author Faycal
 *
 */
public class Showdata<d,c> {
	private d data;
	private c column;

	public Showdata(d data, c column)
    {
        this.data = data;
        this.column = column;
    }


	public d getData() {
		return data;
	}


	public c getColumn() {
		return column;
	}

	public static  Showdata <Object[][], Object[]> initTable(int zahl){
		Object[] column = null;
		Object[][] data = null;
		String query = null;
		
		switch (zahl){
			//Gast anzeigen
		case 1:	
			query = "select idGast,Vorname, Nachname, Strasse, Tel, Mobil,Email, GebDatum, Geschlecht, AusweißNr, Staatsangehörigkeit from gast";
			break;
			//MA anzeigen
		case 2:
			query = "select * from mitarbeiter";
			break;
		default:
			break;
		}
			
		Connection c = ConnectionFactory.createConnection();

		try {
			// statement creation
			Statement state = (Statement) c.createStatement();
			// Query execution
			ResultSet res = state.executeQuery(query);
	
			// retrieve of the meta data in order to retrieve the columns names 
			ResultSetMetaData meta = res.getMetaData();

			// Initialization of an array for the titles of the array columns
			column = new Object[meta.getColumnCount()];
			
			for(int i = 1 ; i <= meta.getColumnCount(); i++){
				column[i-1] = meta.getColumnName(i);
			}
			
			// retrieving the number of lines (Results)
			res.last();

			data = new Object[res.getRow()][meta.getColumnCount()];
			
			// getting the cursor to the first line :)
			res.beforeFirst();
			int j = 1;
			
			// we fill the array with objects (Object[][])
			while(res.next()){
			
				for(int i = 1 ; i <= meta.getColumnCount(); i++)
					data[j-1][i-1] = res.getObject(i);
				j++;
			}
			                      
			res.close();
			state.close();
			
	

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR ! ", JOptionPane.ERROR_MESSAGE);
		}

		return new Showdata <Object[][],Object[]>(data, column);
	}



	
	
	
	

}
