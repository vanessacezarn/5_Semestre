# Inteligência Artificial
metodologia e técnica/método para projeção e construção de **sistemas com compartamentos inteligentes**

#### ➥ Base de Conhecimento (PROLOG; SMA ; RNA)
- estruturada = banco de dados
- não estrurada  fatos, regras, experiência
#### ➥ Motores de Raciocínio (Métodos de busca ; Sistemas Multi Agentes) ➜ DEDUÇÃO e INDUÇÃO
- ALGORITMOS DE BUSCA    
  - Força Bruta ou Cega (dedução)
    - profundidade  ➜ pilha
    - largura/amplitude ➜ fila
  - Informado ou Heurísticos
    - CUSTOS
        - real g(n) - o quanto realmente custa para chegar 
        - estimado ou heurístico h(n) - estimado pela especialista ➜ pode ser admissível ou inadimissível
    - Métodos
        - Subida de Encosta ➜ baseado no profundidade e foca no custo real
        - Guloso ➜ baseado no amplitude e foca no custo estimado
        - A* ➜ baseado no amplitude e soma custo real (acumulado) com custo estimado ➜ com isso, pode corrigir a heurística
            - a heurística é **estática**  
#### ➥ Aprendizado de Máquina ou reconhecimento de padrão por amostra (redes neurais articiais)
- repetição e volume de amostras

### ➤ Tipos de problemas adequado para IA
- diagnóstico ➜ reconhecimento de padrões (substituir o especialista)
- 'empacotamento' ➜ descobrir o estado final e/ou os passos até o estado final (não se sabe como chegar no estado final) 
--- 
# MÉTODOS DE BUSCA
- busca o que? ➜ busca soluções para problemas
- o que seriam essas soluções?
    - gerar ou atingir Estado(s) desejado(s)
    - gerar ou produzir passo-a-passo até o Estado(s) desejados(s)
- não faz diagnóstico, ou seja, ela resolve os problemas de 'empacotamento'
  
#### ➥ Força Bruta
- profundidade  ➜ pilha
- largura/amplitude ➜ fila

#### ➥ Heurístico
  - custo:
    - Real: Subida de Encosta | A*
    - Estimado: Guloso | A*  

#### ➤ Principio é GERAR e TESTAR
  - gerar um novo estado clonado
  - testar
    - ehValido
    - visitado
    - ehMeta
#### ➤ Modelagem:
  - Estados ➜ Estrutura de Dados ➜ atributos e variáveis
  - Regras de Transição ➜ métodos
  - Restrições ➜ ifs e validações
  - Estrutura de visitados ➜ listas ou HashMaps
  - Função meta ou objetivo
