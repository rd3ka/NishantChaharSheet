import java.util.*;

class main {

  static int maxSubArray(int []nums) {
    int size = nums.length;
    
    int current_sum = nums[0], max_sum = current_sum;
    for(int i = 1; i < size; i++) { 
      current_sum = Integer.max(nums[i], current_sum + nums[i]);
      max_sum = Integer.max(max_sum , current_sum);
    }
    return max_sum;
  }

  public static void main(String []args) {
    int []nums = {1};
    System.out.println(maxSubArray(nums)); 
  }
}
