#include <vector>
#include <list>
#include <iostream>
#include <sstream>
#include <ctime>
#include <random>
#include "HashTable.h"

/* Implement mc_dlog in this file */
 
void HashNode::assign(unsigned long key, unsigned long value){
	this->key = key;
	this->value = value;
	this->next = NULL;
}

HashTable::HashTable(){	//constructor, intializes table of size 1
	this->table->reserve(1);
}

HashTable::HashTable(size_t num){	//constructor,takes size of table as argument
	this->num = num;
	this->table = new vector<list<HashNode> >[num];
}

HashTable::~HashTable(){		//deconstructor
	//std:: table*.clear()
}

size_t HashTable::size(){		//return size of hash table
	size_t size;
	size = this->table->size();
	return size;
}

size_t HashTable::hash_function(ulint x){	//hash function
	return (x % num);
}

ulint HashTable::getValue(ulint){		//find and return associated data with key
	int value;

	return value;
}

void HashTable::insert(ulint key,ulint value){	//insert data associated with key
	//HashNode *nodeToAdd = (HashNode*)malloc(sizeof(HashNode));
	//nodeToAdd->assign(key, value);
	//this->table->push_back(

	HashNode nodeToAdd;
	
	ulint term = this->num;
	
	if(!(term < this->table->size())){
		this->table->resize(term+1);
	}

	nodeToAdd.assign(key, value);

	int index = hash_function(key);
	
	list<HashNode> list;
	this->table->push_back(list);

	this->table[index].push_back(nodeToAdd));

}

void HashTable::erase(ulint key){		//remove key and associated data
	int index = hash_function(key);
	ulint num = this->table[index].size();

	list<int> it;

	it = this->table[index].begin();

	for(int i=0; i < num; i++){
		if (this->table[index][it].getkey() = key){
			it = this->table[index].erase(it);
		}
		else{
			++it;
		}
	}

}

void HashTable::rehash(size_t newsize){		//set new size to hash table
	this->table.resize(newsize);

}

