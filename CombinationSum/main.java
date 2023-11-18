import java.util.*;


class main {

  public static void doCombinationSum(int []candidates,
                                      int target, 
                                      List <Integer> aux, 
                                      List <List <Integer>> combinations,
                                      int index) {

    if (index == candidates.length) {
      if (target <= 0)  
        combinations.add(new ArrayList <>(aux));
      return;
    }

    if (candidates[index] <= target) {
      aux.add(candidates[index]); /* considering candidates less than target */
      doCombinationSum(candidates, target - candidates[index], aux, combinations, index); 
      /* considering candidates less than target for as many times possible */ 
      aux.remove(aux.size() - 1); /*backtracking to reset the state of auxilary array */
    }
    doCombinationSum(candidates, target, aux, combinations, index + 1);
  }

  public static List <List <Integer>> combinationSum(int candidates[], int target) {
    List < List <Integer>> combinations = new ArrayList <> ();
    doCombinationSum(candidates, target, new ArrayList <>(), combinations, 0);
    return combinations;
  }

  public static void main(String []args) {
    int candidates[] = new int[]{2, 3, 5};
    int target = 8;
    System.out.println(combinationSum(candidates, target));
  }
}
