package deadlock;

public class Processo1 extends Thread{
    private Recurso recurso1;
    private Recurso recurso2;

    public Processo1(Recurso recurso1, Recurso recurso2) {
        this.recurso1 = recurso1;
        this.recurso2 = recurso2;
    }
    
    @Override
    public void run(){
        synchronized(recurso1){
            System.out.println("Processo 1 bloqueou "+ recurso1.getNome());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
            
            synchronized(recurso2){
                System.out.println("Processo 1 bloqueou "+recurso2.getNome());
            }
        }
    }
    
}
