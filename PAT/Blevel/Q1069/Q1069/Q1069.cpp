// Q1069.cpp: 1069. 微博转发抽奖
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <map>
using namespace std;

int main()
{
	int N, k, fir;
	scanf("%d%d%d", &N, &k, &fir);
	if (fir > N) {
		printf("Keep going...");
	}
	map<string, int> map;
	for (int i = 1; i <= N; i++) {
		string temp;
		cin >> temp;
		if (map[temp] == 1) fir++;
		if (i == fir && map[temp] == 0) {
			cout << temp << endl;
			map[temp] = 1;
			fir += k;
		}
	}
    return 0;
}

/*
输入样例1：
9 3 2
Imgonnawin!
PickMe
PickMeMeMeee
LookHere
Imgonnawin!
TryAgainAgain
TryAgainAgain
Imgonnawin!
TryAgainAgain
输出样例1：
PickMe
Imgonnawin!
TryAgainAgain
输入样例2：
2 3 5
Imgonnawin!
PickMe
输出样例2：
Keep going...
*/