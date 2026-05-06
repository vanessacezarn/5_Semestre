package sincronizacao;

public class Conta {
    private int saldo = 100;
    
    /*
        *seção crítica do sistema --> método sacar e o acesso a varialvel
        * synchronized = deixa apenas um acessar por vez o método
    */
    
    public synchronized void sacar(int valor)
    {
        saldo -= valor;
        System.out.println(Thread.currentThread().getName()+ " saldo:" + saldo);                   

    }

    public synchronized int getSaldo() {
        return saldo;
    }
    
    
    
}
