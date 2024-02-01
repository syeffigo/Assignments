import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Assignment1 {
      
    private static long convertToUnixTimestamp(String userInput) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date date = sdf.parse(userInput);
            return date.getTime() / 1000; 
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; 
        }
    }

    
    private static ZonedDateTime convertToZonedDateTime(String userInput, String zoneId) {
        LocalDateTime localDateTime = LocalDateTime.parse(userInput, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        return localDateTime.atZone(ZoneId.of(zoneId));
    }

    
    private static ZonedDateTime convertUTCtoIST(ZonedDateTime utcDateTime) {
        return utcDateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    }

    private static String formatZonedDateTime(ZonedDateTime zonedDateTime) {
        return zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ssXXX"));
    }

    public static void main(String[] args) {
        
        String userInput = "29/01/2024 01:00";

        long unixTimestamp = convertToUnixTimestamp(userInput);
        System.out.println("Unix Timestamp (Local IST): " + unixTimestamp);

        ZonedDateTime istDateTime = convertToZonedDateTime(userInput, "Asia/Kolkata");
        ZonedDateTime utcDateTime = istDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("Local IST Timestamp: " + formatZonedDateTime(istDateTime));
        System.out.println("UTC Timestamp: " + formatZonedDateTime(utcDateTime));

        ZonedDateTime convertedIstDateTime = convertUTCtoIST(utcDateTime);
        System.out.println("Converted IST Timestamp: " + formatZonedDateTime(convertedIstDateTime));
    }

}
