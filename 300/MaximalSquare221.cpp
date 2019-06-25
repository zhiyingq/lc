#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
	// a dp solution
	int maximalSquare(vector<vector<char> >& matrix) {
        if (matrix.size() == 0 || matrix[0].size() == 0) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
    	int dp[m + 1][n + 1] {}; // initialize the array
        int maxlen {0};
        
        
        for (size_t i = 1; i <= m; i++) {
            for (size_t j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxlen = max(maxlen, dp[i][j]);                    
                }                   
            };            
        };

        
        return maxlen * maxlen;
    }

    
    int maximalSquare(vector<vector<char> >& matrix) {
    	if (matrix.size() == 0 || matrix[0].size() == 0) return 0;
    	int length = 1;
    	size_t i = 0;
    	size_t j = 0;
    	while (i < matrix.size() && j < matrix[0].size()) {
    		if (isSquare(&matrix, i, j, length)) {
        		length++;
        	}
        	else {
        		if (++j == matrix[0].size()) {
        			i++;
        			j = 0;
        		}
        	}
    	}
        return (--length) * length;
    }

    // check whether it's a square, with left upper corner orrdinate <i,j>
    // and with side length of "length"
    bool isSquare(vector<vector<char>>* matrix, size_t i, size_t j, int length) {
    	if (j + length > (*matrix)[0].size() || i + length > (*matrix).size()) return false;
    	for (size_t row = i; row < i + length; row++) {
        	for (size_t col = j; col < j + length; col++) {
        		if ((*matrix)[row][col] == '0') return false;
        	};
        };
        return true;
    }
};

int main() {
	return 0;
}