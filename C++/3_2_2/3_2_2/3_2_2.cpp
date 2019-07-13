// 3_2_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>
using std::cin; 
using std::cout; 
using std::endl;
using std::string;
int main()
{
	/*
	string s;
	cin >> s;
    cout << s << endl; 

	string s1, s2;
	cin >> s1 >> s2;
	cout << s1 << s2 << endl;

	string word;
	while (cin >> word)
	{
		cout << word << endl;
	}
	
	string line;
	while (getline(cin, line))
	{
		cout << line << endl;
	}

	string line;
	while (getline(cin, line))
	{
		if (!line.empty())
		{
			cout << line << endl;
		}
	}
	

	string line;
	while (getline(cin, line))
	{
		if (line.size() > 80)
		{
			cout << line << endl;
		}
	}

	string str = "Hello";
	string phrase = "Hello World";
	string slang = "Hiya";
	if (str < phrase)
	{
		cout << "str is less than phrase" << endl;
	}
	if (phrase < slang)
	{
		cout << "phrase is less than slang" << endl;
	}
	
	string s1 = "Hello", s2 = "world\n";
	string s3 = s1 + s2;
	s1 += s2;
	cout << s3 << s1;
	
	string s1 = "Hello", s2 = "world";
	string s3 = s1 + ", " + s2 + "\n";
	cout << s3;
	string s4 = s1 + ", ";
	// string s5 = "hello" + ", "; this one is error 两个冒号字符串不能直接相加
	string s6 = s1 + ", " + "world";
	// string s7 = "hello" + ", " + s2; 前面部分两个冒号字符串不能直接相加
	
	*/

	string s, result;
	while (cin >> s)
	{
		if (!result.size())
		{
			result += s;
		}
		else
		{
			result = result + " " + s;
		}
		
	}
	cout << result << endl;
	return 0;

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
