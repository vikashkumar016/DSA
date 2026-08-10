class Solution {
    public int maxArea(int[] ht) {
         int maxWater =0;
    int lp=0;
    int rp=ht.length-1;
    while(lp<rp){
        //Calculate water area
        int height=Math.min(ht[lp],ht[rp]);
        int width=rp-lp;
        int currWater=height*width;
        maxWater=Math.max(maxWater,currWater);

        //update pointer
        if(ht[lp]<ht[rp]){
            lp++;
        }
        else{
            rp--;
        }
    }
    return maxWater;
    }
}