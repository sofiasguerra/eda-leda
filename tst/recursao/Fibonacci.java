import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Fibonacci(n));
    }
    
    public static int Fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

}
