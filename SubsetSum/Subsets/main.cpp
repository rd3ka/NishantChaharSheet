#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

static void display(vector <vector <int>> v) {
    for(auto itr : v) {
        for(vector <int>::iterator it = itr.begin(); it != itr.end(); ++it)
            cout << *it << " ";
        cout << endl;
    }
}

static void doSubset(vector <vector <int>>& subsets, 
                    vector <int>& set,
                    vector <int>& num, 
                    int index = 0) {
    
    subsets.emplace_back(set);

    for(int i = index; i < num.size(); i++) {
        if (index != i && num[i] == num[i - 1]) continue;
        set.emplace_back(num[i]);
        doSubset(subsets, set, num, i + 1);
        set.pop_back();
    }
}

static vector <vector <int>> subset(vector <int> num, int n)  {
    vector <vector <int>> subsets;
    vector <int> sets;
    sort(num.begin(), num.end());
    doSubset(subsets, sets, num);
    return subsets;
}


int main(int argc, char** argv) {
    int n = 3;
    vector <int> nums = {1, 2, 2};
    display(subset(nums, n));
    return 0;
}
