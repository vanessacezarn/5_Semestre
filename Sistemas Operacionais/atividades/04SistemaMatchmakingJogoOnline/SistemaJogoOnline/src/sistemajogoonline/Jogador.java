package sistemajogoonline;

public class Jogador implements Runnable {
    
    private Buffer buffer;
    private int identificador;
    private String nickname;

    public Jogador(Buffer buffer, int identificador, String nickname) {
        this.buffer = buffer;
        this.identificador = identificador;
        this.nickname = nickname;
    }
    
        
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }   

    @Override
    public void run(){
        try{
            buffer.produzir(this);
        }catch(InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }    
    
}
