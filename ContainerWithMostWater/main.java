import java.util.*;

class main {
  
  public static int maxArea(int []heights) {
    
    int x = 0; int y = heights.length - 1;
    int max_area = Integer.MIN_VALUE;

    while(x < y) {
      int l = y - x;
      int h = Integer.max(heights[x], heights[y]) - Math.abs(heights[x] - heights[y]);
      max_area = Integer.max(max_area, l * h);
      if (heights[x] > heights[y]) y--; else x++;      
    }
    return max_area;
  }

  public static void main(String args[]) {
    int heights[] = new int[]{1,8,6,2,5,4,8,3,7};
    System.out.println(maxArea(heights));
  }
}
