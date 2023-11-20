#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static const void display(vector <vector <int>> subsets) {
  for(auto v : subsets) {
    for(vector <int>::iterator itr = v.begin(); itr != v.end(); ++itr) 
      cout << *itr << " ";
    cout << endl;
  }
}


static void doSolveUniqueSubsets(vector <int>& nums,
                                 vector <vector <int>>& subsets,
                                 vector <int> set,
                                 int index) {
  subsets.emplace_back(set);
  
  for(int i = index; i < nums.size(); i++) {
    if (i != index && nums[i] == nums[i - 1])
      continue;
    set.emplace_back(nums[i]);
    doSolveUniqueSubsets(nums, subsets, set, i + 1);
    /* considering element at index */ 
    set.pop_back(); 
    /* removing that element at index and then considering i.e not considering that element */
  }
}

static vector <vector <int>> unique_subsets(vector <int> nums) {
  vector <vector <int>> subsets;
  vector <int> set;
  sort(nums.begin(), nums.end());
  doSolveUniqueSubsets(nums, subsets, set, 0);
  return subsets;
}

int main(int argc, char** argv) {
  vector <int> nums = {1, 2, 2};
  display(unique_subsets(nums));
  return 0;
}
