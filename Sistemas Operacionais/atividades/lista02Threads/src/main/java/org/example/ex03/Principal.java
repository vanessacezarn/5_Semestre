/*3 - Crie um contador compartilhado entre duas threads.
Cada uma deve incrementar esse contador 1000 vezes.
Ao final, imprima o valor do contador. Observe o resultado.

Pesquise sobre Race Condition e resuma brevemente.
Race condition ocorre quando múltiplas threads acessam e modificam
dados compartilhados simultaneamente sem sincronização adequada,
causando resultados inconsistentes e imprevisíveis.

*/
package org.example.ex03;

class Contador {
    public int valor = 0;
}
public class Principal extends Thread {
    private Contador contador;

    public Principal(Contador contador, String nome) {
        super(nome);
        this.contador = contador;
    }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                contador.valor++;
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Contador contador = new Contador();

            Principal t1 = new Principal(contador, "Thread A");
            Principal t2 = new Principal(contador, "Thread B");

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("CONTADOR: " + contador.valor);
        }
}
