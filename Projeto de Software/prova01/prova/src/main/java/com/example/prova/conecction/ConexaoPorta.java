package com.example.prova.conecction;

import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Component;
@Component
public class ConexaoPorta {
    private SerialPort serialPort;

    public ConexaoPorta() {
        this("COM5", 9600);
    }

    public ConexaoPorta(String portaCOM, int taxa) {

        serialPort = SerialPort.getCommPort(portaCOM);
        serialPort.setBaudRate(taxa);
        serialPort.setNumDataBits(8);
        serialPort.setNumStopBits(SerialPort.ONE_STOP_BIT);
        serialPort.setParity(SerialPort.NO_PARITY);



        if (serialPort.openPort()) {
            System.out.println("Porta aberta com sucesso: " + portaCOM);
        } else {
            System.out.println("Erro ao abrir a porta: " + portaCOM);
        }
    }

    public void enviaDados(char opcao) {
        if (serialPort != null && serialPort.isOpen()) {
            byte[] dados = new byte[]{(byte) opcao};
            serialPort.writeBytes(dados, dados.length);
            System.out.println("Enviado para o Arduino: " + opcao);
        } else {
            System.out.println("Porta serial não está aberta.");
        }
    }

    public void close() {
        if (serialPort != null && serialPort.isOpen()) {
            serialPort.closePort();
            System.out.println("Porta fechada.");
        }
    }
}
