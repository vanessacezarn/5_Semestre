package produtorConsumidorBlockingQueue;

public class Principal {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread produtor = new Thread (new Produtor(buffer));
        Thread consumidor = new Thread (new Consumidor(buffer));
        
        produtor.start();
        consumidor.start();

    }
}
