// Name: Yuntao Liang
// USC NetID: yuntaoli
// CSCI 455 PA5
// Fall 2018

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
   hashSize = HASH_SIZE;
   tableArray = new ListType[hashSize];
   for (int i = 0; i < hashSize; i ++) {
      tableArray[i] = NULL;
   }
}


Table::Table(unsigned int hSize) {
   hashSize = hSize;
   tableArray = new ListType[hashSize];
   for (int i = 0; i < hashSize; i ++) {
      tableArray[i] = NULL;
   }
}


int * Table::lookup(const string &key) {
   ListType & list = tableArray[hashCode(key)];
   return lookUp(list, key);
}

bool Table::remove(const string &key) {
   ListType & list = tableArray[hashCode(key)];
   return listRemove(list, key);
}

bool Table::insert(const string &key, int value) {
   ListType & list = tableArray[hashCode(key)];
   return insertFront(list, key, value);
}

int Table::numEntries() const {
   int count = 0;
   for (int i = 0; i < hashSize; i ++) {
      count += numOfEntry(tableArray[i]);
   }
   return count;
}


void Table::printAll() const {
   for (int i = 0; i < hashSize; i ++) {
      printList(tableArray[i]);
   }
}

void Table::hashStats(ostream &out) const {
   cout << "number of buckets: " << hashSize << endl;
   cout << "number of entries: " << numEntries() << endl;
   cout << "number of non-empty buckets: " << numOfNonEmptyBuckets() << endl;
   cout << "longest chain: " << longestChain() << endl;
}


// add definitions for your private methods here
/**
 * get the number of non-empty buckets in this table
 */
int Table::numOfNonEmptyBuckets() const{
   int count = 0;
   for (int i = 0; i < hashSize; i ++) {
      if (tableArray[i] != NULL) {
         count ++;
      }
   }
   return count;
}
/**
`* get the longest chain in this table
*/
int Table::longestChain() const{
   int longest = 0;
   for (int i = 0; i < hashSize; i ++) {
      if (tableArray[i] != NULL) {
         int curSize = numOfEntry(tableArray[i]);
         if (curSize > longest) {
            longest = curSize;
         }
      }
   }
   return longest;
}