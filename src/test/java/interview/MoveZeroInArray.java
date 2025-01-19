package interview;

public class MoveZeroInArray {
    public static void main(String[] args) {
        int[] arr = {1,53,0,423,12,2,0,6,0};
        int index = 0; // Index to place the non-zero element

        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i]; // Move non-zero element to the correct index
                index++;
            }
        }
        // Fill the remaining positions with zero
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
        for(int a:arr){
            System.out.println(a);
        }
    }
}
