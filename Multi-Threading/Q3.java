class testingSynchronisation{
   synchronized public void printString(String string){
       System.out.println(string);
    }
    public void printTable(int number){
    synchronized (this){
        for(int i=1; i<=10; i++){
            System.out.println(number*i);
        }
    }
    }
}
class Thread1 extends Thread{
testingSynchronisation obj;
    public Thread1(testingSynchronisation obj){
    this.obj = obj;
    }
    public void run(){
    obj.printString("Hello Mentor. ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    obj.printTable(2);
    }
}
class Thread2 extends Thread{
    testingSynchronisation obj;
    public Thread2(testingSynchronisation obj){
    this.obj = obj;
    }
    public void run(){
        obj.printString("Have a good day!");
        obj.printTable(5);
    }
}
public class Q3 {
    public static void main(String[] args) {
        testingSynchronisation obj = new testingSynchronisation();
        Thread1 t1 = new Thread1(obj);
        Thread2 t2 = new Thread2(obj);
        t1.start();
        t2.start();
    }
}
