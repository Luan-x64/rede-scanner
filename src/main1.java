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




public class main1 {
		private static void retornaSistema() {
	        Properties properties = System.getProperties();
	        String sistema = System.getProperty("os.name");
	       
	        if(sistema.equals("Linux")) {
	        	System.out.println("Linux");
	        } else if(sistema.equals("Windows 7")) {
	        	System.out.println("Windows 7");
	        } else {
	        	System.out.println("Outro so");
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
				System.out.print("inciando");
			}
			int opcao1;
			String opcaoSelecionada;
	
		    Scanner ip = new Scanner(System.in);
			Scanner porta = new Scanner(System.in);
			Scanner porta21 = new Scanner(System.in);
			Scanner porta23 = new Scanner(System.in);
			Scanner opcao = new Scanner(System.in);
			Scanner IpInicia = new Scanner(System.in);
			Scanner arquivo1 = new Scanner(System.in);

		
			System.out.println("Escolha uma das opções de range:");
			System.out.println("1 - COMPLETAR APENAS 192.168.1.* ");
			System.out.println("2 - COMPLETAR APENAS 192.168.*.* ");
			System.out.println("3 - COMPLETAR APENAS 192.*.*.* ");
			System.out.println("4 - SCCANNER REDE ALL IPS ");
			opcao1 = opcao.nextInt();

	
			
			
			if(opcao1 == 2) {
				System.out.println("De qual range de ip você deseja começar o scan da range? [Enter para 0 para padrão] ");
				System.out.println("Ex: 192.168.'25'.*");
				System.out.println("    192.168.'26'.*");
				System.out.println("    192.168.'27'.*");
			} else if (opcao1 == 1) {
				System.out.println("De qual range de ip você deseja começar o scan? [Enter para 0 para padrão] ");
				i2 = IpInicia.nextInt();
				if(IpInicia.equals(null)) {
					i2 = 0;
				}
			} else if (opcao1 == 4) {
				System.out.println("Digite O ip na sequencia 1.2.3.4 ");
				System.out.println("1º ");
				IP1 = IpInicia.nextInt();
				System.out.println("2º ");
				IP2 = IpInicia.nextInt();
				System.out.println("3º ");
				IP3 = IpInicia.nextInt();
				System.out.println("4º ");
				IP4 = IpInicia.nextInt();
				System.out.print("Digite uma porta: ");
				porta1 = porta.nextInt();
				System.out.println("Digite mais uma porta");
				porta2 = porta21.nextInt();
				System.out.println("Digite mais uma porta");
				porta3 = porta23.nextInt();
				
			} else {
				System.out.print("Digite o ip: (Ex Range: 177.187.2  O PROXIMO . E NUMERO SERA AUTOMATICO ");
				ip1 = ip.next();
				System.out.print("Digite uma porta: ");
				porta1 = porta.nextInt();
				
				System.out.println("Digite mais uma porta");
				porta2 = porta21.nextInt();
			}
			
			
			
			
			
		
			System.out.println("Digite o nome desejado para o arquivo : Ex:forabolsonaro que ele será salvo como forabolsonaro.txt");
			arquivo = arquivo1.next();	
			
			
			
			scan(ip1, porta1, opcao1);
			
	
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

		
		public static Object scan(String ip, int port, int Opcao) throws IOException {
			File file = new File(arquivo + ".txt");
		    FileWriter arq = new FileWriter(arquivo + ".txt", true);
			PrintWriter gravarArq = null;
			
			
			switch (Opcao) {
			case 1: { 
				while(i2 <= portMax) {
					
					ips = ip1 + "." + i2;
					System.out.println(ips );
					if(portIsOpen(ips, porta1, timeout)) {
						System.out.println("Porta " + porta1 + " aberta em " + ips);
						arq = new FileWriter(arquivo + ".txt", true);
						gravarArq = new PrintWriter(arq);
						gravarArq.println(ips + ":" + porta1);
						gravarArq.close();
						contador = contador + 1;
					
						
						
						

						
						
					} else	{
						System.out.println("Porta " + porta1 + " fechada ");
					}
				i2++;
			}
			
			break;
			}
			case 2: {
			while(i2 <= portMax) {
				for(int i3 = 0; i3 <= portMax; i3++ ) {
					ips = ip1 + "." + i2 + "." + i3;
					//System.out.println(ips );
					if(portIsOpen(ips, porta1, timeout)) {
						System.out.println("Porta " + porta1 + " aberta em " + ips);
						arq = new FileWriter(arquivo + ".txt", true);
						gravarArq = new PrintWriter(arq);
						gravarArq.println(ips + ":" + porta1);
						gravarArq.close();
						contador = contador + 1;
						
						

						
						
					} else	{
						
						System.out.println("Porta " + porta1 + " fechada ");
					}
					if(portIsOpen(ips, porta2, timeout)) {
						System.out.println("Porta " + porta2 + " aberta em " + ips);
						arq = new FileWriter(arquivo + ".txt", true);
						gravarArq = new PrintWriter(arq);
						gravarArq.println(ips + ":" + porta2);
						gravarArq.close();
						contador = contador + 1;
						
						

						
						
					} else	{
						
						System.out.println("Porta " + porta2 + " fechada ");
					}
					
					
					
						
						
				}
				i2++;
			}
			
			break;
			}
				
			case 3: {
				int i4 = 160;
				
			while( i4 <= portMax) {	
				for(int i10 = 0;i10 <= portMax; i10++) {
					for(int i2 = 0; i2 <= portMax; i2++ ) {
						ips = ip1 + "." + i4 + "." + i10 + "." + i2;
						System.out.println(ips );
						if(portIsOpen(ips, porta1, timeout)) {
							System.out.println("Porta " + porta1 + " aberta em " + ips);
							arq = new FileWriter(arquivo + ".txt", true);
							gravarArq = new PrintWriter(arq);
							gravarArq.println(ips + ":" + porta1);
							gravarArq.close();
							contador = contador + 1;
							
							

							
							
						} else	{
							
							System.out.println("Porta " + porta1 + " fechada ");
						}
						if(portIsOpen(ips, porta2, timeout)) {
							System.out.println("Porta " + porta2 + " aberta em " + ips);
							arq = new FileWriter(arquivo + ".txt", true);
							gravarArq = new PrintWriter(arq);
							gravarArq.println(ips + ":" + porta2);
							gravarArq.close();
							contador = contador + 1;
							
							

							
							
						} else	{
							
							System.out.println("Porta " + porta2 + " fechada ");
						}
					}
					
				}
				i4++;
			}
				
				break;
				
				
			}
			case 4: {
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
									System.out.println("Porta " + porta1 + " aberta em " + ips);
									contador = contador + 1;
									System.out.println("IPS ENCONTRADOS: " + contador);
									arq = new FileWriter(arquivo  + ".txt", true);
									gravarArq = new PrintWriter(arq);
									gravarArq.println(ips + ":" + porta1);
									gravarArq.close();
									
									
									

									
									
								} else	{
									
									//System.out.println("Porta " + porta1 + " fechada ");
								}
								if(portIsOpen(ips, porta2, timeout)) {
									System.out.println("Porta " + porta2 + " aberta em " + ips);
									arq = new FileWriter(arquivo  + ".txt", true);
									gravarArq = new PrintWriter(arq);
									gravarArq.println(ips + ":" + porta2);
									gravarArq.close();
									contador = contador + 1;
									System.out.println("IPS ENCONTRADOS: " + contador);

									
									

									
									
								} else	{
									
									//System.out.println("Porta " + porta2 + " fechada ");
								}
								if(portIsOpen(ips, porta3, timeout)) {
									System.out.println("Porta " + porta3 + " aberta em " + ips);
									arq = new FileWriter(arquivo  + ".txt", true);
									gravarArq = new PrintWriter(arq);
									gravarArq.println(ips + ":" + porta3);
									gravarArq.close();
									contador = contador + 1;
									//System.out.println("IPS ENCONTRADOS: " + contador);

									
									

									
									
								} else	{
									
									//System.out.println("Porta " + porta3 + " fechada ");
									System.out.println("IPS ESCANEADOS: " + contador_scan);
									System.out.println("IPS ENCONTRADOS: " + contador);
								}
								System.out.println(ips);
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
				
				
				
				
				
				
				//finaliza
				
			}
			
			default:
				System.out.println("Foram encontrados " + contador + " IPS!");
			}
			System.out.println("Foram encontrados " + contador + " IPS!");
			return gravarArq;
			
			

			
		}
		

}
