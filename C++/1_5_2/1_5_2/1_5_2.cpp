// 1_5_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"
#include "Sales_item.h"
#include <iostream>

int main()
{
    // eg1 *********************************************************************
	// 0-201-70353-X 4 24.99
	/*
	Sales_item item1, item2;
	std::cin >> item1 >> item2;
	// first check that item1 and item2 represent the same book
	if (item1.isbn() == item2.isbn())
	{
		std::cout << item1 + item2 << std::endl;
		return 0;
	}
	else
	{
		std::cout << "Data must refer to same ISBN" << std::endl;
		return -1; // failure
	}
	*/
	// ex 1.23 and 1.24 *********************************************************************
	Sales_item item1, item2;
	int num = 1;
	if (std::cin>>item1)
	{
		while (std::cin>>item2)
		{
			if (item1.isbn() == item2.isbn())
			{
				num++;
			}
			else
			{
				std::cout << item1.isbn() << " has "<< num <<" records" << std::endl;
				item1 = item2;
				num = 1;
			}
		}
		std::cout << item1.isbn() << " has " << num << " records" << std::endl;
	}
	else
	{
		std::cout << "No data" << std::endl;
		return -1;
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
