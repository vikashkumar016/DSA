class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)-> freq.get(a)-freq.get(b));
        for(int num : freq.keySet()){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
       int[] arr= new int[k];
       for(int i=0;i<arr.length;i++){
        arr[i]=pq.poll();
       }
       return arr;
    }
}