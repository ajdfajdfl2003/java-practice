package jvm.classloader;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class JvmClassLoaderPrintPath {
    public static void main(String[] args) {
        //BootstrapClassLoader
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("BootstrapClassLoader");
        for (URL urL : urLs) {
            System.out.println(" ---> " + urL.toExternalForm());
        }

        //ExtClassLoader
        printClassLoader("ExtClassLoader",JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        //AppClassLoader
        printClassLoader("AppClassLoader",JvmClassLoaderPrintPath.class.getClassLoader());
    }

    private static void printClassLoader(String name, ClassLoader classLoader) {
        System.out.println();
        if (classLoader != null) {
            System.out.println(name + " ClassLoader -> " + classLoader.toString());
            printURLForClassLoader(classLoader);
        } else {
            System.out.println(name + "ClassLoader -> null");
        }
    }

    private static void printURLForClassLoader(ClassLoader classLoader) {
        Object ucp = insightFiled(classLoader, "ucp");
        Object path = insightFiled(ucp, "path");
        ArrayList ps = (ArrayList) path;
        for (Object p : ps) {
            System.out.println(" ==> " + p.toString());
        }
    }

    private static Object insightFiled(Object obj, String fName) {
        try {
            Field f = null;
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
