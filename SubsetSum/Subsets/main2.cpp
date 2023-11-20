#include <iostream>
#include <vector>
using namespace std;

static void display(vector <int>& nums) {
    for(vector <int>::iterator itr = nums.begin(); itr != nums.end(); ++itr)
        cout << *itr << " ";
    cout << endl;
}


static void doSubset(vector <int> nums, vector <int> aux, int n, int index) {
    if (index == n) {
        display(aux);
        return;
    }
    aux.emplace_back(nums[index]);
    doSubset(nums, aux, n, index + 1);
    aux.pop_back();
    doSubset(nums, aux, n, index + 1);
}

static void subset(vector <int> nums, int n) {
    vector <int> aux;
    doSubset(nums, aux,  n, 0);
}

int main(int argc, char** argv) {
    vector <int> nums = {1, 2, 3};
    int n = nums.size();
    subset(nums, n);
    return 0;
}