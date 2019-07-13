// Q1060.cpp: 1060. 爱丁顿数
//

#include "stdafx.h"
#include <iostream>
#include <vector>
using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	vector<int> num(N);
	for (int i = 0; i < N; i++)
		scanf("%d", &num[i]);
	int D = N;
	while (D > 0) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (num[i] > D) {
				cnt++;
			}
		}
		if (cnt >= D) {
			printf("%d\n", D);
			return 0;
		}
		D--;
	}
	printf("%d\n", 0);
    return 0;
}

/*
输入样例：
10
6 7 6 9 3 10 8 2 7 8
输出样例：
6
*/