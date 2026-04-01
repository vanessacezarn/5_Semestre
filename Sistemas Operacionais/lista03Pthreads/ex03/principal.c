/*
 Escreva um programa formado por várias threads, que executam um laço de repetição de N interações para incrementar em 1 uma variável compartilhada. Ao término da execução, verifique o valor final da variável compartilhada.
*/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h> 
#include <unistd.h> 

#define N 7
#define NUM_THREADS 4
int contador;

void *threadA (void *arg)
{
	for(int i=0; i<N; i++){
		contador+=1;
	}
	pthread_exit (NULL);
}


// thread "main"
int main (int argc, char *argv[])
{
       pthread_t thread[NUM_THREADS];
	long status, i;

	for(i = 0; i < NUM_THREADS; i++)
	{
		printf ("Creating thread %ld\n", i);
		status = pthread_create (&thread[i], NULL, threadA, (void *) i);
		pthread_join(thread[i],NULL);

		if (status) // ocorreu um erro na criação
		{
			perror ("pthread_create");
			exit (-1);
		}
	}

	// encerra a thread "main"
	printf("CONTADOR = %d\n",contador);
	pthread_exit (NULL);
	
}

