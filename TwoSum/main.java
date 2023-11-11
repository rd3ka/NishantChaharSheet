import java.util.*;


class main {

    static boolean two_sum(int []nums, int target) {

        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while(l < r) {
            
            int sum = nums[l] + nums[r];

            if (sum == target) return true;
            else if (sum > target) r--;
            else 
                l++;
        }
        return false;
    }

    public static void main(String []args) {
        int []nums = {1, -2, 1, 0, 5};
        int target = 0;
        System.out.println(two_sum(nums, target));
    }
}