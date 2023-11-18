#include <string>
#include <iostream>
#include <algorithm>
#include <numeric>

static const std::string getPermutation(int n, int k) {
  char nums[n];
  std::iota(nums, nums + n, '1');

  for(int i = 1; i < k; i++)
    std::next_permutation(nums, nums + n);

  return std::string(nums, nums + n);
}

int main(int argc, char** argv) {
    int n,k;
    scanf("%d%d", &n, &k);
    std::cout << getPermutation(n, k) << std::endl;
    return 0;
}
