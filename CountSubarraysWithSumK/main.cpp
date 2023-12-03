#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

static const void display(vector <vector <int>> combinations) {
    for(auto combination : combinations) {
        for(vector <int>::iterator itr = combination.begin(); itr != combination.end(); ++itr)
            cout << *itr << " ";
        cout << endl;
    }
}

static void doSubarrayWithSumK(vector <int>& nums, int n, int k, vector <vector <int>>& state_space, 
                              vector <int>& aux, int index = 0)
                              {
  if (k == 0) {
      state_space.emplace_back(aux);
    return;
  }

  for(int i = index; i < nums.size(); i++) {
    if (nums[i] <= k) {
      aux.emplace_back(nums[i]);
      doSubarrayWithSumK(nums, n, k - nums[i], state_space, aux, i + 1);
      aux.pop_back();
    }
  }
}

static int subarrayWithSumK(vector <int> nums, int n, int k) {
  vector <vector <int>> state_space;
  vector <int> aux;
  sort(nums.begin(), nums.end());
  doSubarrayWithSumK(nums, n, k, state_space, aux);
  display(state_space);
  return state_space.size();
}

int main(int argc, char** argv) {
  int n = 6, k = 3;
  vector <int> nums = {1, 2, 3, 1, 1, 1};
  printf("%d\n", subarrayWithSumK(nums, n, k));
  return 0;
}
