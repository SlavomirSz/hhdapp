import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        //Get subscribers from db/subscribers
        Postgresql postgresql = new Postgresql();
        postgresql.selectSubscriberById(1);

        //Get from db/calendar



//        Mailer mailer = new Mailer();
//        mailer.sendEmail();
    }
}
