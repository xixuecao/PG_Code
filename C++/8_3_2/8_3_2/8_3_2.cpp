// 8_3_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <fstream>
#include <stdexcept>

using namespace std;

// 8.13
struct PersonInfo {
	string name;
	vector<string> phones;
};
bool valid(const string &s) {
	return true;
}
string format(const string& s) {
	return  s;
}
int main(int argc, char *argv[])
{
	if (argc != 2)
	{
		cerr << "输入文件名" << endl;
		return -1;
	}
	ifstream in(argv[1]);
	if (!in)
	{
		cerr << "无法打开文件" << endl;
		return -1;
	}

	string p, phone;
	vector<PersonInfo> people;
	istringstream record;

	while (getline(in, p))
	{
		PersonInfo info;
		record.clear();
		record.str(p);
		record >> info.name;
		while (record >> phone)
		{
			info.phones.push_back(phone);
		}
		people.push_back(info);
	}

	ostringstream os;
	for (const auto &entry : people)
	{
		ostringstream formatted, badNums;
		for (const auto &nums : entry.phones )
		{
			if (!valid(nums))
			{
				badNums << nums << " ";
			}
			else
			{
				formatted << format(nums) << " ";
			}
		}
		if (badNums.str().empty())
		{
			os << entry.name << " " << formatted.str() << endl;
		}
		else
		{
			cerr << "input error: " << entry.name << " invalid number(s) " << badNums.str() << endl;
		}
	}
	cout << os.str() << endl;
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
