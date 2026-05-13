
package produtorConsumidor;


public class Produtor implements Runnable {
    private Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }
    public void run(){
        for (int i=0; i<10; i++){
            buffer.set(i);
            //System.out.println("Produzido: "+i);
        }
    }
}
