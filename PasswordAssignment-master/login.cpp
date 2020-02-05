/**
  * Team: lambda68u
  * Date:
  *	
**/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <openssl/sha.h>
#include <sstream>
#include <iomanip>

#include "authlib.h"

using namespace std;

int openFile(vector<string>& userList) {
	string temp;
	ifstream file("pwdb.txt");
	if(file.is_open()) {
		while (getline(file, temp)) {
			cout << temp << endl;
			userList.push_back(temp);
		}
		file.close();
		return 0;
	} else {
		cout << "Input file not found" << endl;
		return 1;
	}
}

string hashPassword(string passEnter) {
	 unsigned char hash[SHA256_DIGEST_LENGTH];
    SHA256_CTX sha256;
    SHA256_Init(&sha256);
    SHA256_Update(&sha256, passEnter.c_str(), passEnter.size());
    SHA256_Final(hash, &sha256);
    stringstream ss;
    for(int i = 0; i < SHA256_DIGEST_LENGTH; i++)
    {
        ss << hex << setw(2) << setfill('0') << (int)hash[i];
    }
    return ss.str();
}

int checkPass(vector<string>& userList, string userEnter, string passHashed) {
	int i = 0;
	bool found = false;
	string tempToFind = userEnter + ":" + passHashed;
	cout << tempToFind << endl;
	while (i < userList.size() & found == false) {
		cout << userList.at(i) << endl;
		if (userList.at(i).compare(tempToFind) == 0) {
			found = true;
			cout << "Found" << endl;
			return 0;
		}
		i++;
	}
	return 1;
}

int main() {
  	bool auth = false;
 	string userEnter;
 	string passEnter;
 	string passHashed;
 	cout << "Please enter your username: ";
 	cin >> userEnter;
 	cout << userEnter << " please enter your password: ";
 	cin >> passEnter;
 	cout << endl;
 	passHashed = hashPassword(passEnter);
 	cout << passHashed << endl;
 	vector<string> userList;
 	if (openFile(userList) != 0) {
 		cout << "Error with file" << endl;
 		return 1;
 	}
 	if (checkPass(userList, userEnter, passHashed) == 0) {
 		auth = true;
 	}

  	if (auth) authenticated(userEnter);
  	else rejected(userEnter);
}

