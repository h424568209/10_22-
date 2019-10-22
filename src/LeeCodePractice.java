import java.util.Arrays;

public class LeeCodePractice {
    /**
     *给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 使用三个指针 第一个放在数组首部、第二个放在数组尾部、第三个遍历数组
     * 若遍历到0 则放到数组首部
     * 若遍历到2 则交换最后一个元素和当前元素，并且当前元素的位置减一 因为不确定交换过来的值是多少
     * @param nums
     */
    public void sortColors(int[] nums) {
        int begin = -1;
        int end = nums.length;
        for(int i = 0;i<end;i++){
          if(nums[i]==0){
             swap(nums,i,++begin);
          } if(nums[i]==2){
              swap(nums,i--,--end);
          }
        }
    }

    private void swap(int[] nums, int i, int begin) {
        int t = nums[i];
        nums[i] = nums[begin];
        nums[begin] = t;
    }

    /**
     * 找出needle在haystack中的首元素下标，若不存在，则返回-1
     * 使用needle大小的一个动态长度在haystack中对比，
     *
     * @param haystack
     * @param needle
     * @return
     */
    public  int strStr(String haystack, String needle) {
       int haylen = haystack.length();
       int needlen = needle.length();
       if(haylen<needlen){
           return -1;
       }
       int end = needlen-1;
       int statr = 0;
       while(end<haylen){
           if(haystack.substring(statr,end+1).equals(needle)){
               return statr;
           }
           end++;
           statr++;
       }
       return -1;
}
    /**
     * 移除链表中值和给定值相同的元素
     * 使用双指针法，若遇到等于val的元素则将最后一个元素放到数组首部，更新末尾的指针
     * 否则只更新首指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i<n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else{
                i++;
            }
        }
        return n ;
    }
    /**
      给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
      在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
      找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     使用双指针法，分别从数组的左端点和右端点遍历
      res中存放当前面积的最大值
      遍历的时候较小的值加着计算，因为只有这样才可能让容器中所存放的容量最大

     */
    public int maxArea(int[] height) {
        int begin  = 0;
        int end = height.length-1;
        int res = 0;
        while(end>begin){
            int h = Math.min(height[end],height[begin]);
            res = Math.max(res, h * (end - begin));
            if(height[end]>height[begin]){
                begin++;
            }else{
                end --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeeCodePractice maxArea = new LeeCodePractice();
        int []arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea.maxArea(arr));
        LeeCodePractice str = new LeeCodePractice();
        System.out.println(str.strStr("asdasd","q"));
        LeeCodePractice sortcolors = new LeeCodePractice();
        int nums[]={1,2,2,2,2,1,0,1,1,0};
        sortcolors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
