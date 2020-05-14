import com.mashape.unirest.http.exceptions.UnirestException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) throws SQLException, UnirestException {
        //Get subscribers from db/subscribers
        Postgresql postgresql = new Postgresql();
        LinkedList<Subscriber> subscribers = postgresql.selectActiveSubscribers();


        LocalDateTime today = LocalDateTime.now();
        int todayDay = today.getDayOfMonth();
        int todayMonth = today.getMonthValue();
        Day day = new Day(todayDay,todayMonth);
        day.setHollydays(postgresql.selectHolydays(day));
        System.out.println(day.getHollydays());
        //TODO mail text

//        Mailer mailer = new Mailer();
//        mailer.sendEmail();
    }


}
