import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

public class Kalbi {

    public Kalbi(){}

    public ArrayList<String> getHolydays(int day, String month) throws UnirestException {
        ArrayList<String> holydays = new ArrayList<String>();
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://www.kalbi.pl/"+day+"-"+month)
                .asString();
        String body = response.getBody();
        try{
            String[] part1 = body.split("Nietypowe święta:");
            String[] part2 = part1[1].split("</div>");
            String[] part3 = part2[1].split("title=\"");
            for(int i=1;i<part3.length;i++){
                String[] holyday = part3[i].split("\"");
                holydays.add(holyday[0]);
            }
        } catch (Exception e){
            holydays.add("unholyday");
        }
        return holydays;
    }

}
