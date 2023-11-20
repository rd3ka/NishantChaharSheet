import java.util.*;


class main {

  static int singleNumber(int nums[]) {
    int loner = nums[0];
    for(int i = 1; i < nums.length; i++)
      loner ^= nums[i];
    return loner;
  }

  public static void main(String []args) {
    int nums[] = new int[]{4, 1, 2, 1, 2};   
    System.out.println(singleNumber(nums));
  }
}
