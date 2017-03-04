package fr.ece.bernoux.lab4MultiThread.exo2;

import java.util.concurrent.locks.ReentrantLock;
//What is the problem with the given code?
//The given code is creating a deadlock
public class PhilosopherDinner {

    private final ReentrantLock[] forks;

    public PhilosopherDinner(int forkCount) {
        ReentrantLock[] forks = new ReentrantLock[forkCount];
        for (int i = 0; i < forkCount; i++) {
            forks[i] = new ReentrantLock();
        }
        this.forks = forks;
    }

    /**A Philosophe try to eat 
     * 
     * @param index
     */
    public void eat(int index) {
        ReentrantLock fork1 = forks[index];
        ReentrantLock fork2 = forks[(index + 1) % forks.length];
        fork1.lock();
        try {
        	//I release the left fork if the right fork is not available, like this i'm not blocking the code
        	if(!fork2.isLocked()){
        		fork2.lock();
                try {
                    System.out.println("philosopher " + index + " eat");
                } finally {
                    fork2.unlock();
                }
        	}    
        } finally {
            fork1.unlock();
        }
    }

    public static void main(String[] args) {
        PhilosopherDinner dinner = new PhilosopherDinner(5);
        for (int i = 0; i < 5; i++) {
            final int philosopher = i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for(;;) {
                        dinner.eat(philosopher);
                    }
                }

            }).start();
        }
    }

}
