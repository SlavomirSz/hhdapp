import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;

public class Mailer {

    public Mailer(){

    }
    public void sendEmail(LinkedList<Subscriber> subscribers, Day day){
        final String username = "happyholydayapp@gmail.com";
        final String password = "Behemoth666";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("sszlakowski@o2.pl") //TODO
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String[] getHollydaysTable(String hollydays){
        return hollydays.split("|");
    }
    private String setText(String[] hollydays){
        //TODO
        String text="";
        for(int i=0;i<hollydays.length;i++){
            text+="Wszystkiego najlepszego z okazji "+hollydays[i];
        }
        return text;
    }

}
