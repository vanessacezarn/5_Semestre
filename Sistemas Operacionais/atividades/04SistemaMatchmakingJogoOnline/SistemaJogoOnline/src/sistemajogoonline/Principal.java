
package sistemajogoonline;

import java.util.concurrent.TimeUnit;


public class Principal {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread consumidor = new Thread (new Servidor(buffer));    
        consumidor.start(); 
        try {
            Thread p1 = new Thread(new Jogador(buffer, 1, "vava"));
            p1.start();
            TimeUnit.MILLISECONDS.sleep(1500);
            
            Thread p2 = new Thread(new Jogador(buffer, 22, "manda"));
            p2.start();
           // TimeUnit.MILLISECONDS.sleep(500);

            Thread p3 = new Thread(new Jogador(buffer, 3, "thi"));
            p3.start();
            TimeUnit.MILLISECONDS.sleep(800);

            Thread p4 = new Thread(new Jogador(buffer, 14, "ba"));
            p4.start();
            TimeUnit.MILLISECONDS.sleep(200);

            Thread p5 = new Thread(new Jogador(buffer, 55, "jo"));
            p5.start();

        } catch (InterruptedException e) {
            System.err.println("A inicialização dos jogadores foi interrompida.");
            Thread.currentThread().interrupt();
        }
        
        
           
    }
}
