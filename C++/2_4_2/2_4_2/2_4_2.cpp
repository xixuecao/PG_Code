﻿// 2_4_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>

int main()
{
	int i;
	const int ic = 10;
	i = ic;                   // (a)合法

	int* p1;
	const int* const p3 = p1;
	//p1 = p3;                // (b)不合法，类型不一致，const int* 不能直接给int*
	//p1 = &ic;               // (c)不合法，类型不一致，const int 类型并不能被int *类型改变
	//p3 = &ic;               // (d)不合法，类型不一致
	int* const p2 = p1;



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
