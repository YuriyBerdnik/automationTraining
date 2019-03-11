package JavaThreads;

import java.util.Deque;
import java.util.LinkedList;

class QueueBuyer {

    private static Deque<Buyer> deque = new LinkedList<>();

    //synchronized (QueueBuyer.class)
    static synchronized void add(Buyer buyer) {
        deque.addLast(buyer);
    }

    //synchronized (QueueBuyer.class)
    static synchronized Buyer extract() {
        return deque.pollFirst();
    }

    static int getSize() {
        return deque.size();
    }

}
