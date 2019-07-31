// 7_1_4.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "Sales_data.h"
#include "Person.h"

int main()
{
	// 7.11
	cout << "exercise 7.11" << endl;
	Sales_data data1;
	Sales_data data2("11111");
	Sales_data data3("11111", 10, 50);
	Sales_data data4(cin);

	// 7.13
	cout << "exercise 7.13" << endl;
	Sales_data total(cin);
	if (cin)
	{
		Sales_data trans(cin);
		while (read(cin,trans)) // 这里必须用read，否则cin指挥读取两次 
		{
			if (total.isbn() == trans.isbn())
			{
				total.combine(trans);
			}
			else
			{
				print(cout, total) << endl;
				total = trans;
			}
		}
		print(cout, total) << endl;
	}
	else
	{
		cerr << "No data?" << endl;
		return  -1;
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
