// Q1066.cpp: 1066. 图像过滤
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int M, N, low, high, exch;
	scanf("%d%d%d%d%d", &M, &N, &low, &high, &exch);

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			int temp;
			scanf("%d", &temp);
			if (temp >= low && temp <= high)
				temp = exch;
			if (j == 0) {
				printf("%03d", temp);
			} else {
				printf(" %03d", temp);
			}
		}
		printf("\n");
	}
    return 0;
}

/*
输入样例：
3 5 100 150 0
3 189 254 101 119
150 233 151 99 100
88 123 149 0 255
输出样例：
003 189 254 000 000
000 233 151 099 000
088 000 000 000 255
*/