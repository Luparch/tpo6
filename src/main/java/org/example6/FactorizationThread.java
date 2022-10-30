package org.example6;

import java.util.ArrayList;
import java.util.List;

public class FactorizationThread implements Runnable{

    Thread t;
    private Producer producer;

    public FactorizationThread(Producer producer){
        this.producer = producer;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        int num;
        while(producer.hasNext()){
            num = producer.get();
            //System.out.println(Thread.currentThread() + " " + num);
            factorizeNumber(num);
        }
    }

    public List<Integer> factorizeNumber(int num){
        List<Integer> list = new ArrayList<>();
        PrimeProducer.Notice notice = PrimeProducer.getNotice();
        int prime = notice.getPrime();
        int counter = 0;
        while(num!=1){
            while(num % prime == 0){
                num /= prime;
                counter++;
            }
            list.add(counter);
            counter = 0;
            prime = PrimeProducer.getNextPrimeForMe(notice);
        }
        return list;
    }
}
