// Q1068.cpp: 1068. 万绿丛中一点红
//

#include "stdafx.h"
#include <cstdio>
#include <vector>
#include <math.h>
#include <map>
using namespace std;

int M, N, TOL;
vector<vector<int>> num;
int dir[8][2] = { { -1, -1 },{ -1, 0 },{ -1, 1 },{ 0, 1 },{ 1, 1 },{ 1, 0 },{ 1, -1 },{ 0, -1 } };

bool junge(int i, int j) {
	for (int k = 0; k < 8; k++) {
		int tx = i + dir[k][0];
		int ty = j + dir[k][1];
		if (tx >= 0 && tx < N && ty >= 0 && ty < M && abs(num[i][j] - num[tx][ty]) <= TOL) return false;
	}
	return true;
}
int main()
{
	
	scanf("%d%d%d", &M, &N, &TOL);
	num.resize(N, vector<int>(M));
	map<int, int> map;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &num[i][j]);
			map[num[i][j]]++;
		}
	}
	int count = 0;
	int x, y;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (junge(i, j) && map[num[i][j]] == 1)
			{
				count++;
				x = i + 1;
				y = j + 1;
			}
		}
	}
	if (count == 1) {
		printf("(%d, %d): %d", y, x, num[x - 1][y - 1]);
	} else if (count == 0) {
		printf("Not Exist");
	} else {
		printf("Not Unique");
	}
    return 0;
}

/*
输入样例1：
8 6 200
0 	     0 	      0 	   0	    0 	     0 	      0        0
65280 	 65280    65280    16711479 65280    65280    65280    65280
16711479 65280    65280    65280    16711680 65280    65280    65280
65280 	 65280    65280    65280    65280    65280    165280   165280
65280 	 65280 	  16777015 65280    65280    165280   65480    165280
16777215 16777215 16777215 16777215 16777215 16777215 16777215 16777215
输出样例1：
(5, 3): 16711680
输入样例2：
4 5 2
0 0 0 0
0 0 3 0
0 0 0 0
0 5 0 0
0 0 0 0
输出样例2：
Not Unique
输入样例3：
3 3 5
1 2 3
3 4 5
5 6 7
输出样例3：
Not Exist
*/