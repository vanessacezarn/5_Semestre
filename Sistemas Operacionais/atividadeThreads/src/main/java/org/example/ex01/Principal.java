/*1 - Crie uma classe que herda de Thread e faça com que ela imprima
números de 1 até 5, com uma pausa de 1 segundo entre cada número.
 */
package org.example.ex01;

public class Principal extends Thread {
    public Principal(String str) {
        super(str);
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Principal Thread1 = new Principal("Primeira");
        Thread1.start();
    }
}
