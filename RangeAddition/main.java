import java.util.*;

class main {

    public static int[] getModifiedArray(int length, int updates[][]) {
        int queries = updates.length;
        int nums[] = new int[length + 1];

        while(queries-- > 0) {
            int startIndex = updates[queries][0]; int endIndex = updates[queries][1];
            int value = updates[queries][2];
            
            nums[startIndex] += value;
            nums[endIndex + 1] -= value;
        }

        for(int i = 1; i <= length; i++) nums[i] += nums[i - 1];
        return Arrays.copyOfRange(nums, 0, length);
    }

    public static void main(String args[]) {
        int length = 5;
        int updates[][] = {
            {1, 3, 2},
            {2, 4, 3},
            {0, 2, -2}
        };

        System.out.println(Arrays.toString(getModifiedArray(length, updates)));
    }
}