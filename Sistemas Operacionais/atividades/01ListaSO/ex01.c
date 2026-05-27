#include <sys/types.h>
#include<unistd.h>
#include<stdio.h>
 
int main()
{
       float base, altura;
       printf("digite a base e a altura: ");
       scanf("%f %f", &base, &altura);
       
       pid_t procID;
 
       procID = fork();
       
       
       
 
       if (procID < 0)
       {
             printf("Erro na criação do novo processo\n");
             return -1;
       }
       else if (procID == 0)
            {
             printf("\n\nProcesso filho - PID = %d\n", getpid());
             float area = base * altura;
             printf("area = %2.f\n", area);
             return 1;
            }
            else
            {
             printf("\nProcesso Pai - PID = %d\n", getpid());
             float perimetro = (2*base) + (2*altura);
             printf("perimetro = %2.f", perimetro);
             return 1;
            }
}
