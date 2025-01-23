package day22;

import java.util.Arrays;

public class MaximizeAreaOfSquareHoleInGrid {
    public static void main(String[] args) {
        MaximizeAreaOfSquareHoleInGrid obj = new MaximizeAreaOfSquareHoleInGrid();
        int n = 3;
        int m = 2;
        int[] hBars = {3,2,4};
        int[] vBars = {3,2};
        System.out.println(obj.maximizeSquareHoleArea(n,m,hBars,vBars));
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxLen = Math.min(maxConsecLen(hBars),maxConsecLen(vBars)) + 1;
        return maxLen * maxLen;
    }
    public int maxConsecLen(int[] arr){
        int len = 1, maxLen = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] == arr[i] - 1){
                len++;
            }else{
                len = 1;
            }
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
}
