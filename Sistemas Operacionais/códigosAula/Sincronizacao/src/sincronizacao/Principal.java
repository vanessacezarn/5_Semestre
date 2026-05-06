
package sincronizacao;

public class Principal {

    
    public static void main(String[] args) {
        Conta conta = new Conta();
        Usuario u1 = new Usuario(conta);
        Usuario u2 = new Usuario(conta);
        
        u1.start();
        u2.start();
    }
    
}
