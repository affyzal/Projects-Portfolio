/*
AFZAL MIAH: 170010026
*/
#include <iostream>
#include "Mbaby.h"

#ifndef _MBABYMENU_H
#define _MBABYMENU_H

using namespace std;

class Menu{
	private:
		int OpCode;
		int OpErand;
		string filestore[32];
		string accumulator;
		string CI;
		string PI;
		bool anchor;
	public:
		Menu(string filename);
		void runMenu();
		void control();
		bool fetch();
		void decode();
		bool execute();
		void printStore();
};

#endif
