import java.util.*;

class main {

  static int[] twoDifference(int nums[], int target) {
    Arrays.sort(nums);

    target = Math.abs(target);

    int l = 0, r = 1;

    while(l <= r && r < nums.length) {

      int diff = nums[r] - nums[l];

      if (diff == target && l != r)
          return new int[]{nums[l], nums[r]};
      else if (diff > target)
          l++;
      else 
          r++;
    }
    return new int[]{-1, -1};
  }

  public static void main(String args[]) {
    int nums[] = {1, 8, 30, 40, 100};
    int target = -60;
    System.out.println(Arrays.toString(twoDifference(nums, target)));
  }
}
