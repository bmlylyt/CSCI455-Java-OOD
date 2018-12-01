// Name: Yuntao Liang
// USC NetID: yuntaoli
// CSCI 455 PA5
// Fall 2018


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in header files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  

struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

/**
 * append a entry at the end of the list
 * @param list the list you are going to insert
 * @param name the key you want to insert
 * @param score the value of the entry
 * @return true if insert successfully, false if the key is
 * already exists
 */
bool append(ListType & list, const std::string & key, int score);

/**
 * insert the entry at the front of the list
 * @param list the list you are going to insert
 * @param name the key of the entry
 * @param score the value of the entry
 * @return true if the key is already exists, otherwise false
 */
bool insertFront(ListType & list, const std::string & key, int score);

/**
 * update the value of the key that already in the list
 * @param list the list you want make the operation
 * @param name the key of the entry you want to update
 * @param score the value of the entry you want to update
 * @return true if update successfully, otherwise false
 */
bool update(ListType & list, const std::string & key, int score);

/**
 * remove the specific element corresponding to given key
 * if the key not exits in list, return false
 * @param list the list you want to make the removal
 * @param name the key of the key-value pair
 * @return true if this pair is removed, otherwise false
 */
bool listRemove(ListType & list, const std::string & key);

/**
 * check if a given key exists in this list
 * @param list the list you want to check
 * @param name the key you want to check
 * @return true if this key is in this list, otherwise false
 */
bool containsKey(ListType & list, const std::string & key);

/**
 * return the number of entry in this list
 * @param list the list you want to check
 * @return the number of entry in a given list
 */
int numOfEntry(ListType & list);

/**
 * check the value corresponding to the given key
 * @param list the list you want to check
 * @param name the key of value you want to get
 * @return the value of given key
 */
int * lookUp(ListType & list, const std::string & name);

/**
 * print all the entry of the given list
 * @param list the list you want to print
 */
void printList(ListType & list);

// keep the following line at the end of the file
#endif