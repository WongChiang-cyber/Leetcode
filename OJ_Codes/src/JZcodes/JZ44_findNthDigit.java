package JZcodes;

import java.lang.reflect.Array;

public class JZ44_findNthDigit {
    public static int findNthDigit(int n) {
        //System.out.println("n = "+n);
        long pos =n;
        long i = 0;
        long digitSum_last = 0;
        long digitSum_next = 0;
        int offset = 9;
        long digit = 0;
        long number = 0;
        long startPos = 0;
        //ten = 10^i
        long ten = 0;
        while(true){
            if(i==0){
                digitSum_next = 0;
                ten = 0;
            }else if(i==1){
                digitSum_next = 10;
                ten = 10;
            }else{
                offset*=10;
                ten*=10;
                digitSum_next = offset*i+digitSum_last;
            }
            //System.out.println("digit_next = "+String.valueOf(digitSum_next));
            if(pos>=digitSum_next){
                //目前的i比较小，目标不在本次循环的范围内
                digitSum_last = digitSum_next;
                i++;
                continue;
            }else{
                //n>digit_next 到达上限，应该取上个循环的结果i
                digit = digitSum_last;
                i--;
                if(i==0)
                    ten=0;
                number = (pos-digit)/(i+1)+ten/10;
                //System.out.println("number = "+number);
                startPos = (number-ten/10)*(i+1) + digit;
                String str = String.valueOf(number);
                return str.charAt((int)(pos-startPos))-'0';
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
