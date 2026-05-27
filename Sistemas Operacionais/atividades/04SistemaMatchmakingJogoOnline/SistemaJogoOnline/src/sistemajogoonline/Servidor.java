package sistemajogoonline;

public class Servidor implements Runnable{
    private Buffer  buffer;

    public Servidor(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run(){
        try{
            for(int i=0; i<5; i++){
                buffer.consumir();
                Thread.sleep(500); //simula o tempo de consumo
            }
            System.out.println("Encerrado todos os jogos");
        }catch(InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }
}
