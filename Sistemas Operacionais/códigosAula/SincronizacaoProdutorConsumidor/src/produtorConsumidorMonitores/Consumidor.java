package produtorConsumidorMonitores;

public class Consumidor implements Runnable {
    private BufferCircular buffer;

    public Consumidor(BufferCircular buffer) {
        this.buffer = buffer;
    }

    public void run(){
        try{
            for(int i=0; i<10; i++){
                int valor = buffer.get();
                System.out.println("Consumido: "+valor);
            }
        } catch(InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }
}
