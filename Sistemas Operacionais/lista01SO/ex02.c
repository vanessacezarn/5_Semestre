#include <sys/types.h>
#include<unistd.h>
#include<stdio.h>
#include <unistd.h>
#include <sys/wait.h>


 
int main()
{
            
       pid_t procID;
       pid_t filho2;
 
       procID = fork();
       
       
       
 
       if (procID < 0)
       {
             printf("Erro na criação do novo processo\n");
             return -1;
       }
       else if (procID == 0)
            {
             printf("\n\nProcesso filho 1- PID = %d\n", getpid());
             for (int i =0 ; i<10; i++){
             	printf("%d \t",i);
             	fflush(stdout);
             }
             return 1;
            }
            else
            {
             filho2 = fork();
             if (filho2 == 0){
             	printf("\n\nProcesso filho 2- PID = %d\n", getpid());
             	for (int i = 25 ; i<35; i++){
             	printf("%d \t",i);
             	fflush(stdout);

            	}
            	printf("\n");
             wait(NULL);
             return 1;
             } else{
		 printf("\nProcesso Pai - PID = %d\n", getpid());
		 for (int i =40 ; i<50; i++){
		     printf("%d \t",i);
		     fflush(stdout);

		 }
		 wait(NULL);
		 wait(NULL);
		 return 1;
		}
		     
            }
}
