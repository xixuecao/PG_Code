// 12_2_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <cstring>
#pragma warning(disable:4996)
using namespace std;


int main()
{
	// 12.23
	const char* c1 = "Hello ";
	const char* c2 = "World";

	char* r = new char[strlen(c1) + strlen(c2) + 1];
	strcpy(r, c1);
	strcat(r, c2);
	cout << r << endl;
    
	string s1 = "hello ";
	string s2 = "world";
	strcpy(r, (s1 + s2).c_str());
	cout << r << endl;

	delete[] r;

	// 12.24
	char c;
	char* r1 = new char[20];
	int l = 0;
	while (cin.get(c))
	{
		if (isspace(c)) break;
		r1[l++] = c;
		if (l == 20) {
			cout << "full" << endl;
			break;
		}
	}
	r1[l] = 0;
	cout << r1 << endl;

	delete[] r1;

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
