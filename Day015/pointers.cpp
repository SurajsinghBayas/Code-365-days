#include <iostream>
#include <iomanip>
using namespace std;
int var = 20;   // actual variable declaration
  int* ptr;      // pointer variable declaration
  ptr = &var;    // store address of var in pointer variable
  cout << "Value of var: " << var << endl;
  cout << "Address of var: " << &var << endl;
  cout << "Value stored in ptr: " << ptr << endl;
  cout << "Value pointed to by ptr: " << *ptr << endl;