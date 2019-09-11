// 11_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <map>
#include <set>

using namespace std;

// 11.4
string& trans(string& s) {
	for (int p = 0; p < s.size(); p++)
	{
		if (s[p] >= 'A' && s[p] <= 'Z')
		{
			s[p] -= ('A' - 'a');
		}
		else if (s[p] == ',' || s[p] == '.') {
			s.erase(p, 1);
		}
	}
	return s;
}

int main(int argc, char* argv[])
{

	// 11.3
	cout << "exercise 11.3:" << endl;
	ifstream in1(argv[1]);
	if (!in1)
	{
		cerr << "can't open file!" << endl;
		exit(1);
	}
	set<string> exclude{ "The", "But", "And", "Or", "An", "A", "the", "but", "and", "or", "an", "a" };
	map<string, size_t> word_count1;
	string s1;
	while (in1 >> s1)
	{
		if (exclude.find(s1) == exclude.end())
		{
			word_count1[s1]++;
		}
	}
	for (auto i : word_count1)
	{
		cout << i.first << "   " << i.second << ((i.second > 1) ? " times" : " time") << endl;
	}

	// 11.4
	cout << endl <<  "exercise 11.4:" << endl;
	ifstream in2(argv[2]);
	if (!in2)
	{
		cerr << "can't open file!" << endl;
		exit(1);
	}
	map<string, size_t> word_count2;
	string s2;
	while (in2 >> s2)
	{
		if (exclude.find(trans(s2)) == exclude.end())
		{
			word_count2[trans(s2)]++;
		}
	}
	for (auto i : word_count2)
	{
		cout << i.first << "   " << i.second << ((i.second > 1) ? " times" : " time") << endl;
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
