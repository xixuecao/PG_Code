// 1_6.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"
#include "Sales_item.h"
#include <iostream>

int main()
{
	// 0-201-78345-X 3 20
	Sales_item total; // hold the next trans
	if (std::cin>>total)
	{
		Sales_item trans;
		while (std::cin>>trans)
		{
			if (total.isbn() == trans.isbn())
				total += trans;
			else
			{
				std::cout << total << std::endl;
				total = trans;
			}
		}
		std::cout << total << std::endl; // last trans
	}
	else
	{
		std::cerr << "No Data ?!" << std::endl;
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
