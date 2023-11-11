import java.util.*;

class main {
  
  static void swap(int []ar, int x, int y) {
    ar[x] ^= ar[y];
    ar[y] ^= ar[x];
    ar[x] ^= ar[y];
  }

  static void reverse(int []ar, int start, int end) {
    while(start < end)
      swap(ar, start++, end--);
  }

  static void rotate_right(int []ar, int k) {
    k %= ar.length;
    int size = ar.length;

    reverse(ar, 0, size - 1);
    reverse(ar, 0, k - 1);
    reverse(ar, k, size - 1);
  }

  public static void main(String []args) {
    int []ar = {-1, -100, 3, 99};
    int k = 2;
    rotate_right(ar, k);
    System.out.println(Arrays.toString(ar));
  }
}
