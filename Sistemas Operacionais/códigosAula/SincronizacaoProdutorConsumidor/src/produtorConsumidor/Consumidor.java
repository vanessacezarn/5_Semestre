package produtorConsumidor;

public class Consumidor implements Runnable {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }
    public void run(){
        for (int i=0; i<10; i++){
            int valor = buffer.get();
            //System.out.println("Consumindo: "+valor);
        }
    }
    
}
