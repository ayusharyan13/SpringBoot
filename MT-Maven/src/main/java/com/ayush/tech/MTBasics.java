package com.ayush.tech;



/*  ---------------------------------------  1st way to create the thread using Thread class ---------------------------------------------------
//public class MTBasics {
//    public static void main(String [] args) {
//        MTBasics o = new MTBasics();
////        MyThread thread = new MyThread();
//        Thread thread = new Thread(o.new MyThread());
//        thread.start();
//        thread.run();
//        thread.run();
//        thread.run();
//    }
//
//    public class MyThread extends Thread {
//        @Override
//        public void run() {
//            System.out.println("Current Thread: " + currentThread().getName());
//        }
//    }
//}



/*   ---------------------------------- another way to create thread using Runnable Interface---------------------------:                    */

/*
public class MTBasics{

    public static void main(String[]args) {
        MTBasics o = new MTBasics();
        MyThread thread = o.new MyThread();
        thread.run();
    }

    public class MyThread extends Thread implements Runnable{
        @Override
        public void run() {
            System.out.println("in thread :" + Thread.currentThread().getName() );
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("in thread :" + Thread.currentThread().getName() );
        }
    }
}
*/


/* ------------------------------------------     Setting Daemon Thread and making it sleep   ---------------------------------------------
**   One cannot set the main Thread as Daemon:   so to set the thread as daemon , one needs to start the thread first: --- Thread.start();
**   Then you can set the thread as daemon and all:                                                                                                     */

public class MTBasics{

    public static void main(String[]args) {
        MTBasics o = new MTBasics();
        MyThread thread = o.new MyThread();
        try{
            thread.start();   // firstly i have created a new thread and then we are setting it a daemon thread:
            thread.setDaemon(true);

        } catch (Exception e) {
            System.out.println("application stopped forcefully ");
            Thread.interrupted();
        }

    }

    public class MyThread extends Thread{
        @Override
        public void run() {

            try {
                System.out.println("in this thread Before sleep:" + Thread.currentThread().getName() );
                Thread.sleep(140000);
                System.out.println("in this thread after sleep:" + Thread.currentThread().getName() );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*     If you are interrupting your thread --> your thread must be in sleep position:
       If your thread is not set as daemon: then it won't stop even after thread.interrupt or tread.stop()

       ==> use interrupt carefully:
 */