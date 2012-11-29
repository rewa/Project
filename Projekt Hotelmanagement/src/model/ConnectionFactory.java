package model;



import java.sql.*;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ConnectionFactory {

    public static Connection createConnection() {
     	
    	String Url = "jdbc:mysql://i-intra-02:3306/";
    
      //  String Url = "i-intra-02.informatik.hs-ulm.de"; // intra MySQL server

        String db = "wfprj_wf5_28"; // Database name
        String user = "wfprj_wf5_28"; // a user on this db
        String pw = "dinc38";// her password
      
   	/*
        String Url = "jdbc:mysql://localhost:3306/"; // local MySQL server
        String db = "test"; // Database name
        String user = "root"; // a user on this db
       String pw = "";// her password
      */  
     Connection cone = null;
        try {
            // Connecting to database
            cone = DriverManager.getConnection(Url + db, user, pw);
           // cone = DriverManager.getConnection(localUrl + db, user, pw);

            // Loading MySQL Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Configuring connection, e.g.
            cone.setAutoCommit(false);

        }  catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("SQL Expcetion bei Verbindungsaufbau");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Connection Fehler");
        }

        return cone;
    }

    /*
    public static TableModel getTableModelFromQuery(String query) {
        Connection c = ConnectionFactory.createConnection();
        ResultSet result = null;
        try {
            PreparedStatement s = c.prepareStatement(query);
            result = s.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSetToTableModel(result);
    }


    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<String>();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }
           

            // Get all rows.
            Vector<Object> rows = new Vector<Object>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<Object>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    //ComboBoxModel Employee
    public static ComboBoxModel resultSetToComboBoxModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
           int numberOfColumns = metaData.getColumnCount();
  
            Vector<Object> rows = new Vector<Object>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<Object>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultComboBoxModel(rows);

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
*/
    

}
