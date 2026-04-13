package org.example.comunicacao_threads;

public class Mensagem {
    private boolean pronta = false;

    public synchronized void esperarMensagem(){
        while(!pronta){
            try {
                System.out.println("Thread esperando mensagem...");
                wait(); // espera até alguém chamar notify
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Mensagem recebida!");
    }

    public synchronized void enviarMensagem() {
        System.out.println("Preparando mensagem...");
        pronta = true;
        notify(); // acorda a thread que esta esperando
        System.out.println("Mensagem enviada!");
    }
}
