class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer>q= new LinkedList<>();
        int count=1;
        for(int i=0;i<n;i++){
            q.add(count);
            count++;
        }
        int move=1;
        
       while(q.size()>1){
         for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }

            q.poll();
       }
       return q.peek();
    }
}