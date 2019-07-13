// 2_6_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>

int main()
{
	struct Sales_data {
		std::string bookNo;
		unsigned units_sold = 0;
		double revenue = 0;
	};
	// ********************1.51_1
	/*
	Sales_data sale1, sale2;
	double price = 0;
	std::cin >> sale1.bookNo >> sale1.units_sold >> price;
	sale1.revenue = sale1.units_sold * price;
	std::cin >> sale2.bookNo >> sale2.units_sold >> price;
	sale2.revenue = sale2.units_sold * price;
	if (sale1.bookNo == sale2.bookNo) {
		unsigned totalCnt = sale1.units_sold + sale2.units_sold;
		double totalRevenue = sale1.revenue + sale2.revenue;
		std::cout << sale1.bookNo << " " << totalCnt << " " << totalRevenue << " ";
		if (totalCnt != 0)
		{
			std::cout << totalRevenue / totalCnt << std::endl;
		}
		else
		{
			std::cout << "No Sales!" << std::endl;
		}
		return 0;
	}
	else
	{
		std::cerr << "Data must refer to same ISBN" << std::endl;
		return -1;
	}
	*/
	// ********************1.51_2
	/*
	Sales_data sale, total;
	double price = 0;
	if (std::cin >> total.bookNo >> total.units_sold >> price)
	{
		total.revenue = total.units_sold * price;
		while (std::cin >> sale.bookNo >> sale.units_sold >> price)
		{
			sale.revenue = sale.units_sold * price;
			if (total.bookNo == sale.bookNo)
			{
				total.units_sold = total.units_sold + sale.units_sold;
				total.revenue = total.revenue + sale.revenue;
			}
			else
			{
				std::cout << "ISBN must be same!" << std::endl;
				return -1;
			}
		}
		std::cout << total.bookNo << " " << total.units_sold << " " << total.revenue << " ";
		if (total.units_sold != 0)
		{
			std::cout << total.revenue / total.units_sold << std::endl;
		}
		else
		{
			std::cout << "No Sales!" << std::endl;
		}
		return 0;
	}
	else
	{
		std::cout << "No input!" << std::endl;
		return -1;
	}
	*/
	// ********************1.52
	/*
	Sales_data sale1, sale2;
	double price = 0;
	if (std::cin >> sale1.bookNo >> sale1.units_sold >> price)
	{
		int cnt = 1;
		while (std::cin >> sale2.bookNo >> sale2.units_sold >> price)
		{
			if (sale1.bookNo == sale2.bookNo) {
				cnt++;
			}
			else
			{
				std::cout << sale1.bookNo << " " << cnt << std::endl;
				cnt = 1;
				sale1 = sale2;
			}
		}
		std::cout << sale1.bookNo << " " << cnt << std::endl;
	}
	else
	{
		std::cout << "No input!" << std::endl;
		return -1;
	}
	return 0;
	*/
	// ********************1.6
	Sales_data sale1, sale2;
	double price = 0;
	if (std::cin >> sale1.bookNo >> sale1.units_sold >> price)
	{
		sale1.revenue = sale1.units_sold * price;
		while (std::cin >> sale2.bookNo >> sale2.units_sold >> price)
		{
			sale2.revenue = sale2.units_sold * price;
			if (sale1.bookNo == sale2.bookNo) {
				sale1.units_sold = sale1.units_sold + sale2.units_sold;
				sale1.revenue = sale1.revenue + sale2.revenue;
			}
			else
			{
				std::cout << sale1.bookNo << " " << sale1.units_sold << " " << sale1.revenue << " ";
				if (sale1.units_sold != 0)
				{
					std::cout << sale1.revenue / sale1.units_sold << std::endl;
				}
				else
				{
					std::cout << "No book" << std::endl;
				}
				sale1 = sale2;
			}
		}
		std::cout << sale1.bookNo << " " << sale1.units_sold << " " << sale1.revenue << " ";
		if (sale1.units_sold != 0)
		{
			std::cout << sale1.revenue / sale1.units_sold << std::endl;
		}
		else
		{
			std::cout << "No book";
		}
	}
	else
	{
		std::cout << "No input!" << std::endl;
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
