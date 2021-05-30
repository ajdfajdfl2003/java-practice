package thread.list;

import java.util.Arrays;
import java.util.List;

public class TryArrays {
    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3);
        // Arrays.asList not support "add" method
        try {
            list.add(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Arrays.asList not support "remove" method
        try {
            list.remove(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.set(2, 4);
        System.out.println(list);
    }
}
