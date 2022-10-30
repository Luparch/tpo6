package org.example6;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int threadsCount = 4;
        Producer producer = new Producer(2, 756000);
        List<FactorizationThread> threads = new ArrayList<>(threadsCount);
        for(int i = 0; i < threadsCount; i++){
            threads.add(new FactorizationThread(producer));
        }

        for(FactorizationThread o : threads){
            try {
                o.t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("end");
    }
}
