// Q1064.cpp: 1064. 朋友数
// set有序，不重复

#include "stdafx.h"
#include <iostream>
#include <set>
using namespace std;

int cntNum(int k) {
	int cnt = 0;
	while (k != 0) {
		cnt += k % 10;
		k /= 10;
	}
	return cnt;
}

int main()
{
	int N;
	scanf("%d", &N);
	set<int> a;
	for (int i = 0; i < N; i++) {
		int temp;
		scanf("%d", &temp);
		a.insert(cntNum(temp));
	}
	printf("%d\n", a.size());
	for (auto i = a.begin(); i != a.end(); i++) {
		if (i != a.begin()) printf(" ");
		printf("%d", *i);
	}
	return 0;
}

/*
输入样例：
8
123 899 51 998 27 33 36 12
输出样例：
4
3 6 9 26
*/