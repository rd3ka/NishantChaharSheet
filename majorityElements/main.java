import java.util.*;

class main {
  
  static int major_element(int []nums ) {
    /* use moore-voting algorithm 
     * 
     * intution: the majority element in an array will always remain the lead
     * even after encountering other elements
     *
     * Approach: 
     *
     * count & candidate, where count is set to 0 and candidate is to any arbitrary value
     * loop:
     *  
     *    a. if count is 0:
     *          assign current element as new candidate
     *    b. if current element is same as candidate:
     *          the candidature of that candidate increases, hence we increament by 1
     *    c. if current element is different from the candidate:
     *          the candidature of that candidate decreases, hence we decrease by 1
     * */

    int count = 0, candidate = 0;
    for(int num : nums) {

      if (count == 0)
        candidate = num;

      count += (num == candidate) ? 1 : -1; 
    }
    return candidate;
  }

  public static void main(String []args) {
    int []ar = {2, 2, 1, 1, 1, 2, 2};
    System.out.println(major_element(ar)); 
  }
}
