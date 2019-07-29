#pragma once
#ifndef PERSON_H
#define PERSON_H
#include <iostream>

class Person {
	friend std::istream& read(std::istream&, Person&);
	friend std::ostream& print(std::ostream&, const Person&);
private:
	string Name;
	string Address;
public:
	string getName() const { return Name; }
	string getAddress() const { return Address; }
};
std::istream& read(std::istream& is, Person& p) {
	is >> p.Name >> p.Address;
	return is;
}
std::ostream& print(std::ostream& os, const Person& p) {
	os << p.getName() << " " << p.getAddress();
	return os;
}

#endif // !PERSON_H