package practice;

public class Singleton {

    static class Inner {
        static {
            System.out.println("Inner Statuc Field");
        }

        static final Singleton testInstance = new Singleton(3);
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