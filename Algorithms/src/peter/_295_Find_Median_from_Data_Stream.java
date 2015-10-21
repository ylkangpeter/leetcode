package peter;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by ylkang on 10/19/15.
 */
public class _295_Find_Median_from_Data_Stream {

    int total = 0;

    PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

    PriorityQueue<Integer> leftQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            }
            return 0;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (total == 0) {
            leftQueue.add(num);
        } else if (total == 1) {
            int tmp = leftQueue.peek();
            if (tmp > num) {
                leftQueue.poll();
                rightQueue.add(tmp);
                leftQueue.add(num);
            } else {
                rightQueue.add(num);
            }
        } else {
            if (leftQueue.size() == rightQueue.size()) {
                if (rightQueue.peek() < num) {
                    int tmp = rightQueue.poll();
                    leftQueue.add(tmp);
                    rightQueue.add(num);
                } else {
                    leftQueue.add(num);
                }
            } else {
                if (leftQueue.peek() <= num) {
                    rightQueue.add(num);
                } else {
                    int tmp = leftQueue.poll();
                    leftQueue.add(num);
                    rightQueue.add(tmp);
                }
            }
        }
        total++;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (total == 0) {
            return 0;
        } else if (total % 2 == 1) {
            return leftQueue.peek();
        } else {
            return ((double) leftQueue.peek() + rightQueue.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        _295_Find_Median_from_Data_Stream a = new _295_Find_Median_from_Data_Stream();
        a.addNum(1);
        System.out.println(a.findMedian());
        a.addNum(2);
        System.out.println(a.findMedian());
        a.addNum(3);
        System.out.println(a.findMedian());

    }
}
