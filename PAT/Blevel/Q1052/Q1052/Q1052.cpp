// Q1052.cpp: 1052. 卖个萌
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string> prase(string s) {
	int N = s.length();
	vector<string> v;
	int cnt = 0;
	bool flag = false;
	string temp = "";
	for (int i = 0; i < N; i++) {
		if (s[i] == '['){
			flag = true;
			temp = "";
		} else if (s[i] == ']') {
			flag = false;
			v.push_back(temp);
		} else if (flag = true) {
			temp += s.at(i);
		}
	}
	return v;
}

int main() {
	string str;
	getline(cin, str);
	vector<string> hand = prase(str);
	getline(cin, str);
	vector<string> eye = prase(str);
	getline(cin, str);
	vector<string> face = prase(str);
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int a, b, c, d, e;
		scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
		if (a > hand.size() || b > eye.size() || c > face.size() || d > eye.size() || e > hand.size() || a < 1 || b < 1 || c < 1 || d < 1 || e < 1) {
			cout << "Are you kidding me? @\\/@" << endl;
			continue;
		}
		cout << hand[a - 1] << "(" << eye[b - 1] << face[c - 1] << eye[d - 1] << ")" << hand[e - 1] << endl;
	}
    return 0;
}

/*
输入样例：
[╮][╭][o][~\][/~]  [<][>]
[╯][╰][^][-][=][>][<][@][⊙]
[Д][▽][_][ε][^]  ...
4
1 1 2 2 2
6 8 1 5 5
3 3 4 3 3
2 10 3 9 3
输出样例：
╮(╯▽╰)╭
<(@Д=)/~
o(^ε^)o
Are you kidding me? @\/@
*/