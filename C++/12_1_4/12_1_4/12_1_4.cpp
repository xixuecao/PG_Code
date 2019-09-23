// 12_1_4.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <memory>
using namespace std;

struct destination {};
struct connection {};

connection connect(destination*){
	cout << "open connect!" << endl;
	return connection();
}
void disconnect(connection) {
	cout << "close connect!" << endl;
}

// 12.14
void f1(destination& d) {
	cout << "no shared_ptr" << endl;
	connection c = connect(&d);
	cout << endl;
}

void end_connection(connection* p) { disconnect(*p); }

void f2(destination& d) {
	cout << "shared_ptr" << endl;
	connection c = connect(&d);
	shared_ptr<connection> p(&c, end_connection);
	cout << endl;
}

// 12.15
void f3(destination& d) {
	cout << "shared_ptr lambda" << endl;
	connection c = connect(&d);
	shared_ptr<connection> p(&c, [](connection* p) {disconnect(*p); });
	cout << endl;
}

int main()
{
	destination d;
	// 12.14
	cout << "exercise 12.14:" << endl;
	f1(d);
	f2(d);

	// 12.15
	cout << endl << "exercise 12.15:" << endl;
	f3(d);
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
