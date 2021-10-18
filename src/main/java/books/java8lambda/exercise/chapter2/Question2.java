package books.java8lambda.exercise.chapter2;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Question2 {
    public static void main(String[] args) {
        final ThreadLocal<DateFormatter> dateFormatterThreadLocal = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
        System.out.println(dateFormatterThreadLocal.get().getFormat().format(new Date()));
    }
}
