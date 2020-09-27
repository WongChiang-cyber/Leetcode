package JSBank;
import java.util.*;

public class printAllStack {

    public List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();
        find(nums,0,path,stack,res);
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return res;
    }
    public void find(int[] nums,int index,List<Integer> path,List<Integer> stack,List<List<Integer>> res){
        //遍历到最后一个元素
        if(index==nums.length-1){
            System.out.print("path:"+path.toString());
            System.out.println(" stack:"+stack.toString());
            ArrayList<Integer> out = new ArrayList<>(path);
            out.add(nums[index]);
            for (int i = stack.size()-1; i >= 0 ; i--) {
                out.add(stack.get(i));
            }
            res.add(out);
            return;
        }
        int num = nums[index];
        path.add(num);
        find(nums,index+1,path,stack,res);
        stack.add(path.remove(path.size()-1));
        find(nums,index+1,path,stack,res);
        stack.remove(stack.size()-1);
    }

    public static void main(String[] args) {
        printAllStack t = new printAllStack();
        int[] nums = {1,4,2,3};
        List<List<Integer>> list = t.solution(nums);
        for(List<Integer> l : list){
            System.out.println(l.toString());
        }
    }




}
