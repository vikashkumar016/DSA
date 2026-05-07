class Solution {
    public int maximumPopulation(int[][] logs) {
       int[] population= new int[101];
       for(int i=0;i<logs.length;i++){
        int birth=logs[i][0];
        int death=logs[i][1];

        for(int j=birth;j<death;j++){
            population[j-1950]++;

        }
       }
       int maxPop = 0;
        int ansYear = 1950;
       for(int i=0;i<101;i++){
           if(population[i]>maxPop){
            maxPop=population[i];
            ansYear=i+1950;
           }
       }
       return ansYear;
    }
}