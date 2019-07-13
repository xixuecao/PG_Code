// 3_3_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "Sales_item.h"
#include <vector>
#include <string>
using std::vector;
using std::string;
int main()
{
	/*
	vector<Sales_item> Svec1, Svec2;
	Sales_item item;
	while (std::cin >> item)
	{
		Svec1.push_back(item);
		Svec2.push_back(item);
	}
	// using relational operators is illegal
	
	if (Svec1 > Svec2)
	{
		std::cout << "Svec1 is bigger!" << std::endl;
	}
	
	if (Svec1 == Svec2)
	{
		std::cout << "Svec1 is bigger!" << std::endl;
	}
    std::cout << "Hello World!\n"; 
	
	vector<unsigned> scores(11, 0);
	unsigned grade;
	while (std::cin >> grade)
	{
		if (grade <= 100)
		{
			++scores[grade / 10];
		}
	}
	for (auto i : scores)
	{
		std::cout << i << " ";
	}
	

	// 3.16
	vector<int> v1;
	vector<int> v2(10);
	vector<int> v3(10, 42);
	vector<int> v4{ 10 };
	vector<int> v5{ 10,42 };
	vector<string> v6{ 10 };
	vector<string> v7{ 10, "Hi" };

	vector<vector<int>> iv{ v1,v2,v3,v4,v5 };
	vector<vector<string>> sv{ v6, v7 };
	for (auto v : iv)
	{
		for (auto i : v)
		{
			std::cout << i << " ";
		}
		std::cout << std::endl;
	}
	for (auto v : sv)
	{
		for (auto i : v)
		{
			std::cout << i << " ";
		}
		std::cout << std::endl;
	}
	
	// 3.17
	vector<string> sv;
	string word;
	while (std::cin >> word)
	{
		sv.push_back(word);
	}

	for (auto &s : sv)
	{
		for (auto& c : s)
		{
			c = toupper(c);
		}
		std::cout << s << std::endl;
	}

	*/
	vector<int> v;
	int k;
	while (std::cin >> k)
	{
		v.push_back(k);
	}
	for (auto i : v)
	{
		std::cout << i << " ";
	}
	std::cout << std::endl;

	for (decltype(v.size()) i = 0; i < v.size()-1; i++)
	{
		std::cout << v[i] + v[i + 1] << " ";
	}
	std::cout << std::endl;

	for (decltype(v.size()) i = 0; i < v.size()/2; i++)
	{
		std::cout << v[i] + v[v.size()-1-i] << " ";
	}
	if (v.size()%2 != 0)
	{
		std::cout << v[v.size() / 2];
	}
	std::cout << std::endl;
	
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
