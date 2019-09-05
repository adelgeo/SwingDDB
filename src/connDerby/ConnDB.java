package connDerby;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adel
 */
public class ConnDB {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            //Load Driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Connection 
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/proj", "root", "root");
            
            //to insert and save directly
            conn.setAutoCommit(true);

            //statements
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.getResultSet();

            stmt.executeUpdate("insert into customer(id, firstName, lastName, salary) values(11, 'Jasmin','Nacer', 5633)");
            rs = stmt.executeQuery("select id, firstName, lastName, salary from customer"); //save result in the object rs here we're in the fisrt line of the table

            while (rs.next()) {    //next line of the all table 
                System.out.println("ID " + rs.getString("id") + "  " + rs.getString("firstName") + "  " + rs.getString("lastName")
                        + " " + rs.getString("salary"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
