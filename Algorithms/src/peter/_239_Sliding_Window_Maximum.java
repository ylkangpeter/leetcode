package peter;

import java.util.*;

/**
 * Created by ylkang on 7/20/15.
 */
public class _239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 - o2 > 0) return -1;
                if (o1 - o2 < 0) return 1;
                return 0;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = queue.peek();

        for (int i = 1; i <= nums.length - k; i++) {
            queue.remove(nums[i - 1]);
            queue.offer(nums[i + k - 1]);
            result[i] = queue.peek();
        }

        return result;
    }

    public int[] maxSlidingWindow_Dequeue(int[] nums, int k) {
        if (nums.length == 0)
            return nums;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> memo = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (memo.size() > 0 && memo.getLast() < nums[i])
                memo.removeLast();
            memo.add(nums[i]);
            if (i < k - 1)
                continue;
            res[i - k + 1] = memo.peek();
            if (nums[i - k + 1] == res[i - k + 1])
                memo.removeFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new _239_Sliding_Window_Maximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

}
