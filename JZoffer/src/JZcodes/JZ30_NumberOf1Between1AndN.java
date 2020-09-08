package JZcodes;

public class JZ30_NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        long digit = 1;
        long sum = 0;
        long high=1,low=1;
        while(high!=0){
            high = n/(digit*10);
            low = n%digit;
            long num = n/digit-high*10;
            if(num==0){
                sum += high*digit;
            }else if(num==1){
                sum += high*digit+low+1;
            }else{
                //num = 2~9
                sum += (high+1)*digit;
            }
            digit *= 10;
        }
        return (int)sum;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(1410065408));
    }
}
