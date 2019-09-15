// 11_2_3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <utility>
#include <vector>
#include <map>

using namespace std;

// 11.14
void add_family(map<string, vector<pair<string, string>>>& families, const string& family) {
	if (families.find(family) == families.end())
	{
		families[family] = vector<pair<string, string>>();
	}
}
void add_child(map<string, vector<pair<string, string>>>& families, const string& family, const pair<string, string>& child) {
	families[family].push_back(child);
}

int main(int argc, char* argv[])
{
	// 11.12 & 11.13
	cout << "exercise 11.12 & 11.13: " << endl;
	ifstream in1(argv[1]);
	if (!in1)
	{
		cerr << "can't open file!" << endl;
		exit(1);
	}
	vector<pair<string, int>> vp;
	string s;
	int v;
	while (in1 >> s && in1>>v)
	{
		// vp.push_back(pair<string, int>(s, v));
		vp.push_back({ s, v }); // easiest way
		// vp.push_back(make_pair(s, v));
	}
	for (auto i : vp)
	{
		cout << i.first << " " << i.second << endl;
	}
	// 11.14
	cout << endl <<  "exercise 11.14: " << endl;

	map<string, vector<pair<string, string>>> mfa{ {"Lu", {{"Jiajian", "2010/.06/05"}, {"Lu","2006/09/07"}, {"Bo","2005/06/07"}}} };

	mfa["Li"] = { {"Shuai","2018/06/05"},{"hongru" ,"2018/06/03"} };

	add_family(mfa, "张");
	add_child(mfa, "张", make_pair( "强", "2019/08/07" ));
	add_child(mfa, "张", { "刚", "2019/08/07" });
	add_child(mfa, "王", { "五", "2019/08/07" });
	add_family(mfa, "王");

	for (auto i : mfa)
	{
		cout << i.first << ": ";
		for (auto k : i.second)
		{
			cout << k.first << " " << k.second <<  "***/***";
		}
		cout << endl;
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
