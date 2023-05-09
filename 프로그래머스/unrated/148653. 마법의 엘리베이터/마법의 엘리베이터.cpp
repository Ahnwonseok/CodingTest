#include <string>
#include <vector>

using namespace std;
int answer = 100000000;
int f(int num, int stone){
        
    if(num<10){
       stone+=min(num, 11-num);
       answer = min(answer,stone);
       return 0;
    }
    
    
    int l = num%10;
    num/=10;
    if(num>0) f(num +1, stone+10-l);                  
    f(num , stone+l);
    
    return 0;
}
int solution(int storey) {
    
    f(storey, 0);
    return answer;
}