// 10_3_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include "Sales_data.h"
using namespace std;

// 10.15
void add(int a) {
	auto sum = [a](int b) {return a + b; };
	cout << sum(1) << endl;
}

// 10.16
void elimDups(vector<string> &s) {
	sort(s.begin(), s.end());
	auto end_unique = unique(s.begin(), s.end());
	s.erase(end_unique, s.end());
}
void biggies1(vector<string>& words, vector<string>::size_type sz) {
	elimDups(words);
	stable_sort(words.begin(), words.end(), [](const string& a, const string& b) {return a.size() < b.size(); });
	auto wc = find_if(words.begin(), words.end(), [sz](const string& a) {return a.size() >= sz; });
	auto count = words.end() - wc;
	cout << count << " words of length " << sz << " or longer" << endl;
	for_each(wc, words.end(), [](const string& s) { cout << s << " "; });
	cout << endl;
}

// 10.18
void biggies2(vector<string>& words, vector<string>::size_type sz) {
	elimDups(words);
	stable_sort(words.begin(), words.end(), [](const string& a, const string& b) {return a.size() < b.size(); });
	auto wc = partition(words.begin(), words.end(), [sz](const string& a) {return a.size() >= sz; });
	auto count = wc - words.begin();
	cout << count << " words of length " << sz << " or longer" << endl;
	for_each(words.begin(), wc, [](const string& s) { cout << s << " "; });
	cout << endl;
}

// 10.19
void biggies3(vector<string>& words, vector<string>::size_type sz) {
	elimDups(words);
	stable_sort(words.begin(), words.end(), [](const string& a, const string& b) {return a.size() < b.size(); });
	auto wc = stable_partition(words.begin(), words.end(), [sz](const string& a) {return a.size() >= sz; });
	auto count = wc - words.begin();
	cout << count << " words of length " << sz << " or longer" << endl;
	for_each(words.begin(), wc, [](const string& s) { cout << s << " "; });
	cout << endl;
}

int main(int argc, char *argv[])
{
	// 10.14
	cout << "exercise 10.14: " << endl;
	auto sum = [](int a, int b) {return a + b; };
	cout << sum(1, 1) << endl;
	cout << endl;

	// 10.15
	cout << "exercise 10.15: " << endl;
	add(5);
	cout << endl;

	// 10.16
	cout << "exercise 10.16: " << endl;
	ifstream in(argv[1]);
	if (!in)
	{
		cerr << "can't open file" << endl;
		exit(0);
	}
	vector<string> vs1;
	string s;
	while (in>>s)
	{
		vs1.push_back(s);
	}
	vector<string> vs2 = vs1;
	vector<string> vs3 = vs1;

	biggies1(vs1, 4);
	cout << endl;

	// 10.17
	cout << "exercise 10.17: " << endl;
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
	sort(vsd.begin(), vsd.end(), [](const Sales_data& lhs, const Sales_data& rhs) {return lhs.isbn() < rhs.isbn(); });
	for (auto i : vsd)
	{
		print(cout, i);
		cout << endl;
	}
	cout << endl;

	// 10.18
	cout << "exercise 10.18: " << endl;
	biggies2(vs2, 4);
	cout << endl;

	// 10.19
	cout << "exercise 10.19: " << endl;
	biggies3(vs3, 4);
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
