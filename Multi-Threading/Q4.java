import java.util.concurrent.*;
public class Q4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future <Integer> future = executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("Callable lets you return value");
                return 5;
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable does not let you return value");
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
