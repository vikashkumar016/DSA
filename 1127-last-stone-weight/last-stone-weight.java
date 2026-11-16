class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());

    for (int stone : stones) {
    pq.add(stone);
    }
    
    while(pq.size()>1){
        int x=pq.poll();
        int y=pq.poll();
        int diff=x-y;
        if(diff>0){
            pq.add(diff);
        }
    }
     return pq.isEmpty() ? 0 : pq.poll();
    }
}