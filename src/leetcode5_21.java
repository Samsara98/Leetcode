import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode5_21 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)->(o2-o1));
        priorityQueue.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (priorityQueue.size() < k)
                priorityQueue.add(nums[i]);
            else if (nums[i] >= priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        int result=nums[0];
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }
        return result;
    }


}
