// 9_2_7.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <list>
using namespace std;

// 9.15
bool equal_vec(vector<int> v1,vector<int> v2) {
	if (v1 == v2)
		return true;
	return false;
}

// 9.16
bool equal_vec_li(vector<int> &v1, list<int> &v2) {
	if (v1.size() != v2.size())
		return false;
	auto lb = v2.begin();
	auto le = v2.end();
	auto vb = v1.begin();
	for (; lb != le; lb++, vb++)
	{
		if (*lb != *vb)
			return false;
	}
	return true;
}

int main()
{
	// 9.15
	cout << "9.15" << endl;
	vector<int> ivec{ 1,2,3,4,5,6,7 };
	vector<int> ivec1{ 1,2,3,4,5,6,7 };
	vector<int> ivec2{ 1,2,3,4,5 };
	vector<int> ivec3{ 1,2,3,4,5,6,8 };
	vector<int> ivec4{ 1,2,3,4,5,7,6 };
	cout << equal_vec(ivec, ivec1) << endl;
	cout << equal_vec(ivec, ivec2) << endl;
	cout << equal_vec(ivec, ivec3) << endl;
	cout << equal_vec(ivec, ivec4) << endl;
	ivec1.push_back(8);
	ivec1.pop_back();
	cout << ivec1.capacity() << " " << ivec1.size() << " " << endl;
	cout << equal_vec(ivec, ivec1) << endl;

	// 9.16
	cout << endl << "9.16" << endl;
	list<int> l1{ 1,2,3,4,5,6,7 };
	list<int> l2{ 1,2,3,4,5 };
	list<int> l3{ 1,2,3,4,5,6,8 };
	list<int> l4{ 1,2,3,4,5,7,6 };
	cout << equal_vec_li(ivec, l1) << endl;
	cout << equal_vec_li(ivec, l2) << endl;
	cout << equal_vec_li(ivec, l3) << endl;
	cout << equal_vec_li(ivec, l4) << endl;
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
