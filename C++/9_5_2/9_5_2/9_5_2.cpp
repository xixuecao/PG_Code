// 9_5_2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;


// 9.43
void replace_str1(string &s, const string &oldVal, const string &newVal) {
	if (oldVal.empty())
	{
		return;
	}
	auto beg = s.begin();
	while (beg != s.end())
	{
		auto iter1 = beg;
		auto iter2 = oldVal.begin();
		while (iter2 != oldVal.end() && *iter1 == *iter2)
		{
			iter1++;
			iter2++;
		}
		if (iter2 == oldVal.end())
		{
			beg = s.erase(beg, iter1);
			if (!newVal.empty())
			{
				iter2 = newVal.end();
				do
				{
					iter2--;
					beg = s.insert(beg, *iter2);
				} while (iter2 > newVal.begin());
			}
			beg += newVal.size();
		}
		else
		{
			beg++;
		}
	}
}

// 9.44
void replace_str2(string &s, const string &oldVal, const string &newVal) {
	size_t p = 0;
	while ((p = s.find(oldVal, p)) != string::npos)
	{
		s.replace(p, oldVal.size(), newVal);
		p += newVal.size();
	}
}

// 9.45

void pre_str_suf(string& s, const string& pre, const string& suf) {
	s.insert(s.begin(), 1, ' ');
	s.insert(s.begin(), pre.begin(), pre.end());
	s.append(" ");
	s.append(suf.begin(), suf.end());
}

// 9.46
void pre_str_suf2(string& s, const string& pre, const string& suf) {
	s.insert(0, " ");
	s.insert(0, pre);
	s.insert(s.size(), " ");
	s.insert(s.size(), suf);
}
int main()
{
	string s = "some string", s2 = "some other string";
	string s1 = "some string";
	s.insert(0, s2, 1, s2.size());
	s1.insert(0, s2)  ;
	std::cout << s1 << endl << s << endl;

	// 9.43
	cout << endl << "exercise  9.43" << endl;
	string str1 = "tho thru tho!";
	replace_str1(str1, "thru", "through");
	cout << str1 << endl;

	replace_str1(str1, "tho", "though");
	cout << str1 << endl;

	replace_str1(str1, "through", "");
	cout << str1 << endl;

	// 9.44
	cout << endl << "exercise  9.44" << endl;
	string str2 = "tho thru tho!";
	replace_str2(str2, "thru", "through");
	cout << str2 << endl;

	replace_str2(str2, "tho", "though");
	cout << str2 << endl;

	replace_str2(str2, "through", "");
	cout << str2 << endl;
	
	// 9.45
	cout << endl << "exercise  9.45" << endl;
	string name = "James Bond";
	pre_str_suf(name, "Mr.", "II");
	cout << name << endl;

	// 9.4
	cout << endl << "exercise  9.46" << endl;
	string name2 = "James Bond2";
	pre_str_suf2(name2, "Mr.", "II");
	cout << name2 << endl;
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
