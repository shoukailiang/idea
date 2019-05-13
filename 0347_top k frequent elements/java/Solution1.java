import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
public class Solution1 {
    private class Freq implements Comparable<Freq>{
        public int e, freq;
        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
        // 可比较
        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq)
                return -1;
            else if(this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        // java的PriorityQueue 默认是最小堆
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();                       // 获取并删除队首元素
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution1()).topKFrequent(nums, k));
    }
}