package org.example.comunicacao_threads;

public class Principal {
    public static void main(String[] args) {
        Mensagem msg = new Mensagem();

        Thread t1 = new Thread(() -> {
            msg.esperarMensagem();
        });
        Thread t2 = new Thread(() -> {
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            msg.enviarMensagem();
        });
        t1.start();
        t2.start();
    }
}
