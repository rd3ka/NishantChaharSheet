import java.util.*;

class main {

  static void swap(int []ar, int x, int y) {
    ar[x] ^= ar[y];
    ar[y] ^= ar[x];
    ar[x] ^= ar[y];
  }

  static void sorted_square(int []ar) {
    int size = ar.length;
    for(int i = size - 1; i >= 0; i--) { 
      if (Math.abs(ar[i]) < Math.abs(ar[0])) 
        swap(ar, 0, i);
      ar[i] *= ar[i];
    }
  }

  public static void main(String []args) {
    int []ar = {-4, -1, 0, 3, 10};
    sorted_square(ar);
    System.out.println(Arrays.toString(ar));
  }
}
