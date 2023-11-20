import java.util.*;


class main {

    static void doSolveSubsetSum(int nums[], List <Integer> subset_sums, 
                                             List <Integer> sets, 
                                             int index) {
        int sum = 0;
        for(Integer s : sets)
            sum += s;
        
        subset_sums.add(sum);

        for(int i = index; i < nums.length; i++) {
            sets.add(nums[i]);
            doSolveSubsetSum(nums, subset_sums, sets, i + 1);
            sets.remove(sets.size() - 1);
        }
    }

    static List <Integer> solveSubsetSum(int n, int nums[]) {
        List <Integer> subset_sums = new ArrayList <> ();
        doSolveSubsetSum(nums, subset_sums, new ArrayList <> (), 0);
        Collections.sort(subset_sums);
        return subset_sums;
    }

    public static void main(String []args) {
        int n = 3;
        int nums[] = new int[]{3, 1, 2};
        System.out.println(solveSubsetSum(n, nums));
    }
}
