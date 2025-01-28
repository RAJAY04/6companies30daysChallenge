package day27;

import java.util.ArrayList;

public class MissingAndRepeating {
    public static void main(String[] args) {
        MissingAndRepeating obj = new MissingAndRepeating();
        int[] arr = {4, 3, 6, 2, 1, 1};
        System.out.println(obj.findTwoElement(arr));
    }

    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++){
            int val = arr[i];
            int trueIndex = val - 1;
            if(arr[i] == arr[trueIndex]){
                continue;
            }
            swap(arr,i,trueIndex);

            if(arr[i] != (i + 1))i--;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != (i + 1)){
                list.add(arr[i]);
                list.add(i + 1);
            }
        }
        return list;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
