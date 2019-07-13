// Q1051.cpp: 1051. 复数乘法
//

#include "stdafx.h"
#include <iostream>
#include <math.h>
using namespace std;

int main()
{
	float R1, P1, R2, P2;
	scanf("%f%f%f%f", &R1, &P1, &R2, &P2);
	float A = R1 * cos(P1) * R2 * cos(P2) - R1 * sin(P1) * R2 * sin(P2);
	float B = R1 * sin(P1) * R2 * cos(P2) + R2 * sin(P2) * R1 * cos(P1);
	if (B >= 0) {
		printf("%.2f+%.2fi", A, B);
	} else {
		printf("%.2f%.2fi", A, B);
	}
    return 0;
}

/*
输入样例：
2.3 3.5 5.2 0.4
输出样例：
-8.68-8.23i
*/