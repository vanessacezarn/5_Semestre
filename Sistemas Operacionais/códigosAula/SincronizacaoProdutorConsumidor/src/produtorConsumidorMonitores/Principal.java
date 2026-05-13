package produtorConsumidorMonitores;

public class Principal {
    public static void main(String[] args) {
        BufferCircular buffer = new BufferCircular(5);
        Thread threadProdutor = new Thread(new Produtor(buffer));
        Thread threadConsumidor = new Thread(new Consumidor(buffer));
        
        threadProdutor.start();
        threadConsumidor.start();

    }
}
