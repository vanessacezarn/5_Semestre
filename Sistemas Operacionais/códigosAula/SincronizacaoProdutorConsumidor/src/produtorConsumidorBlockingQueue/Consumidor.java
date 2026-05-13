package produtorConsumidorBlockingQueue;

public class Consumidor implements Runnable{
    private Buffer  buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run(){
        try{
            for(int i=0; i<10; i++){
                buffer.consumir();
                Thread.sleep(1000); //simula o tempo de consumo
            }
        }catch(InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }
}
