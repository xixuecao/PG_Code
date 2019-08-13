// 8_3_1.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <stdexcept>
#include <sstream>
#include <vector>
#include <string>

using namespace std;

// 8.9
istream& f(istream& in) {
	string v; // 从8.1.2copy过来要改成string
	while (in >> v, !in.eof())
	{
		if (in.bad())
		{
			throw runtime_error("IO错误");
		}
		if (in.fail())
		{
			cerr << "数据错误，请重试" << endl;
			in.clear();
			in.ignore(100, '\n'); // 消除100个字符对后续的影响，所以忽略
			continue;
		}
		cout << v << endl;
	}
	in.clear();
	return in;
}

struct PersonInfo {
	string name;
	vector<string> phones;
};

int main()
{
	// 8.9
	
	ostringstream msg;
	msg << "C++ Primer 5th" << endl;
	istringstream in(msg.str());
	f(in);
	
	// 8.10

	ifstream fin("data8_10.txt");
	if (!fin)
	{
		cerr << "无法打开文件" << endl;
		return -1;
	}

	vector<string> words;
	string line;
	while (getline(fin, line))
	{
		words.push_back(line);
	}
	fin.close();

	for (auto &i : words)
	{
		istringstream linestr(i);
		string word;
		while (linestr>>word)
		{
			cout << word << " ";
		}
		cout << endl;
	}

	// 8.11
	string p, phone;
	vector<PersonInfo> people;
	istringstream record;

	while (getline(cin, p))
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
