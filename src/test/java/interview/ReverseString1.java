package interview;

public class ReverseString1 {
    public static void main(String[] args) {
        String str = "Hello World";
        String rev = "";
        for(String word : str.split(" ")) {
           String reverse ="";
           for(int i = word.length()-1; i >= 0; i--) {
               reverse = reverse + word.charAt(i);
           }
           rev = rev+" "+ reverse;
        }
        System.out.println(rev);
    }
}
