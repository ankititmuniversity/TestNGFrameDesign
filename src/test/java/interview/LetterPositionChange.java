package interview;

public class LetterPositionChange {
    public static void main(String[] args) {
        String sentence = "Hello World";
        String[] words = sentence.split(" ");
        String rev = "";
        for (String word : words) {
            int length = word.length();
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(length - 1);
            String middle = word.substring(1, length-1);
            rev = rev + lastChar + middle+firstChar+" ";
        }
        System.out.println(rev);
    }
}
