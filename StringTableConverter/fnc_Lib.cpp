#include "fnc_Lib.h"

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

#include <boost/algorithm/string.hpp>


using namespace std;

string readedLine;
ofstream outputFile;

void fnc_Lib::writeLine(string outputLine) {

	outputFile.open("StringTable.xml", ios::app);

	//outputFile.seekp(0,ios::end);
	outputFile << outputLine << endl;

	outputFile.close();
}

void fnc_Lib::createPackage(string stSlash){
	vector<string> packageName;

	boost::split(packageName, stSlash, boost::is_any_of("#"));

	if(firstPackage == false){

		writeLine("\t</Package>");
		writeLine("");
		writeLine("");
	}

	writeLine("\t<Package name=\"" + packageName[1] + "\">");
	
	firstPackage = false;
	packageName.clear();
}

void fnc_Lib::createKey(string inputLine){

	boost::split(content, inputLine, boost::is_any_of(","));

	writeLine("\t\t<Key ID=\"" + content[0] + "\">");
	writeLine("\t\t\t<" + languages[1] + ">" + content[1] + "</" + languages[1] +">");
	writeLine("\t\t\t<" + languages[2] + ">" + content[2] + "</" + languages[2] +">");
	writeLine("\t\t</Key>");
	writeLine("");
	writeLine("");

	content.clear();
}

bool fnc_Lib::isSlash(string stSlash) {

	if(stSlash[0] == '/' && stSlash[1] == '/') {
		if(stSlash[2] == '#') {
			createPackage(stSlash);
			return true;
		}
		return true;
	}
	return false;


}

void fnc_Lib::setup(void) {

	string first = readLine();
	sizeVector = 1;

	for( int i = 0; i < first.size(); i++){
		if( first[i] == ','){
			sizeVector++;
		}
	}

	//cout << sizeVector << endl;
	//content.resize(sizeVector);
	//languages.resize(sizeVector);

	boost::split(languages, first, boost::is_any_of(","));
}


string fnc_Lib::readLine(void) {

	ifstream inputFile;
	inputFile.open(filePath);

	if(!inputFile.good()) {


		cout << "Error while Reading File" << endl;
		isGood = false;
		inputFile.close();

	}

	inputFile.seekg(0, ios::end);
	endOfFile = inputFile.tellg();

	inputFile.seekg(x);
	getline (inputFile, readedLine);

	boost::erase_all(readedLine, " "); //erase all whitespaces in this string
	boost::erase_all(readedLine, "\t"); //erase all tabs in this string
	boost::erase_all(readedLine, "\""); //erase all qoutes in this string

	y = x;
	x = inputFile.tellg();
	isGood = true;
		
	if(x == endOfFile) {
			
		isGood = false;
		cout << "End of File" << endl;
		inputFile.close();
		return readedLine;
		
	}

	return readedLine;
}

void fnc_Lib::theEnd(){
	writeLine("\t</Package>");
	writeLine("</Project>");

	cout << "File sucessfull created" << endl;
}