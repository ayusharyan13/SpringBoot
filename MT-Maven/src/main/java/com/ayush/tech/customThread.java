package com.ayush.tech;

public class customThread {
    public static void main(String[] args) {
        // objects of Animal class
        Animal a1 = new Animal("tom","cat");
        Animal a2 = new Animal("bashooka","tiger");

        // let's create 4 thread:: 2 threads on a1 and 2 threads on a2

        MyThread thread1 = new MyThread(a1);
        MyThread thread2 = new MyThread(a1);

        MyThread thread3 = new MyThread(a2);
        MyThread thread4 = new MyThread(a2);

        // starting all 4 threads at once
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    public static class MyThread extends Thread {
        // let's create animal as a property of this class --> member variable
        Animal animal;

        // now create the constructor of this to accept animal object

        public MyThread(Animal animal) {
            this.animal = animal;
        }

        @Override
        public void run() {
            // taking a lock on this animal object --> object level synchronization
//            synchronized (this.animal) {

            // Class level synchronization
            // only one thread runs of a class at once --> t1--> t2--> t3--> t4
            synchronized (Animal.class) {
                System.out.println("current thread: " + currentThread().getName() + ", animal: " + this.animal);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
