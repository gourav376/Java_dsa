class Max1s{
static int maxOnes(int arr[]){
int max = 0 ;
int cou = 0;
for(int i =0 ;i< arr.length;i++)
{if(arr[i]==0){
if(max<cou){max=cou;}
cou =0;
}
else{
cou++;}
}
return max;}
public static void main(String [] args){
int [] arr = {1,1,1 , 0 , 1,1,1,1,0 , 0 ,1, 1,0};
System.out.println("Max number of one's : "+maxOnes(arr)); 
}
}
