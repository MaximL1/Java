import java.util.concurrent.Semaphore;

public class MultithreadApp {
    public static void main(String[] args) throws InterruptedException {

        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        new Thread(new ThreadFour(s3, "Thread-4")).start();
        new Thread(new ThreadOne(s1, "Thread-1")).start();
        new Thread(new ThreadOne(s2, "Thread-2")).start();
        new Thread(new ThreadThree(s1, s2, s3, "Thread-3")).start();
        //new Thread(new ThreadFour(s3, "Thread-4")).start();

    }
}

class ThreadOne extends Thread {
    private Semaphore th1;
    private String name;

    public ThreadOne(Semaphore first, String name) {
        this.th1 = first;
        this.name = name;
    }

    public void run() {
        if (name.contains("1")) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " released s1 ");
        } else
            System.out.println(name + " released s2 ");

        th1.release();
    }
}

class ThreadThree extends Thread {
    private Semaphore th1, th2, th3;
    private String name;

    public ThreadThree(Semaphore th1, Semaphore th2, Semaphore th3, String name) {
        this.th1 = th1;
        this.th2 = th2;
        this.th3 = th3;
        this.name = name;
    }

    public void run() {
        try {
            th1.acquire();
            th2.acquire();
            System.out.println(name + " acquired s1 and s2");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th3.release();
        System.out.println(name + " release s3");
    }
}

class ThreadFour extends Thread {
    private Semaphore th3;
    private String name;

    public ThreadFour(Semaphore th3, String name) {
        this.th3 = th3;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            th3.acquire();
            System.out.println(name + " acquired s3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th3.release();
        System.out.println(name + " release s4");
    }
}