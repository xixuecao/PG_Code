// Q1015.cpp: 1015. 德才论
//
/*
德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；
才分不到但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；
德才分均低于H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；
其他达到最低线L的考生也按总分排序，但排在第三类考生之后。
*/
#include "stdafx.h"
#include <vector>
#include <algorithm>
#include <iostream>
#include <cstdio>
using namespace std;

struct people {
	int type;
	int id;
	int dnum;
	int cnum;
};
int compare(struct people a, struct people b) {
	if (a.type == b.type) {
		if ((a.dnum + a.cnum) == (b.dnum + b.cnum))
		{
			if (a.dnum == b.dnum)
			{
				return b.id > a.id;
			}
			return a.dnum > b.dnum;
		}
		return (a.dnum + a.cnum) > (b.dnum + b.cnum);
	}
	return b.type > a.type;
}
int main()
{
	int n, low, high;
	scanf("%d %d %d", &n, &low, &high);
	vector<people> list;
	people temp;
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d %d", &temp.id, &temp.dnum, &temp.cnum);
		if (temp.dnum >= low && temp.cnum >= low) {
			if (temp.dnum >= high && temp.cnum >= high) {
				temp.type = 1;
			}
			else if (temp.dnum >= high && temp.cnum < high) {
				temp.type = 2;
			}
			else if (temp.dnum < high && temp.cnum < high && temp.dnum >= temp.cnum) {
				temp.type = 3;
			}
			else {
				temp.type = 4;
			}
			list.push_back(temp);
		}
	}
	sort(list.begin(), list.end(), compare);
	printf("%d\n", list.size());
	for (int i = 0; i < list.size(); i++)
	{
		printf("%d %d %d\n", list[i].id, list[i].dnum, list[i].cnum);
	}
    return 0;
}

/*
输入样例：
14 60 80
10000001 64 90
10000002 90 60
10000011 85 80
10000003 85 80
10000004 80 85
10000005 82 77
10000006 83 76
10000007 90 78
10000008 75 79
10000009 59 90
10000010 88 45
10000012 80 100
10000013 90 99
10000014 66 60
输出样例：
12
10000013 90 99
10000012 80 100
10000003 85 80
10000011 85 80
10000004 80 85
10000007 90 78
10000006 83 76
10000005 82 77
10000002 90 60
10000014 66 60
10000008 75 79
10000001 64 90
*/