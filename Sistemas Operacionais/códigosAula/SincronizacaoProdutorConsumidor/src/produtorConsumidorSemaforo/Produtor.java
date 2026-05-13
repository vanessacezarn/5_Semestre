package produtorConsumidorSemaforo;

public class Produtor implements Runnable{
    private Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        try{
            for(int i=0; i<10; i++){
                buffer.put(i);
                Thread.sleep(1000); //simula o tempo de produção
            }
        }catch(InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }    
}
