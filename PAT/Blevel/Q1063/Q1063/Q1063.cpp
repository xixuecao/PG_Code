// Q1063.cpp: 1063. 计算谱半径
//

#include "stdafx.h"
#include <iostream>
#include <math.h>
using namespace std;

int main()
{
	int N;
	scanf("%d", &N);
	int max = 0;
	for (int i = 0; i < N; i++) {
		int a, b;
		scanf("%d%d", &a, &b);
		int temp = a * a + b * b;
		if (max < temp) {
			max = temp;
		}
	}
	printf("%.2f", sqrt(max));
    return 0;
}

/*
输入样例：
5
0 1
2 0
-1 0
3 3
0 -3
输出样例：
4.24
*/