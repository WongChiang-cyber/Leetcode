package LeetCode;

class LC11_maxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left<right){
            int maxHeight = Math.min(height[left],height[right]);
            res = Math.max((right-left)*maxHeight,res);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

}
