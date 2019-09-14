// 11_2_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <sstream>
#include <fstream>
#include <map>
#include <set>
#include <list>
#include <string>
#include "Sales_data.h"

using namespace std;

// 11.9
string& trans(string& s) {
	for (int i = 0; i < s.size(); i++)
	{
		if (s[i] >= 'A' && s[i] <= 'Z')
		{
			s[i] -= ('A' - 'a');
		}
		else if (s[i] == ',' || s[i] == '.') {
			s.erase(i, 1);
		}
	}
	return s;
}

// 11.11
bool compareIsbn1(const Sales_data& lhs, const Sales_data& rhs) {
	return lhs.isbn() < rhs.isbn();
}

int main(int argc, char* argv[])
{
	// 11.9
	cout << "exercise 11.9: " << endl;
	ifstream in(argv[1]);
	if (!in)
	{
		cerr << "can't open file" << endl;
		exit(1);
	}

	map<string, list<int>> msl;
	string line;
	string word;
	int linenum = 0;
	while (getline(in, line))
	{
		linenum++;
		istringstream in(line);
		while (in >> word)
		{
			msl[trans(word)].push_back(linenum);
		}
	}
	for (auto i:msl)
	{
		cout << i.first << " line: ";
		for (auto j:i.second)
		{
			cout << j << " ";
		}
		cout << endl;
	}

	// 11.11
	cout << endl <<  "exercise 11.11: " << endl;
	//set<Sales_data, decltype(compareIsbn1)*> ssd(compareIsbn1);
	typedef bool (*pf)(const Sales_data & lhs, const Sales_data & rhs);
	set<Sales_data, pf> ssd(compareIsbn1);

	Sales_data s1("0009", 4, 80);
	Sales_data s2("0000", 7, 70);
	Sales_data s3("0003", 6, 90);
	ssd.insert(s1);
	ssd.insert(s2);
	ssd.insert(s3);
	for (auto i : ssd)
	{
		print(cout, i);
		cout << endl;
	}

	return 0;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
