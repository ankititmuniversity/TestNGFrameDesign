package interview;

public class Palindrome {
    public static void main(String[] args) {
        //method1
        int num =121;
        String str = String.valueOf(num);
        String str2 = String.format("%d",num);
        String str3 = Integer.toString(num);
        String rev ="";
        for (int i =0;i<str.length();i++){
            rev = str.charAt(i)+rev;
        }
        System.out.println(rev);
        if (rev.equals(str)){
            System.out.println("Given Number is Palindrome");
        }else {
            System.out.println("Given Number is not Palindrome");
        }
        //method2
        int sum=0;
        do{
            sum =sum*10+(num%10); //20
            num=num/10;
        }while (num!=0);
        System.out.println(sum);
        if ((num == sum)) {
            System.out.println("Given Number is Palindrome");
        } else {
            System.out.println("Given Number is Palindrome");
        }

    }
}
