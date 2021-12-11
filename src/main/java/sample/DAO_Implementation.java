package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Implementation implements DAOInterface {
    public Connection con3;

    public DAO_Implementation(Connection con3) throws SQLException{
        this.con3=con3;
    }

    @Override
    public void add(Customer cust) throws ClassNotFoundException, SQLException {
        String quer1 ="INSERT INTO savingstable VALUES ( ?, ?,?,?,? )";
        PreparedStatement query =con3.prepareStatement(quer1);

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
        query=con3.prepareStatement("Update savingstable set custno=?, custname=?, cdep=?,nyears=?,savtype=? where custno= ?");
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
        PreparedStatement query =con3.prepareStatement(quer1);
        query.setString(1,custno);
        query.executeUpdate();

        System.out.println("One record Deleted");

    }

    @Override
    public List<Customer> display() throws ClassNotFoundException, SQLException {
        String quer1="Select * from savingstable";
        List<Customer> custList=new ArrayList<Customer>();
        PreparedStatement query =con3.prepareStatement(quer1) ;

        ResultSet rs=query.executeQuery();

        Customer obj1;

        while (rs.next()){
            obj1 =new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));

            custList.add(obj1);
        }
        return custList;
    }

    @Override
    public Customer search(String custno) throws SQLException, ClassNotFoundException {
        String quer1 ="Select * from savingstable where custno = ?";
        PreparedStatement query =con3.prepareStatement(quer1, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        query.setString(1,custno);

        ResultSet rs=query.executeQuery();

        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        Customer obj1=null;

        obj1 =new Customer(rs.getString("custno"),rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));
        return obj1;
    }
}
