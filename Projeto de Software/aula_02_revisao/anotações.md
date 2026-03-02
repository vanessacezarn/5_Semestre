# VISÃO GERAL - REVISÃO
## Modelagem de sistema de software
- complexeidade de desenvolvimento de um software aumenta à medida que o tamanho do sistema cresce
- para sistemas mais complexo é necessário planejamento inicial ou desenvolvimento de um modelo
#### Motivos para utilizar modelos
1) Gerenciamento da complexidade
    - pode haver diversos modelos de um mesmo sistema, cada qual descrevendo uma perspectiva do sistema a ser construído
2) Comunicação entre pessoas envolvidas
    - o desenvolvimento do sistema envolve a execução de diversas atividades, as quais se traduzem em informações sobre o sistema
3) Redução de custos no desenvolvimento
4) Previsão do comportamento futuro do sistema
     - o comportamento pode ser discutido mediante análise do seu modelo, estes servem como laboratório em diferentes soluções para um problema relacionado à construção do sistema
#### Paradigma da Orientação a Objetos = FORMA DE ABORDAR UM PROBLEMA
- construir um sistema de software a partir de agentes autômatos que interagem entre si
- princípios da orientação a objetos:
    - qualquer coisa é um objeto
    - objetos realizam tarefas por meio de requisições de serviços a outros objetos
    - cada objeto pertence a uma determinada classe, uma classe agrupa objetos similares
    - a classe é um repositório para comportamentos associados ao objeto
    - classes são organizadas em hierarquias
- um sistema de software orientado a objetos consiste em objetos em colaboração com o objetivo de realizar as funcionalidades do sistema
#### Classe e objeto
- classe é como um molde a partir do qual objetos são construídos
#### Operação
- alguma ação que o objeto sabe realizar quando solicitado --> método
- para que uma operação em um objeto seja executada, deve haver estímulos enviados a esse objeto
#### Mensagem 
- quando ocorre um estímulo diz-se que o objeto está recebendo uma mensagem requisitando alguma operação
- em orientação a objeto quando se diz que objetos estão trocando mensagens significa que esses objetos estão enviando mensaggens com objetivo de realizar alguma tarefa dentro sistema que estão
#### Estado
- de um objeto corresponde ao conjunto de valores de seus atributos em dado momento
- uma mensagem tem potencial de mudar o estado desse objeto
#### Abstração na orientação a objetos
- é um processo mental no qual nos atemos aos aspectos mais relevantes de alguma coisa
  #### Encapsulamento 
  - forma de restringir o acesso ao comportamento interno de um objeto
  - public, private, protected
  #### Polimorfismo
  - princípio pelo qual duas ou mais classes derivadas da mesma superclasse podem invocar métodos que têm a mesma assinatura, mas com  comportamentos distintos
  - exemplo: mais de um construtor na mesma classe
  - overload e override
  #### Generalização (herança)
  - é outra forma de abstração utilizada na orientação a objetos
  - declara que as características e comportamentos comuns a um conjunto de objetos podem ser abstraídos em uma classe
  - representação em qualquer diagrama é um triangulo, topo aponta para classe-mãe/origem e base para as classes filhas
  #### Composição
  - objetos compostos por outros objetos
  - exemplo: classe pessoa é composta pela classe telefone
---
## UML E visões de um sistema
- Linguagem de Modelagem Unificada (UML) seus autores sugerem que um sistema pode ser descrito por cinco visões interdependentes desse sistema
### Visões de um sistema
- o desenvolvimento do sistema do software complexo demanda que seus desenvolvedores tenham a possibilidade de examinar e estudar esses sistema a partir de perspectivas diversas
<div align="center"><img width="482" height="259" alt="{29415B30-5E6E-4AFD-AAA4-ED0C215BF359}" src="https://github.com/user-attachments/assets/a6f16422-76d8-45a0-89c3-2c5c02111b56" />
</div>

#### 1) Visão de Casos de Uso
- descreve o sistema de um ponto de vista externo como um conjunto de interações entre o sistema e os agentes externos ao sistema
#### 2) Visão de Projeto
- enfatiza as características do sistema que dão suporte, tanto estrutural quanto comportamental, às funcionalidades externamente visíveis do sistema
#### 3) Visão de Implementação
- abrage o gerenciamento de versões do sistema, construídas pelo agrupamento de módulos e subsistemas
#### 4) Visão de Implantação
-   corresponde à distribuição física do sistema em seus subsistemas e à conexão entre essas partes
#### 5) Visão de Processo
- esta visão enfatiza as características de concorrência(paralelismo), sincronização e desempenho do sistema

### Diagramas da UML
- artefatos de software, documentos que podem ser textuais ou gráficos, são os artefatos que compõem as visões do sistema
- os 13 diagramas da UML 2.0
<div align="center">
    <img width="564" height="305" alt="{74579CC8-7647-4FC6-987D-5E1889D37140}" src="https://github.com/user-attachments/assets/591861a7-e5a4-489a-86ef-e59828051dc9" />
</div>
-  na discipla será trabalhada a organizaçao F.F.D.

---

## Processo de desenvolvimento de software

```mermaid
    graph LR;
        COMUNICAÇÃO-requisitos_software --> PLANEJAMENTO-custo_tempo;
        PLANEJAMENTO-custo_tempo --> PROJETO-UML;
        PROJETO-UML --> CONSTRUÇÃO-código;
        CONSTRUÇÃO-código --> ENTREGA-manutenção
```

