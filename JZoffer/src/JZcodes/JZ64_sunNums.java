package JZcodes;

public class JZ64_sunNums {
    private static int res =0;
    public int sumNums(int n) {
        boolean x = n>1 && sumNums(n-1)>1;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        JZ64_sunNums t = new JZ64_sunNums();
        System.out.println(t.sumNums(2));
    }
}
