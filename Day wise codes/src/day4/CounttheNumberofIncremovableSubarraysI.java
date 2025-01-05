package day4;

public class CounttheNumberofIncremovableSubarraysI
{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new CounttheNumberofIncremovableSubarraysI().incremovableSubarrayCount(nums));
    }

    public int incremovableSubarrayCount(int[] nums) {
        int count = 0 , n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i; j < n; j++){
                boolean isIncreasing = true;
                int prev = 0;
                for(int k = 0 ; k < n; k++){
                    if(k >= i && k <= j){
                        k = j;
                        continue;
                    }

                    if(nums[k] <= prev){
                        isIncreasing = false;
                        break;
                    }
                    prev = nums[k];

                }
                if(isIncreasing)count++;
            }
        }
        return count;
    }
}
