#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;


static void display(vector <string> chessboard) {
    for(vector<string>::iterator itr = chessboard.begin(); itr != chessboard.end(); ++itr)
        cout << *itr << endl;
}

static void display(vector <vector <string>> state_space) {
    for(auto v : state_space) {
        for(string s : v)
            cout << s << endl;
        cout << endl;
    }
}

static bool isSafe(int row, int col, vector <string> chessboard, int n) {
    /* upper left diagonal */
    for(int r = row, c = col; r >= 0 && c >= 0; r--,c--)
        if (chessboard[r][c] == 'Q') 
            return false;
    /* left direction */
    for(int c = col; c >= 0; c--)
        if (chessboard[row][c] == 'Q')
            return false;
    /* right lower diagonal */
    for(int r = row, c = col; r < n && c >= 0; r++, c--)
        if (chessboard[r][c] == 'Q')
            return false;
    return true;
}

static void doSolveNQueens(int col, vector <string>& chessboard, vector <vector <string>>& state_space, int n) {
    if (col == n) {
        state_space.emplace_back(chessboard);
        return;
    }

    for(int row = 0; row < n; row++) {
        if (isSafe(row, col, chessboard, n)) {
            chessboard[row][col] = 'Q';
            doSolveNQueens(col + 1, chessboard, state_space, n);
            chessboard[row][col] = '.';
        }

    }
}

vector <vector <string>> solveNQueens(int n) {
    vector <vector <string>> state_space;
    
    /* preparing chessboard */
    vector <string> chessboard(n, string(n,'.'));
    /* preparing ends */ 
    doSolveNQueens(0, chessboard, state_space, n);
    return state_space;
}

int main(int argc, char** argv) {
    int n; scanf("%d", &n);
    vector <vector <string>> state_space = solveNQueens(n);
    display(state_space);
    return 0;
}