// Q1002.cpp: 1002. A+B for Polynomials
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	int k1, k2;
	float c[1001] = {0};
	scanf("%d", &k1);
	for (int i = 0; i < k1; i++) {
		int t;
		float num;
		scanf("%d%f", &t, &num);
		c[t] += num;
	}
		
	scanf("%d", &k2);
	for (int i = 0; i < k2; i++) {
		int t;
		float num;
		scanf("%d%f", &t, &num);
		c[t] += num;
	}
	int cnt = 0;
	for (int i = 0; i < 1001; i++) {
		if (c[i] != 0) cnt++;
	}
	printf("%d", cnt);
	if (cnt != 0) printf(" ");
	for (int i = 1000; i > -1; i--) {
		if (c[i] != 0 && cnt > 0) {
			printf("%d %.1f", i, c[i]);
			cnt--;
			if (cnt != 0) printf(" ");
		}
	}
    return 0;
}

/*
Sample Input
2 1 2.4 0 3.2
2 2 1.5 1 0.5
Sample Output
3 2 1.5 1 2.9 0 3.2
*/