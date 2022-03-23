package exercises.codesignalcontainer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A container of integers that should support
 * elements addition, removal, and search of the median element
 */
public class ContainerImpl implements Container {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public ContainerImpl() {
        // write your code here
    }

    @Override
    public void add(int value) {
        // write your code here
        try {
            this.priorityQueue.add(value);
        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean delete(int value) {
        try {
            return this.priorityQueue.remove(value);
        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public int getMedian() {
        try {
            if (this.priorityQueue.isEmpty()) {
                throw new RuntimeException();
            }

            int median;
            PriorityQueue<Integer> priorityQueueCopy = new PriorityQueue<>(this.priorityQueue);
            List<Integer> list = new ArrayList<>(this.priorityQueue.size());
            while (!priorityQueueCopy.isEmpty()) {
                list.add(priorityQueueCopy.poll());
            }

            int listSize = list.size();
            if (listSize % 2 == 0) {
                median = list.get((listSize / 2) - 1);
            } else {
                median = list.get(listSize / 2);
            }
            return median;
        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }
}


