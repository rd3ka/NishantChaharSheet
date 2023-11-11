#include <iostream>
#include <algorithm>
#include <vector>

static void display(std::vector <int> num) {
  for(std::vector <int>::iterator itr = num.begin(); itr != num.end(); ++itr)
    printf("%d ", *itr);
  printf("\n");
}

static bool next_permutation(std::vector <int>& data) {

  if (data.size() <= 1) return false; 

  int last = data.size() - 2;
  while(last-- >= 0 ) if (data[last] < data[last + 1]) break; 

  if (last < 0) return false;

  int nextGreater = data.size() - 1;
  for (int i = data.size() - 1; i > last; i--) {

    if (data[i] > data[last]) {
      nextGreater = i;
      break;
    }
  }
  std::swap(data[nextGreater], data[last]);
  std::reverse(data.begin() + last + 1, data.end());
  return true;
}

int main(int argc, char** argv) {
  int num; scanf("%d", &num);
  std::vector <int> ar = {1, 2, 3};
  do {
    display(ar);
  } while(next_permutation(ar));
}
