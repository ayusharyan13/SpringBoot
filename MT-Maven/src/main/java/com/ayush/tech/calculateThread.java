package com.ayush.tech;
// Finding the differences of squares b/w even no and odd number from 1000 to 1
public class calculateThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();  // t1 takes 10sec to execute
        t2.start();  // t2 takes 15 secs to execute

        // but if we take here result of this: t1 and t2 :
        // since this is multithreading main thread has been sent to t2 without completing t1 and also
        // without executing t2 completely, main thread run out of t2:
        // so if we take result at that point: result would be random number since t1 and t2 has not completely executed.

        //  ------------------   to resolve above problem------------  ==> we use Thread.join()
        //  ----   Thread.join()  --> it wait at this point till that thread has completely executed:
        // so time taken = max(t1,t2) = max(10,15) = 15  --> in case of no threading --> time = sum(10+15) = 25

        t1.join();
        t2.join();

        System.out.println(t1.result = t2.result);
    }

    public static class MyThread extends Thread{

        private int result;

        public void run() {
            // do the logic to find the squares:

        }
    }
}
