// 10_3_4.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <functional>
#include "Output.h"

using namespace std;
using namespace std::placeholders;

// 10.22
bool check_size1(const string& s, string::size_type sz) {
	return s.size() >= sz;
}
void biggies1(vector<string>& words, vector<string>::size_type sz) {
	output(words);
	auto num = count_if(words.begin(), words.end(), bind(check_size1, _1, sz));
	cout << num << " words of length " << sz << " or longer" << endl;
}

// 10.24
bool check_size2(const string& s, string::size_type sz) {
	return s.size() < sz;
}
void biggies2(vector<int>& vi, const string& s) {
	for (auto i : vi)
		cout << i << " ";
	cout << endl;

	auto num = find_if(vi.begin(), vi.end(), bind(check_size2, s, _1));
	cout <<"The " << num - vi.begin() + 1 << "th number bigger than " << s << endl;
}

// 10.25
void elimDups(vector<string>& s) {
	sort(s.begin(), s.end());
	auto end_unique = unique(s.begin(), s.end());
	s.erase(end_unique, s.end());
}

void biggies3(vector<string>& words, vector<string>::size_type sz) {
	elimDups(words);
	stable_sort(words.begin(), words.end(), [](const string& a, const string& b) {return a.size() < b.size(); });
	auto wc = partition(words.begin(), words.end(), bind(check_size1, _1, sz));
	auto count = wc - words.begin();
	cout << count << " words of length " << sz << " or longer" << endl;
	for_each(words.begin(), wc, [](const string& s) { cout << s << " "; });
	cout << endl;
}
int main(int argc, char* argv[])
{
	// 10.22
	cout << "exercise 10.22: " << endl;
	ifstream in(argv[1]);
	if (!in)
	{
		cerr << "can't open file!" << endl;
		exit(0);
	}
	vector<string> vs1;
	string s;
	while (in >> s)
	{
		vs1.push_back(s);
	}
	biggies1(vs1, 6);

	// 10.24
	cout << endl << "exercise 10.22: " << endl;
	vector<int> vi = { 1,2,3,4,5,6,7,8 };
	biggies2(vi, "Hi");
	biggies2(vi, "LuBo");

	// 10.25
	cout << endl << "exercise 10.25: " << endl;
	biggies3(vs1, 6);
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
