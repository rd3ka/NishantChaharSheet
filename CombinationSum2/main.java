import java.util.*;


class main {

  public static void doCombinationSum(int []candidates, int target, 
                                      List <Integer> aux, 
                                      List <List <Integer>> combinations, int index) {
    
    if (target <= 0) {
      combinations.add(new ArrayList <> (aux));
      return;
    }

    for(int i = index; i < candidates.length; i++) {

      if (i != index && candidates[i] == candidates[index])
        continue;

      if (candidates[i] <= target) {
        aux.add(candidates[i]);
        doCombinationSum(candidates, target - candidates[i], aux, combinations, i + 1);
        aux.remove(aux.size() - 1);
      }
    }
  }

  public static List <List <Integer>> combinationSum2(int [] candidates, int target) {
    List <List <Integer>> combinations = new ArrayList <> ();
    doCombinationSum(candidates, target, new ArrayList <>(), combinations, 0);
    return combinations;
  }

  public static void main(String []args) {
    int candidates[] = new int[]{10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    System.out.println(combinationSum2(candidates, target));
  }
}