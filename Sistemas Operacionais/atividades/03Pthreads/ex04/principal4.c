/*
4 – Escreva um programa com duas threads que compartilham um vetor de inteiros tamanho 5 e uma outra variável inteira que conta quantos elementos há no vetor. Uma das threads escreve um dado no vetor e a outra remove um dado no vetor. A execução das threads é contínua.
a)     Verifique a execução do programa
b)     Os valores apresentados nos dados compartilhados são corretos
c)     Neste problema, as threads precisam ser sincronizadas?
*/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h> 
#include <unistd.h> 



int vetor[5];
int contador = 0;

void *threadA (void *arg)
{
	for(int i=0; i<5; i++){
		int r = rand();
		contador+=1;
		vetor[i] = r;
		sleep(3);
		
		printf("adicionando o numero %d na posição %d | | Total de numeros no vetor %d\n",r,i,contador);
	}
	
	
	pthread_exit (NULL);
}
void *threadB (void *arg)
{
	for(int i=0; i<5; i++){
		vetor[i]=0;
		sleep(5);
		contador-=1;
		printf("removendo o numero da posiçaõ %d | | | | Total de numeros no vetor %d\n",i,contador);
		
	}
	pthread_exit (NULL);
}


int main (int argc, char *argv[])
{
	pthread_t thread1, thread2;
       	pthread_create(&thread1, NULL, threadA, (void *)NULL);	
	pthread_create(&thread2, NULL, threadB, (void *)NULL);
		
	
	for(int i=0; i<5; i++){
		printf("[%d] ", vetor[i]);
	}
	printf("\nCONTADOR = %d\n",contador);
	pthread_exit (NULL);
	
}

