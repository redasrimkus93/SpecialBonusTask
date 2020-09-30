import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        printBonusDatesBetween(1000,2500);
    }

    static void printBonusDatesBetween(int fromYear, int toYear){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");
        Year yearFrom = Year.parse(String.valueOf(fromYear), dateTimeFormatter);
        Year yearTo = Year.parse(String.valueOf(toYear), dateTimeFormatter);
        LocalDate localDateFrom = yearFrom.atMonthDay(MonthDay.of(Month.JANUARY, 01));
        LocalDate localDateTo = yearTo.atMonthDay(MonthDay.of(Month.JANUARY, 01));

        LocalDate start = LocalDate.parse(localDateFrom.toString());
        LocalDate end = LocalDate.parse(localDateTo.toString());
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        for (int i = 0; i < totalDates.size(); i++){
            String tas= totalDates.get(i).toString().replaceAll("-","");
            if(tas.equals(new StringBuilder(tas).reverse().toString())){
                System.out.println(totalDates.get(i));
            }
        }
    }
}
