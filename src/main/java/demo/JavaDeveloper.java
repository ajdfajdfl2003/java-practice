package demo;

import java.time.LocalDateTime;
import java.util.Arrays;

public class JavaDeveloper {
    public static void main(String[] args) {
//        method(null);
        extracted();
//        allMatch();

        Integer a = 127;
        Integer b = 127;
        System.out.printf("a==b: %s.\n", a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.printf("c==d: %s.\n", c == d);

    }

    private static void allMatch() {
        if (Arrays.asList("1", "1", "1").stream().allMatch("1"::equals)) {
            System.out.println("all match");
        }
    }

    private static void extracted() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

//        System.out.println(new Timestamp(Instant.parse("2022-06-25T16:00:00.00Z").toEpochMilli()));
//        System.out.println("ISO_LOCAL_DATE: " + OffsetDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
//        System.out.println("LOCAL DATE: " + OffsetDateTime.now().toLocalDateTime());
//        System.out.println(OffsetDateTime.of(OffsetDateTime.now().minusDays(1).toLocalDate(), LocalTime.of(16, 0), ZoneOffset.UTC));
//        System.out.println(OffsetDateTime.of(OffsetDateTime.now()
//                        .toLocalDate(), LocalTime.of(16, 0), ZoneOffset.UTC)
//                .toInstant());
//
//        System.out.println(new Timestamp(OffsetDateTime.of(OffsetDateTime.now()
//                        .toLocalDate(), LocalTime.of(16, 0), ZoneOffset.UTC)
//                .toInstant().toEpochMilli()));
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
