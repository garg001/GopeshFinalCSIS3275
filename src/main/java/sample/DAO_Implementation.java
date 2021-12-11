package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Implementation implements DAOInterface {
    public Connection con3;

    public DAO_Implementation(Connection con3) throws SQLException{
        this.con3=con3;
    }

    @Override
    public void add(Customer cust) throws ClassNotFoundException, SQLException {
        String quer1 ="INSERT INTO savingstable VALUES ( ?, ?,?,?,? )";
        PreparedStatement query =con3.connect().prepareStatement(quer1);

        query.setString(1,cust.getCustno());
        query.setString(2,cust.getCustname());
        query.setDouble(3,cust.getCdep());
        query.setInt(4,cust.getNyears());
        query.setString(5,cust.getSavtype());

        query.executeUpdate();

        System.out.println("One record added");
    }

    @Override
    public Customer edit(Customer cust, String custno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query=con3.connect().prepareStatement("Update savingstable set custno=?, custname=?, cdep=?,nyears=?,savtype=? where custno= ?");
        query.setString(1,cust.getCustno());
        query.setString(2,cust.getCustname());
        query.setDouble(3,cust.getCdep());
        query.setInt(4,cust.getNyears());
        query.setString(5,cust.getSavtype());
        query.setString(6,custno);

        query.executeUpdate();
        System.out.println("One record edited");

        return cust;
    }

    @Override
    public void delete(String custno) throws SQLException, ClassNotFoundException {
        String quer1 ="Delete from savingstable where custno = ?";
        PreparedStatement query =con3.connect().prepareStatement(quer1);
        query.setString(1,custno);
        query.executeUpdate();

        System.out.println("One record Deleted");

    }

    @Override
    public void display() throws ClassNotFoundException, SQLException {
        String quer1="Select * from savingstable";
        PreparedStatement query =con3.connect().prepareStatement(quer1) ;

        ResultSet rs=query.executeQuery();

        Customer obj1;

        while (rs.next()){
            obj1 =new Customer(rs.getString("custname"),rs.getString("custno"),rs.getString("savtype"),rs.getDouble("cdep"),rs.getInt("nyears"));

            System.out.println();

            System.out.print("Customer Number: "+ obj1.getCustno() +" ");
            System.out.print("Customer Name: "+ obj1.getCustname() +" ");
            System.out.print("Customer Deposit: "+ obj1.getCdep() +" ");
            System.out.print("No of years: "+ obj1.getNyears() +" ");
            System.out.print("Savings Type: "+ obj1.getSavtype());
        }

    }

    @Override
    public Customer search(String custno) throws SQLException, ClassNotFoundException {
        String quer1 ="Select * from savingstable where custno = ?";
        PreparedStatement query =con3.connect().prepareStatement(quer1, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        query.setString(1,custno);

        ResultSet rs=query.executeQuery();

        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        Customer obj1=null;

        obj1 =new Customer(rs.getString("custname"),rs.getString("custno"),rs.getString("savtype"),rs.getDouble("cdep"),rs.getInt("nyears"));
        return obj1;
    }
}
