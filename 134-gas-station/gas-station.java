class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas=0;
        int totCost=0;
      
        int start=0;
        int currGas=0;
     for(int i=0;i<gas.length;i++){
         totCost+=cost[i];
         totGas+=gas[i];

        currGas+=(gas[i]-cost[i]);
        if(currGas<0){
          start  =i+1;
          currGas=0;
        }
     }
       if(totGas<totCost){
            return -1;
        }
     return start;
    }
}