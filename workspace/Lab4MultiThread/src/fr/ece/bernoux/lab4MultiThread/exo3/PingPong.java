package fr.ece.bernoux.lab4MultiThread.exo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*This code is writing pong when ping is write. This fuction wait a boolean to be true
 * 
 */

public class PingPong {

	final Lock lock = new ReentrantLock();
	final Condition ping = lock.newCondition();
	final Condition pong = lock.newCondition();

	private void ping() {
		this.lock.lock();		
		System.out.print(
				"ping awaits " +  /*this.lock.tryLock() +*/  "\n");
		System.out.println("ping");
		this.pong.signal();
		this.lock.unlock();

	}

	private void pong() throws InterruptedException {

		this.lock.lock();
		System.out.print("pong awaits " + /* this.lock.tryLock() +*/  "\n");
		this.pong.await();
		this.lock.lock();
		System.out.println("pong");
		this.ping.signal();
		this.lock.unlock();

	}

	public static void main(String[] args) throws InterruptedException {
		PingPong pingPong = new PingPong();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					new AssertionError(e);
				}
				int i = 0;
				for (;;) {
					i++;
					System.out.println(i);
					pingPong.ping();
					pingPong.lock.lock();
					try {
						pingPong.ping.await();
						pingPong.lock.lock();
						System.out.print(
								"ping awaits " +  /*pingPong.lock.tryLock() + */ "\n");

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}).start();

		for (;;) {
			pingPong.pong();
		}

	}

}
