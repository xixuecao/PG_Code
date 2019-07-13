// Q1045.cpp: 1045. 快速排序
//

#include "stdafx.h"
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int num[100000], copy[100000], ans[100000];
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &num[i]);
		copy[i] = num[i];
	}
	sort(copy, copy + N);
	int max = 0, cnt = 0;
	for (int i = 0; i < N; i++) {
		// copy是顺序数组，右边一定是更大的，只要找到左边的最大就行
		if (copy[i] == num[i] && copy[i] > max) {
			ans[cnt++] = copy[i];
		}
		if (num[i] > max) {
			max = num[i];
		}
	}
	printf("%d\n", cnt);
	for (int i = 0; i < cnt; i++) {
		if (i == 0) {
			printf("%d", ans[i]);
		} else {
			printf(" %d", ans[i]);
		}
	}
	printf("\n");
    return 0;
}

/*
输入样例：
5
1 3 2 4 5
输出样例：
3
1 4 5
*/