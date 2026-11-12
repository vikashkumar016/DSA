class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer>radiant=new LinkedList<>();
        Queue<Integer>dire=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R'){
                radiant.offer(i);
            }
            else {
                dire.offer(i);
            }
        }
       while(!radiant.isEmpty() && !dire.isEmpty()) {

    int r = radiant.poll();
    int d = dire.poll();

    if(r < d) {
        radiant.offer(r+n);
    }
    else {
        // Dire gets the turn
        dire.offer(d+n);
    }
}    
if(radiant.isEmpty()){
    return "Dire";
}    
    return "Radiant";
    }
}