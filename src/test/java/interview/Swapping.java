package interview;

public class Swapping {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("Before Swap::"+a);
        System.out.println("Before Swap::"+b);
        int temp;
        temp =a;
        a=b;
        b=temp;
        System.out.println("After Swap::"+a);
        System.out.println("After Swap::"+b);

        System.out.println("-------Without Third Variable-----------");
        int c= 24;
        int d =25;
        System.out.println("Before Swap::"+c);
        System.out.println("Before Swap::"+d);
        c =c+d; //49
        d=c-d;  //24
        c=c-d; //25
        System.out.println("After Swap::"+c);
        System.out.println("After Swap::"+d);
    }
}
