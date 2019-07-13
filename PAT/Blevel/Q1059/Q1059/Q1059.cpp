// Q1059.cpp: 1059. C语言竞赛
//

#include "stdafx.h"
#include <iostream>
#include <math.h>
using namespace std;

bool isPrime(int k) {
	for (int i = 2; i <= sqrt(k); i++) {
		if (k % i == 0) {
			return false;
		}
	}
	return true;
}

int main()
{
	int N;
	scanf("%d", &N);
	int num[10000] = {0};
	for (int i = 0; i < N; i++) {
		int temp;
		scanf("%d", &temp);
		num[temp] = i + 1;
	}
	int k;
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		int p;
		scanf("%d", &p);
		printf("%04d", p);
		if (num[p] == 0) {
			printf(": Are you kidding?\n");
		} else if (num[p] == -1) {
			printf(": Checked\n");
		} else if (num[p] == 1) {
			printf(": Mystery Award\n");
			num[p] = -1;
		} else if (isPrime(num[p])) {
			printf(": Minion\n");
			num[p] = -1;
		} else {
			printf(": Chocolate\n");
			num[p] = -1;
		}
	}
    return 0;
}

/*
输入样例：
6
1111
6666
8888
1234
5555
0001
6
8888
0001
1111
2222
8888
2222
输出样例：
8888: Minion
0001: Chocolate
1111: Mystery Award
2222: Are you kidding?
8888: Checked
2222: Are you kidding?
*/