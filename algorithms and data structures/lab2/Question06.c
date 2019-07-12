/*READ ME:
Loop Invariant: The loop determines whether the array element is negative and swaps the negative element with the i'th position 
of the array starting with i =0. After detecting a negative element, the i increments by 1 and the element in that i'th position 
gets swapped with the negative element.
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
