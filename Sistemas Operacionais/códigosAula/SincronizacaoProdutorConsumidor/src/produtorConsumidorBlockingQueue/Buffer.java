package produtorConsumidorBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Buffer {
     private BlockingQueue<Integer> fila = new ArrayBlockingQueue<>(5);
     public void produzir (int valor) throws InterruptedException{
         fila.put(valor);
         System.out.println("Produzido: "+valor);
     }
     public void  consumir() throws InterruptedException{
         int valor = fila.take();
         System.out.println("Consumindo: "+valor);
     }
     
}
