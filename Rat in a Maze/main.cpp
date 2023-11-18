#include <iostream>
#include <vector>

using namespace std;

static bool isSafe(vector <vector <int>> m, 
                    vector <vector <bool>> visit,
                    int row, 
                    int col, 
                    int n) {
        return row >= 0 && col >= 0 &&  row < n && col < n && m[row][col] == 1 && visit[row][col] == false;
}


static void display(vector <string> directions) {
    for(vector <string>::iterator itr = directions.begin(); itr != directions.end(); ++itr) 
        cout << *itr << " ";
    cout << endl;
}


static void doRatMaze(int row, int col, vector <string>& directions, string direction, vector <vector <bool>>& visit, vector <vector <int>> m, int n) {
    if (row == n - 1 && col == n - 1) {
        directions.emplace_back(direction);
        return;
    }

    if (isSafe(m, visit, row, col, n)) {
        visit[row][col] = true;
        doRatMaze(row - 1, col, directions, direction + 'U', visit, m, n);
        doRatMaze(row + 1, col, directions, direction + 'D', visit, m, n);
        doRatMaze(row, col + 1, directions, direction + 'R', visit, m, n);
        doRatMaze(row, col - 1, directions, direction + 'L', visit, m, n);
        visit[row][col] = false;
    }
}

static vector <string> ratMaze(int n, vector <vector <int>> m) {
    vector <vector <bool>> visit(n, vector <bool> (n, false));
    vector <string> directions;
    doRatMaze(0,0,directions, "", visit,m,n);
    return directions;
}

int main(int argc, char** argv) {
    int n = 4;
    vector <vector <int>> m = {  {1, 0, 0, 0}, 
                                 {1, 1, 0, 1},
                                 {1, 1, 0, 0},
                                 {0, 1, 1, 1}    };
    display(ratMaze(n, m));
    return 0;
}