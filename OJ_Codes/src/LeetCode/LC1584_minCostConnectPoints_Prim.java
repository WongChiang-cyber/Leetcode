package LeetCode;

//use prim method
public class LC1584_minCostConnectPoints_Prim {
    public int minCostConnectPoints(int[][] points) {
        int[][] distance = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int x_A = points[i][0];
                int y_A = points[i][1];
                int x_B = points[j][0];
                int y_B = points[j][1];
                int dis = Math.abs(x_A-x_B)+Math.abs(y_A-y_B);
                distance[i][j] = dis;
            }
        }
        boolean[] set = new boolean[points.length];
        //boolean[] setB = new boolean[points.length];
        set[0] = true;
        //setB[0] = false;
        int res = 0;
        for(int k = 0;k<points.length-1;k++){
            int min_start=0,min_end = 0;
            int min = Integer.MAX_VALUE;
            //找到两个集合之间的最小边
            for (int i = 0; i < set.length; i++) {
                if(set[i]){
                    for (int j = 0; j < set.length; j++) {
                        if(!set[j]){
                            if(distance[i][j]<min){
                                min = distance[i][j];
                                min_start = i;
                                min_end = j;
                            }
                        }
                    }
                }
            }
            //find start end
            set[min_end] = true;
            //setB[min_end] = false;
            res += min;
        }
        return res;
    }

    public static void main(String[] args) {
        LC1584_minCostConnectPoints_Prim t = new LC1584_minCostConnectPoints_Prim();
        int[][] dis = {
            //{0,0},{2,2},{3,10},{5,2},{7,0}
            {0,0},{1,1},{1,0},{-1,1}
        };
        System.out.println(t.minCostConnectPoints(dis));
    }
}
