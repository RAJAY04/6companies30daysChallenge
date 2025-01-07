package day6;

public class LongestMountaininArray
{
    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
        System.out.println(new LongestMountaininArray().longestMountain(arr));
    }
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        inc[0] = 1;
        dec[n - 1] = 1;
        for(int i = 1 ; i < n; i++){
            if(arr[i] <= arr[i - 1]){
                inc[i] = 1;
            }else{
                inc[i] = inc[i - 1] + 1;
            }
            if(arr[n - i - 1] <= arr[n - i]){
                dec[n - i - 1] = 1;
            }else{
                dec[n - i - 1] = dec[n - i] + 1;
            }
        }

        int max = 0;
        for(int i = 0 ; i < n; i++){
            if(inc[i] > 1 && dec[i] > 1)
                max = Math.max(inc[i] + dec[i] - 1,max);
        }

        return max;
    }
}
