#include "fnc_Lib.h"
#include <iostream>
#include <boost/algorithm/string.hpp>
using namespace std;

int main(int argc, const char *argv[]){

	fnc_Lib fnc;

	string name, strInput, defPackName;
	fnc.x = 0;
	fnc.firstPackage = true;

	if(argc < 2) {
 
		cout << "Drag and drop the .csv file into this Window" << endl;
		getline(cin,fnc.filePath);
		boost::erase_all(fnc.filePath, "\"");
	}else{
		fnc.filePath = argv[1];
	}

	cout << "Enter Project name:";
	cin >> name;
	
	fnc.writeLine("<Project name=\"" + name + "\">");

	fnc.setup();


	while(fnc.isGood) {

		strInput = fnc.readLine();

		if(strInput == ""){
			continue;
		}

		if(fnc.isSlash(strInput)){
			continue;
		}

		if(fnc.firstPackage){
			cout << "Couldn´t find Package, please enter Package name" << endl;
			cin >> defPackName;
			fnc.writeLine("\t<Package name=\"" + defPackName + "\">");
			fnc.firstPackage = false;
		}

		fnc.createKey(strInput);
	}
		
	fnc.theEnd();

	cout << "You can now close this Window";
	cin.get();

	return 0;
}
