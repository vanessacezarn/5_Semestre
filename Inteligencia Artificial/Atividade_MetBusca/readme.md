# Atividade de IA - Métodos de Busca
### Tarefa

Modelar e implementar (utilizando o pacote buscaJava.jar, do professor Jomi Hubner) o problema dos missionários e canibais.

### Descrição do problema:

Três missionários e três canibais estão à beira de um rio e dispõem de um barco com capacidade para apenas duas pessoas. O problema consiste em determinar as tripulações de uma série de travessias de forma que todo o grupo atravesse para o outro lado do rio, respeitando a condição de que, em nenhum momento, os canibais sejam mais numerosos do que os missionários em qualquer uma das margens.

---

### Modelagem do Problema

1) Estados: 
    - estado inicial :
        - Ce = 3, Cd = 0, Me = 3, Md = 0, barco = 'e'
            - todos canibais e missionários na mesma margem, nesse caso todos iniciaram na esquerda 
        - variáveis do tipo int que representam a quantidade de canibais e missionarios em cada margem do rio 
            - Ce = total de canibais na margem esquerda
            - Cd = total de canibais na margem direita
            - Me = total de missionarios na margem esquerda
            - Md = total de missionarios na margem direita
        - variavel do tipo char 
            - barco = localizar em que lado esta o barco
2) Regras de Transição:
    - canibalSozinho
    - missionarioSozinho
    - doisCanibais
    - doisMissionarios
    - canibalMissionario
3) Restrições:
    - Número de canibais NUNCA pode ser maior que o número de missionários, se tiver algum, em uma das margem
        - if(Me > 0 && Ce > Me) return false
        - if(Md >0 && Cd > Md)  return false
    - não pode ter numero de canibais ou missionario menor que zero ou maior que 3
        if (Ce < 0 || Ce > 3 || Cd < 0 || Cd > 3) return false;
        if (Me < 0 || Me > 3 || Md < 0 || Md > 3) return false;
4) Visitados:
    - armazena os estados que já foram visitados
    - os estados já visitados ficam armazenados em um string de concatenação das 4 variaveis do problema na ordem (Ce,Cd,Me,Md,barco)
5) Função Objetivo:
    - Ce = 0, Cd = 3, Me = 0, Md = 3,barco='d';
        - que todos tenham atravessado para outra margem
