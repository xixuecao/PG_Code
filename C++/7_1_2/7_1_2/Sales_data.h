#pragma once
#ifndef SALES_DATA_H
#define SALES_DATA_H
#include <iostream>
#include <string>
using namespace std;

class Sales_data {
	friend std::istream& operator >> (std::istream&, Sales_data&);
	friend std::ostream& operator << (std::ostream&, const Sales_data&);
	friend bool operator<(const Sales_data&, const Sales_data&);
	friend bool operator==(const Sales_data&, const Sales_data&);

public:
	Sales_data() = default;
	Sales_data(const string &book): bookNo(book){}
	Sales_data(istream& is) { is >> *this; }
public:
	Sales_data& operator += (const Sales_data&);
	string isbn() const { return bookNo; }
	Sales_data& combine(const Sales_data&);
	double avg_price() const;
private:
	string bookNo;
	unsigned units_sold = 0;
	double sellingprice = 0.0;
	double saleprice = 0.0;
	double discount = 0.0;
	double revenue = 0.0;
};

inline bool compareIsbn(const Sales_data& lhs, const Sales_data& rhs) {
	return lhs.isbn() == rhs.isbn();
}

Sales_data operator + (const Sales_data&, const Sales_data&);

inline bool operator==(const Sales_data& lhs, const Sales_data& rhs)
{
	// must be made a friend of Sales_item
	return lhs.units_sold == rhs.units_sold &&
		lhs.revenue == rhs.revenue &&
		lhs.isbn() == rhs.isbn();
}



inline bool operator!=(const Sales_data& lhs, const Sales_data& rhs)
{
	return !(lhs == rhs); // != defined in terms of operator==
}

// assumes that both objects refer to the same ISBN
Sales_data& Sales_data::operator+=(const Sales_data& rhs)
{
	units_sold += rhs.units_sold;
	revenue += rhs.revenue;
	return *this;
}

// assumes that both objects refer to the same ISBN
Sales_data operator+(const Sales_data& lhs, const Sales_data& rhs)
{
	Sales_data ret(lhs);  // copy (|lhs|) into a local object that we'll return
	ret += rhs;           // add in the contents of (|rhs|) 
	return ret;           // return (|ret|) by value
}

std::istream& operator>>(std::istream& in, Sales_data& s)
{
	double price;
	in >> s.bookNo >> s.units_sold >> price;
	// check that the inputs succeeded
	if (in)
		s.revenue = s.units_sold * price;
	else
		s = Sales_data();  // input failed: reset object to default state
	return in;
}

std::ostream& operator<<(std::ostream& out, const Sales_data& s)
{
	out << s.isbn() << " " << s.units_sold << " "
		<< s.revenue << " " << s.avg_price();
	return out;
}


Sales_data& Sales_data::combine(const Sales_data& rhs) {
	units_sold += rhs.units_sold;
	revenue += rhs.revenue;
	return *this;
}

double Sales_data::avg_price() const {
	if (units_sold)
	{
		return revenue / units_sold;
	}
	else
	{
		return 0;
	}
}
#endif // !SALES_DATA_H
