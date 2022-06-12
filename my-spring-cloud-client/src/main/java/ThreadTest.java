import java.util.concurrent.CompletableFuture;

public class ThreadTest {
    public static void main(String[] args) {
//        CompletableFuture cf1 = CompletableFuture.runAsync(new Worker("a"));
//        CompletableFuture cf2 = CompletableFuture.runAsync(new Worker("b"));
//        CompletableFuture cf3 = CompletableFuture.runAsync(new Worker("c"));
//        int i = 0;
//        while(i < 1000) {
//            cf1.(cf2).thenRun(cf3);
//            i ++;
//        }
    }

    static class Worker implements Runnable {

        private String s;

        Worker(String s) {
            this.s = s;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + s);
        }
    }

}
