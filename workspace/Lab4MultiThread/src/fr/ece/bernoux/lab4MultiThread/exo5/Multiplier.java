package fr.ece.bernoux.lab4MultiThread.exo5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multiplier {
	private ExecutorService srv;//The pool is stored here
	private Future<Integer>[] futures;// The result from the callable are stored here
	private Integer[] results;//The result for the runnable is store here


	
	/**The constructor method who instanciate each element of the class
	 * 
	 * @param NbThread
	 * @param NbFuture
	 */
	@SuppressWarnings("unchecked")
	public Multiplier(int NbThread, int NbFuture) {
		super();
		this.srv = Executors.newFixedThreadPool(NbThread);
		this.futures = new Future[NbFuture];
		this.results = new Integer[NbFuture];
	}
	/**
	 * 
	 * @param n
	 * @return n*10
	 */
	private int computeValue(final int n){		
		return n*10;	
	}

	public static void main(String[] args) {
		int NbThread = 4;
		int NbFuture = 100;
		Multiplier myMultiplier = new Multiplier(NbThread, NbFuture);
		
		//For each clacule i try to do it with the runnable and the callable method
		for (int i = 0; i < NbFuture; i++) {
			final int n = i;
			///The runnable Part
			myMultiplier.srv.submit(new Runnable() {
				
				@Override
				public void run() {
					//The value is directly stored for the runnable, this allow error(null value)
					myMultiplier.results[n] = myMultiplier.computeValue(n);
					
				}
			});
					
			///The callable Part
			myMultiplier.futures[i] = myMultiplier.srv.submit(new Callable<Integer>() {
				@Override
				public Integer call() {
					//The value is return in a Futur form
					return myMultiplier.computeValue(n);
				}
			});
		}
		
		//I print all my result
		for (Integer result : myMultiplier.results) {
			System.out.println(result);
			
		}
		
		for ( Future<Integer> futur : myMultiplier.futures) {
			try {
				//Extraction of the result
				System.out.println(futur.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
