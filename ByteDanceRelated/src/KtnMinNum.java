import java.util.Arrays;

//https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=117&&tqId=44581
public class KtnMinNum {
    public int findKth(int[] a, int n, int K) {
        if(K>n)
            return -1;
        int first = partration(a,0,a.length);
        int begin = 0;
        int end = a.length;
        while(first+1!=K){
            System.out.println("first = "+first);
            if(first+1<K){
                begin = first;
                first = partration(a,begin,end);
            }else{
                end = first;
                first = partration(a,begin,end);
            }
        }
        return a[first];
    }

    private int partration(int[]a,int begin,int end){
        int index = (begin+end)/2;
        int pivot = a[index];
        System.out.println("pivot = "+pivot);
        swap(a,begin,index);
        int first = begin;
        int second = begin+1;
        while(second<end){
            if(a[second]>pivot){
                swap(a,second,++first);
            }
            second++;
        }
        swap(a,first,begin);
        return first;
    }

    private void swap(int[]a,int first,int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void main(String[] args) {
        KtnMinNum t = new KtnMinNum();
        int[] a = {1,2,2,3,5};
        System.out.println(t.findKth(a,a.length,2));
    }

}

