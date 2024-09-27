#pragma once
#include <string>
#include <vector>

using namespace std;

class fnc_Lib
{
public:
	void writeLine(string outputLine);
	void setup();
	void createKey(string inputLine);
	void theEnd();
	void createPackage(string stSlash);
	bool isSlash(string stSlash);

	string readLine();

	bool isGood, firstPackage;
	long x,y;
	int begin,endOfFile;
	int sizeVector;
	string filePath;

	vector<string> content;
	vector<string> languages;
};
