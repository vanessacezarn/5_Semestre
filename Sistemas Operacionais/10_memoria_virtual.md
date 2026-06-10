<div align="center">

  # Memória Virtual </div>

- perite a execução de programas que não são carregados completamente na memória física
<div align="center">

## Conceitos Iniciais </div>
#### mecanismos básicos de páginação
- ao acontecer um acesso à memória
  - busca tabela de páginas
  - bit v ➜
  - bit i ➜

#### Page Fault (falta de página)
#### Paginação por Demanda

<div align="center">

## Substituição de páginas na memória </div>
- ao acontecer Page Fault há necessidade de uma pagina

<div align="center">

## Algoritmos de Substituição de Página (Page-Replace Algor ) </div>
#### Algortimo Ótimo
- coloca a falta de página em um futuro mais longe ➜ menor taxa de falta de páginas
- conhecido com OPT ou MIN

#### FIFO
- a página escolhida para ser substituída é a página que está há mais tempo na memória
- MMU deve ter uma lista com os números das páginas lógicas ➜ quando uma página é carregada na memória, seu número é colocado no final da lista
- desempenho ruim ➜ não considera que a página foi acessada

#### LRU (Least Recently Used)
- escolhe a página que a mais tempo não é usada ➜ considera que as páginas acessadas recentemente por um processo serão acessadas novamente num futuro próximo
- exige suporte de hardware ➜ registradores adicionais
- alto custo para manter a tabela de páginas

<div align="center">

## Buffer de páginas </div>
- usado em conjunto com um algoritmo de substituição de páginas

<div align="center">

## Alocação de Quadros </div>

- quadros = páginas físicas

<div align="center">

## Thrashing </div>
- ocorre quando a maior parte do tempo é usada para 
- tratamento de falta de páginas é mais lento que o acesso normal à memória
- quando um processo possui um número muito pequenos de 
- consequência ➜ queda global de desempenho do sistema
----
#### anotações
- tabela de paginas faz o 'link' entre memoria logica e memoria fisica
- disco = memoria virtual --> quando não ha espaço na memoria fisica
  - vai pro disco e fica na espera por pagina ate 'abrir espaço' para que ele possa executar --> escolhe uma 'vitima' para substituir a pagina, a pagina escolhida vi para o disco, portanto libera uma pagina, e o processo que estava esperando passa a executar
