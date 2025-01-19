package interview;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int num =153;
        int sum=0;
        do {
           sum=sum+(num%10 )*(num%10 )*(num%10 );
           num=num/10;
        }while (num > 0);
        System.out.println(sum);
    }
}
