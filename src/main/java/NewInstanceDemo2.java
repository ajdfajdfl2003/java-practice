import practice.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceDemo2 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("practice.Student");

            Class[] params = new Class[2];
            // 第一個參數是String
            params[0] = String.class;
            // 第二個參數是int
            params[1] = Integer.TYPE;

            // 取得對應參數列的建構方法
            Constructor constructor = c.getConstructor(params);

            // 指定引數內容
            Object[] argObjs = new Object[2];
            argObjs[0] = "caterpillar";
            argObjs[1] = new Integer(90);

            // 給定引數並實例化
            Object obj = constructor.newInstance(argObjs);
            // 呼叫toString()來觀看描述
            System.out.println(obj);

            Object[] argObjsOther = new Object[2];
            argObjsOther[0] = "Angus";
            argObjsOther[1] = new Integer(10);
            Student objToStudent = (Student) constructor.newInstance(argObjsOther);
            System.out.println(objToStudent.getName() + ", " + objToStudent.getScore());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
