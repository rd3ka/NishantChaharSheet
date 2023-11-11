import java.util.*;

class main {
  
  public static void swap(int []nums, int x, int y) {
    nums[x] ^= nums[y];
    nums[y] ^= nums[x];
    nums[x] ^= nums[y];
  }

  public static List < List <Integer>> permutation(int []nums, List <List <Integer>>result, int index) {
    if (index == nums.length) {
      result.add(Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toList()));
      return;
    }
    for(int i = index; i < nums.length; i++) {
      if (i != index && nums[i] == nums[index]) 
        continue;
      swap(nums, i, index);
      permute(nums, index + 1);
    }
  }

  public static void permute(int []nums) {
    List < List <Integer>> result = new ArrayList <new ArrayList <>> ();
    permutation(nums, result, 0);
  }

  public static void main(String []args) {
    int nums[] = new int[]{1, 2, 3};
    permute(nums);
  }
}
