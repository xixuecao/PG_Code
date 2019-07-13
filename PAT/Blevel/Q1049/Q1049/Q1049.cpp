// Q1049.cpp: 1049. 数列的片段和
// 找规律
// 注意要用double，double的scanf是"%lf"

#include "stdafx.h"
#include <iostream>
using namespace std;

int main() {
	int N;
	double k, sum = 0.0;
	scanf("%d", &N);
	for (int i = 1; i <= N; i++) {
		scanf("%lf", &k);
		sum += k * i * (N - i + 1);
	}
	printf("%.2f", sum);
    return 0;
}

/*
输入样例：
4
0.1 0.2 0.3 0.4
输出样例：
5.00
*/