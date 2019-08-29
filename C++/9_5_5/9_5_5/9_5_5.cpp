// 9_5_5.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <string>
#include <stdexcept>
using namespace std;

// 9.51
class date {
	friend ostream& operator<<(ostream&, const date&);
public:
	date() = default;
	date(string& s);

	unsigned y() const { return year; }
	unsigned m() const { return month; }
	unsigned d() const { return day; }
private:
	unsigned year, month, day;
};
const string month_name[] = { "January", "February", "March", "April","May", "June","July","August","September","October","Noverber","December" };
const string month_abbr[] = { "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct", "Nov","Dec" };

const int days[] = { 31,28,31,30,31,30,31,31,30,31,30,31 };

inline int get_month(string& s, int& end_of_month) {
	int i, j;
	for ( i = 0; i < 12; i++)
	{
		for ( j = 0; j < month_abbr[i].size(); j++)
		{
			if (s[j] != month_abbr[i][j])
			{
				break;
			}
		}
		if (j == month_abbr[i].size())
		{
			break;
		}
	}
	if (i == 12)
	{
		throw invalid_argument("Not legal month");
	}
	if (s[j] == ' ')
	{
		end_of_month = j + 1;
		return i + 1;
	}
	for (; j < month_name[i].size(); j++)
	{
		if (s[j] != month_name[i][j])
		{
			break;
		}
	}
	if (j == month_name[i].size() && s[j] == ' ')
	{
		end_of_month = j + 1;
		return i + 1;
	}
	throw invalid_argument("Not legal month");
}
inline int get_day(string& s, int month, int& p) {
	size_t q;
	int day = stoi(s.substr(p), &q);
	if (day < 1||day > days[month])
	{
		throw invalid_argument("Not legal date");
		
	}
	p += q;
	return day;
}
inline int get_year(string& s, int& p) {
	size_t q;
	int year = stoi(s.substr(p), &q);
	if (p + q < s.size())
	{
		throw invalid_argument("Not legal ends");
	}
	return year;
}

date::date(string& s) {
	int p;
	size_t q;
	if ((p = s.find_first_of("0123456789")) == string::npos)
	{
		throw invalid_argument("No numbers");
	}

	if (p > 0) {
		month = get_month(s, p);
		day = get_day(s, month, p);
		if (s[p]!=' '&&s[p]!=',')
		{
			throw invalid_argument("非法间隔符");
		}
		p++;
		year = get_year(s, p);
	}
	else
	{
		month = stoi(s, &q);
		p = q;
		if (month <1 || month >12)
		{
			throw invalid_argument("不是合法月份");
		}
		if (s[p++] != '/')
		{
			throw invalid_argument("非法间隔符");
		}
		day = get_day(s, month,p);
		if (s[p++] != '/')
		{
			throw invalid_argument("非法间隔符");
		}
		year = get_year(s, p);
	}
}

ostream& operator<<(ostream& out, const date& d) {
	out << d.y() << "年" << d.m() << "月" << d.d() << "日" << endl;
	return out;
}
int main()
{
	// 9.50
	cout << "exercise 9.50: " << endl;
	vector<string> vs = { "1", "2", "3","5" };
	vector<string> vf = { "1.25", "2.25", "3.25","5" };
	int sumi = 0;
	float sumf = 0;
	for (auto i : vs) {
		sumi += stoi(i);
	}
	cout << sumi << endl;
	for (auto i : vf) {
		sumf += stof(i);
	}
	cout << sumf << endl;
	
	// 9.51
	cout << endl << "exercise 9.51: " << endl;
	string dates[] = { "Jan 1,2014", "February 1 2014","3/1/2014","3 1 2014" };
	try
	{
		for (auto i : dates)
		{
			date dl(i);
			cout << dl;
		}
	}
	catch (invalid_argument e)
	{
		cout << e.what() << endl;
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
