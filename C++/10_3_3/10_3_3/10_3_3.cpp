// 10_3_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include "Output.h"

using namespace std;
void func3() {
	int v = 42;
	auto f = [v]() mutable {return ++v; };
	v = 0;
	cout << f() << endl;
}

// 10.20
void biggies(vector<string>& words, vector<string>::size_type sz) {
	output(words);
	auto num = count_if(words.begin(), words.end(), [sz](const string& s) {return s.size() >= sz; });
	cout << num << " words of length " << sz << " or longer" << endl;
}

// 10.21
void mutable_lambda() {
	int i = 5;
	auto f = [i]() mutable->bool {if (i > 0) { i--; return false; }else{return true;}};
	for (int j = 0; j < 6; j++)
	{
		cout << f() << " ";
	}
	cout << endl;
}

int main(int argc, char *argv[])
{
	vector<string> vs = { "1","2","3" };
	int sz = 7;
	ostream& os = cout;
	char c = ' ';
	char c1 = 'c';
	char& a = c1;
	auto wc = find_if(vs.begin(), vs.end(), [=](const string& s) {return s.size() >= sz; });
	for_each(vs.begin(), vs.end(), [=, &os](const string& s) {os << s << a; });
	cout << endl;

	func3();

	// 10.20
	cout << endl << "exercise 10.20: " << endl;
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
	biggies(vs1, 6);

	// 10.21
	cout << endl << "exercise 10.21: " << endl;
	mutable_lambda();
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
