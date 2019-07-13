// Q1050.cpp: 1050. 螺旋矩阵
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

bool compare(int a, int b) { return a > b; }

int main() {
	int N, m, n;
	scanf("%d", &N);
	int min = N;
	for (int i = N; i >= sqrt(N); i--) {
		for (int j = 0; j <= sqrt(N); j++) {
			if (i * j == N && min > i - j) {
				min = i - j;
				m = i;
				n = j;
			}
		}
	}
	vector<int> a(N);
	for (int i = 0; i < N; i++)
		scanf("%d", &a[i]);
	sort(a.begin(), a.end(), compare);
	vector<vector<int>> data(m, vector<int>(n));
	int size = 0;
	int i = 0, j = 0;
	while (size < N) {
		for (; size < N && j < n && data[i][j] == 0; j++)
			data[i][j] = a[size++];
		i++;
		j--;
		for (; size < N && i < m && data[i][j] == 0; i++)
			data[i][j] = a[size++];
		i--;
		j--;
		for (; size < N && j > -1 && data[i][j] == 0; j--)
			data[i][j] = a[size++];
		i--;
		j++;
		for (; size < N && i > -1 && data[i][j] == 0; i--)
			data[i][j] = a[size++];
		i++;
		j++;
	}
	for (int p = 0; p < m; p++) {
		printf("%d", data[p][0]);
		for (int q = 1; q < n; q++) {
			printf(" %d", data[p][q]);
		}
		printf("\n");
	}
    return 0;
}

/*
输入样例：
12
37 76 20 98 76 42 53 95 60 81 58 93
输出样例：
98 95 93
42 37 81
53 20 76
58 60 76
*/