package practice;

public class Singleton {

    static class Inner {
        static final Singleton testInstance = new Singleton(3);

        static {
            System.out.println("Inner Statuc Field");
        }
    }

    public static Singleton getInstance() {
        return Inner.testInstance;
    }

    public Singleton(int i) {
        System.out.println("Test " + i + " Construct! ");
    }

    static {
        System.out.println("Static Field");
    }
}