// Day015/index.cpp

#include <iostream>
using namespace std;
int main()
{

  cout << "Hello World" << endl;
  cout << "This is Day 15!" << endl;
  cout << "C++14 is great!" << endl;

  for (int i = 0; i <= 5; i++)
  {
    for (int j = 0; j < i; j++)
    {
      cout << "*" << " ";
    }
    cout << endl;
  }

  //Data Types in C++14
  int myNum = 10;               // Integer (whole number)
  float myFloatNum = 5.99;     // Floating point number
  double myDoubleNum = 19.99;  // Double precision floating point number
  char myLetter = 'D';         // Character
  string myString = "Hello";   // String (text)
  bool myBoolean = true;       // Boolean (true or false)
  cout << "Integer: " << myNum << endl;
  cout << "Float: " << myFloatNum << endl;
  cout << "Double: " << myDoubleNum << endl;
  cout << "Character: " << myLetter << endl;
  cout << "String: " << myString << endl;
  cout << "Boolean: " << myBoolean << endl;
  
  //different print statemnts 
  cout << "C++14 supports auto keyword!" << endl;
  auto autoVar = 42; // Compiler infers the type as int
  cout << "Auto variable: " << autoVar << endl;

  //different printing statemnts 
  cout << "Using raw string literals in C++14:" << endl;
  cout << R"(Line 1
  123
Line 2
Line 3)" << endl; 
//input statement
  string name;
  cout << "Enter your name: ";
  getline(cin, name);
  cout << "Hello, " << name << "!" << endl;    

  //different input statement statements
  int age;
  cout << "Enter your age: ";
  cin >> age;
  cout << "You are " << age << " years old." << endl; 

  double radius;
  cout<< "Enter the radius of a circle: ";
  cin >> radius;
  double area = 3.14159 * radius * radius;
  cout << "The area of the circle is: " << area << endl;

  //syntax of loops
  cout << "Counting from 1 to 5 using a for loop:" << endl;
  for (int i = 1; i <= 5; i++) {
    cout << i << " ";
  }
  cout << endl;
  //while loop
  cout << "Counting down from 5 to 1 using a while loop:" << endl
        ;
  int count = 5;
  while (count >= 1) {
    cout << count << " ";
    count--;
  }
  cout << endl; 
  //do while loop
  cout << "Counting from 1 to 5 using a do-while loop:" <<
  endl;
  int num = 1;
  do {
    cout << num << " ";
    num++;
  } while (num <= 5);
  cout << endl;
//if else statement
  int number;
  cout << "Enter an integer: ";
  cin >> number;
  if (number > 0) {
    cout << "You entered a positive number." << endl;
  } else if (number < 0) {
    cout << "You entered a negative number." << endl;
  } else {
    cout << "You entered zero." << endl;
  }
  //if else ladder
  int marks;
  cout << "Enter your marks: ";
  cin >> marks;
  if (marks >= 90) {
    cout << "Grade: A" << endl;
  } else if (marks >= 80) {
    cout << "Grade: B" << endl;
  } else if (marks >= 70) {       
    cout << "Grade: C" << endl;
  } else if (marks >= 60) {
    cout << "Grade: D" << endl;
  } else {
    cout << "Grade: F" << endl;
  }

  //switch case
  int day;
  cout << "Enter a number (1-7) for the day of the week:";
  cin >> day;
    switch (day) {
    case 1:
      cout << "Monday" << endl;
      break; 
    case 2:
      cout << "Tuesday" << endl;
      break;
    case 3:
      cout << "Wednesday" << endl;
      break;
  default:
      cout << "Invalid day number!" << endl;
  }
// functions 
  cout << "The sum of 5 and 10 is: " << (5 + 10) << endl;
  // function syntax
  auto add = [](int a, int b) {
    return a + b;
  };
  cout << "The sum of 7 and 3 is: " << add(7, 3) << endl;

  // function decleration 
  auto multiply = [](int x, int y) {
    return x * y;
  };
  cout << "The product of 4 and 6 is: " << multiply(4, 6) << endl;


 

  //object and class syntax "class class_name {  public: data_members; member_functions; };"
  class Person {
  public:
    string name;
    int age;
    void introduce() {
      cout << "Hello, my name is " << name << " and I am " << age << " years old." << endl;
    }
  };
  //syntax to create object of class "class_name object_name;"
  Person person1;
  person1.name = "Alice";
  person1.age = 30;
  person1.introduce();

  //inheritance syntax "class class_derived : access_specifier base_class"
  class Employee : public Person {
  public:
    string company;
    void work() {
      cout << name << " is working at " << company << "." << endl;
    }
  };
  Employee emp1;
  emp1.name = "Bob";
  emp1.age = 28;
  emp1.company = "TechCorp";
  emp1.introduce();
  emp1.work();

//polymorphism syntax
  class Animal {
  public:
      virtual void sound() {
      cout << "Animal makes a sound" << endl;
    }
  };
  class Dog : public Animal {
  public:
    void sound() override {
      cout << "Dog barks" << endl;
    }
  };
  // Using base class pointer to derived class object
  // syntax "base_class* base_ptr; base_ptr = &derived_object;"
  Animal* animalPtr;
  Dog dog;
  animalPtr = &dog;
  animalPtr->sound(); // Outputs: Dog barks

  // pointer syntax
  int var = 20;   // actual variable declaration
  int* ptr;      // pointer variable declaration
  ptr = &var;    // store address of var in pointer variable
  cout << "Value of var: " << var << endl;
  cout << "Address of var: " << &var << endl;
  cout << "Value stored in ptr: " << ptr << endl;
  cout << "Value pointed to by ptr: " << *ptr << endl;

  //reference syntax
  int original = 50;
  int& ref = original; // ref is a reference to original
  cout << "Original value: " << original << endl;
  cout << "Reference value: " << ref << endl;
  ref = 100; // Modifying ref also modifies original
  cout << "Modified original value: " << original << endl;
  cout << "Modified reference value: " << ref << endl;  
  //modifying original value using reference
  original = 200;
  cout << "After modifying original:" << endl;
  cout << "Original value: " << original << endl;
  cout << "Reference value: " << ref << endl;

  





  return 0;
}
