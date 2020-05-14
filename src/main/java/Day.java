import java.util.ArrayList;

public class Day {
    private final int day;
    private final int month;
    private String monthS, hollydays;


    public Day(int day, int month) {
        this.monthS = monthTranslator(month);
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public String getHollydays() {
        return hollydays;
    }

    public String getMonthS() {
        return monthS;
    }

    public void setHollydays(String hollydays) {
        this.hollydays = hollydays;
    }

    private String monthTranslator(int month) {
        String resp = "";
        if (1 == month) {
            resp = "stycznia";
        } else if (2 == month) {
            resp = "lutego";
        } else if (3 == month) {
            resp = "marca";
        } else if (4 == month) {
            resp = "kwietnia";
        } else if (5 == month) {
            resp = "maja";
        } else if (6 == month) {
            resp = "czerwca";
        } else if (7 == month) {
            resp = "lipca";
        } else if (8 == month) {
            resp = "sierpnia";
        } else if (9 == month) {
            resp = "wrzesnia";
        } else if (10 == month) {
            resp = "pazdziernika";
        } else if (11 == month) {
            resp = "listopada";
        } else if (12 == month) {
            resp = "grudnia";
        }
        return resp;
    }

    private void setHollydays(ArrayList<String> arrayList) {
        StringBuilder holidays = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i < arrayList.size() - 1) {
                holidays.append(arrayList.get(i)).append("|");
            } else {
                holidays.append(arrayList.get(i));
            }
            this.hollydays = holidays.toString();
        }
    }
}
