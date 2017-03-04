package fr.ece.bernoux.lab4MultiThread.exo1;

import java.util.ArrayList;

/*1)Why use Runnable?
 * Because we can reuse code for each thread and run it separately in each thread
 */


public class CounterThread {
	public static void main(String[] args) {
		
		
		//We create an arrayList
		ArrayList<Integer> myList = new ArrayList<>();
		
		//We create 4 thread
		Thread[]  counters =new Thread[5];
		
		//We instanciate them
		for (int i = 0; i < counters.length; i++) {
			counters[i]= new Thread(new Counter(myList));
		}
		//We start them
		for (int i = 0; i < counters.length; i++) {
			counters[i].start();
		}
		//We wait for the end of each of them
		for (int i = 0; i < counters.length; i++) {
			try {
				counters[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//We end the programm
		System.out.println("Program finishes!");
		System.out.println(myList);
		System.out.println(myList.size());

		
	}
}
