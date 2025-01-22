package day21;

import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        FindTheDistanceValueBetweenTwoArrays obj = new FindTheDistanceValueBetweenTwoArrays();
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        System.out.println(obj.findTheDistanceValue(arr1,arr2,d));
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        Arrays.sort(arr2);
        for(int num : arr1){
            int upperBound = binarySearch(arr2,num + d,true);
            int lowerBound = binarySearch(arr2,num - d,false);
            if((lowerBound != -1 && Math.abs(num - arr2[lowerBound]) > d) || (upperBound != -1 && Math.abs(num - arr2[upperBound]) > d)){
                ans++;
            }
        }
        return ans;
    }

    public int binarySearch(int[] nums,int target, boolean isUpperBound){
        int s = 0 , e = nums.length - 1;
        int ans = -1;
        while(s < e){
            int mid = s + (e - s)/2;
            if(isUpperBound){
                if(nums[mid] <= target){
                    ans = mid;
                    s = mid + 1;
                }else{
                    e = mid;
                }
            }else{
                if(nums[mid] >= target){
                    ans = mid;
                    e = mid;
                }else{
                    s = mid + 1;
                }
            }

        }
        return ans;
    }
}
