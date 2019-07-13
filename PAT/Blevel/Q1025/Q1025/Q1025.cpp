// Q1025.cpp: 1025. 反转链表
//

#include "stdafx.h"
#include <algorithm>
using namespace std;

int main() {
	int firId, n, k;
	scanf("%d%d%d", &firId, &n, &k);
	int id[100000], data[100000], next[100000];
	for (int i = 0; i < n; i++) {
		int temp;
		scanf("%d", &temp);
		scanf("%d%d", &data[temp], &next[temp]);
	}
	int size = 0;
	while (firId != -1) {
		id[size++] = firId;
		firId = next[firId];
	}
	for (int i = 0; i < (size - size % k); i += k) {
		reverse(begin(id) + i, begin(id) + i + k);
	}
	for (int i = 0; i < size - 1; i++)
		printf("%05d %d %05d\n", id[i], data[id[i]], id[i + 1]);
	printf("%05d %d -1", id[size - 1], data[id[size - 1]]);
	return 0;
}

/*
输入样例：
00100 6 4
00000 4 99999
00100 1 12309
68237 6 -1
33218 3 00000
99999 5 68237
12309 2 33218
输出样例：
00000 4 33218
33218 3 12309
12309 2 00100
00100 1 99999
99999 5 68237
68237 6 -1
*/