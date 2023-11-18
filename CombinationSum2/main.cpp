#include <cstdio>
#include <cstdlib>
#include <vector>
#include <algorithm>

static const void display(std::vector <int> nums) {
    for(std::vector <int>::iterator itr = nums.begin(); itr != nums.end(); ++itr) 
        printf("%d ", *itr);
    printf("\n");
}

static void doCombinationSum(std::vector <int> candidates,
                                    std::vector <std::vector <int>>& combinations,
                                    std::vector <int> aux,
                                    int target,
                                    int index = 0) {
        if (target == 0) {
            combinations.emplace_back(aux);
            return;
        }

        for(int i = index; i < candidates.size(); i++) {

            if (i != index && candidates[i] == candidates[index]) 
                continue;

                if (candidates[i] <= target) {
                    aux.emplace_back(candidates[i]);
                    doCombinationSum(candidates, combinations, aux, target - candidates[i], i + 1);
                    aux.pop_back();
                }
        }
    }

std::vector <std::vector <int>> combinationSum2(std::vector <int> candidates, int target) {
    std::vector <std::vector <int>> combinations;
    std::sort(candidates.begin(), candidates.end());
    doCombinationSum(candidates, combinations, {}, target);
    return combinations;    
}

int main(int argc, char** argv) {
    std::vector <int> candidates = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    for(std::vector <int> v : combinationSum2(candidates, target))
        display(v);
    return 0;
}