package interview;

public class FibonacciSeries {
    public static void main(String[] args) {
        /*0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
        * F(0) = 0 (First term)
        F(1) = 1 (Second term)
        F(n) = F(n-1) + F(n-2) for n ≥ 2*/

       int n0 = 0,n1 = 0,sum,n;
       for (int i=0;i<=10;i++){
           if (i<2 && i>=0){
               n0=0;
               n1=1;
               System.out.println(i);
           }else {
               sum=n1+n0;
               n0=n1;
               n1=sum;
               System.out.println(sum);
           }
       }
    }
}
