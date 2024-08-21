import java.util.*;

class MaxPriorityQueue<T extends Comparable<T>> {
    private MinPriorityQueue<InvertedComparable<T>> minPriorityQueue;

    public MaxPriorityQueue() {
        minPriorityQueue = new MinPriorityQueue<>();
    }

    public void insert(T item) {
        // Wrap the key in InvertedComparable to maintain maximum-oriented behavior
        InvertedComparable<T> invertedKey = new InvertedComparable<>(item);
        minPriorityQueue.insert(invertedKey);
    }

    public T max() {
        InvertedComparable<T> invertedMax = minPriorityQueue.min();

        // Unwrap the max key to retrieve the original maximum value
        return invertedMax != null ? invertedMax.getOriginalKey() : null;
    }

    public T removeMax() {
        InvertedComparable<T> invertedMax = minPriorityQueue.removeMin();

        // Unwrap the max key to retrieve the original maximum value
        return invertedMax != null ? invertedMax.getOriginalKey() : null;
    }
}

class MinPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> queue;

    public MinPriorityQueue() {
        queue = new PriorityQueue<>();
    }

    public void insert(T item) {
        queue.offer(item);
    }

    public T min() {
        return queue.peek();
    }

    public T removeMin() {
        return queue.poll();
    }
}

class InvertedComparable<T extends Comparable<T>> implements Comparable<InvertedComparable<T>> {
    private T originalKey;

    public InvertedComparable(T key) {
        this.originalKey = key;
    }

    public T getOriginalKey() {
        return originalKey;
    }

    @Override
    public int compareTo(InvertedComparable<T> o) {
        return o.originalKey.compareTo(this.originalKey);
    }
}
