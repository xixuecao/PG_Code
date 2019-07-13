// 5_6_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <stdexcept>
using namespace std;

int main()
{
	int val1, val2;
	
	// 5.23
	/*
	cin >> val1 >> val2;
	if (val2 == 0)
	{
		cout << "除数为0" << endl;
		return -1;
	}
	cout << "result is: " << val1 / val2 << endl;
	return 0;
	*/

	// 5.24
	/*
	cin >> val1 >> val2;
	if (val2 == 0)
	{
		throw runtime_error("除数不能为0");
	}
	cout << "result is: " << val1 / val2 << endl;
	return 0;
	*/

	// 5.25
	while (cin >> val1 >> val2)
	{
		try
		{
			if (val2 == 0)
			{
				throw runtime_error("除数不能为0");
			}
			cout << "result is: " << val1 / val2 << endl;
		}
		catch (runtime_error err)
		{
			cout << err.what();
			cout << "继续吗？(y/n)?";
			char bl;
			cin >> bl;
			if (bl == 'n' || bl =='N')
			{
				break;
			}
		}
	}
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
