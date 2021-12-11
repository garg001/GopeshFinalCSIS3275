package sample;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface {

    public void add(Customer customer) throws ClassNotFoundException, SQLException;
    public Customer edit(Customer customer, String custno) throws SQLException,ClassNotFoundException;
    public void delete(String custno) throws SQLException, ClassNotFoundException;
    public List<Customer> display() throws ClassNotFoundException,SQLException;
    public Customer search(String custno) throws SQLException, ClassNotFoundException;
}
