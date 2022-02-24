class MyThread extends Thread{
    int count=1;
    public void run(){
        while(count<=20) {
            System.out.println("Thread class thread is running "+count);
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class MyRun implements Runnable{
    int count=1;
    @Override
    public void run(){
        while(count<=20) {
            System.out.println("Runnable interface thread is running "+count);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
public class Q1 {
    public static void main(String[] args) {

        MyThread t1=new MyThread();
        MyRun mr=new MyRun();
        Thread t2=new Thread(mr);
        t1.start();
        t2.start();
        try {
            t2.join();
            System.out.println(t1.getState());
        } catch (InterruptedException e) {
            System.out.println(e);
        }



    }
}
