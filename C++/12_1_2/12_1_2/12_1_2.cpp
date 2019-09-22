// 12_1_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <memory>
using namespace std;

// 12.6
vector<int>* new_vector(void) {
	return new (nothrow) vector<int>;
}

void read_ints(vector<int>* pv) {
	int v;
	while (cin >> v)
	{
		pv->push_back(v);
	}
}

void print_ints(vector<int>* pv) {
	for (const auto &v : *pv)
	{
		cout << v << " ";
	}
	cout << endl;
}

// 12.7
shared_ptr<vector<int>> new_vector1(void) {
	return make_shared<vector<int>>();
}

void read_ints1(shared_ptr<vector<int>> pv) {
	int v;
	while (cin >> v)
	{
		pv->push_back(v);
	}
}

void print_ints1(shared_ptr<vector<int>> pv) {
	for (const auto& v : *pv)
	{
		cout << v << " ";
	}
	cout << endl;
}
int main()
{
	// 12.6
	/*
	cout << "exercise 12.6: " << endl;
	vector<int>* pv = new_vector();
	if (!pv)
	{
		cout << "内存不足" << endl;
		return -1;
	}
	read_ints(pv);
	print_ints(pv);

	delete pv;
	pv = nullptr;
	*/

	// 12.7
	cout << endl <<  "exercise 12.7: " << endl;
	auto spv = new_vector1();
	read_ints1(spv);
	print_ints1(spv);

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
