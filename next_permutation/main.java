import java.util.*;

class main {

    static void swap(int []nums, int x, int y) {
        nums[x] ^= nums[y];
        nums[y] ^= nums[x];
        nums[x] ^= nums[y];
    }

    static void reverse(int []nums, int start, int end) {
        while(start < end) 
            swap(nums, start++, end--);
    }

    static boolean next_permutation(int []nums) {
        /* figure out breaking-point */
        int breaking_point = -1;
        for(int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                breaking_point = i;
                break;
            }
        }

        /* if break-point does not exist, return the reversed array */
        if (breaking_point == -1) {
            reverse(nums, 0, nums.length - 1);
            return false;
        }

        /* if break-point does exist, find the greater element
        within [breaking_point....nums.length - 1] and swap it with element at breaking-point */

        for(int i = nums.length - 1; i >= breaking_point; --i) {
            if (nums[i] > nums[breaking_point]) {
                swap(nums, i, breaking_point);
                break;
            }
        }
        /* reverse from breaking-point + 1 till nums.length - 1 and return the array */
        reverse(nums, breaking_point + 1, nums.length - 1);
        return true;
    }

    static int[] getPermutation(int []nums, int k) {
        for(int i = 1; i < k; i++)
            next_permutation(nums);
        return nums;
    }

    public static void main(String []args) {
        int n,k;
        n = new Scanner(System.in).nextInt();
        k = new Scanner(System.in).nextInt();
        int []nums = new int[n];
        Arrays.setAll(nums, i -> i + 1);
        System.out.println(Arrays.toString(getPermutation(nums, k)));
    }
}