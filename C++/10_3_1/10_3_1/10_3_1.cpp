// 10_3_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include "Sales_data.h"

using namespace std;

// 10.11
void elimDups(vector<string>& words) {

	sort(words.begin(), words.end());

	auto end_unique = unique(words.begin(), words.end());

	words.erase(end_unique, words.end());

}

bool isShorter(const string& a, const string& b) {
	return a.size() < b.size();
}

// 10.12
inline bool compareIsbn1(const Sales_data& lhs, const Sales_data& rhs) {
	return lhs.isbn() < rhs.isbn();
}

// 10.13
inline bool five_or_more(const string& s) {
	return s.size() >= 5;
}
int main(int argc, char *argv[])
{
	// 10.11
	cout << "exercise 10.11:" << endl;
	ifstream in(argv[1]);
	if (!in)
	{
		cerr << "can't open file" << endl;
		exit(0);
	}
	vector<string> vs;
	string s;
	while (in >> s)
	{
		vs.push_back(s);
	}

	cout << "Words: " << endl;
	for (auto& i : vs)
		cout << i << " ";
	cout << endl;

	elimDups(vs);

	cout << "elimDups Words: " << endl;
	for (auto& i : vs)
		cout << i << " ";
	cout << endl;

	stable_sort(vs.begin(), vs.end(), isShorter);

	cout << "stable_sort Words: " << endl;
	for (auto& i : vs)
		cout << i << " ";
	cout << endl;

	// 10.12
	cout << endl << "exercise 10.12:" << endl;
	ifstream insd(argv[2]);
	if (!insd)
	{
		cerr << "can't open file" << endl;
		exit(0);
	}
	vector<Sales_data> vsd;
	Sales_data sd;
	while (read(insd, sd))
	{
		vsd.push_back(sd);
	}
	sort(vsd.begin(), vsd.end(), compareIsbn1);
	for (auto i : vsd)
	{
		print(cout, i);
		cout << endl;
	}

	// 10.13
	cout << endl << "exercise 10.13:" << endl;
	ifstream inw(argv[3]);
	if (!inw)
	{
		cerr << "can't open file" << endl;
		exit(0);
	}
	vector<string> vw;
	string w;
	while (inw >> w)
	{
		vw.push_back(w);
	}
	cout << "Words: " << endl;
	for (auto& i : vw)
		cout << i << " ";
	cout << endl;

	auto end = partition(vw.begin(), vw.end(), five_or_more);

	cout << "Partition Words: " << endl;
	for (auto i = vw.begin(); i < end; i++)
	{
		cout << *i << " ";
	}
	cout << endl;
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
