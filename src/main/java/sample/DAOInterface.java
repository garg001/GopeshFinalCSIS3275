package sample;

import java.sql.SQLException;

public interface DAOInterface {

    public void add(Customer customer) throws ClassNotFoundException, SQLException;
    public Customer edit(Customer customer, String custno) throws SQLException,ClassNotFoundException;
    public void delete(String custno) throws SQLException, ClassNotFoundException;
    public void display() throws ClassNotFoundException,SQLException;
    public Customer search(String custno) throws SQLException, ClassNotFoundException;
}
