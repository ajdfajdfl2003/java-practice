package jvm.classloader;

import java.util.Base64;

public class HiHiClassLoader extends ClassLoader {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        new HiHiClassLoader()
                .findClass("jvm.classloader.HiHi")
                .newInstance();
    }

    @Override
    protected Class<?> findClass(String name) {
        String hihiBase64 = "yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBAAlIaUhpLmphdmEMAAcACAcAFgwAFwAYAQAeVGhpcyBpcyBhIEhpSGkgSW5pdGlhbGl6ZWQgISEhBwAZDAAaABsBABRqdm0vY2xhc3Nsb2FkZXIvSGlIaQEAEGphdmEvbGFuZy9PYmplY3QBABBqYXZhL2xhbmcvU3lzdGVtAQADb3V0AQAVTGphdmEvaW8vUHJpbnRTdHJlYW07AQATamF2YS9pby9QcmludFN0cmVhbQEAB3ByaW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYAIQAFAAYAAAAAAAIAAQAHAAgAAQAJAAAAHQABAAEAAAAFKrcAAbEAAAABAAoAAAAGAAEAAAADAAgACwAIAAEACQAAACUAAgAAAAAACbIAAhIDtgAEsQAAAAEACgAAAAoAAgAAAAUACAAGAAEADAAAAAIADQ==";
        byte[] decode = Base64.getDecoder().decode(hihiBase64);
        return super.defineClass(name, decode, 0, decode.length);
    }
}
