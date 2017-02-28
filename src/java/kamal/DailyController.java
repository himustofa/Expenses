package kamal;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/expensesURL")
public class DailyController {

    Connection con = null;
    Statement stm = null;
    ResultSet rs;
    PreparedStatement ps;

    //DATABASE CONNECTIVITY
    public Connection getConnection() {
        try {
            //Register the driver class
            Class.forName("com.mysql.jdbc.Driver");
            //Create the connection object
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mk", "root", "123");
        } catch (Exception e) {
            System.err.println(e);
        }
        return con;
    }

    //INSERT DATA
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Expenses addExpenses(Expenses expenses) throws SQLException {

        if (expenses.getPrice() > 0) {
            try {
                con = getConnection();
                //Create the statement object
                stm = con.createStatement();
                //Execute the query
                stm.executeUpdate("CREATE TABLE IF NOT EXISTS daily_expenses (id INT(11) NOT NULL AUTO_INCREMENT, date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, name VARCHAR(25), quantity INT(11) NOT NULL default 0, price INT(11), PRIMARY KEY(id));");
                stm.executeUpdate("INSERT INTO daily_expenses (name, price) VALUES('" + expenses.getName() + "', " + expenses.getPrice() + ");");
                JOptionPane.showMessageDialog(null, "Inserted");
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                if (stm != null) {
                    con.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            //End of getPrice()
        }

        //End of addExpenses()
        return expenses;
    }

    //DISPLAY DATA
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expenses> getExpenses() {
        List<Expenses> list = new ArrayList<Expenses>();
        try {
            con = getConnection();
            ps = con.prepareStatement("select id, name, price from daily_expenses;");
            rs = ps.executeQuery();
            while (rs.next()) {
                Expenses expenses = new Expenses();
                expenses.setId(rs.getInt("id"));
                expenses.setName(rs.getString("name"));
                expenses.setPrice(rs.getInt("price"));
                list.add(expenses);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return list;
    }

    //EDIT DATA
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Expenses updateExpenses(Expenses expenses) {
        if (expenses.getId() <= 0) {
            return null;
        }
        try {
            con = getConnection();
            String sql = "update daily_expenses set name ='" + expenses.getName() + "', price = " + expenses.getPrice() + " where id = " + expenses.getId() + " ";
            stm = con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            System.err.println(e);
        }
        return expenses;
    }

    //DELETE DATA
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteExpenses(@PathParam("id") int id) {
        con = getConnection();
        try {
            String sql = "delete from daily_expenses where id = " + id + "";
            stm = con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
