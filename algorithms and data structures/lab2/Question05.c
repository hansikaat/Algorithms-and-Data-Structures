
/*READ ME:
If an array with both negative and positive variants is provided, the program
would calclulate the array length and iterate over the array to find whether
there is any negative element. If found, swap with the first element. Then
incrment the current position to the next position and start checking whether
there is any other negative element and if found, swap with the current
position. The program is designed to go through the array only once to determine
whether there is any negative element.
*/
#include<stdio.h>

int main(void)
{
    int array[4]={1,2,-8,-9}; //array of integers (both positive and negative)
    //size of the array
    int length=sizeof(array)/sizeof(int);

        int i=0;
        for(int j=0;j<length;j++){
          //checking whether the element is negative
          if(array[j]<0){
            //swap elements
            int temp=array[i];
            array[i]=array[j];
            array[j] = temp;
            i++;
          }
        }
        //print the ordered array
        for(int i=0;i<length;i++){
          printf("%d ", array[i]);
        }
}

/*execution
-8 -9 1 2 
*/