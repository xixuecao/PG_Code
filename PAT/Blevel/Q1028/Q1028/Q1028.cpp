// Q1028.cpp: 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;
int main() {
	int n;
	cin >> n;
	string name;
	int maxyear = 0, maxmonth = 0, maxday = 0, minyear = 9999, minmonth = 9999, minday = 9999;
	int year, month, day, count = 0;
	string maxname, minname;
	for (int i = 0; i < n; i++) {
		cin >> name;
		scanf("%d/%d/%d", &year, &month, &day);
		if ((year < 2014 || (year == 2014 && month < 9) || (year == 2014 && month == 9 && day <= 6)) && 
			(year > 1814 || (year == 1814 && month > 9) || (year == 1814 && month == 9 && day >= 6))) {
			count++;
			if (year > maxyear || (year == maxyear && month > maxmonth) || (year == maxyear && month == maxmonth && day > maxday)) {
				maxday = day;
				maxmonth = month;
				maxyear = year;
				maxname = name;
			}
			if (year < minyear || (year == minyear && month < minmonth) || (year == minyear && month == minmonth && day < minday)) {
				minday = day;
				minmonth = month;
				minyear = year;
				minname = name;
			}
		}
	}
	cout << count;
	if (count != 0)
		cout << " " << minname << " " << maxname;
	return 0;
}

/*
输入样例：
5
John 2001/05/12
Tom 1814/09/06
Ann 2121/01/30
James 1814/09/05
Steve 1967/11/20
输出样例：
3 Tom John
*/