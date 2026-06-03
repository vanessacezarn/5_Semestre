/*Crie duas threads diferentes: uma deve imprimir “Thread A” contando de 1 até 5,
 e a outra “Thread B” também de 1 até 5. Execute ambas ao mesmo tempo e observe
 o resultado. Reflita: a ordem de execução será sempre a mesma?*/
package org.example.ex02;

public class Principal extends Thread {
    public Principal(String str) {
        super(str);
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(i + " - " + getName());

        }
    }
    public static void main(String[] args) {
        Principal Thread1 = new Principal("Thread A");
        Principal Thread2 = new Principal("Thread B");
        Thread1.start();
        Thread2.start();
    }
}
