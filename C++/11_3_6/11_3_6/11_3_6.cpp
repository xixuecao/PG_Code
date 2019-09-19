// 11_3_6.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <map>
#include <stdexcept>

using namespace std;

// 11.33

map<string, string> build_map(ifstream& map_file) {
	map<string, string> trans_map;
	string key;
	string value;
	while (map_file >> key && getline(map_file, value)) {
		if (value.size() > 1)
		{
			trans_map[key] = value.substr(1);
		}
		else
		{
			throw runtime_error("no rule for" + key);
		}
	}
	return trans_map;
}

string transform(string& s, map<string, string>& trans_map) {
	auto iter = trans_map.find(s);
	if (iter != trans_map.end())
	{
		return iter->second;
	}
	else
	{
		return s;
	}
}

void word_trasform(ifstream& map_file, ifstream& input) {
	auto trans_map = build_map(map_file);
	string text;
	while (getline(input, text))
	{
		istringstream stream(text);
		string word;
		bool first = true;
		while (stream >> word)
		{
			if (first)
			{
				first = false;
			}
			else
			{
				cout << " ";
			}
			cout << transform(word, trans_map);
		}
		cout << endl;
	}
}

int main(int argc, char* argv[])
{
	ifstream map_file(argv[1]);
	if (!map_file)
	{
		cerr << "can't open map file" << endl;
		exit(1);
	}
	ifstream input(argv[2]);
	if (!input)
	{
		cerr << "can't open input file" << endl;
		exit(1);
	}
	word_trasform(map_file, input);
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
