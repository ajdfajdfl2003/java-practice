package lombok;

public class Family {
    public static void main(String[] args) {
        Child.builder()
                .age(123)
                .name("angus")
                .createTime(123L)
                .build();
    }
}
