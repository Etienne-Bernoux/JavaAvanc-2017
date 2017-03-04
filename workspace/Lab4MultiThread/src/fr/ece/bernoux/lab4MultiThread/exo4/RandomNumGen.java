package fr.ece.bernoux.lab4MultiThread.exo4;

import java.util.concurrent.atomic.AtomicLong;

public class RandomNumGen {
	//I use an atomicLong
    private AtomicLong  x;

    public  RandomNumGen(AtomicLong seed) {
        if (seed.get() == 0) {
            throw new IllegalArgumentException("seed == 0");
        }
        x = seed;
    }

    public Long next() {  // Marsaglia's XorShift
        x.set(x.get()^x.get() >>> 12);
        x.set(x.get()^x.get() << 25);
        x.set(x.get()^x.get() >>> 27);
        return (x.get() * 2685821657736338717L);
    }

    public static void main(String[] args) {
        RandomNumGen rng = new RandomNumGen(new AtomicLong(System.currentTimeMillis()));
        for(int i = 0; i < 1000; i++) {
            System.out.println(rng.next());
        }
    }

}
