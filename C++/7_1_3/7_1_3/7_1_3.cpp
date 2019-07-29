// 7_1_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "Sales_data.h" // 7.6修改在此处
#include "Person.h" // 7.9修改在此处

using namespace std;


int main()
{
	/*
	// 7.6
	cout << "exercise 7.6:" << endl;
	Sales_data book1;
	read(cin, book1);
	print(cout, book1);

	// 7.7
	cout << "exercise 7.7:" << endl;
	Sales_data total;
	if (read(cin, total))
	{
		Sales_data trans;
		while (read(cin, trans))
		{
			if (total.isbn() == trans.isbn())
			{
				total = add(total, trans);
			}
			else
			{
				print(cout, total);
				cout << endl;
				total = trans;
			}
		}
		print(cout, total);
		cout << endl;
	}
	else
	{
		cerr << "No data?" << endl;
		return -1;
	}
	*/
	// 7.9
	cout << "exercise 7.9:" << endl;
	Person p;
	read(cin, p);
	print(cout, p);

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
