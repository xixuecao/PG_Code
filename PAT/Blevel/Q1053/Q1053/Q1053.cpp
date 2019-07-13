// Q1053.cpp:1053. 住房空置率
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main() {
	int N, D;
	float e;
	scanf("%d%f%d", &N, &e, &D);
	int pz = 0, z = 0;
	for (int i = 0; i < N; i++) {
		int k;
		float temp;
		scanf("%d", &k);
		int cnt = 0;
		for (int j = 0; j < k; j++) {
			scanf("%f", &temp);
			if (temp < e) {
				cnt++;
			}
		}
		if (cnt > k / 2) {
			if (k > D) {
				z++;
			} else {
				pz++;
			}
		}
	}
	printf("%.1f%% %.1f%%", pz * 100.0 / N, z * 100.0 / N);
    return 0;
}

/*
输入样例：
5 0.5 10
6 0.3 0.4 0.5 0.2 0.8 0.6
10 0.0 0.1 0.2 0.3 0.0 0.8 0.6 0.7 0.0 0.5
5 0.4 0.3 0.5 0.1 0.7
11 0.1 0.1 0.1 0.1 0.1 0.1 0.1 0.1 0.1 0.1 0.1
11 2 2 2 1 1 0.1 1 0.1 0.1 0.1 0.1
输出样例：
40.0% 20.0%
（样例解释：第2、3户为“可能空置”，第4户为“空置”，其他户不是空置。）
*/