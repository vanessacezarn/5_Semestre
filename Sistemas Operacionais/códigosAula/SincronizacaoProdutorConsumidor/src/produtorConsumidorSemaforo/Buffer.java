package produtorConsumidorSemaforo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    /*Queue é uma interface do framework de coleções (java.util) que representa uma estrutura de dados 
    de fila, baseada no princípio FIFO (First-In-First-Out - "primeiro a entrar, primeiro a sair"). */
    private static final int CAPACITY = 5;
    private Semaphore semFull = new Semaphore (0);
    private Semaphore semEmpty = new Semaphore (CAPACITY);
    
    public void put (int item) throws InterruptedException{
        semEmpty.acquire(); //adquire um espaço vazio
        synchronized(this){
            queue.add(item);
            System.out.println("Produzido: "+item);
        }
        semFull.release();//libera um espaço cheio
    }
    public int get() throws InterruptedException{
        semFull.acquire(); // adquire um espaço cheio
        int item;
        synchronized(this){
            item = queue.poll();
            System.out.println("Consumindo: "+item);
        }
        semEmpty.release(); // libera uma espaço vazio
        return item;
    }
    
    
    
}
