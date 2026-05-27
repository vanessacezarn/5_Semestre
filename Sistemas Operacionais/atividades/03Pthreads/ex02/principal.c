/*
Escreva um programa formado por 3 threads, que executam um laço de repetição de
N interações. Neste laço, cada thread imprime sua identificação. A partir da execução do programa, identifique como acontece o escalonamento dos threads.
*/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h> 
#include <unistd.h> 

#define N  5


void *thread (void *arg)
{
	char *nome = (char *)arg;
	for(int i=0; i<N; i++){
		printf ("Thread %s interação - %d | Identificaçao: %ld \n", nome, i, (long) arg);
	}
	pthread_exit (NULL);
}




// thread "main"
int main (int argc, char *argv[])
{
       pthread_t threadA, threadB, threadC;
 
       
	
	pthread_create(&threadA, NULL, *thread, (void *)"A");	
	pthread_create(&threadB, NULL, *thread, (void *)"B");
	pthread_create(&threadC, NULL, *thread, (void *)"C");
	
	pthread_join(threadA,NULL);
	pthread_join(threadB,NULL);
	pthread_join(threadC,NULL);
	
	
}

