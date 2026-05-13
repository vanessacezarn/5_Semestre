package produtorConsumidorMonitores;

public class Produtor implements Runnable {
    private BufferCircular buffer;

    public Produtor(BufferCircular buffer) {
        this.buffer = buffer;
    }
    public void run(){
        try{
            for(int i=0; i<10; i++){
                buffer.put(i);
                System.out.println("Produzido: "+i);
            }
        } catch(InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }
}
