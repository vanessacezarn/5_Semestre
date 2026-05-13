package produtorConsumidorMonitores;

public class BufferCircular {
    private final int [] buffer;
    private int front = 0;
    private int rear = 0;
    private int count = 0;
    
    public BufferCircular(int size){
        buffer = new int [size];
    }
    
    public synchronized void put (int value) throws InterruptedException{
        while(count == buffer.length){
            wait(); // buffer está cheio, tem que esperar até o consumidor consumir
        }
        buffer[rear] = value;
        rear=(rear+1) % buffer.length;
        count ++;
        notifyAll(); // notifica as threads que estão esperando para consumir
    }
    
     public synchronized int get () throws InterruptedException{
        while(count == 0){
            wait(); // buffer está vazio, tem que esperar até o produtor produzir
        }
        int result = buffer[front];
        front = (front + 1)%buffer.length;
        count --;
        notifyAll();// notifica as threads que estão esperando para produzir
        return result;
    }
    
}
