#include <cstdio>
#include <cstdlib>
#include <vector>
#include <algorithm>

static const void display(std::vector <int> nums) {
  for(std::vector <int>::iterator itr = nums.begin(); itr != nums.end(); ++itr)
    printf("%d ", *itr);
  printf("\n");
}

static const void permutation(std::vector <int> nums, 
                          std::vector <std::vector<int>>& permutations, 
                          int index = 0) {

  if (index == nums.size() - 1) {
    permutations.emplace_back(nums);
    return;
  }

  for(int i = index; i < nums.size(); i++) {

    if (i != index && nums[i] == nums[index])
      continue;

    std::swap(nums[i], nums[index]);
    permutation(nums, permutations, index + 1);

  }
}

static std::vector <std::vector <int>> permute(std::vector <int>& nums) {
  std::vector <std::vector <int>> permutations;
  permutation(nums, permutations);
  return permutations;
}

int main(int argc, char** argv) {
  std::vector <int> nums = {1, 2, 3};
  for(std::vector <int> v : permute(nums))
    display(v);
  return 0;
}
