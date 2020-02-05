/*
AFZAL MIAH: 170010026
*/
#include <iostream>
#include "Menu.h";
#include "Mbaby.h";

Menu::Menu(string filename){
	anchor = Mbaby::getFile(filename, filestore);
	int OpCode = 0;
	int OpErand = 0;

	printStore();

	string CI = "00000000000000000000000000000000";
	string PI = "00000000000000000000000000000000";
	string accumulator = filestore[0];
}

void Menu::printStore(){
	for(intC i=0;i<32;i++){ //loop through each line and output
		cout << filestore[i] << "\n";
	}
}


void Menu::runMenu(){
	while(anchor){
		control();//increment
		anchor = fetch();//fetch
		decode();//decode
		anchor = execute();//execute until anchor returns false
	}
}

void Menu::control(){
	cout << "INCREMENT\n";	//increment
	string ci = CI;		//set control instruction
	int ciNum = Mbaby::binaryToDecimal(CI);	//convert to number

	CI = Mbaby::decimalToBinary(ciNum);	//set new control instruction
	cout << ciNum << " >> " << ciNum << "\n"; //output control number.
}

bool Menu::fetch(){
	cout << "FETCH\n";
	int ci = Mbaby::binaryToDecimal(CI);	//set control instruction

	PI = filestore[ci];	//set present instruction
	cout << "PI: " << PI << "\n";	//output present instruction
	return true;
}

void Menu::decode(){
	cout <<"DECODE\n";
	
	OpCode = Mbaby::OpCode(PI);	//set opcode and operand
	OpErand = Mbaby::OpErand(PI);
}

bool Menu::execute(){
	cout << "EXECUTE\n";
	do{
	if(OpCode==0){
		cout << "JMP\n";

		CI = filestore[OpErand]; //set control instruction to operand

		cout << "CI: " << CI << "=" << Mbaby::binaryToDecimal(CI) << "\n";
	}
	if(OpCode==1){
		cout << "JRP\m";
		int ci = Mbaby::binaryToDecimal(CI);	//convert control instruction to decimal
		string operandstring = filestore[OpErand];//set to operand
		int operandnum = Mbaby::binaryToDecimal(operandstring); //set opend
		cout << CI << "\n"; //output control instruction 
		ci += operandnum;//change instruction decimal value
		CI = Mbaby::decimalToBinary(ci); //set to binarystring of new ci
		break;
	}
	if(OpCode==2){
		cout << "LDN\n";
	}
	if(OpCode==3){
		cout << "STO\n";
	}
	if(OpCode==4){
		cout << "NOTHING\n";
	}
	if(OpCode==5){
		cout << "SUB\n";
	}
	if(OpCode==6){
		cout << "CMP\n";
	}
	if(OpCode==7){
		return false;
	}
	}while(OpCode!=7);
	//cout
	return true;
}

int main(){
	Menu* menu = new Menu("babytest.txt");
	menu->runMenu();
}
