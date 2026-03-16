# VISÃO GERAL - REVISÃO
- itens abordados nessa revisão:
    - Modelagem
    - UML
    - Processo de desenvolvimento
    - Participantes do projeto
## ➤ Modelagem de sistema de software
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
## ➤ UML e visões de um sistema
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

## ➤ Processo de desenvolvimento de software

```mermaid
    graph LR;
        COMUNICAÇÃO-requisitos_software --> PLANEJAMENTO-custo_tempo;
        PLANEJAMENTO-custo_tempo --> PROJETO-UML;
        PROJETO-UML --> CONSTRUÇÃO-código;
        CONSTRUÇÃO-código --> ENTREGA-manutenção
```

### Atividades típicas de um processo de desenvolvimento
1) Levantamento de requisitos
    - compreensão do problema aplicada ao desenvolvimento de software
    - objetivo: usuários e desenvolvedores tenham a mesma visão do problema a ser resolvido
    - requisitos são identificados a partir de um domínio ou problema de negócio ( área caracterizada por um conjunto de conceitos e terminologias compreendidas por especialistas na área, ou seja, a parte relevante do mundo real para o desenvolvimento do sistema)
        - requisitos funcionais = funcionalidades do sistema
        - requisitos não funcionais = características de qualidae que o sistema deve possuir e que estão relacionadas às suas funcionalidades
        - requisitos normativos = impostas sobre o desenvolvimento do sistema, por exemplo, adequação de custos e prazos, aspectos legais, componentes de hardware e software. Está incluso as regra de negócio
    - medir a qualidade de um sistema de software é atráves da qualidade = será útil se os requisitos definidos forem atendidos e refletirem as necessidades dos usuários. 
2) Análise
    - etapa em que analistas realizam um estudo detalhado dos requisitos levantados na atividade anterior
    - a partir do estudo são construídos modelos para representar o sistema a ser construído
    - principais ferramentas da UML para análise:
        - diagrama de casos de uso (funcionalidades e fluxos)
        - diagrams de classes
    - foco principal = aspectos lógicos e independentes de implementação de um sistema  
3) Projeto
    - definição de como o sistema funcionará para atender os requisitos
    - são adicionadas as restrições de tecnologias aos modelos construídos na fase de análise
    - composto por duas atividades principais:
        - projeto da arquitetura ou de alto nível = distribuir as classes de objetos relacionadas do sistema em subsistemas e seus componentes, distribuir os componentes fisicamente pelos recursos de hardware disponivel ➜ normalmente utiliza diagramas de implementação
        - projeto detalhado ou de baixo nível = são modelados as colaborações ente os objetos de cada módulo com o objetivo de realizar suas funcionalidades, são realizadas projeto de interface com usuário, projeto de banco de dados ➜ diagramas utilizados: diagrama de classes, diagrama de casos de uso, diagrama de interação, diagrama de estado e diagrama de atividade
4) Implementação
    - sistema é codificado
5) Teste
    - verificação do sistema construído, os requisitos foram atendindo
    - relatórios de testes = informações sobre erros detectados no software
    - tipos básicos de testes:
        - teste de unidades: sobre elementos do código-fonte do sistema
        - teste de integração: sobre operações do sistema 
6) Implantação
   - sistema é empacotado, distribuido e instalado no ambiente do usuário
   - manuais do sistema
   - treinamento dos usuários
---
## ➤ Participantes do processo
#### gerente do projeto
- responsável pela gerência das atividades na construção do sistema
    - exemplo: orçamento do projeto, estimar o tempo para o desnevolvimento do sistema, ...
#### Analista
- profissional que deve ter conhecimento do domínio do negócio e entender seua problema para definir os requisitos
- devem se comunicar com especialistas do domínio para obter conhecimento acerca dos problemas e das necessidades envolvidas
#### Projetista
- avalia as alternativad de solução do problema resultante da análise
- gerar a especicficação de uma solução computacional detalhada
#### Arquitetos de Software
- elaborar a arquitetura do sistema como um todo
- toma decisões sobre quais subsistemas compõem o sistema como um todo e quais são as interfaces entre esses subsistemas.
-  deve ser capaz de tomar decisões técnicas detalhadas 
#### Programadores
- responsável pela implementação do sistema
#### Especialistas do domínio ou de negócio
- indivíduo que possui conhecimento acerca da área ou do negócio em que o sistema em desenvolvimento estará inserido
- termo mais amplo que especialista de domínio é cliente
- dois tipos de cliente:
    - cliente usuário: indivíduo que efetivamente utiliza o sistema
        - geralmente é quem o analista de sistemas interage para levantar os requisitos do sistema
    - cliente contratante : indivíduo que solicita o desenvolvimento do sistema
#### Avaliadores de qualidade
- desempenho e confiabilidade são exemplos de características que devem ser encontrada no software
- asseguram a adequação do processo de desenvolvimento e do produto de software sendo desenvolvido aos padrões de qualidade estabelecidos pela organização
---
