package org.example6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeProducer {

    static class Notice{
        private int index;
        public Notice(){
            index = 0;
        }

        public int getPrime(){
            return primes.get(index);
        }

    }
    private static List<Integer> primes;

    static {
        primes = new ArrayList<>();
        primes.add(2);
    }

    public static Notice getNotice(){
        return new Notice();
    }


    public static int getNextPrimeForMe(Notice notice){
        int nextIndex = notice.index+1;
        int nextPrime;
        if(primes.size()-1 < nextIndex){
            nextPrime = calcPrimeGreaterThan(primes.get(notice.index));
            notice.index = primes.size()-1;
        }
        else{
            nextPrime = primes.get(nextIndex);
            notice.index = nextIndex;
        }
        return nextPrime;
    }

    private static int getPrimeNextByPrime(int begin){
        if(primes.get(primes.size()-1) <= begin){
            return calcPrimeGreaterThan(begin);
        }
        int index = Collections.binarySearch(primes, begin);
        return primes.get(index+1);
    }

    private synchronized static int calcPrimeGreaterThan(int begin){
        int num = begin + 1;
        while(!isPrime(num)){
            num++;
        }
        primes.add(num);
        return num;
    }

    private synchronized static boolean isPrime(int num){
        for(int o : primes){
            if(num % o == 0){
                if(o != num)
                    return false;
            }
        }
        return true;
    }
}
