package org.example.join_threads;

public class DownloadThread extends Thread {
    public void run() {
        System.out.println("Iniciando download");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Download concluido!!!");
    }
}
