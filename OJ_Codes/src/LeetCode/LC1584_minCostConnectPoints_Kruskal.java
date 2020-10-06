package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;

//use prim method
public class LC1584_minCostConnectPoints_Kruskal {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Distance> distance = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int x_A = points[i][0];
                int y_A = points[i][1];
                int x_B = points[j][0];
                int y_B = points[j][1];
                int dis = Math.abs(x_A-x_B)+Math.abs(y_A-y_B);
                distance.add(new Distance(i,j,dis));
            }
        }
        distance.sort(new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                return o1.distance - o2.distance;
            }
        });
        boolean[] set = new boolean[points.length];
        int count = 0;
        int res =0;
        for (int i = 0; i < distance.size(); i++) {
            int start = distance.get(i).start;
            int end = distance.get(i).end;
            if((set[start] & set[end])){
                set[start] = true;
                set[end] = true;
                res += distance.get(i).distance;
                count++;
            }
            if(count==points.length-1)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        LC1584_minCostConnectPoints_Kruskal t = new LC1584_minCostConnectPoints_Kruskal();
        int[][] dis = {
            //{0,0},{2,2},{3,10},{5,2},{7,0}
            //{0,0},{1,1},{1,0},{-1,1}
            {2,-3},{-17,-8},{13,8},{-17,-15}
        };
        System.out.println(t.minCostConnectPoints(dis));
    }
}
class Distance{
    int start;
    int end;
    int distance;
    Distance(int start,int end,int distance){
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}
