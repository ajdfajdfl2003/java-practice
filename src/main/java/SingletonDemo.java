import practice.Singleton;

public class SingletonDemo {
    public static Singleton testOut = new Singleton(1);

    public static void main(String args[]) {
        Singleton t = new Singleton(2);
        Singleton.getInstance();
    }
}
