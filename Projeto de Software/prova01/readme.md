# Automação WEB com Java, Spring Boot e Arduino
Nesta atividade, deverá ser desenvolvido uma aplicação simples para controlar LEDs conectados ao Arduino por meio de uma aplicação Java/Spring Boot. A comunicação entre o sistema Java e o Arduino será realizada pela porta serial utilizando a biblioteca jSerialComm.

## Objetivos da atividade
- Compreender o funcionamento básico da comunicação serial
- Programar o Arduino para receber comandos pela porta serial
- Utilizar Java para enviar dados ao Arduino
- Integrar a comunicação serial com uma aplicação Spring Boot
- Criar uma interface web simples para ligar e desligar LEDs

## Arduino 
A montagem deverá utilizar os seguintes elementos: arduino, cabo USB, protiboard, led, resistores e jumpers. A seguir a uma ilustração de como deve ser montado o arduino.
<div align="center">
    <img width="492" height="428" alt="image" src="https://github.com/user-attachments/assets/b25427b9-eca3-4961-bf0b-1e1873d14351" />

</div>

## Requisitos da atividade

Além da comunicação com o Arduino, o sistema desenvolvido deve seguir uma arquitetura baseada no padrão MVC.

- A aplicação deve possuir:
    - Model: classes responsáveis por representar os dados do sistema, como o histórico de acionamento dos LEDs;
    - View: páginas web responsáveis por exibir os botões de controle e a tabela com o histórico;
    - Controller: classes responsáveis por receber as requisições da interface web e acionar as regras de negócio;
    - Service: classe responsável por concentrar a lógica de comunicação com o Arduino e o registro das ações realizadas;
    - Repository: interface responsável pela persistência dos dados no banco.

Sempre que o usuário clicar em Ligar ou Desligar, o sistema deve enviar o comando correspondente ao Arduino e registrar no banco de dados um histórico da ação realizada.

- O histórico deve conter, no mínimo:
    - Identificador do registro;
    - Ação realizada: LIGADO ou DESLIGADO;
    - Data e hora da ação.

- A página principal do sistema deve exibir:
    - Um botão para ligar os LEDs;
    - Um botão para desligar os LEDs;
    - Uma tabela com o histórico de acionamentos

