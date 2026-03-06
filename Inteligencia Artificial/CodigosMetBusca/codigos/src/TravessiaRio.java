/*CODIGO PARA RESOLVER O PROBLEMA DA TRAVESSIA DO RIO COM UM HOMEM, UM LOBO, UMA ALFACE E UM CARNEIRO*/
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;
import busca.MostraStatusConsole;

public class TravessiaRio implements Estado{
    
  @Override
    public String getDescricao() {
        return " Problema do Homem, Lobo, Alface e Carneiro";
    }
    
    final char H , L, A, C ;
    final String op; // operacao que gerou o estado
    
    
    /** construtor para o estado, recebe cada valor de atributo */
    public TravessiaRio(char H, char L, char A, char C, String op) {    
        this.H = H;
        this.L = L;
        this.A = A;
        this.C = C;
        this.op = op;
    }

    /**
     * verifica se o estado final foi atingido nesse caso se todos atravessaram o rio para a margem direita
     */
    @Override
    public boolean ehMeta() {
        return H == 'd'&& L == 'd' && A == 'd' && C == 'd' ;
    }
    
    /**
     * Custo para geracao do estado
     */
    @Override
    public int custo() {
        return 1;
    }
    
    /**
     * gera uma lista de sucessores do nodo.
     * @return visitados
     */
    @Override
    public List<Estado> sucessores() {
        List<Estado> visitados = new LinkedList<Estado>(); // a lista de sucessores
        
        levarNada(visitados);
        levarLobo(visitados);
        levarAlface(visitados);
        levarCarneiro(visitados);
        
        return visitados;
    }
    /*
        Verificar as restrições do problema
    */
    private boolean ehValido(char H, char L, char A, char C){
        /*Lobo e o Carneiro não podem ficar na mesma margem sem o Homem*/
        if (L == C && H != L)
            return false;
        /*Carneiro não pode ficar na mesma margem que a Alface sem o Homem*/
        if(C == A && H != C){
            return false;
        }    
        return true;
    }
    
    /*Apenas o homem troca de margem*/
    private void levarNada(List<Estado> visitados) { 
        if(H == 'e' && ehValido('d',this.L,this.A,this.C)){
            TravessiaRio novo = new TravessiaRio('d',this.L,this.A, this.C,"Homem atrevessa sozinho para margem D");
            if (!visitados.contains(novo)) visitados.add(novo);
        }
        if(H == 'd' && ehValido('e',this.L,this.A,this.C)) {
            TravessiaRio novo = new TravessiaRio('e',this.L,this.A, this.C,"Homem atrevessa sozinho para margem E");
            if (!visitados.contains(novo)) visitados.add(novo);
        }
    }
    
    /*Homem leva o lobo 
         para isso tem que estarem no mesmo lado
        !! Carneiro e Alface não podem ficar sozinhos na mesma margem !! a condição tem que ser testa "depois" da travessia
    */
    private void levarLobo(List<Estado> visitados) {
        if (H == L) {
            if(H =='e' && ehValido('d','d',this.A,this.C)){
                TravessiaRio novo = new TravessiaRio('d', 'd', this.A, this.C,"Homem atravessa com o lobo para margem D");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
            if (H =='d' && ehValido('e','e',this.A,this.C)){
                TravessiaRio novo = new TravessiaRio('e','e' , this.A, this.C,"Homem atravessa com o lobo para margem E");
                if (!visitados.contains(novo)) visitados.add(novo);
            }     
        }  
    }
    /*utilizando operador ternario = chatgpt
        operador ternario --> condição ? valor_se_verdadeiro : valor_se_falso;
    
        if(H == L){
            char novaMargem = (H == 'e') ? 'd' : 'e' ;
            if (ehValido(novaMargem,novaMarge,this.A, this.C)){
                TravessiaRio novo = new TravessiaRio(novaMargem, novaMargem, this.A, this.C,"Homem atravessa com o lobo");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
       }
    */
    
    private void levarAlface(List<Estado> visitados) {
        if(H == A){
            if (H == 'e' && ehValido('d',this.L,'d',this.C)){
                TravessiaRio novo = new TravessiaRio('d',this.L,'d',this.C, "Homem atravessa a alface para a margem D");
                if(!visitados.contains(novo)) visitados.add(novo);
            }
            if (H == 'd'&& ehValido('e',this.L,'e',this.C)){
                TravessiaRio novo = new TravessiaRio('e',this.L,'e',this.C, "Homem atravessa a alface para a margem E");
                if(!visitados.contains(novo)) visitados.add(novo);
            }   
        }
    }
    
    private void levarCarneiro(List<Estado> visitados) {
        if(H == C){
            if (H == 'e' && ehValido('d',this.L,this.A,'d')){
                TravessiaRio novo = new TravessiaRio('d',this.L,this.A,'d', "Homem atravessa com o carneiro para a margem D");
                if(!visitados.contains(novo)) visitados.add(novo);
            }
            if (H == 'd' && ehValido('e',this.L,this.A,'e')){
                TravessiaRio novo = new TravessiaRio('e',this.L,this.A,'e',"Homem atravessa com o carneiro para a margem E");
                if(!visitados.contains(novo)) visitados.add(novo);
            }   
        }
    }
    
    /**
     * verifica se um estado e igual a outro
     * (usado para poda)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof TravessiaRio) {
            TravessiaRio e = (TravessiaRio)o;
            return this.H == e.H &&
                   this.L == e.L &&
                   this.A == e.A &&
                   this.C == e.C;
        }
        return false;
    }
    
    /** 
     * retorna o hashCode do estado
     * (usado para poda, conjunto de fechados)
     */
    @Override
    public int hashCode() { 
        return (""+this.H + this.L+this.A+this.C).hashCode();
    }
    
    @Override
    public String toString() {
        return "(" + this.H + "," + this.L + "," + this.A +"," + this.C + ") "  + op + "\n";
    }
    
    public static void main(String[] a) {
        TravessiaRio estadoInicial = new TravessiaRio('e','e','e','e',"estado inicial");
        
        // chama busca em largura
        System.out.println("busca em ....");
        Nodo n = new BuscaLargura(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("solucao:\nem ordem Homem, Lobo, Alface,Carneiro\n" + n.montaCaminho() + "\n\n");
        }
    }
}
