// Q1048.cpp: 1048. 数字加密
// 这里注意，不只是A短于B在A前面补0，B短于A也要在前面补0

#include "stdafx.h"
#include <string>
#include <iostream>
using namespace std;

int main() {
	string A, B;
	cin >> A >> B;
	int la = A.length();
	int lb = B.length();
	if (la < lb) {
		for (int i = 0; i < lb - la; i++)
			A = "0" + A;
	} else {
		for (int i = 0; i < la - lb; i++)
			B = "0" + B;
	}
	int cnt = 1;
	string s;
	for (int i = B.length() - 1; i > -1; i--) {
		int a = A.at(i) - '0';
		int b = B.at(i) - '0';
		if (cnt++ % 2 != 0) {
			if (a + b % 13 == 10) s = "J" + s;
			else if (a + b % 13 == 11) s = "Q" + s;
			else if (a + b % 13 == 12) s = "K" + s;
			else  s = std::to_string((a + b) % 13) + s;
		} else {
			s = std::to_string((b - a + 10) % 10) + s;
		}
	}
	cout << s;
    return 0;
}

/*
输入样例：
1234567 368782971
输出样例：
3695Q8118
*/