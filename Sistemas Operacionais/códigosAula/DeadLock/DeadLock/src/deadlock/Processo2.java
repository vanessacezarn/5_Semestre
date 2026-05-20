package deadlock;

public class Processo2 extends Thread {
    private Recurso recurso1;
    private Recurso recurso2;

    public Processo2(Recurso r1, Recurso r2) {
        this.recurso1 = r1;
        this.recurso2 = r2;
    }
    
    @Override
    public void run(){
        synchronized(recurso1){
            System.out.println("Processo 2 bloqueou "+ recurso1.getNome());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
            
            synchronized(recurso2){
                System.out.println("Processo 2 bloqueou "+recurso2.getNome());
            }
        }
    }
}
