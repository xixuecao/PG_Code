// Q1058.cpp: 1058. 选择题
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <set>
using namespace std;

int main()
{
	int N, k;
	scanf("%d%d", &N, &k);
	vector<int> score(k), wrong(k);
	vector<set<char>> ans(k);
	for (int i = 0; i < k; i++) {
		int temp, l;
		scanf("%d%d%d", &score[i], &temp ,&l);
		for (int j = 0; j < l; j++) {
			char c;
			scanf(" %c", &c);
			ans[i].insert(c);
		}
	}

	for (int i = 0; i < N; i++) {
		int sum = 0;
		scanf("\n");
		for (int j = 0; j < k; j++) {
			if (j != 0) scanf(" ");
			int temp;
			scanf("(%d", &temp);
			set<char> x;
			for (int m = 0; m < temp; m++) {
				char c;
				scanf(" %c", &c);
				x.insert(c);
			}
			scanf(")");
			if (x == ans[j]) {
				sum += score[j];
			} else {
				wrong[j]++;
			}
		}
		printf("%d\n", sum);
	}
	int maxWrongCnt = 0;
	for (int i = 0; i < k; i++) {
		if (wrong[i] > maxWrongCnt) {
			maxWrongCnt = wrong[i];
		}
	}
	if (maxWrongCnt == 0)
		printf("Too simple");
	else {
		printf("%d", maxWrongCnt);
		for (int i = 0; i < k; i++) {
			if (wrong[i] == maxWrongCnt) {
				printf(" %d", i + 1);
			}
		}
	}
    return 0;
}

/*
输入样例：
3 4
3 4 2 a c
2 5 1 b
5 3 2 b c
1 5 4 a b d e
(2 a c) (2 b d) (2 a c) (3 a b e)
(2 a c) (1 b) (2 a b) (4 a b d e)
(2 b d) (1 e) (2 b c) (4 a b c d)
输出样例：
3
6
5
2 2 3 4
*/