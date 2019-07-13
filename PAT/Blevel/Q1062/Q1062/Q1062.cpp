// Q1062.cpp: 1062. 最简分数
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int prime(int i, int k) {
	while (i % k != 0) {
		int temp = i % k;
		i = k;
		k = temp;
	}
	return k;
}

int main()
{
	int N1, M1, N2, M2, k;
	scanf("%d/%d%d/%d%d", &N1, &M1, &N2, &M2, &k);
	if (N1 * M2 > N2 * M1) {
		swap(N1, N2);
		swap(M1, M2);
	}
	bool flag = false;
	for (int i = k * N1 / M1 + 1; k * N1 < i * M1 && i * M2 < k * N2 ; i++) {
		if (prime(i, k) == 1) {
			printf("%s%d/%d", flag == true ? " ":"", i, k);
			flag = true;
		}
	}
    return 0;
}

/*
输入样例：
7/18 13/20 12
输出样例：
5/12 7/12
*/