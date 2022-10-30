package org.example6;

public class Producer {

    private int cur;
    private int end;

    public Producer(int c, int e){
        cur = c;
        end = e;
    }

    public boolean hasNext(){
        return cur <= end;
    }
    public synchronized int get(){
        return cur++;
    }

}
