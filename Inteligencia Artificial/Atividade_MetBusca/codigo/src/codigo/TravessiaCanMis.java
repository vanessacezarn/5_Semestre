package codigo;
/**
 * Atividade de Inteligência Artificial - Vanessa Cezar do Nascimento
 *  Código para resolução do problema da travessia de 3 canibais e 3 missionarios em um rio
 */

import java.util.LinkedList;
import java.util.List;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;
import busca.MostraStatusConsole;

public class TravessiaCanMis implements Estado{
    
  @Override
    public String getDescricao() {
        return " Problema da travessia de um rio de 3 Canibais e 3 Missionários ";
    }
    
    final int Ce, Cd, Me, Md;
    final char barco;
    final String op; // operacao que gerou o estado
    
    
    /** construtor para o estado, recebe cada valor de atributo */
    public TravessiaCanMis(int Ce,int Me, int Cd, int Md, char barco, String op) {    
        this.Ce = Ce;
        this.Me = Me;
        this.Cd = Cd;
        this.Md = Md;
        this.barco = barco;
        this.op = op;
    }

    /**
     * verifica se o estado final foi atingido, nesse caso se todos atravessaram o rio para a margem direita
     */
    @Override
    public boolean ehMeta() {
        return Ce == 0 && Me == 0 && Cd == 3  && Md == 3;
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
     * 
     */
    @Override
    public List<Estado> sucessores() {
        List<Estado> visitados = new LinkedList<Estado>(); // a lista de sucessores
        
        canibalSozinho(visitados);
        missionarioSozinho(visitados);
        doisCanibais(visitados);
        doisMissionarios(visitados);
        canibalMissionario(visitados);
        
        return visitados;
    }
    
    /*
        Verificar as restrições do problema
        nesse caso não pode ter mais canibais que missionarios em uma mesma margem
    */
    private boolean ehValido(int Ce,int Me, int Cd,  int Md ){
        /*não pode ter numero de canibais ou missionario menor que zero ou maior que 3*/
        if (Ce < 0 || Ce > 3 || Cd < 0 || Cd > 3) return false;
        if (Me < 0 || Me > 3 || Md < 0 || Md > 3) return false;
        /*Se tiver algum missionario na margem esquerda, a quantidade deles tem que ser maior que a de canibais nessa margem*/
        if (Me > 0 && Ce > Me){ return false;}
        /*Se tiver algum missionario na margem direita, a quantidade deles tem que ser maior que a de canibais nessa margem*/        
        if (Md >0 && Cd > Md){ return false; }
        return true;
    }
       
    /**
     * Metodo para a travessia de apenas um canibal
     * @param visitados lista de estados já visitados
     */
    private void canibalSozinho(List<Estado> visitados) { 
        if(barco == 'e' && this.Ce > 0){
            int NovoCe = this.Ce - 1;
            int NovoCd = this.Cd + 1;
            if(ehValido(NovoCe,this.Me,NovoCd,this.Md)){
                TravessiaCanMis novo = new TravessiaCanMis(NovoCe, this.Me, NovoCd, this.Md,'d',"Um canibal atravessa para a margem DIREITA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }   
        if(barco=='d' && this.Cd > 0){
            int NovoCd = this.Cd - 1;
            int NovoCe = this.Ce + 1;
            if(ehValido(NovoCe,this.Me,NovoCd,this.Md)){
                TravessiaCanMis novo = new TravessiaCanMis(NovoCe, this.Me, NovoCd, this.Md,'e',"Um canibal atravessa para a margem ESQUERDA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }
    }
    
    /**
     * Método para realizar a travessia de apenas um missionário
     * @param visitados lista de estados já visitados
     */
    private void missionarioSozinho(List<Estado> visitados) {
        if(barco == 'e' && this.Me > 0){
            int NovoMe = this.Me - 1;
            int NovoMd = this.Md + 1;
            if(ehValido(this.Ce, NovoMe, this.Cd, NovoMd)){
                TravessiaCanMis novo = new TravessiaCanMis(this.Ce, NovoMe, this.Cd, NovoMd,'d',"Um missionario atravessou para a margem DIREITA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }   
        if(barco=='d' && this.Md > 0){
            int NovoMd = this.Md - 1;
            int NovoMe = this.Me + 1;
            if(ehValido(this.Ce, NovoMe, this.Cd, NovoMd)){
                TravessiaCanMis novo = new TravessiaCanMis(this.Ce, NovoMe, this.Cd, NovoMd,'e',"Um missionario atravessou para a margem ESQUERDA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }
    }
    
    /**
     * Método para realizar a travessia de dois canibais
     * @param visitados lista de estados já visitados
     */
    private void doisCanibais(List<Estado> visitados) { 
        if(barco == 'e' && this.Ce > 1){
            int NovoCe = this.Ce - 2;
            int NovoCd = this.Cd + 2;
            if(ehValido(NovoCe,this.Me,NovoCd,this.Md)){
                TravessiaCanMis novo = new TravessiaCanMis(NovoCe, this.Me, NovoCd, this.Md,'d',"Dois canibais atravessaram para a margem DIREITA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }   
        if(barco=='d' && this.Cd > 1){
            int NovoCd = this.Cd - 2;
            int NovoCe = this.Ce + 2;
            if(ehValido(NovoCe,this.Me,NovoCd,this.Md)){
                TravessiaCanMis novo = new TravessiaCanMis(NovoCe, this.Me, NovoCd, this.Md,'e',"Dois canibais atravessaram para a margem ESQUERDA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }
    }
    
    /**
     * Método para realizar a travessia de dois missionários
     * @param visitados lista de estados já visitados
     */
    private void doisMissionarios(List<Estado> visitados) {
        if(barco == 'e' && this.Me > 0){
            int NovoMe = this.Me - 2;
            int NovoMd = this.Md + 2;
            if(ehValido(this.Ce, NovoMe, this.Cd, NovoMd)){
                TravessiaCanMis novo = new TravessiaCanMis(this.Ce, NovoMe, this.Cd, NovoMd,'d',"Dois missionario atravessaram para a margem DIREITA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }   
        if(barco=='d' && this.Md > 0){
            int NovoMd = this.Md - 2;
            int NovoMe = this.Me + 2;
            if(ehValido(this.Ce, NovoMe, this.Cd, NovoMd)){
                TravessiaCanMis novo = new TravessiaCanMis(this.Ce, NovoMe, this.Cd, NovoMd,'e',"Dois missionario atravessaram para a margem ESQUERDA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }
    }
    
    private void canibalMissionario(List<Estado> visitados) {
        if(barco == 'e' && this.Ce > 0 && this.Me > 0 ){
            int NovoMe = this.Me - 1;
            int NovoCe = this.Ce - 1;
            int NovoMd = this.Md + 1;
            int NovoCd = this.Cd + 1;
            if(ehValido(NovoCe, NovoMe, NovoCd, NovoMd)){
                TravessiaCanMis novo = new TravessiaCanMis(NovoCe, NovoMe, NovoCd, NovoMd,'d',"Um canibal e um missionario atravessaram para a margem DIREITA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }   
        if(barco=='d' && this.Cd > 0 && this.Md > 0){
            int NovoMd = this.Md - 1;
            int NovoCd = this.Cd - 1;
            int NovoMe = this.Me + 1;
            int NovoCe = this.Ce + 1;
            if(ehValido(NovoCe, NovoMe, NovoCd, NovoMd)){
                TravessiaCanMis novo = new TravessiaCanMis(NovoCe, NovoMe, NovoCd, NovoMd,'e',"Um canibal e um missionario atravessaram para a margem ESQUERDA");
                if (!visitados.contains(novo)) visitados.add(novo);
            }
        }
    }
    
    
    /**
     * verifica se um estado e igual a outro
     * (usado para poda)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof TravessiaCanMis) {
            TravessiaCanMis e = (TravessiaCanMis)o;
            return this.Ce == e.Ce &&
                   this.Me == e.Me &&
                   this.Cd == e.Cd &&
                   this.Md == e.Md &&
                   this.barco == e.barco;
        }
        return false;
    }
    
    /** 
     * retorna o hashCode do estado
     * (usado para poda, conjunto de fechados)
     */
    @Override
    public int hashCode() { 
        return (""+this.Ce + this.Me + this.Cd +this.Md + this.barco).hashCode();
    }
    
    @Override
    public String toString() {
        return "(" + this.Ce + "," + this.Me + "|" + this.Cd +"," + this.Md + "|" + this.barco + ") --> "  + op + "\n";
    }
    
    public static void main(String[] a) {
        /*Inicia o problema com todos canibais e missionarios no lada esquedo do rio*/
        /*ordem das variaveis: Qtd Canibais ESQ, Qtd Missionarios Esq, Qtd Canibais DIR, Qtd Missionario DIR, Margem que o barco se encontra*/
        TravessiaCanMis estadoInicial = new TravessiaCanMis(3,3,0,0,'e',"estado inicial - todos na esquerda");
        
        // chama busca em profundidade
        System.out.println("busca em ....");
        Nodo n = new BuscaProfundidade(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("\tSOLUCAO:\nQtd Canibais na Esq, Qtd Missionario na Esq | Qtd Canibais na Dir, Qtd Missionario na Dir | Lado que esta o barco\n\n" + n.montaCaminho() + "\n\n");
        }
    }
}
