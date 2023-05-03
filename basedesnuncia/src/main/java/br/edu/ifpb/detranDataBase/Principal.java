package br.edu.ifpb.detranDataBase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Principal {
	
	public static void main(String[] args) throws IOException {   
		
		Scanner leia = new Scanner(System.in);
		Scanner leitor = new Scanner(System.in);
		String csvFile = "C:\\Users\\carlo\\Downloads\\datatran2023.csv";
		String line = "";
	    String separador = ";";
	    Connection conn = null;
	    Acidentes[] acidentes;
	    
	        try {
	        	
	        	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	        	// ler a linha de cabeçalho
	            String[] colunas = br.readLine().split(separador);         
	            List<Acidentes> tragedias = new ArrayList<Acidentes>();

	            while ((line = br.readLine()) != null) {
	            	
	                String[] dados = line.split(separador);
	          
	  			  // Cria um novo objeto Pessoa para cada linha e define os campos
	                Acidentes tragediaTransito = new Acidentes();
	  		   	   
	             	tragediaTransito.setData(dados[1]);
	              	tragediaTransito.setCidade(dados[4]);
	              	tragediaTransito.setBr(Integer.parseInt(dados[5]));
	              	tragediaTransito.setMunicipio(dados[7]);
	              	tragediaTransito.setCausa_acidente(dados[8]);
	              	tragediaTransito.setTipo_acidente(dados[9]);
	              	tragediaTransito.setFase_dia(dados[11]);
	              	tragediaTransito.setPessoas(Integer.parseInt(dados[15]));
	              	tragediaTransito.setMortos(Integer.parseInt(dados[16]));
	              	tragediaTransito.setFeridos(Integer.parseInt(dados[17]));
	              	tragediaTransito.setVeiculos(Integer.parseInt(dados[18]));
	              	tragediaTransito.setLatitude(dados[19]);
	              	tragediaTransito.setLongitude(dados[20]);
	              	tragediaTransito.setDelegacia(dados[21]);
	  		   	     
	  			  // Adiciona o objeto Pessoa à lista
	  			  tragedias.add(tragediaTransito);
	            }
	      
	        //  Transformar um objeto java em json    
	            Gson gson = new GsonBuilder().setPrettyPrinting().create();
	            String json = gson.toJson(tragedias);
	            
	         // Converte o JSON em um array de objetos Acidentes
	            acidentes = gson.fromJson(json, Acidentes[].class); 
	            
	         // Fazer a conexão com banco de dados
	            conn = ConexaoBanco.getConnection();
	         
	            for (int i = 0; i < acidentes.length; i++) {
	            
	              	PreparedStatement pstmt = conn.prepareStatement("INSERT INTO acidentes (data,cidade,br,municipio,causa_acidente,tipo_acidente,fase_dia,pessoas,mortos,feridos,veiculos,latitude,longitude,delegacia) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
	             
	                pstmt.setString(1, acidentes[i].getData());
	                pstmt.setString(2, acidentes[i].getCidade());
	                pstmt.setInt(3, acidentes[i].getBr());
	                pstmt.setString(4, acidentes[i].getMunicipio());
	                pstmt.setString(5, acidentes[i].getCausa_acidente());
	                pstmt.setString(6, acidentes[i].getTipo_acidente());
	                pstmt.setString(7, acidentes[i].getFase_dia());
	                pstmt.setInt(8, acidentes[i].getPessoas());
	                pstmt.setInt(9, acidentes[i].getMortos());
	                pstmt.setInt(10, acidentes[i].getFeridos());
	                pstmt.setInt(11, acidentes[i].getVeiculos());
	                pstmt.setString(12, acidentes[i].getLatitude());
	                pstmt.setString(13, acidentes[i].getLongitude());
	                pstmt.setString(14, acidentes[i].getDelegacia());
	                
	                pstmt.executeUpdate();
	             }	            
	             System.out.println("Dados Gson inseridos com sucesso no PostgreSQL!");
	            
	            
	             //------------------------------------------Consultas----------------------------------//
	            
	            int option;
	            int cont = 1;
	            SimpleDateFormat formato;
	            double somaMortos;
				double somaFeridos;
			    int quantidade;
	            
	          
	        do {
	    	 
		         StringBuilder sbLogo = new StringBuilder();
		         sbLogo.append("\033[31m"); 
		         sbLogo.append("\n"+"------------ Central de acidentes: DETRAN ------------"+ "\n");
		         System.out.println(sbLogo);
		         
		         StringBuilder sb = new StringBuilder();	  	         
		         sb.append("\u001B[32m");
		         sb.append("                           Menu " + "\n");
		         sb.append( "\n" + " 1. Listar todos os acidentes." + "\n");
		         sb.append(" 2. Exibir o municipio com mais recorrência em acidentes." + "\n");
		         sb.append(" 3. Listar acidentes referente a um município específico" + "\n");
		         sb.append(" 4. Exibir qual turno do dia há mais recorrência em acidentes" + "\n");
		         sb.append(" 5. Exibir BR com mais registros de acidentes" + "\n");
		         sb.append(" 6. Exibir o acidente recorrente a uma BR específica" + "\n");
		         sb.append(" 7. Exibir informações sobre os acidentes do mês de 2023" + "\n");
		         sb.append(" 8. Sair" + "\n");
		         
		         System.out.println(sb);	      
		         
		         StringBuilder sbOption = new StringBuilder();
		         sbOption.append("\033[34m");
		        
		         System.out.print(sbOption.append("Insira uma opção:"));
		        
		         Scanner leitorMenu = new Scanner(System.in);
		         option = leitorMenu.nextInt();
		
		         switch (option) {
				case 1:
					
		            for(Acidentes acidente: acidentes) {
		            	System.out.println(cont + " - "+ acidente);
		            	cont++;
		            }
//		            
					break;
				case 2:
	
					 String municipioMaisRepetido = null;
					 int maxRepeticoes = 0;

					    for (int i = 0; i < acidentes.length; i++) {
					        String municipioAtual = acidentes[i].getMunicipio();
					        int repeticoes = 0;

					        for (int j = 0; j < acidentes.length; j++) {
					            if (acidentes[j].getMunicipio().equals(municipioAtual)) {
					                repeticoes++;
					            }
					        }
					        if (repeticoes > maxRepeticoes) {
					            maxRepeticoes = repeticoes;
					            municipioMaisRepetido = municipioAtual;
					        }
					    }
				        System.out.println("O município mais repetido é " + municipioMaisRepetido);
		             
					break;
				case 3:	
			   
					System.out.print("Municipio: ");
					
					String municipio = leia.nextLine();
		
					for(Acidentes acidente: acidentes) {
						
						if(acidente.getMunicipio().equals(municipio)) {
							System.out.println("Data: " + acidente.getData() + ", Pessoas: " + acidente.getPessoas() + ", Mortos: " + acidente.getMortos() + ", Feridos: " + acidente.getFeridos() + " ,latitude: " + acidente.getLatitude() + " , longitude: " + acidente.getLongitude() + " ,Delegacia " + acidente.getDelegacia());
						}
					}
					
					break;
		
				case 4:	//realiza consulta não direta, adere o resultado invocando-a.
			         Statement statement4 = conn.createStatement(); 
		             String consulta_fase_dia = "SELECT fase_dia FROM acidentes ";
		             ResultSet resultSetFasedia = statement4.executeQuery(consulta_fase_dia);
		             
		             List<String> fases = new ArrayList<>();
		                   
			         while(resultSetFasedia.next()) {
		            	 String faseDia = resultSetFasedia.getString("fase_dia");
		            	 fases.add(faseDia);
		             }
			         	System.out.println("Turno em que há mais registros de acidentes: " + retornaElementRepetido(fases));
			         	statement4.close();
			            resultSetFasedia.close();
			             
					break;
					
				case 5:
					
					 Statement statement5 = conn.createStatement();
		             String consulta5 = "SELECT br FROM acidentes";
		             ResultSet resultSet5 = statement5.executeQuery(consulta5);    
		             List<String> brs = new ArrayList<>();
		             
		             while(resultSet5.next()) {
		            	  String b = resultSet5.getString("br");
		            	  brs.add(b);
		             }
		            
		             System.out.println("BR com mais registros de acidentes: " + retornaElementRepetido(brs));
		             statement5.close();
		             resultSet5.close();
					
					break;
					
				case 6:
					
					 Statement statement7 = conn.createStatement();
			         String consulta = "SELECT DISTINCT br FROM acidentes ";
			         ResultSet resultSet7 = statement7.executeQuery(consulta);
			         
			         System.out.println("------------------Lista de BRs--------------------");
		             
			         while(resultSet7.next()) {
		            	  System.out.print("[" + resultSet7.getString("br") + "]");
		             }
			         
					System.out.println("");
					System.out.println("Informe uma BR: ");
		    
		             statement7.close();
		             resultSet7.close();
					 
					int brEscolhido = Integer.parseInt(leia.nextLine()); 
					
					 List<String> causa = new ArrayList<>();
					 List<String> tipo = new ArrayList<>();
					 
					 for(Acidentes acidente: acidentes) {
						if(acidente.getBr() == brEscolhido) {
							causa.add(acidente.getCausa_acidente());
							tipo.add(acidente.getTipo_acidente());
						}
					}
					  System.out.println("Causa Recorrente: " + retornaElementRepetido(causa));
			          System.out.println("Tipo Recorrente: " +   retornaElementRepetido(tipo));
					
					break;
			
				case 7:
					
					somaMortos = 0;
					somaFeridos = 0;
				    quantidade = 1; 
				    
					formato = new SimpleDateFormat("dd/MM/yyyy");
					
					System.out.println("Escolha um mês: \n 1-[JANEIRO] \n 2-[FEVEREIRO] \n 3-[MARÇO] \n Numero do mês desejado: ");
					int op = leitor.nextInt();
			
					List<String> delegacias = new ArrayList<>();
				   
					for(Acidentes acidente: acidentes) {
				    	
				    	 Date date = formato.parse(acidente.getData());
				         Calendar calendario = Calendar.getInstance();
				         calendario.setTime(date);
				         int mes = calendario.get(Calendar.MONTH) + 1;
				        
				         if(mes == op) {
				        	 somaMortos += acidente.getMortos();
				        	 somaFeridos += acidente.getFeridos();
				        	 quantidade++;
				        	 delegacias.add(acidente.getDelegacia());
				         }
				     }
					
				     System.out.println("Delegacia que obteve mais ocorrência: " + retornaElementRepetido(delegacias));
				     System.out.println("A quantidade de acidentes: " + quantidade);
				     System.out.println("Média de Mortos: " + String.format("%.3f", somaMortos / quantidade));
				     System.out.println("Média de Feridos: " + String.format("%.3f", somaFeridos / quantidade));
				   
					break;
					
				case 8:
				
					System.out.println("Encerrado.");
					break;
					
				default:
					System.out.println("Ocorreu um erro. Insira uma opção válida.");
					break;
				}
	     } while (option != 8);

		             ConexaoBanco.closeConnection();

	        } catch (Exception e) {
	            System.out.println("Erro: " + e.getMessage());
	        } 
	} 
	
	private static String retornaElementRepetido(List<String> elementos) {
		
        String elementoRepetido = null;
        int aux = 0;
        
        for (String value : elementos) {
            int count = 0;
            
            for (String otherValue : elementos) {
                if (value.equals(otherValue)) {
                    count++;
                }
            }
            if (count > aux) {
                aux = count;
                elementoRepetido = value;
            }
        }
		return elementoRepetido;
		
	}

}