class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer>queue=new LinkedList<>();
        Queue<Integer>queuIdx=new LinkedList<>();
        int n=tickets.length;
        for(int i=0;i<tickets.length;i++){
            queue.offer(tickets[i]);
            queuIdx.offer(i);
        }
        int time=0;
         while(!queue.isEmpty()){
              int num=queue.poll();
              int idx=queuIdx.poll();
                num--;
                 time++;
                if(num==0 && idx==k){
                  break;
                }
                if(num==0){
                    continue;
                }
                queue.offer(num);
               
               queuIdx.offer(idx);               
         }
         return time;
    }
}