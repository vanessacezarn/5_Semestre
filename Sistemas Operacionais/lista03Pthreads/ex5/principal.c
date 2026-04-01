/*5 – Considere o problema de somar dois vetores de tamanho N. Desenvolva um algoritmo que permita a criação de diferentes quantidades de threads para efetuar a soma de dois vetores e mostrar o vetor resultante.

d)     Efetue a medida do tempo de execução deste programa, usando a função gettimeofday, conforme o quadro 1.

e)     Compare a execução deste algoritmo com threads, com a execução do algoritmo da lista 2 (com processos). Qual versão mostrou menor tempo de execução?

f)      Neste problema, existiu acesso concorrente aos dados pelos diferentes fluxos de execução?*/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h> 
#include <unistd.h> 
#include <sys/time.h>

#define NUM_THREADS 4
int vetorA[4] = {1,5,9,7};
int vetorB[4] = {3,6,7,4};
int vetorR[4];


void *somar (void *arg)
{
		
	for(int i=0; i<4; i++){
		vetorR[i] = vetorA[i]+vetorB[i];
	}
	printf("\nVetor Resultante");
	for(int a=0; a<4; a++){
		printf("[%d] ", vetorR[a]);
	}
	pthread_exit (NULL);
}


// thread "main"
int main (int argc, char *argv[])
{
	struct timeval tpI, tpF;
	int sec, usec;

        
        pthread_t thread[NUM_THREADS];
	long status, i;
		gettimeofday(&tpI,NULL);

	for(i = 0; i < NUM_THREADS; i++)
	{
		//printf ("Creating thread %ld\n", i);
		status = pthread_create (&thread[i], NULL, somar, (void *) i);
		pthread_join(thread[i],NULL);

		if (status) // ocorreu um erro na criação
		{
			perror ("pthread_create");
			exit (-1);
		}
	}
	gettimeofday(&tpF, NULL);
	
	sec = tpF.tv_sec - tpI.tv_sec;
	usec = tpF.tv_usec - tpI.tv_usec;
	if(usec<0){
		usec+= 1000000L;
		sec-=1;
	}
	printf("tempo: %d s %d us \n", sec, usec);
	// encerra a thread "main"
	pthread_exit (NULL);
	
}

