import java.util.*;


class main {
  

  static void swap(int []ar, int x, int y) {
    ar[x] ^= ar[y];
    ar[y] ^= ar[x];
    ar[x] ^= ar[y];
  }

  static int first_missing(int []nums) {
    int n = nums.length;
    int i = 0;

    while ( i < n ) {
      if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) 
        swap(nums, i, nums[i] - 1);
      else 
        i++;
    }

    System.out.println(Arrays.toString(nums));

    for(i = 0; i < n; i++) {
      if (nums[i] != i + 1) return i + 1;
    }
    return n + 1;
  }

  public static void main(String args[]) {
    int []nums = {2, 4,1};
    System.out.println(first_missing(nums));
  }
}
