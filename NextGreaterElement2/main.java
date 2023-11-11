import java.util.*;

class main {

    static int[] nextGreaterElement(int []nums1, int []nums2) {
        System.out.println(nums2[nums1[0]]);
        return new int[]{};
    }

    public static void main(String []args) {
        int []nums1 = {4, 1, 2}; int []nums2 = {1, 3, 2, 4};
        System.out.println(nextGreaterElement(nums1, nums2));
    }
}