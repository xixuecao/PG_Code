// 10_2_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>

using namespace std;

// 10.9
void elimDups(vector<string>& words) {

	sort(words.begin(), words.end());
	cout << "Sorted words: " << endl;
	for (auto& i : words)
		cout << i << " ";
	cout << endl;

	auto end_unique = unique(words.begin(), words.end());
	cout << "Sorted and Unique words: " << endl;
	for (auto& i : words)
		cout << i << " ";
	cout << endl;

	words.erase(end_unique, words.end());
	cout << "Final Words: " << endl;
	for (auto& i : words)
		cout << i << " ";
	cout << endl;
}

int main(int argc, char *argv[])
{
	// 10.9
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
