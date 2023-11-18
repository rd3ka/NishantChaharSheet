import java.util.*;
import java.util.stream.Collectors;

class main {

    static void swap(int []nums, int x, int y) {
        nums[x] ^= nums[y];
        nums[y] ^= nums[x];
        nums[x] ^= nums[y];
    }

    static void permutation(int []nums, List <List<Integer>> permutations, int index) {
        
        if (index == nums.length - 1) {
            permutations.add(Arrays.stream(nums)
                                    .boxed()
                                    .collect(Collectors.toList()));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[index])
                continue; /* omitting duplicate permutations */
            swap(nums, index, i);
            permutation(nums, permutations, index + 1);
            swap(nums, index, i);
        }
    }

    static List <List <Integer>> permute(int []nums) {
        List < List <Integer> > permutations = new ArrayList <> ();
        permutation(nums, permutations, 0);
        return permutations;
    }

    public static void main(String []args) {
        int []nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }
}
