package interview;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,12,3,4,5}; // length of array 7
        int temp;
        //customized method bubble sort
       for (int i = 0; i < arr.length-1; i++) {  //length of array taken 5
           for (int j = 0; j < arr.length-1-i; j++) {  //length of array taken
               if(arr[j]>arr[j+1]){
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }
       for(int j:arr){
           System.out.println(j);
       }
    }
}
