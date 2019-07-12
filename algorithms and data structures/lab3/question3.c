
	#include<stdio.h>
  #include <ctype.h>

	int main()
	{
    		FILE *ptr_file;
    		char buf[1000];
        int c;
        freopen("output.txt","w",stdout);

    		ptr_file =fopen("98-0.txt","r");
    		if (!ptr_file)
        		return 1;

        while ((c =fgetc(ptr_file)) != EOF ){
          if (isalpha(c) != 0 || c == '\n') printf("%c", c);
          else printf(" ", c);
        }


    	/*	while (fgets(buf,1000, ptr_file)!=NULL)
        		printf("%s",buf);*/

		fclose(ptr_file);
    		return 0;
	}
