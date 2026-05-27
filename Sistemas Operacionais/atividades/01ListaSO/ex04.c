#include <sys/types.h>
#include<unistd.h>
#include<stdio.h>
#include <unistd.h>
#include <sys/wait.h>


 
int main()
{
            
       pid_t filho1;
       pid_t filho2;
       pid_t filho3;
       pid_t filho4;
       pid_t filho5;
 
       filho1 = fork();
 
       if (filho1 < 0)
       {
             printf("Erro na criação do novo processo\n");
             return -1;
       }
       else if (filho1 == 0){
		    printf("\n\nProcesso filho 1- PID = %d\n", getpid());
		    filho2 = fork();
		    if (filho2 == 0){
		   	 printf("\n\nProcesso filho 2- PID = %d\n", getpid());
		   	 filho3 = fork();
		   	 if(filho3 == 0){
		   	 	printf("\n\nProcesso filho 3 - PID = %d\n", getpid());
		   	 }
            	    }
          
             return 1;
            }else{
		     filho4 = fork();
		     if (filho4 == 0){
		     	printf("\n\nProcesso filho 4- PID = %d\n", getpid());
		     	filho5 = fork();
		     	if(filho5 == 0){
		     		printf("\n\nProcesso filho 5- PID = %d\n", getpid());
		     	}
		     return 1;
		     } else{
			 printf("\nProcesso Pai - PID = %d\n", getpid());
			 wait(NULL);
			 wait(NULL);
			 return 1;
			}
			     
		    }
}
