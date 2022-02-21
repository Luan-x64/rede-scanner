import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.Spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




public class main {
		private static void retornaSistema() {
	        Properties properties = System.getProperties();
	        String sistema = System.getProperty("os.name");
	       
	        if(sistema.equals("Linux")) {
	        	//System.out.println("Linux");
	        } else if(sistema.equals("Windows 7")) {
	        	//System.out.println("Windows 7");
	        } else {
	        	//System.out.println("Outro so");
	        }
		}
		static Connection conn = null;
		static Statement stmt = null;
		static ResultSet rs = null;
		private static int i2;
		static String ip1;
		static int timeout = 35; //200
		static int porta1;
		static int porta2;
		static int porta3;
		private static String ips;
		static String ipsAtivos[];
		static int portMax = 255;
		static int contador = 0;
		static String arquivo;
		static int IP1;
		static int IP2;
		static int IP3;
		static int IP4;
		public static void main(String[]  args) throws IOException  {
			retornaSistema();
			
			//UI ui = new UI();
			//ui.Entry();
			if(args.equals(null)) {
				//System.out.print("inciando");
			}
			String opcaoSelecionada;
	
		    Scanner ip = new Scanner(System.in);
			Scanner porta = new Scanner(System.in);
			Scanner porta21 = new Scanner(System.in);
			Scanner porta23 = new Scanner(System.in);
			Scanner opcao = new Scanner(System.in);
			Scanner IpInicia = new Scanner(System.in);
			Scanner arquivo1 = new Scanner(System.in);

				IP1 = 45;
				
				IP2 = 175;
				IP3 = 168;
				
				IP4 = 0;
		
				porta1 = 8080;
				porta2 = 8090;
				porta3 = 8081;
				arquivo = "auto";	
			
			
			
			scan(ip1, porta1);
			
	
			//if(portIsOpen(ip1, porta1, timeout)) {
			//	System.out.println("Porta " + porta1 + " aberta em " + ip1);
			//	main(args);
			//} else	{
			//	System.out.println("Porta " + porta1 + " fechada ");
			//	main(args);
			//}
	
			
			
			
			
		}
		
		public static boolean portIsOpen(String ip, int port, int timeout) {
		    try {
		    	//System.out.println(ip);
		        Socket socket = new Socket();
		        socket.connect(new InetSocketAddress(ip, port), timeout);
		        socket.close();
		        return true;
		    } catch (Exception ex) {
		        return false;
		    }
		}

		
		public static Object scan(String ip, int port) throws IOException {
			File file = new File(arquivo + ".txt");
		    FileWriter arq = new FileWriter(arquivo + ".txt", true);
			PrintWriter gravarArq = null;

				//aqui
				//comecei no 187.0
				int contador_scan = 0;
				while( IP1 <= portMax) {	
					while( IP2 <= portMax) {
						while(IP3 <= portMax) {
							
							while( IP4 <= portMax) {
								
								ips = IP1 + "." + IP2 + "." + IP3 + "." + IP4;
								contador_scan = contador_scan + 1;
								if(portIsOpen(ips, porta1, timeout)) {
									//System.out.println("Porta " + porta1 + " aberta em " + ips);
									contador = contador + 1;
									//System.out.println("IPS ENCONTRADOS: " + contador);
									arq = new FileWriter(arquivo  + ".txt", true);
									gravarArq = new PrintWriter(arq);
									gravarArq.println(ips + ":" + porta1);
									gravarArq.close();
									
									
									

									
									
								} else	{
									
									//System.out.println("Porta " + porta1 + " fechada ");
								}
								if(portIsOpen(ips, porta2, timeout)) {
									//System.out.println("Porta " + porta2 + " aberta em " + ips);
									arq = new FileWriter(arquivo  + ".txt", true);
									gravarArq = new PrintWriter(arq);
									gravarArq.println(ips + ":" + porta2);
									gravarArq.close();
									contador = contador + 1;
									//System.out.println("IPS ENCONTRADOS: " + contador);

									
									

									
									
								} else	{
									
									//System.out.println("Porta " + porta2 + " fechada ");
								}
								if(portIsOpen(ips, porta3, timeout)) {
									//System.out.println("Porta " + porta3 + " aberta em " + ips);
									arq = new FileWriter(arquivo  + ".txt", true);
									gravarArq = new PrintWriter(arq);
									gravarArq.println(ips + ":" + porta3);
									gravarArq.close();
									contador = contador + 1;
									//System.out.println("IPS ENCONTRADOS: " + contador);

									
									

									
									
								} else	{
									
									//System.out.println("Porta " + porta3 + " fechada ");
									//System.out.println("IPS ESCANEADOS: " + contador_scan);
									//System.out.println("IPS ENCONTRADOS: " + contador);
								}
								//System.out.println(ips);
								IP4++;
									
					
							}
							IP4 = 0;
							IP3++;
							
						}
						IP4 = 0;
						IP3 = 0;
						IP2++;
					}
					IP2 = 0;
					IP3= 0;
					IP4 = 0;
					IP1++;
					
				}
				//System.out.println("Foram encontrados " + contador + " IPS!");
				return gravarArq;
				
			
		}
	


}
