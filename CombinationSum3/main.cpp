#include <iostream>
#include <vector>
#include <numeric>
using namespace std;

static const void display(vector <vector <int>> combinations) {
    for(auto combination : combinations) {
        for(vector <int>::iterator itr = combination.begin(); itr != combination.end(); ++itr)
            cout << *itr << " ";
        cout << endl;
    }
}

static const void display(vector <int> v) {
    for(vector <int>::iterator itr = v.begin(); itr != v.end(); ++itr)
        cout << *itr << " ";
    cout << endl;
}

static const void doCombinationSum3(vector <int>& sample_space,
                                    vector <vector <int>>& combinations, 
                                    vector <int> aux,
                                    int k,
                                    int n,
                                    int index = 0) {
  if (n == 0 && k == 0) {
      combinations.emplace_back(aux);
    return;
  }
  
    for(int i = index; i < sample_space.size(); i++) {
      if (sample_space[i] <= n) {
        aux.emplace_back(sample_space[i]);
        doCombinationSum3(sample_space, combinations, aux, k - 1, n - sample_space[i], i + 1);
        aux.pop_back();
      }
    }
}

static vector <vector <int>> combinationSum3(int k, int n) {
    vector <vector <int>> combinations;
    /* preparing sample space */
    vector <int> sample_space(9);
    vector <int> aux;
    iota(sample_space.begin(), sample_space.end(), 1);
    /* sample space preparation ends here */
    doCombinationSum3(sample_space, combinations, aux, k, n);
    return combinations;
}

int main(int arg, char** argv) {
    int k = 3;
    int n = 7;
    display(combinationSum3(k, n));
    return 0;
}
