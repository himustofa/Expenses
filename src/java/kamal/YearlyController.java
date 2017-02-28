package kamal;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/yearlyURL")
public class YearlyController {

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
    public Expenses addYearly(Expenses expenses) throws SQLException {

        if (expenses.getMonthYearAmount() > 0) {
            try {
                con = getConnection();
                //Create the statement object
                stm = con.createStatement();
                //Execute the query
                stm.executeUpdate("CREATE TABLE IF NOT EXISTS yearly_expenses (id INT(11) NOT NULL AUTO_INCREMENT, date TIMESTAMP NOT NULL default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, monthName VARCHAR(25), quantity INT(11) NOT NULL default 0, monthYearAmount INT(11), PRIMARY KEY(id));");
                stm.executeUpdate("INSERT INTO yearly_expenses (monthName, monthYearAmount) VALUES('" + expenses.getMonthName() + "', " + expenses.getMonthYearAmount() + ");");
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
            //End of getMonthlyAmount()
        }

        //End of addExpenses()
        return expenses;
    }

    //DISPLAY DATA
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expenses> getYearly() {
        List<Expenses> list = new ArrayList<Expenses>();
        try {
            con = getConnection();
            ps = con.prepareStatement("select id, monthName, monthYearAmount from yearly_expenses;");
            rs = ps.executeQuery();
            while (rs.next()) {
                Expenses expenses = new Expenses();
                expenses.setId(rs.getInt("id"));
                expenses.setMonthName(rs.getString("monthName"));
                expenses.setMonthYearAmount(rs.getInt("monthYearAmount"));
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
    public Expenses updateYearly(Expenses expenses) {
        if (expenses.getId() <= 0) {
            return null;
        }
        try {
            con = getConnection();
            String sql = "update yearly_expenses set monthName ='" + expenses.getMonthName() + "', monthYearAmount = " + expenses.getMonthYearAmount() + " where id = " + expenses.getId() + " ";
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
    public void deleteYearly(@PathParam("id") int id) {
        con = getConnection();
        try {
            String sql = "delete from yearly_expenses where id = " + id + "";
            stm = con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
