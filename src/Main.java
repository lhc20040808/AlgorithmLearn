public class Main {

    public static Object object = new Object();
    public static int i;

    public static void main(String[] args) {
        try {
//        test1();
//        test2();
//            test3();
//            test4();
            test5();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test5() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("i'm alive");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
    }

    private static void test1() {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    private static void test2() {
        ThreadName t1 = new ThreadName("t1");
        ThreadName t2 = new ThreadName("t2");
        t1.start();
        try {
            Thread.sleep(100);

            t2.start();
            t1.resume();
            t2.resume();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread 执行完毕");
    }

    private static void test3() throws InterruptedException {
        ResumeThread t1 = new ResumeThread();
        ReadThread t2 = new ReadThread();
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendThread();
        System.out.println("suspend t1 2sec");
        Thread.sleep(2000);
        System.out.println("resume t1");
        t1.resumeThread();
    }

    private static void test4() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; i < 100000; i++) ;
            }
        });
        t1.start();
        t1.join();
        System.out.println("i:" + i);
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println(System.currentTimeMillis() + ":Thread1 start");
                    System.out.println(System.currentTimeMillis() + ":Thread1 wait");
                    object.wait();
                    System.out.println(System.currentTimeMillis() + ":Thread1 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":Thread2 start");
                System.out.println(System.currentTimeMillis() + ":Thread2 notify");
                object.notify();
                while (true) {
                    System.out.println(System.currentTimeMillis() + ":Thread2 execute");
                }
//                System.out.println(System.currentTimeMillis() + ":Thread2 end");
            }
        }
    }

    public static class ThreadName extends Thread {

        public ThreadName(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
                System.out.println(getName() + " 执行完毕");
            }
        }
    }

    public static class ResumeThread extends Thread {

        private boolean isSuspend;

        public void suspendThread() {
            isSuspend = true;
        }

        public void resumeThread() {
            isSuspend = false;
            synchronized (this) {
                notify();
            }
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (isSuspend) {
                        try {
                            wait();
                            System.out.println("重新获得了锁");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (object) {
                    System.out.println("ResumeThread");
                }
                Thread.yield();
            }
        }
    }

    public static class ReadThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (object) {
//                    System.out.println("ReadThread");
                }
                Thread.yield();
            }
        }
    }
}
