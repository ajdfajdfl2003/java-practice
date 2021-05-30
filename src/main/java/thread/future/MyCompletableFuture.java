package thread.future;

import java.util.concurrent.CompletableFuture;

public class MyCompletableFuture {
    public static void main(String[] args) {
        final CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "YOYO, bro");
        final String result = cf.thenApply(String::toLowerCase).join();
        System.out.println(result);
        final String result1 = cf.thenCompose(s -> CompletableFuture.supplyAsync(s::toUpperCase)).join();
        System.out.println(result1);
    }
}
