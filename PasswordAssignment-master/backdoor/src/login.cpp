/*
 * Secure Login Form for AC31012 Assignment 1
*/
#include <iostream>
#include "authlib.h"
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
#include <openssl/sha.h>
#include <iomanip>

using namespace std;

// Method for hashing the password entered by user
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

// Main method
int main() {
  bool auth = false;
  
  // Gets input from user (username & password)
  string uName, passEnter, hashPass;
  cout << "Please enter your username: ";
  cin >> uName;
  cout << uName << " please enter your password: ";
  cin >> passEnter;

  hashPass = hashPassword(passEnter);

  // Reads stored usernames & passwords from file
  ifstream inFile;
  string line;
  vector<vector<string>> uNameList;
    
  inFile.open("pwdb.txt");
  if (!inFile) {
    cout << "Unable to open file";
  }
    
  while (inFile >> line) {
    stringstream ssin(line);
    vector<string> temp;
    int i = 0;
    while (ssin.good() && i < 2){
    	string token;
   	 	getline(ssin, token, ':');
   	 	uNameList.push_back(temp);
   	 	uNameList[i].push_back(token);
     	++i;
    }
  }
    
  inFile.close();

  // Checks for match & authenticates if necessary
  int vectorSize = uNameList.size() / 2;
  for (int i = 0; i < vectorSize; i++){
  	if(uNameList[0][i].compare(uName) == 0){
      if (uNameList[1][i].compare(hashPass) == 0) {
        auth = true;
      }
  	}
  }
 
  if (auth) authenticated(uName);
  else rejected(uName);
}
