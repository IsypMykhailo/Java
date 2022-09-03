import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Function;

interface DateOperations {
    boolean isLeapYear(int year);
    int daysBetweenDates(String firstDate, String secondDate) throws ParseException;
    int weeksBetweenDates(String firstDate, String secondDate) throws ParseException;
    String dayOfWeek(String date) throws ParseException;
}
@FunctionalInterface
interface Function2<One, Two, Three> {
    public Three apply(One one, Two two);
}

public class Dates implements Runnable{

    @Override
    public void run() {
        try {
            DateOperations op;
            op = createDateOperationsObject(
                    (year) -> {
                        return year % 4 == 0;
                    },
                    (firstDate, secondDate) -> {
                        try {
                            Calendar cal1 = new GregorianCalendar();
                            Calendar cal2 = new GregorianCalendar();
                            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                            Date date = sdf.parse(firstDate);
                            cal1.setTime(date);
                            date = sdf.parse(secondDate);
                            cal2.setTime(date);

                            return (int) ((cal2.getTime().getTime() - cal1.getTime().getTime()) / (1000 * 60 * 60 * 24));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        return null;
                    },
                    (firstDate, secondDate) -> {
                        try {
                            Calendar cal1 = new GregorianCalendar();
                            Calendar cal2 = new GregorianCalendar();
                            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                            Date date = sdf.parse(firstDate);
                            cal1.setTime(date);
                            date = sdf.parse(secondDate);
                            cal2.setTime(date);

                            return (int) Math.floor(((cal2.getTime().getTime() - cal1.getTime().getTime()) / (1000 * 60 * 60 * 24)) / 7);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        return null;
                    },
                    (date) -> {
                        Calendar cal = new GregorianCalendar();
                        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                        try {
                            Date dateInstance = sdf.parse(date);
                            cal.setTime(dateInstance);
                            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                            switch(dayOfWeek){
                                case 1:
                                    return "Воскресенье";
                                case 2:
                                    return "Понедельник";
                                case 3:
                                    return "Вторник";
                                case 4:
                                    return "Среда";
                                case 5:
                                    return "Четверг";
                                case 6:
                                    return "Пятница";
                                case 7:
                                    return "Суббота";
                                default:
                                    return "Invalid date";
                            }
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            System.out.println(op.isLeapYear(2004));
            System.out.println(op.daysBetweenDates("10072005", "10072008"));
            System.out.println(op.weeksBetweenDates("10072005", "10072008"));
            System.out.println(op.dayOfWeek("10072005"));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public DateOperations createDateOperationsObject (
            Function<Integer, Boolean> isLeapYearAction,
            Function2<String, String, Integer> daysBetweenDatesAction,
            Function2<String, String, Integer> weeksBetweenDatesAction,
            Function<String, String> dayOfWeekAction
            ) {
        return new DateOperations() {
            @Override
            public boolean isLeapYear(int year) {
                return isLeapYearAction.apply(year);
            }

            @Override
            public int daysBetweenDates(String firstDate, String secondDate) throws ParseException {
                return daysBetweenDatesAction.apply(firstDate, secondDate);
            }

            @Override
            public int weeksBetweenDates(String firstDate, String secondDate) throws ParseException {
                return weeksBetweenDatesAction.apply(firstDate, secondDate);
            }

            @Override
            public String dayOfWeek(String date) throws ParseException {
                return dayOfWeekAction.apply(date);
            }
        };
    }
}
