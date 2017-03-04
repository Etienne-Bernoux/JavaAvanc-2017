package fr.ece.bernoux.lab4MultiThread.exo1;

import java.util.ArrayList;

/*
 * Create a counter who count from 0 to 10000
 */
public class Counter implements Runnable {
	private final ArrayList<Integer> myList;

	public Counter(ArrayList<Integer> myList) {
		super();
		this.myList = myList;
	}

	/*Counter
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int valMax=10000;
		for (int i = 0; i < valMax; i++) {
			System.out.println("I'm "+Thread.currentThread().getName()+" and my counter is at "+i);
			//We add the counter to the list
			this.setList(i);
		}
	}
	
	/*We add a value to the list
	 * To assure that to thread doesn't modify the list in the same time than another we synchronised  my list 
	 */
	public void setList(int val){
		synchronized(myList){
		myList.add(val);
		}
	}
}
