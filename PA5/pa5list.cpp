// Name: Yuntao Liang
// USC NetID: yuntaoli
// CS 455 PA5
// Fall 2018

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {

   string sign = "";
   string key = "";
   int value = 0;
   Node * list = NULL;
   while (true) {
      cout << "Please type your command operations in [insert, append, remove, update, number, lookup]" << endl;
      cin >> sign;
      if (sign == "quit"){
         cout << "terminate the program" << endl;
         break;
      } else if (sign == "insert") {
         cout << "Please give out the key" << endl;
         cin >> key;
         cout << "Please give out the value" << endl;
         cin >> value;
         insertFront(list, key, value);
         printList(list);
      } else if (sign == "append") {
         cout << "Please give out the key" << endl;
         cin >> key;
         cout << "Please give out the value" << endl;
         cin >> value;
         append(list, key, value);
         printList(list);
      } else if (sign == "remove") {
         cout << "Please give out the key of entry you want to remove" << endl;
         cin >> key;
         listRemove(list, key);
         printList(list);
      } else if (sign == "update") {
         cout << "Please give out the key of entry you want to update" << endl;
         cin >> key;
         cout << "Please give out the value of entry you want to update" << endl;
         cin >> value;
         update(list, key, value);
         printList(list);
      } else if (sign == "number") {
         cout << "the number of entry in this list is:" << numOfEntry(list) << endl;
      } else if (sign == "lookup") {
         cout << "Please give out the key of entry you want to lookup" << endl;
         cin >> key;
         cout << "the value of entry you want to lookup is:" << * lookUp(list, key) << endl;
      } else {
         cout << "invalid command, try again" << endl;
      }
   }
}
