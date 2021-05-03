package jvm.memory;

public class TestXss {
    //    javac -g jvm/memory/TestXss.java
    //    javap -c -verbose jvm.memory.TestXss
    //    java -Xss160k jvm.memory.TestXss
    static long level = 0;

    static long fact(int n) {
        level++;
        return n < 2 ? 1 : n * fact(n - 1);
    }

    public static void main(String[] args) {
        try {
            System.out.println(fact(1024));
            System.out.println("level= " + level);
        } catch (Error error) {
            System.out.println(error);
            System.out.println("level= " + level);
        }
    }
}
