// Q1056.cpp: 1056. 组合数的和
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int N;
	scanf("%d", &N);
	int sum = 0;
	for (int i = 0; i < N; i++) {
		int temp;
		scanf("%d", &temp);
		sum += temp * 11;
	}
	printf("%d\n", sum * (N - 1));
    return 0;
}

/*
输入样例：
3 2 8 5
输出样例：
330
*/