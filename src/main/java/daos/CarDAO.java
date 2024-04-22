package daos;

import com.sun.jdi.connect.Connector;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarDAO extends DAO<Car>  {


    @Override
    public Car findById(int id) {
        Connection connection = connectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
//        return null;
    }
    @Override
    public List<Car> findAll(){
        //select * from cars, get record set,
        // make a list have a variable be a list(arraylist)
        // loop through record set create an instance of a car that has the field values and put that new car into your list
        //return list
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");

            Set users = new HashSet();

            while(rs.next())
            {
                User user = extractUserFromResultSet(rs);
                users.add(user);
            }

            return users;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
//        return null;
    }

    @Override
    public Car update(Car dto) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET name=?, pass=?, age=? WHERE id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            ps.setInt(3, user.getAge());
            ps.setInt(4, user.getId());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
//        return null;
    }

    @Override
    public Car create(Car dto) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            ps.setInt(3, user.getAge());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
//        return null;
    }

    @Override
    public void delete(int id) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
