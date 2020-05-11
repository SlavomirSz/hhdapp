import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Postgresql {

    public Postgresql(){}

    public Connection dbConnection(){
        Connection c=null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/HHDA",
                            "postgres", "admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    public Subscriber selectSubscriberById(int id) throws SQLException {
        Subscriber subscriber = new Subscriber();
        try {
            Connection c = dbConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SUBSCRIBERS WHERE ID=" + id + ";");
            while (rs.next()) {
                subscriber.setId(rs.getInt("id"));
                subscriber.setFisrtName(rs.getString("first_name"));
                subscriber.setLastName(rs.getString("last_name"));
                subscriber.setEmail(rs.getString("email"));
                subscriber.setStatus(rs.getBoolean("status"));
            }
            rs.close();
            stmt.close();
            c.close();
            System.out.println("Closed database successfully");
        } catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return subscriber;
    }

    public int getSubscribersCount() {
        int count = 0;
        try {
            Connection c = dbConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT COUNT(id) FROM SUBSCRIBERS WHERE STATUS=true;");
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            c.close();
            System.out.println("Closed database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return count;
    }

    public LinkedList<Subscriber> selectActiveSubscribers(){
        int count = getSubscribersCount();
        LinkedList<Subscriber> subscribers = new LinkedList<Subscriber>();
        for(int i = 0 ;i <count;i++){
            subscribers.add(new Subscriber());
        }
        try {
            Connection c = dbConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT * FROM SUBSCRIBERS WHERE STATUS=true;");
            while (rs.next()) {
                for(Subscriber subscriber: subscribers) {
                    subscriber.setId(rs.getInt("id"));
                    subscriber.setFisrtName(rs.getString("first_name"));
                    subscriber.setLastName(rs.getString("last_name"));
                    subscriber.setEmail(rs.getString("email"));
                    subscriber.setStatus(rs.getBoolean("status"));
                }
            }
            rs.close();
            stmt.close();
            c.close();
            System.out.println("Closed database successfully");
        } catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return subscribers;
    }

    public void insertHolyday(){
        //TODO
        try {
            Connection c = dbConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SUBSCRIBERS WHERE ID=;");
            rs.close();
            stmt.close();
            c.close();
            System.out.println("Closed database successfully");
        } catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
