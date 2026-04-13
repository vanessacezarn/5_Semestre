package org.example.join_threads;

public class Principal {
    public static void main(String[] args) {
        DownloadThread download = new DownloadThread();
        download.start();

        try{
            download.join(); //espera a thread terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Continuando execução da main");
    }
}
