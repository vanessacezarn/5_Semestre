package produtorConsumidor;

public class Buffer {
    private int conteudo;
    private boolean disponivel = false;
    
    public synchronized void set(int valor){
        while(disponivel){
            try{
                wait();
            }catch(InterruptedException e){
            }            
        }
        
        conteudo = valor;
        disponivel = true;
        System.out.println("Produzido: ");
        notifyAll();
    }
    public synchronized int get(){
        while(!disponivel){
            try{
                wait();
            }catch(InterruptedException e){
            }            
        }
        System.out.println("Consumindo: ");
        disponivel = false;
        notifyAll();
        return conteudo;
    }
    
}
