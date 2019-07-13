// Q1061.cpp: 1061. 判断题
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int N, M;
	int score[100], right[100];
	scanf("%d%d", &N, &M);
	for (int i = 0; i < M; i++)
		scanf("%d", &score[i]);
	for (int i = 0; i < M; i++)
		scanf("%d", &right[i]);
	for (int i = 0; i < N; i++) {
		int sum = 0;
		for (int j = 0; j < M; j++) {
			int temp;
			scanf("%d", &temp);
			if (temp == right[j]) {
				sum += score[j];
			}
		}
		printf("%d\n", sum);
	}
    return 0;
}

/*
输入样例：
3 6
2 1 3 3 4 5
0 0 1 0 1 1
0 1 1 0 0 1
1 0 1 0 1 0
1 1 0 0 1 1
输出样例：
13
11
12
*/