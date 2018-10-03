package practice;

/**
 * Practice from http://dongchuan.github.io/java/2015/10/07/Java-Static-Loading-Order.html
 */

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