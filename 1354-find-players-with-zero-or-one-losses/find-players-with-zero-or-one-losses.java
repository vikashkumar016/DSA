class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer>winner=new HashMap<>();
        HashMap<Integer,Integer>loser=new HashMap<>();
      for(int i=0;i<matches.length;i++){
            int w=matches[i][0];
            int l=matches[i][1];
             winner.put(w, winner.getOrDefault(w, 0) + 1);
    loser.put(l, loser.getOrDefault(l, 0) + 1);
      }
      ArrayList<Integer>win= new ArrayList<>();
     ArrayList<Integer>los= new ArrayList<>();
      for (int player : winner.keySet()) {
            if (!loser.containsKey(player)) {
                win.add(player);
            }
             }
   for (int lose : loser.keySet()) {
    if (loser.get(lose) == 1) {
        los.add(lose);
    }
}
   Collections.sort(win);
        Collections.sort(los);
  ArrayList<List<Integer>>result= new ArrayList<>();
  result.add(win);
  result.add(los);
  return result;
    }
}