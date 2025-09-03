public class N{
    public static int powerK(int k, int n){
        if (n==1){
            return k;
        }else{
            return k*powerK(k,n-1);
        }

    }
    public static int greatestCommonDivisor(int a, int b){
        int max_divisor=0;
        if (a>b){
            for (int i=1;i<=b;i++){
                if (b%i==0 && a%i==0 && max_divisor<i ){
                    max_divisor=i;
                }
            }
        }else if (a<b){
            for (int i=1;i<=b;i++){
                if (b%i==0 && a%i==0 && max_divisor<i ){
                    max_divisor=i;
                }
            }

        }else{
            max_divisor=a;
        }
        return max_divisor;
    }
    public static void main(String [] args ){
        System.out.println(powerK(5, 3));
        System.out.print(greatestCommonDivisor(18, 12));
    }
}