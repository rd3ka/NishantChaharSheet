import java.util.*;


class main {

  static int maxProduct(int []nums) {
    int current_prod = nums[0], max_prod = Integer.MIN_VALUE;

    /* l to r */
    for(int i = 1; i < nums.length; i++) {
      current_prod = current_prod * nums[i];
      max_prod = Integer.max(max_prod, current_prod);
    }

    current_prod = nums[nums.length - 1];

    /* r to l */
    for(int i = nums.length - 2; i >= 1; i--) {
      current_prod = current_prod * nums[i];
      max_prod = Integer.max(max_prod, current_prod);
    }
    return max_prod;
  }

  public static void main(String []args) {
    int []nums = {-2, 3, -4};
    System.out.println(maxProduct(nums));
  }
}
