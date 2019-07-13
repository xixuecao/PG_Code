// Q1067.cpp: 1067. 试密码
// 用getline的话，之前要先吸收换行符，可以采取的办法是C++里面的cin.get()，或者C里面的getchar()

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

int main()
{
	string correct;
	int limit, count = 0;
	cin >> correct >> limit;
	cin.get();
	while (count < limit) {
		string temp;
		getline(cin, temp);
		if (temp.compare("#") == 0) {
			return 0;
		} else if (temp.compare(correct) != 0) {
			cout << "Wrong password: " << temp << endl;
			count++;
		} else {
			cout << "Welcome in" << endl;
			return 0;
		}
	}
	cout << "Account locked" << endl;
    return 0;
}

/*
输入样例1：
Correct%pw 3
correct%pw
Correct@PW
whatisthepassword!
Correct%pw
#
输出样例1：
Wrong password: correct%pw
Wrong password: Correct@PW
Wrong password: whatisthepassword!
Account locked
输入样例2：
cool@gplt 3
coolman@gplt
coollady@gplt
cool@gplt
try again
#
输出样例2：
Wrong password: coolman@gplt
Wrong password: coollady@gplt
Welcome in
*/