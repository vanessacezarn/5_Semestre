### Revisão 
- IA ➜ metodologia e técnica/método para projeção e construção de **sistemas com compartamentos inteligentes**
    - base de conhecimento (PROLOG; SMA ; RNA)
        - estruturada = banco de dados
        - não estrurada  fatos, regras, experiência
    -  motores de raciocínio (Métodos de busca ; Sistemas Multi Agentes)
        - dedução ou indução
          - profundidade e largura (força bruta)
          - subida de encosta, guloso, A*, Algoritmos Genéricos (heurísticas (dica))
    - aprendizado de máquina ou reconhecimento de padrão por amostra (redes neurais articiais)
        - repetição e volume de amostras
- tipos de problemas adequado para IA
    - diagnóstico ➜ reconhecimento de padrões (substituir o especialista)
    - 'empacotamento' ➜ descobrir o estado final e/ou os passos até o estado final
# MOTORES DE RACIOCÍNIO - métodos de busca
- algortimo que buscam solução de problema
    - busca de força bruta (mais processamento e mais consumo de memória) ➜ SEMPRE CHEGA NA SOLUÇÃO MELHOR
    - busca de heurística (menos processamento e menos consumo de memória) ➜ NEM SEMPRE CHEGA NA MEHOR SOLUÇÃO (depende da herítica)
- solucionar um problema com métodos de busca exige a **modelagem** de:
    - estados
    - regras de transição
    - restrições
    - visitantes (lista ou hash)
    - função objetivo (saber se o sistema atingiu a solução)
---
### problema da jarra
há duas jarras, uma jarra1 com 4 litros e outra jarra2 com 3 litros, também há uma torneira que jorra água infinitamente. o problema é deixar 2 litros em alguma das jarras.
    
 - modelagem do método de busca:
    1) estados
        - estado inicial : jarra1 = 0 e jarra2 = 0 
    2) regras de transição
        1) encher a jarra1
        2) encher a jarra2
        3) esvaziar jarra1
        4) esvaziar jarra2
        5) despejar jarra1 em jarra2
        6) despejar jarra2 em jarra1 
    3) restrições
        - não há      
    4) visitantes(já foi visitado)
       - armazenar os estados que já foram visitados
    5) função objetivo (foi alcançado o objetio)
        - jarra1 == 2 && jarra2 == 0 || jarra1 == 0 e jarra2 == 2 

---
revisão 

