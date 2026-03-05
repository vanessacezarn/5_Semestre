## Métodos de Busca
- para mudanças de estados sempre fazer 3 perguntas:
  - 1) heValido
    2) já foi visitado
    3) ehMeta
- **profundidade** = percorrer todo galho antes de voltar para o nó principal
  - nem sempre entrega a melhor solução = sempre entrega a primeira solução que encontra
  - na IA não pode usar recursão queando for profundidade
  - vai "cortando" os caminhos que não atendem as 3 perguntas da mudança de estado = logo não consome tanta memória
  - usa pilha
```
        1
  2      5      8
3  4    6  7   9  10
```
- **amplitude** = percorre por "nivel" a árvore
  - acha todas as soluções possiveis
  - a que mais consome memória
  - em geral é mais utilizada
  - usa fila
```
         1
  2      3       4
5  6    7  8   9  10
```
---
## Problema
- Problema do Homem, Lobo, Alface e Carneiro
     - Duas margens de rio com uma canoa. O único que rema é o homem. O objetivo é levar todos da margem esquera para margem direita.
    - Entretanto, só um passageiro com o remador (homem) é possível. E não se pode deixar sozinhos na margem um Carneiro com alface e um Carneiro com o lobo.
    -  qual é a sequencia de passos necessários para levar todos para a outra margem.
#### Modelagam
1) estados
2) regras de transição
3) restrições
4) visitados
5) função objetivo

```.java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula03;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;
import busca.MostraStatusConsole;

public class Homem implements Estado {
    
    @Override
    public String getDescricao() {
        return " Problema do Homem, Lobo, Alface e Carneiro";
    }
    
    /*final int TAM1 = 4; //capacidade da jarra1
    final int TAM2 = 3; //capacidade da jarra2
    */
    final String H , L, A, C ;
    final String op; // operacao que gerou o estado
    
    
    /** construtor para o estado, recebe cada valor de atributo */
    public Homem(String H, String L, String A, String C, String op) {    
        this.H = H;
        this.L = L;
        this.A = A;
        this.C = C;
        this.op = op;
    }

    /**
     * verifica se o estado final foi atingido
     */
    @Override
    public boolean ehMeta() {
        return H.equals("d") && L.equals("d") && A.equals("d") && C.equals("d") ;
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
    
    /*Apenas o homem troca de margem*/
    private void levarNada(List<Estado> visitados) { 
        if(H.equals("e")){
            Homem novo = new Homem("d",this.L,this.A, this.C,"Homem trocando de margem sozinho");
            if (!visitados.contains(novo)) visitados.add(novo);
        }else if(H.equals("d")) {
            Homem novo = new Homem("e",this.L,this.A, this.C,"Homem trocando de margem sozinho");
            if (!visitados.contains(novo)) visitados.add(novo);
        }
    }
    /*Homem leva o lobo = para isso tem que estarem no mesmo lado
        !! Carneiro e Alface não podem ficar sozinhos na mesma margem
    */
    private void levarLobo(List<Estado> visitados) {
        Jarras novo = new Jarras(this.jarra1,TAM2,"Enchendo a jarra2");
        if (!visitados.contains(novo)) visitados.add(novo);
    }
    
    private void levarAlface(List<Estado> visitados) {
        Jarras novo = new Jarras(0,this.jarra2,"Esvaziando a jarra1");
        if (!visitados.contains(novo)) visitados.add(novo);
    }
    
    private void levarCarneiro(List<Estado> visitados) {
        Jarras novo = new Jarras(this.jarra1,0,"Esvaziando a jarra2");
        if (!visitados.contains(novo)) visitados.add(novo);
    }
    /*
    private void despejarJarra1EmJarra2(List<Estado> visitados) {
        int j1 = this.jarra1;  //clone
        int j2 = this.jarra2;  //clone para gerar novo estado
        
        if (j1 > (TAM2 - j2)){
            j1 = j1 - (TAM2 - j2);
            j2 = TAM2;
        } else {
            j2 = j2 + j1;
            j1 = 0;
        }
        Jarras novo = new Jarras(j1,j2,"Despejando jarra1 em jarra2");
        if (!visitados.contains(novo)) visitados.add(novo);
    }
    
    private void despejarJarra2EmJarra1(List<Estado> visitados) {
        int j1 = this.jarra1;  //clone
        int j2 = this.jarra2; //clone para gerar novo estado
        
        if (j2 > (TAM1 - j1)){
            j2 = j2 - (TAM1 - j1);
            j1 = TAM1;
        } else {
            j1 = j2 + j1;
            j2 = 0;
        }
        Jarras novo = new Jarras(j1,j2,"Despejando jarra2 em jarra1");
        if (!visitados.contains(novo)) visitados.add(novo);
    }*/
 
    /**
     * verifica se um estado e igual a outro
     * (usado para poda)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Jarras) {
            Jarras e = (Jarras)o;
            return this.jarra1 == e.jarra1 && 
                   this.jarra2 == e.jarra2;
        }
        return false;
    }
    
    /** 
     * retorna o hashCode do estado
     * (usado para poda, conjunto de fechados)
     */
    @Override
    public int hashCode() { 
        return (""+this.jarra1 + this.jarra2).hashCode();
    }
    
    @Override
    public String toString() {
        return "(" + this.jarra1 + "," + this.jarra2 + ") "  + op + "\n";
    }
    
    public static void main(String[] a) {
        Homem estadoInicial = new Homem("e","e","e","e", "estado inicial");
        
        // chama busca em largura
        System.out.println("busca em ....");
        Nodo n = new BuscaLargura(new MostraStatusConsole()).busca(estadoInicial);
        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
        }
    }
}


```
