package PDD_2020;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(R(sc.nextInt()));
        }
    }

    public static int R(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;

        return R(n/2)+1;
    }
}
