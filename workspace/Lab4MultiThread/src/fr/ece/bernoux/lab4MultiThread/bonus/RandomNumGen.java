package fr.ece.bernoux.lab4MultiThread.bonus;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class RandomNumGen {
	//I use an AtomicLongFieldUpdater
	//This class is designed for use in atomic data structures in which several
	//fields of the same node are independently subject to atomic updates. 
    private AtomicLongFieldUpdater x[];

    public  RandomNumGen(AtomicLong seed,int size) {
        if (seed.get() == 0) {
            throw new IllegalArgumentException("seed == 0");
        }
        x = new AtomicLongFieldUpdater[size];
        x[0].set(x,seed.get());
    }

    public Long next(int i) {  // Marsaglia's XorShift
        x[i].set(x,x[i].get(x)^x[i].get(x) >>> 12);
        x[i].set(x,x[i].get(x)^x[i].get(x) << 25);
        x[i].set(x,x[i].get(x)^x[i].get(x) >>> 27);
        return (x[i].get(x) * 2685821657736338717L);
    }

    public static void main(String[] args) {
    	int size=1000;
        RandomNumGen rng = new RandomNumGen(new AtomicLong(System.currentTimeMillis()),size);
        for(int i = 0; i < size; i++) {
            System.out.println(rng.next(i));
        }
    }



}
