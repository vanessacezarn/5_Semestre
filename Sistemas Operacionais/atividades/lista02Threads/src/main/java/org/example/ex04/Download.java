/*4 - Simule um download criando uma thread que vai de 0% até 100%,
 incrementando de 10 em 10 e esperando meio segundo entre cada passo.
 A saída deve mostrar o progresso do download*/
package org.example.ex04;

public class Download extends Thread {
    public Download(String str) {
        super(str);
    }
    public void run() {
        System.out.println("Iniciando download");
        for(int i=0; i<=100;i=i+10) {
            System.out.println(i+"%");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Download concluido!!!");
    }
    public static void main(String[] args) {
        Download Thread1 = new Download("Thread");
        Thread1.start();
    }
}
