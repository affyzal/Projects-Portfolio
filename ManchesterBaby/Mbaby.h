/*
Manchester Baby
AFZAL MIAH: 170010026
*/

#include <iostream>
#include <vector>
#include <array>

#ifndef _MBABY_H
#define _MBABY_H

using namespace std;

class Mbaby{
	public:
		//static int binarystring[32], num, it;
		//convertion functions
		static string decimalToBinary(int decimal);//
		static int binaryToDecimal(string binarystring);//

		//getters for binary parts
		static bool getFile(string file, string* store);//
		static int OpCode(string binarystring);//
		static int OpErand(string binarystring);//

		//file functions
		static void write(string writeline);//
};

#endif
