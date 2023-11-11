import java.util.*;


class main {

    static List <Integer> majority_elements(int []nums) {
        int candidate_x = 0, count_x = 0;
        int candidate_y = 0, count_y = 0;

        for(int num : nums) {

            if (count_x == 0 && num != candidate_y) 
                candidate_x = num;
            else
                count_x = (candidate_x == num) ? 1 : -1;

            if (count_y == 0 && num != candidate_x)
                candidate_y = num;
            else         
                count_y = (candidate_y == num) ? 1 : -1;
        }

        List <Integer> result = new ArrayList <> ();
        int threshold = nums.length / 3;

        count_x = 0; count_y = 0;
        for(int num : nums) {
            if (candidate_x == num) count_x++;
            if (candidate_y == num) count_y++;
        }

        if (count_x > threshold) result.add(candidate_x);
        if (count_y > threshold) result.add(candidate_y);

        return result;
    }

    public static void main(String []args) {
        int []nums = {1,2};
        System.out.println(majority_elements(nums));
    }
}