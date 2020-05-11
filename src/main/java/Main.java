import com.mashape.unirest.http.exceptions.UnirestException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) throws SQLException, UnirestException {
        //Get subscribers from db/subscribers
//        Postgresql postgresql = new Postgresql();
//        LinkedList<Subscriber> subscribers = postgresql.selectActiveSubscribers();
        Kalbi kalbi = new Kalbi();
        ArrayList<String> holydays = kalbi.getHolydays(1,"stycznia");
        for(String holyday: holydays){
            System.out.println(holyday);
        }
        //TODO Get from db/calendar

        //TODO mail text

//        Mailer mailer = new Mailer();
//        mailer.sendEmail();
    }
}
