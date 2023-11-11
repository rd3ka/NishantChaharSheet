import java.util.*;

class main {

  static int[] vectorize(int num) {
    int size = (int)(Math.floor(Math.log10(num) + 1));
    int vector[] = new int[size];

    int index = size - 1;
    while ( num != 0) {
      vector[index--] = num % 10;
      num /= 10;
    }

    return vector;
  }

  static int devectorize(int []nums) {
    int num = 0;
    for(int e : nums)
      num = num * 10 + e;
    return num;
  }

  static void swap(int []nums, int x, int y) {
    nums[x] ^= nums[y];
    nums[y] ^= nums[x];
    nums[x] ^= nums[y];
  }

  static void reverse(int []nums, int start, int end) { while(start < end) swap(nums, start++, end--); }

  static boolean next_permutation(int []nums) {

     int break_point = 0;
     for(int i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
          break_point = i;
          break;
        }
     }

    if (break_point == -1) {
      reverse(nums, 0, nums.length - 1);
      return false;
    }

    for(int i = nums.length - 1; i > break_point; i--) {
      if (nums[i] > nums[break_point]) {
        swap(nums, i, break_point);
        break;
      }
    }

    reverse(nums, break_point + 1, nums.length - 1);
    return true;
  }

  static int nextGreaterElement(int num) {
    int num_array[] = vectorize(num);
    while(next_permutation(num_array)) {
      System.out.println(Arrays.toString(num_array));
      int result = devectorize(num_array);
      return result <= num ? -1 : result;
    }
    return -1;
  }

  public static void main(String []args) {
    int num = new Scanner(System.in).nextInt();
    System.out.println(nextGreaterElement(num));
  }
}