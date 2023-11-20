#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


static void display(vector <int> v) {
  for(vector <int>::iterator itr = v.begin(); itr != v.end(); ++itr)
      cout << *itr << " ";
  cout << endl;
}

static void doSolveSubsetSum(vector <int>& nums, int sum, vector <int>& subset_sums, int index) {
  if (index == nums.size()) {
    subset_sums.emplace_back(sum);
    return;
  }
  doSolveSubsetSum(nums, sum + nums[index], subset_sums, index + 1); /* element is picked */ 
  doSolveSubsetSum(nums, sum, subset_sums, index + 1); /* element is not picked */
}

static vector <int> solveSubsetSum(int n, vector <int> nums) {
  vector <int> subset_sums;
  doSolveSubsetSum(nums, 0, subset_sums, 0);
  sort(subset_sums.begin(), subset_sums.end());
  return subset_sums;
}

int main(int argc, char** argv) {
  int n = 3;
  vector <int> nums = {3, 1, 2};
  display(solveSubsetSum(n, nums));
  return 0;
}
