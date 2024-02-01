
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Assignment2 {
      
      public static void main(String[] args) {

        String userInput = "29/01/2024 01:00";

        
        /* ========== CONVERTING USER INPUT TO ZONED-DATE-TIME ================ */
        ZonedDateTime originalDateTime = convertToZonedDateTime(userInput, "Asia/Kolkata");
        System.out.println("Original Timestamp: " + formatZonedDateTime(originalDateTime));

        
        /* ========== ADDING ONE DAY ============= */
        ZonedDateTime plusOneDay = originalDateTime.plusDays(1);
        System.out.println("Timestamp after adding one day: " + formatZonedDateTime(plusOneDay));

        
        /* ========== SUBTRACTING 10 DAYS ================== */
        ZonedDateTime minusTenDays = originalDateTime.minusDays(10);
        System.out.println("Timestamp after subtracting 10 days: " + formatZonedDateTime(minusTenDays));

        
        /* ============ ADDING ONE HOUR ============  */
        ZonedDateTime plusOneHour = originalDateTime.plusHours(1);
        System.out.println("Timestamp after adding 1 hour: " + formatZonedDateTime(plusOneHour));

        
        /* ========== SUBTRACTING 5 HOURS AND 30 MINUTES ========== */
        ZonedDateTime minusFiveHoursThirtyMins = originalDateTime.minusHours(5).minusMinutes(30);
        System.out.println("Timestamp after subtracting 5 hours 30 minutes: " + formatZonedDateTime(minusFiveHoursThirtyMins));

        
        /* ============ CREATING A LIST OF ZONED-DATE-TIME OBJECTS FOR SORTING ========= */
        List<ZonedDateTime> dateList = new ArrayList<>();
        dateList.add(originalDateTime);
        dateList.add(plusOneDay);
        dateList.add(minusTenDays);
        dateList.add(plusOneHour);
        dateList.add(minusFiveHoursThirtyMins);

        
        /*  ========= SORTING OBJECTS USING TIMESTAMP/DATE =========== */
        Collections.sort(dateList, Comparator.comparing(ZonedDateTime::toInstant));

        System.out.println("\nSorted Timestamps:");
        for (ZonedDateTime dateTime : dateList) {
            System.out.println(formatZonedDateTime(dateTime));
        }
      }
    
      /* ========= CONVERTING USER INPUT TO ZONED-DATE-TIME ===============  */
    private static ZonedDateTime convertToZonedDateTime(String userInput, String zoneId) {
        LocalDateTime localDateTime = LocalDateTime.parse(userInput, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        return localDateTime.atZone(ZoneId.of(zoneId));
    }

    /* ============= FORMATTING ZONED-DATE-TIME ================ */
    private static String formatZonedDateTime(ZonedDateTime zonedDateTime) {
        return zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ssXXX"));
    }
}
