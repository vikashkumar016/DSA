class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis= new boolean[n];
        Queue<Integer>q= new LinkedList<>();
        q.offer(0);
        vis[0]=true;
        while(!q.isEmpty()){
          int node=q.poll();
             for(int num:rooms.get(node)){
                if(!vis[num]){
                    vis[num]=true;
                    q.add(num);
                }
             }
        }
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                return false;
            }
        }
      return true;
    }
}