// Name: Yuntao Liang
// USC NetID: yuntaoli
// CSCI 455 PA5
// Fall 2018

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*
   
   string sign = "";
   string key = "";
   int value = -1;
   while (true) {
      cout << "cmd>" << endl;
      cin >> sign;
      if (sign == "insert") {
         cin >> key;
         cin >> value;
         grades->insert(key, value);
      } else if (sign == "change") {
         cin >> key;
         cin >> value;
         if (grades->lookup(key) != NULL) {
            int * oldValue = grades->lookup(key);
            *oldValue = value;
         }
      } else if (sign == "lookup") {
         cin >> key;
         int * oldValue = grades->lookup(key);
         if (oldValue != NULL) {
            cout << "Name: " << *(oldValue) << endl;
         }
      } else if (sign == "remove") {
         cin >> key;
         grades->remove(key);
      } else if (sign == "print") {
         grades->printAll();
      } else if (sign == "size") {
         cout << grades->numEntries() << endl;
      } else if (sign == "stats") {
         grades->hashStats(cout);
      } else if (sign == "help") {
         cout << "Insert this name and score in the grade table. If this name was already present, print a message to that effect, and don't do the insert." << endl;
         cout << "change name newscore: Change the score for name. Print an appropriate message if this name isn't present." << endl;
         cout << "lookup name: Lookup the name, and print out his or her score, or a message indicating that student is not in the table." << endl;
         cout << "remove name: Remove this student. If this student wasn't in the grade table, print a message to that effect." << endl;
         cout << "print: Prints out all names and scores in the table." << endl;
         cout << "size: Prints out the number of entries in the table." << endl;
         cout << "stats: Prints out statistics about the hash table at this point." << endl;
         cout << "help: Prints out a brief command summary." << endl;
         cout << "quit: Exits the program." << endl;
      } else if (sign == "quit") {
         break;
      } else {
         cout << "ERROR: invalid command, type 'help' to check the command summary" << endl;
      }
   }

   return 0;
}
