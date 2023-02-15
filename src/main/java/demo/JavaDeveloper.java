package demo;

import java.time.Instant;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class JavaDeveloper {
    public static void main(String[] args) {
//        method(null);
//        extracted();

    }

    private static void extracted() {
        System.out.println(Instant.parse("2022-06-25T16:00:00.00Z").toString());
        System.out.println("ISO_LOCAL_DATE: " + OffsetDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("LOCAL DATE: " + OffsetDateTime.now().toLocalDateTime());
        System.out.println(OffsetDateTime.of(OffsetDateTime.now().minusDays(1).toLocalDate(), LocalTime.of(16, 0), ZoneOffset.UTC));
        System.out.println(OffsetDateTime.of(OffsetDateTime.now()
                .minusDays(1).toLocalDate(), LocalTime.of(16, 0), ZoneOffset.UTC)
                .toEpochSecond());
    }

    public static void method(String param) {
        switch (param) {
// 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
// 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
// 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}
