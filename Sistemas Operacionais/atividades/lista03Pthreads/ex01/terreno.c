/*
Crie um programa com dois threads. As medidas de um terreno retangular devem ser lidas. Um
thread deve calcular a área do terreno e outro o perímetro. Todos os resultados obtidos devem ser
mostrados ao usuário.
*/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h> 
#include <unistd.h> 

#define NUM_THREADS 5


typedef struct{
	float base;
	float altura;
}Dimensoes;

void *calArea (void *arg)
{
	Dimensoes *dados = (Dimensoes *)arg;
	float area = (dados->base * dados->altura);
	printf("Área do Terreno = %.2f\n", area);
	pthread_exit (NULL); // encerra esta thread
}

void *calPerimetro (void *arg)
{
	Dimensoes *dados = (Dimensoes *)arg;
	float perimetro = (dados->base * 2) + (dados->altura * 2);
	printf("Perímetro do Terreno = %.2f\n", perimetro);
	pthread_exit (NULL); // encerra esta thread
}

// thread "main"
int main (int argc, char *argv[])
{
       pthread_t thread;
       Dimensoes d;
       printf("digite a base e a altura: ");
       scanf("%f %f", &d.base, &d.altura);
	
	pthread_create(&thread, NULL, calArea, (void *)&d);	
	pthread_create(&thread, NULL, calPerimetro, (void *)&d);
		
	
	pthread_exit (NULL);
}

