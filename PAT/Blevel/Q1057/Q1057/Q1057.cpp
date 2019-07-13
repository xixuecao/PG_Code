// Q1057.cpp: 1057. 数零壹
//

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

int main()
{
	string input;
	getline(cin, input);
	int N = input.length();
	int sum = 0;
	for (int i = 0; i < N; i++) {
		if (isalpha(input[i])) {
			char l = tolower(input[i]);
			sum += l - 'a' + 1;
		}
	}
	int a = 0, b = 0;
	while (sum != 0) {
		if (sum % 2 == 0)
			a++;
		else
			b++;
		sum /= 2;
	}
	printf("%d %d", a, b);
    return 0;
}

/*
输入样例：
PAT (Basic)
输出样例：
3 4
*/