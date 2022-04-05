#include <bits/stdc++.h>
using namespace std;

void printSpaces(int id){
    for(int j=0; j<id ;j++) cout<<" ";
}

int main(){
    int id=0;
    string l;
    cin>>l;
    int i=0;
    while(i<l.size()){
        if (l[i]=='{'){
            if(l[i+1]=='}'){
                cout<<"{\n";
                printSpaces(id);
                cout<<"}";
                i+=2;
            }
            else{
                cout<<'{'<<endl;
                id+=2;
                printSpaces(id);
                i++;
            }
        }
        else if(l[i]=='}'){
            cout<<endl;
            id-=2;
            printSpaces(id);
            cout<<'}';
            i++;
        }
        else if(l[i]==','){
            cout<<','<<endl;
            printSpaces(id);
            i++;
        }
        else{
            cout<<l[i];
            i++;
        }
    }
    cout<<endl;
}
