/*
AFZAL MIAH: 170010026
*/

#include <iostream>
#include <fstream>
#include <sstream>
#include <cmath>
#include "Mbaby.h"

using namespace std;

string Mbaby::decimalToBinary(int decimal){
	string binarystring;
	if(decimal == 0){	//set to empty if 0
		binarystring = ("00000000000000000000000000000000");
	}
	if(decimal > 0){	//positive number
		int shift = 1;
		for(int i=0; i<32; i++){	//loop through 32 bits
			if((shift&decimal)>=1){		//set string to approriate switch
				binarystring = "1"+binarystring;
			}
			else{
				binarystring = "0"+binarystring;
			}
			shift <<= 1;	//shift left
		}
		return binarystring;
	}
	else{			//negative number
		int shift = 1;
		for(int i=0; i<32; i++){		//do as positive number
			if((shift&decimal)>=1){
				binarystring = "1"+binarystring;
			}
			else{
				binarystring = "0"+binarystring;
			}
			shift <<= 1;
		}
		string layer = ("00000000000000000000000000000000");
		for(int i=0;i<32;i++){	//flip to negative binary string
			if(binarystring[i]=='0'){
				layer[i] = '1';
			}
			else{
				layer[i] = '0';
			}
		}
		layer.pop_back();		//add one to end
		layer = layer + "1";
		return layer;
	}
}


int Mbaby::binaryToDecimal(string binarystring){
	string typecheck;
	typecheck = binarystring;
	int num = 0;
	int bitvalue;
	string layer = ("00000000000000000000000000000000");
	if(typecheck[0]=='1'){		//if number is negative, reverse to positive binarystring
		for(int i=0;i<32;i++){	//loop 32 bits
			if(binarystring[i]=='0'){		//set switches as appropriate
				layer[i] = '1';
			}
			else{
				layer[i] = '0';
			}
		}
		layer.pop_back();				//add one to end
		layer = layer + "1";
	}
	if(binarystring[0]=='0'){	//when number is positive
		for(int i=0;i<32;i++){
			if(binarystring[i]=='1'){
				bitvalue = (2^(31-i));
				num+= bitvalue;
			}
		}
		return num;
	}

	else{				//when number is negative
		for(int i=0;i<32;i++){
			if(layer[i]=='1'){
				bitvalue = (2^(31-i));
				num += bitvalue;
			}
		}
		num = num*(-1);		//make negative
		return num;
	}
}

bool Mbaby::getFile(string filename, string* filestore){	//get file
	fstream file;
	file.open(filename.c_str(), ios:: out | ios::in);	//open file whilsts cleaning filestream

	string line;
	int count = 0;
	ifstream linenum(filename);
	while(getline(linenum, line)){	//get number of lines
		count++;
	}
	string line2;
	if(file.is_open()){		//if file exists
		for(int i=0;i<count;i++){	//loop for number of lines
			getline(file, line2);	//set line2 to line read
			filestore[i] = line2;	//add line to filestore
			string temp;		//temp for revesing
			for(int x=filestore->size();x>0;x--){ //reverse back2front to allow for correct intrepretations
				temp += filestore[x-1];		//set temp back to front filestore
			}
			filestore[i] = temp;		//set filestore
		}
		file.close();		//close file
		return true;
	}
	else{
		return false;
	}
}


int Mbaby::OpCode(string binaryline){	//get opcode
	string Op = binaryline.substr(16,3);	//isolate opcode part

	int Opcode = binaryToDecimal(Op);	//convert to decimal opcode
	return Opcode;
}

int Mbaby::OpErand(string binaryline){	//get operand
	string Op = binaryline.substr(27,5);	//isolate operand part

	int Opcode = binaryToDecimal(Op);	//convert to decimal operand
	return Opcode;
}

void Mbaby::write(string writeline){		//write conversion to file
	fstream file;
	file.open("Output.txt", std::ios_base::app); //open file whilst clearing if not empty
	file << writeline;				//write to file
	file.close();
}
