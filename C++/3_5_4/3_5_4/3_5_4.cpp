// 3_5_4.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int main()
{
	// 3.39
	/*
	string s1, s2;
	cin >> s1 >> s2;
	if (s1 > s2)
	{
		cout << "第一个字符串大于第二个字符串" << endl;
	}
	else if(s1 < s2){
		cout << "第一个字符串大于第二个字符串" << endl;
	}
	else
	{
		cout << "字符串相等" << endl;
	}
	*/
	/*
	char str1[80], str2[80];
	cin >> str1 >> str2;
	auto result = strcmp(str1, str2);
	switch (result)
	{
	case 1:
		cout << "第一个字符串大于第二个字符串" << endl;
		break;
	case -1:
		cout << "第一个字符串小于第二个字符串" << endl;
		break;
	case 0:
		cout << "字符串相等" << endl;
		break;
	default:
		cout << "未定义的结果" << endl;
		break;
	}
	*/
	// 3.40
	char str1[80], str2[80], str[200];
	cin >> str1 >> str2;
	strcpy_s(str, str1);
	strcat_s(str, str2);
	cout << str << endl;
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
