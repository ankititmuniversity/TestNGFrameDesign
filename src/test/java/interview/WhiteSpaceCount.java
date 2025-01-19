package interview;

public class WhiteSpaceCount {
    public static void main(String[] args) {
        String str = "Hello World! Welcome to Java";
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            // Check if the character is a whitespace
            if (Character.isWhitespace(str.charAt(i))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
