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
# MOTORES DE RACIOCÍNIO
- algortimo que buscam solução de problema
    - busca de força bruta (mais processamento e mais consumo de memória) ➜ SEMPRE CHEGA NA SOLUÇÃO MELHOR
    - busca de heurística (menos processamento e menos consumo de memória) ➜ NEM SEMPRE CHEGA NA MEHOR SOLUÇÃO (depende da herítica)
- solucionar um problema com métodos de busca exige a modelagem de:
    - estados
    - regras de transição
    - restrições
    - visitantes (lista ou hash)
    - função objetivo (saber se o sistema atingiu a solução) 
## MÉTODOS DE BUSCA
