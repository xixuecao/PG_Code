// Q1070.cpp: 1070. 结绳
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int N;
	scanf("%d", &N);
	vector<int> num(N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &num[i]);
	}
	sort(num.begin(), num.end());
	double sum = (num[0] + num[1]) / 2;
	if (N > 2) {
		for (int i = 2; i < N; i++) {
			sum = (sum + num[i]) / 2;
		}
	}
	printf("%d", (int) sum);
	return 0;
}

/*
输入样例：
8
10 15 12 3 4 13 1 15
输出样例：
14
*/