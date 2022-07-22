package com.gontzal.ipartek.uf1844;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServidor {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(2002);
				Socket s = ss.accept();
				Scanner sc = new Scanner(s.getInputStream());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH)) {
			
			String cerrar="";
			pw.println("Binvenido al servidor | quit para cerrar");

			do {
			String texto = sc.nextLine();

			pw.println(texto.toUpperCase());
			}while(cerrar.equals("quit"));
		} catch (IOException e) {

			System.out.println("Ha habido un problema de comunicación");
		}
	}
}
