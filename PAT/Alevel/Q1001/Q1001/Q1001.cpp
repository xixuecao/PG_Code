// Q1001.cpp: 1001. A+B Format
//

#include "stdafx.h"
#include <string>
#include <iostream>
using namespace std;

int main()
{
	int a, b;
	scanf("%d%d", &a, &b);
	string s = to_string(a + b);
	int l = s.length();
	for (int i = 0; i < l; i++) {
		cout << s[i];
		if (s[i] == '-') continue;
		if ((i + 1) % 3 == l % 3 && i != l - 1) cout << ",";
	}
	return 0;
}

/*
Sample Input
-1000000 9
Sample Output
-999,991
*/