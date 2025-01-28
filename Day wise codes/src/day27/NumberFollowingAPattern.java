package day27;

public class NumberFollowingAPattern {
    public static void main(String[] args) {
        String S = "IIIIDDDI";
        System.out.println(printMinNumberForPattern(S));
    }

    static String printMinNumberForPattern(String S){
        int n = S.length();
        char[] arr = S.toCharArray();
        int[] sufix = new int[n + 1];
        boolean[] numbers = new boolean[10];
        sufix[n - 1] = (arr[n - 1] == 'D') ? 1 : 0;
        for(int i = n - 2; i >= 0 ; i--){
            if(arr[i] == 'D'){
                sufix[i] = sufix[i + 1] + 1;
            }else{
                sufix[i] = 0;
            }
        }

        StringBuilder res = new StringBuilder();
        int num = sufix[0] + 1;
        numbers[num] = true;
        res.append(num + "");

        for(int i = 1; i <= n; i++){
            num = findMin(numbers) + sufix[i];
            numbers[num] = true;
            res.append(num + "");
        }
        return res.toString();

    }

    static int findMin(boolean[] n){
        for(int i = 1 ; i < n.length; i++){
            if(n[i])continue;
            return i;
        }
        return -1;
    }
}
