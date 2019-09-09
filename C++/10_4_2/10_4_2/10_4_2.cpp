// 10_4_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <numeric>
#include "Sales_data.h"

using namespace std;

bool compareIsbn1(const Sales_data &lhs, const Sales_data& rhs) {
	return lhs.isbn() < rhs.isbn();
}

int main(int argc, char* argv[])
{
	// 10.29 *********************************************************************
	cout << "exercise 10.29: " << endl;
	ifstream in(argv[1]);
	if (!in)
	{
		cerr << "can't open file!" << endl;
		exit(0);
	}

	vector<string> vs;
	
	istream_iterator<string> str(in), eofs;
	vs.push_back(*str++);
	while (str!=eofs)
	{
		vs.push_back(*str++);
	}
	for (auto i : vs)
		cout << i << " ";
	cout << endl;

	// 10.30 *********************************************************************
	// 12 3 7 5 4 5 9 ^Z
	cout << endl << "exercise 10.30: " << endl;
	vector<int> vi;
	istream_iterator<int> iter(cin), eofi;

	vi.push_back(*iter++);
	while (iter != eofi)
	{
		vi.push_back(*iter++);
	}
	sort(vi.begin(), vi.end());
	ostream_iterator<int> outer(cout, " ");
	copy(vi.begin(), vi.end(), outer);
	cout << endl;

	// 10.31 *********************************************************************
	cout << endl << "exercise 10.31: " << endl;
	unique_copy(vi.begin(), vi.end(), outer);
	cout << endl;

	// 10.32 *********************************************************************
	cout <<  endl << "exercise 10.32: " << endl;
	ifstream insd(argv[2]);
	if (!insd)
	{
		cerr << "can't open file!" << endl;
		exit(0);
	}
	vector<Sales_data> vsd;
	Sales_data sd;
	while (insd >> sd)
	{
		vsd.push_back(sd);
	}
	sort(vsd.begin(), vsd.end(), compareIsbn1);
	
	auto l = vsd.begin();
	while (l != vsd.end())
	{
		auto item = *l;
		auto r = find_if(l + 1, vsd.end(), [item](const Sales_data& item1) {return item.isbn() != item1.isbn(); });
		cout << accumulate(l + 1, r, item) << endl;
		l = r;
	}

	// 10.33 *********************************************************************
	cout << endl << "exercise 10.31: " << endl;
	if (argc != 6)
	{
		cout << "file nums error!" << endl;
		return -1;
	}
	ifstream fin(argv[3]);
	if (!fin)
	{
		cerr << "can't open input file!" << endl;
		exit(1);
	}
	ofstream fout1(argv[4]);
	if (!fout1)
	{
		cerr << "can't open output file1!" << endl;
		exit(1);
	}
	ofstream fout2(argv[5]);
	if (!fout2)
	{
		cerr << "can't open output file2!" << endl;
		exit(1);
	}
	istream_iterator<int> fiter(fin), eof;
	ostream_iterator<int> outer1(fout1, " ");
	ostream_iterator<int> outer2(fout2, "\n");
	while (fiter != eof)
	{
		if (*fiter % 2 != 0)
		{
			*outer1++ = *fiter++;
		}
		else
		{
			*outer2++ = *fiter++;
		}
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
