// Q1054.cpp: 1054. 求平均值
// 本题用java抛出异常更方便

#include "stdafx.h"
#include <iostream>
#include <cstdio>
#include <string.h>
using namespace std;
int main() {
	int n, cnt = 0;
	char a[50], b[50];
	double temp, sum = 0.0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		scanf("%s", a);
		sscanf(a, "%lf", &temp);
		sprintf(b, "%.2lf", temp);
		int flag = 0;
		for (int j = 0; j < strlen(a); j++) {
			if (a[j] != b[j]) flag = 1;
		}
		if (flag || temp < -1000 || temp > 1000) {
			printf("ERROR: %s is not a legal number\n", a);
			continue;
		}
		else {
			sum += temp;
			cnt++;
		}
	}
	if (cnt == 1) {
		printf("The average of 1 number is %.2lf", sum);
	}
	else if (cnt > 1) {
		printf("The average of %d numbers is %.2lf", cnt, sum / cnt);
	}
	else {
		printf("The average of 0 numbers is Undefined");
	}
	return 0;
}

/*
输入样例1：
7
5 -3.2 aaa 9999 2.3.4 7.123 2.35
输出样例1：
ERROR: aaa is not a legal number
ERROR: 9999 is not a legal number
ERROR: 2.3.4 is not a legal number
ERROR: 7.123 is not a legal number
The average of 3 numbers is 1.38
输入样例2：
2
aaa -9999
输出样例2：
ERROR: aaa is not a legal number
ERROR: -9999 is not a legal number
The average of 0 numbers is Undefined
*/