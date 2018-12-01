// Name: Yuntao Liang
// USC NetID: yuntaoli
// CSCI 455 PA5
// Fall 2018


#include <iostream>

#include <cassert>

#include "listFuncs.h"

#include <string>
using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below
/**
 * print all the entry of the given list
 * @param list the list you want to print
 */
void printList(ListType & list) {
   Node * node = list;
   if (node == NULL) return;
   while (node != NULL) {
      cout << node->key << " " << node->value << endl ;
      node = node->next;
   }

}

/**
 * check if a given key exists in this list
 * @param list the list you want to check
 * @param name the key you want to check
 * @return true if this key is in this list, otherwise false
 */
bool containsKey(ListType & list, const string & key) {
   Node * node = list;
   while (node != NULL) {
      if (node->key == key) {
         return true;
      }
      node = node->next;
   }
   return false;
}

/**
 * append a entry at the end of the list
 * @param list the list you are going to insert
 * @param name the key you want to insert
 * @param score the value of the entry
 * @return true if insert successfully, false if the key is
 * already exists
 */
bool append(ListType & list, const string & key, int score) {
   Node * node = list;
   if (containsKey(list, key)) {
      cout << "the entry you want to insert already exist" << endl;
      return false;
   }
   Node * newNode = new Node(key, score);
   if (node == NULL) {
      list = newNode;
      return true;
   }
   while (node->next != NULL) {
      node = node->next;
   }
   node->next = newNode;
   return true;
}

/**
 * insert the entry at the front of the list
 * @param list the list you are going to insert
 * @param name the key of the entry
 * @param score the value of the entry
 * @return true if the key is already exists, otherwise false
 */
bool insertFront(ListType & list, const std::string & key, int score) {
   Node * node = list;
   Node * newNode = new Node(key, score);
   if (containsKey(list, key)) {
      cout << "the key you want to insert already exist" << endl;
      return false;
   }
   newNode->next = node;
   list = newNode;
   return true;   
}

/**
 * update the value of the key that already in the list
 * @param list the list you want make the operation
 * @param name the key of the entry you want to update
 * @param score the value of the entry you want to update
 * @return true if update successfully, otherwise false
 */
bool update(ListType & list, const std::string & key, int score) {
   Node * node = list;
   if (node == NULL) {
      cout << "the target you want to update not exist in the list" << endl;
      return false;
   }
   while (node != NULL) {
      if (node->key == key) {
         node->value = score;
         return true;
      }
      node = node->next;
   }
   cout << "the target you want to update not exist in the list" << endl;
   return false;
}

/**
 * remove the specific element corresponding to given key
 * if the key not exits in list, return false
 * @param list the list you want to make the removal
 * @param name the key of the key-value pair
 * @return true if this pair is removed, otherwise false
 */
bool listRemove(ListType & list, const std::string & key) {
   Node * node = list;
   if (node == NULL) {
      cout << "the target you want to remove is not in the list" << endl;
      return false;
   }
   if (node->key == key) {
      list = node->next;
      node->next = NULL;
      delete node;
      return true;
   }
   while (node->next != NULL) {
      if (node->next->key == key) {
         Node * temp = node->next;
         node->next = node->next->next;
         temp->next = NULL;
         delete temp;
         return true;
      }
      node = node->next;
   }
   cout << "the target you want to remove is not in the list" << endl;
   return false;
}

/**
 * return the number of entry in this list
 * @param list the list you want to check
 * @return the number of entry in a given list
 */
int numOfEntry(ListType & list) {
   Node * node = list;
   int count = 0;
   if (node == NULL) return count;
   while (node != NULL) {
      count ++;
      node = node->next;
   }
   return count;
}

/**
 * check the value corresponding to the given key
 * @param list the list you want to check
 * @param name the key of value you want to get
 * @return the value of given key
 */
int * lookUp(ListType & list, const std::string & key) {
   Node * node = list;
   while (node != NULL) {
      if (node->key == key) {
         return &(node->value);
      }
      node = node->next;
   }
   return NULL;
   
}