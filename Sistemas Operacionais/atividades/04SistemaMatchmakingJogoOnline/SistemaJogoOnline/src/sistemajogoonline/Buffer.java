package sistemajogoonline;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Buffer {
    
    private BlockingQueue<Jogador> fila = new ArrayBlockingQueue<>(10);
    public void produzir (Jogador j) throws InterruptedException{
         fila.put(j);
         System.out.println("Jogador: "+j.getNickname() + " entrou no jogo");
    }
    public void  consumir() throws InterruptedException{
         if (fila.isEmpty()) {
            System.out.println("Aguardando a entrada de jogadores para iniciar uma partida\n" );
        }
        Jogador j1 = fila.take();
        System.out.println("jogador: "+ j1.getNickname() + " esta aguardando a entrada de um adversario");

        Jogador j2 = fila.take();
        System.out.println("------- Partida entre "+ j1.getNickname()+" e "+ j2.getNickname()+  " iniciada --------");
    }
}
