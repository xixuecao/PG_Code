// Q1047.cpp: 1047. 编程团体赛
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int N, id, temp, score, maxId, maxScore = 0;
	scanf("%d", &N);
	int num[1001] = { 0 };
	for (int i = 0; i < N; i++) {
		scanf("%d-%d%d", &id, &temp, &score);
		num[id] += score;
		if (num[id] > maxScore) {
			maxId = id;
			maxScore = num[id];
		}
	}
	printf("%d %d", maxId, maxScore);
    return 0;
}

/*
输入样例：
6
3-10 99
11-5 87
102-1 0
102-3 100
11-9 89
3-2 61
输出样例：
11 176
*/