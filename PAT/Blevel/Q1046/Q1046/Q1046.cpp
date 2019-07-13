// Q1046.cpp:1046. 划拳
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	int a, aNum, b, bNum, aCnt = 0, bCnt = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d%d%d%d", &a, &aNum, &b, &bNum);
		if (aNum != a + b && bNum == a + b) {
			aCnt++;
		} else if (aNum == a + b && bNum != a + b) {
			bCnt++;
		} else {
			continue;
		}
	}
	printf("%d %d", aCnt, bCnt);
    return 0;
}

/*
输入样例：
5
8 10 9 12
5 10 5 10
3 8 5 12
12 18 1 13
4 16 12 15
输出样例：
1 2
*/