// 9_5_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
using namespace std;

// 9.47
void find_str1(const string& s, const string & chars) {
	string::size_type pos = 0;
	while ((pos = s.find_first_of(chars, pos)) != string::npos)
	{
		cout << s[pos] << " ";
		pos++;
	}
	cout << endl;
}

void find_str2(const string& s, const string& chars) {
	string::size_type pos = 0;
	while ((pos = s.find_first_not_of(chars, pos)) != string::npos)
	{
		cout << s[pos] << " ";
		pos++;
	}
	cout << endl;
}

// 9.49
void find_longest_word(ifstream& in) {
	string s, word;
	int max = 0;
	while (in >> s)
	{
		if (s.find_first_of("bdfghjklpqty") != string::npos)
		{
			continue;
		}
		if (max < s.size())
		{
			word = s;
			max = s.size();
		}
	}
	cout << "longest word: " << word << endl;
}
int main(int argc, char *argv[])
{
	/*
	string river("luboxihuanhuyan");
	auto pos1 = river.find_first_of("hu", 1);
	auto pos2 = river.find_last_of("hu", 1);
	std::cout << river.size() << " " << pos1 << " " << pos2 << endl; 
	*/

	// 9.47
	cout << "exercise 9.47: " << endl;
	string s = "ab2c3d7R4E6";
	// 两个函数一样原因是我们要求的者字符串刚好只有数字和字母，是互补的，所以将参数反过来即可
	find_str1(s, "0123456789");
	find_str1(s, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
	find_str2(s, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
	find_str2(s, "0123456789");

	// 9.49
	cout << endl << "exercise 9.49: " << endl;
	ifstream in(argv[1]);
	if (!in)
	{
		cerr << "无法打开输入文件" << endl;
		return -1;
	}
	find_longest_word(in);

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
