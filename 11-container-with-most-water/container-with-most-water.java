class Solution {
    public int maxArea(int[] ht) {
    //     if(height.length<3){   ///Brute force appraoch 
    //         return 1;
    //     }
    //   int maxWater=0;
    //   for(int i=0;i<height.length;i++){
    //     for(int j=i+1;j<height.length;j++){
    //         int ht=Math.min(height[i],height[j]);
    //         int width=j-1;
    //         int currWater=ht*width;
    //         maxWater=Math.max(maxWater,currWater);
    //     }
    //   }  
    //   return maxWater;
    //OPTIMISED SOLUTION
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
