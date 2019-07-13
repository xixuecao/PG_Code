// Q1065.cpp: 1065. 单身狗
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int main() {
	int N;
	int couple[100000] = { -1 };
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int a, b;
		scanf("%d%d", &a, &b);
		couple[a] = b;
		couple[b] = a;
	}
	int M;
	scanf("%d", &M);
	vector<int> list(M), isHere(100000);
	for (int i = 0; i < M; i++) {
		scanf("%d", &list[i]);
		// 如果有对象，就把自己设置为来了：1，至于单身狗没人权，就当空气了：0。
		if (couple[list[i]] != -1) {
			isHere[list[i]] = 1;
		}
	}
	sort(list.begin(), list.end());
	set<int> s;
	string result = "";
	for (int i = 0; i < M; i++) {
		// 检查对象来没来，只需要检查有对象的是不是都来了，单身狗是空气。
		// 因为单身狗没对象couple[单身狗] = 0，所以isHere[couple[单身狗]] = 0
		if (isHere[couple[list[i]]] != 1) {
			s.insert(list[i]);
		}
	}
	printf("%d\n", s.size());
	for (auto i = s.begin(); i != s.end(); i++) {
		if (i == s.begin()) {
			printf("%05d", *i);
		} else {
			printf(" %05d", *i);
		}
	}
    return 0;
}

/*
输入样例：
3
11111 22222
33333 44444
55555 66666
7
55555 44444 10000 88888 22222 11111 23333
输出样例：
5
10000 23333 44444 55555 88888
*/