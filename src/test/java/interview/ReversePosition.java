package interview;

public class ReversePosition {
    public static void main(String[] args) {
        String str = "abcd";
        String newStr="";
        String [] arr = str.split("");
        String temp;
        temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[3] =temp;
        for (int i = 0; i < arr.length; i++) {
            newStr=newStr.concat(arr[i]);
        }
        System.out.println(newStr);
    }
}
