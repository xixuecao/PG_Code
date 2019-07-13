// 3_2_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>
using std::string;
using std::cin;
using std::cout;
using std::endl;
int main()
{
	/*
	string str("Hello World!!!");
	for (auto i : str)
	{
		cout << i << endl;
	}
	
	string str("Hello World!!!");
	int cnt = 0;
	for (auto i : str)
	{
		if (ispunct(i))
		{
			cnt++;
		}
		
	}
	cout << cnt << " punctuation characters in " << str << endl;
	

	string s("Hello World!!!");
	for (auto &c :s)
	{
		c = toupper(c);
	}
	cout << s << endl;
	
	string s("hello world!!!");
	if (!s.empty())
	{
		s[0] = toupper(s[0]);
	}
	cout << s << endl;
	

	string s("hello world!!!");
	for (decltype(s.size()) idx = 0; idx != s.size() && !isspace(s[idx]); idx++)
	{
		s[idx] = toupper(s[idx]);
	}
	cout << s << endl;
	*/

	const string hexdigits = "0123456789ABCDEF";
	cout << "Enter a series of numbers between 0 and 15" << " separated by spaces. Hit ENTER when finished" << endl;
	string result;
	string::size_type n;
	while (cin >> n)
	{
		if (n < hexdigits.size())
		{
			result += hexdigits[n];
		}
	}
	cout << "Your number is: " << result << endl;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门提示: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
