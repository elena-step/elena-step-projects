package javasummer2017.Threads;

public class MyThread extends Thread implements Runnable {
    private Thread _thread;
    private String _name;

    MyThread(String name) {
        _thread = new Thread();
        _name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + _name + " started.");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("Thread " + _name + " finished.");

    }
}
