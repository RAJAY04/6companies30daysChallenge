package day14;

public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preorder));
    }

    public static boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int n = arr.length;
        int diff = 1;
        for(int i = 0 ; i < n; i++){
            diff--;
            if(!arr[i].equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
