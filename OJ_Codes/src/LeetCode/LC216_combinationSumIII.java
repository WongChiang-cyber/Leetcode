package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC216_combinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        find(k,n,1,path,res);
        return res;
    }

    public void find(int k, int n, int min, List<Integer> path,List<List<Integer>> res){
        //最大值取上界
        int max = (n+1)/k;
        if(min>=10)
            return;
        if(k==1){
            if(n>=10)
                return;
            path.add(n);
            //System.out.print(path.get(i));
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
            //System.out.println();
            path.remove(path.size()-1);
            return;
        }
        for (int i = min; i < max && i < 10; i++) {
            path.add(i);
            find(k-1,n-i, i +1,path,res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        LC216_combinationSumIII t = new LC216_combinationSumIII();
        List<List<Integer>> res = t.combinationSum3(2,18);
        for(List<Integer> list : res){
            System.out.println(list.toString());
        }
    }
}
