// Q1055.cpp: 1055. 集体照
//

#include "stdafx.h"
#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct people {
	string name;
	int k;
};

bool compare(struct people a, struct people b) {
	if (a.k == b.k) {
		return a.name < b.name;
	}
	return a.k > b.k;
}

int main()
{
	int N, k;
	scanf("%d%d", &N, &k);
	vector<people> p(N);
	for (int i = 0; i < N; i++)
		cin >> p[i].name >> p[i].k;

	sort(p.begin(), p.end(), compare);
	for (int i = 0; i < N;) {
		string result = "";
		if (i == 0) {
			result += p[i].name;
			i++;
			for (int j = 1; j < N / k + N % k; j++, i++) {
				if (j % 2 == 0) {
					result = result + " " + p[i].name;
				} else {
					result = p[i].name + " " + result;
				}
			}
		} else {
			result += p[i].name;
			i++;
			for (int j = 1; j < N / k; j++, i++) {
				if (j % 2 == 0) {
					result = result + " " + p[i].name;
				} else {
					result = p[i].name + " " + result;
				}
			}
		}
		cout << result << endl;
	}
    return 0;
}

/*
输入样例：
10 3
Tom 188
Mike 170
Eva 168
Tim 160
Joe 190
Ann 168
Bob 175
Nick 186
Amy 160
John 159
输出样例：
Bob Tom Joe Nick
Ann Mike Eva
Tim Amy John
*/