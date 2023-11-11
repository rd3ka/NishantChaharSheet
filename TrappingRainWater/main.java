import java.util.*;

class main {

  static int trap(int []height) {
    int size = height.length;

    int left_support[] = new int[size];
    left_support[0] = 0; /* first block will always overflow*/

    for(int i = 1; i < size; i++)
      left_support[i] = Integer.max(left_support[i - 1], height[i - 1]);


    int right_support[] = new int[size];
    right_support[size - 1] = 0; /* last block will always overflow as well */ 

    for(int i = size - 2; i >= 0; i--)
      right_support[i] = Integer.max(right_support[i + 1], height[i + 1]);


    System.out.println(Arrays.toString(left_support));
    System.out.println(Arrays.toString(right_support));

    int trw = 0;
    for(int i = 0; i < size; i++) {
      int min_height = Integer.min(left_support[i], right_support[i]); 
      trw += min_height - height[i] >= 0 ? min_height - height[i] : 0;
    }
    return trw;
  }


  static int trap_optimized(int [] height) {
    int i = 0, j = height.length - 1, trw = 0;
    int left_max = Integer.MIN_VALUE, right_max = Integer.MAX_VALUE;

    while(i <= j) {

      left_max = Integer.max(left_max, height[i]);
      right_max = Integer.max(right_max, height[j]);

      trw += Integer.min(left_max, right_max) - Integer.min(height[i], height[j]);
      
      if (height[i] < height[j]) i++; else j--;  
    }
    return trw;
  }

  public static void main(String []args) {
    int heights[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(heights));   
  }
}
