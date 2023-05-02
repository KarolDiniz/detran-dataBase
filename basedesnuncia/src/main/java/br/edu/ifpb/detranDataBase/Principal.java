package br.edu.ifpb.detranDataBase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {
	
	public static void main(String[] args) throws IOException {   
		
		Scanner leia = new Scanner(System.in);
		String csvFile = "C:\\Users\\carlo\\Downloads\\datatran2023.csv";
		String line = "";
	    String csvSplitBy = ";";
	    Connection conn = null;
	    
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        	
	        	// ler a linha de cabeçalho
	            /*String[] colunas = br.readLine().split(csvSplitBy);
	            
	            List<Acidentes> acidentes = new ArrayList<Acidentes>();

	            while ((line = br.readLine()) != null) {
	          
	              String[] dados = line.split(csvSplitBy);
	              
	              for(String a: dados) {
	            	  System.out.println(a);
	              }
	         
	  			  // Cria um novo objeto Pessoa para cada linha e define os campos
	              	Acidentes acidente = new Acidentes();
	  		   	   
	              	acidente.setId(dados[0]);
	              	acidente.setData(dados[1]);
	              	acidente.setDia_semana(dados[2]);
	              	acidente.setHorario(dados[3]);
	              	acidente.setCidade(dados[4]);
	              	acidente.setBr(Integer.parseInt(dados[5]));
	              	acidente.setKm(dados[6]);
	              	acidente.setMunicipio(dados[7]);
	              	acidente.setCausa_acidente(dados[8]);
	              	acidente.setTipo_acidente(dados[9]);
	              	acidente.setClassificacao_acidente(dados[10]);
	              	acidente.setFase_dia(dados[11]);
	              	acidente.setSentido_via(dados[12]);
	              	acidente.setTipo_pista(dados[13]);
	              	acidente.setTracado_via(dados[14]);
	              	acidente.setPessoas(Integer.parseInt(dados[15]));
	              	acidente.setMortos(Integer.parseInt(dados[16]));
	              	acidente.setFeridos(Integer.parseInt(dados[17]));
	              	acidente.setVeiculos(Integer.parseInt(dados[18]));
	              	acidente.setLatitude(dados[19]);
	              	acidente.setLongitude(dados[20]);
	              	acidente.setDelegacia(dados[21]);
	  		   	     
	  			  // Adiciona o objeto Pessoa à lista
	  			  acidentes.add(acidente);
	            }
	      
	        //  Transformar um objeto java em json    
	            Gson gson = new GsonBuilder().setPrettyPrinting().create();
	            String json = gson.toJson(acidentes);

	         // Converte o JSON em um array de objetos Acidentes
	            Acidentes[] tragediasTransito = gson.fromJson(json, Acidentes[].class);*/
	        
	         // Fazer a conexão com banco de dados
	            conn = ConexaoBanco.getConnection();
	          
	           /* for (Acidentes adt : tragediasTransito) {
	              
	            	PreparedStatement pstmt = conn.prepareStatement("INSERT INTO acidentes (id,data,dia_semana,horario,cidade,br,km,municipio,causa_acidente,tipo_acidente,classificacao_acidente,fase_dia,sentido_via,tipo_pista,tracado_via,pessoas,mortos,feridos,veiculos,latitude,longitude,delegacia) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	              
	            	pstmt.setString(1, adt.getId());
	                pstmt.setString(2, adt.getData());
	                pstmt.setString(3, adt.getDia_semana());
	                pstmt.setString(4, adt.getHorario());
	                pstmt.setString(5, adt.getCidade());
	                pstmt.setInt(6, adt.getBr());
	                pstmt.setString(7, adt.getKm());
	                pstmt.setString(8, adt.getMunicipio());
	                pstmt.setString(9, adt.getCausa_acidente());
	                pstmt.setString(10, adt.getTipo_acidente());
	                pstmt.setString(11, adt.getClassificacao_acidente());
	                pstmt.setString(12, adt.getFase_dia());
	                pstmt.setString(13, adt.getSentido_via());
	                pstmt.setString(14, adt.getTipo_pista());
	                pstmt.setString(15, adt.getTracado_via());
	                pstmt.setInt(16, adt.getPessoas());
	                pstmt.setInt(17, adt.getMortos());
	                pstmt.setInt(18, adt.getFeridos());
	                pstmt.setInt(19, adt.getVeiculos());
	                pstmt.setString(20, adt.getLatitude());
	                pstmt.setString(21, adt.getLongitude());
	                pstmt.setString(22, adt.getDelegacia());
	                
	                pstmt.executeUpdate();
	             }*/
	            
	             System.out.println("Dados Gson inseridos com sucesso no PostgreSQL!");
	             
	            
	             //------------------------------------------Consultas----------------------------------//
	             int option;
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
		         sb.append(" 6. Listar acidentes referente a uma BR específica" + "\n");
		         sb.append(" 7. Sair" + "\n");
		         
		         System.out.println(sb);	      
		         
		         StringBuilder sbOption = new StringBuilder();
		         sbOption.append("\033[34m");
		         System.out.print(sbOption.append("Insira uma opção:"));
		         
		         Scanner leitorMenu = new Scanner(System.in);
		         option = leitorMenu.nextInt();
		         
		         switch (option) {
				case 1:
					Statement statement1 = conn.createStatement();
					String sql = "SELECT * FROM acidentes";
					ResultSet resultSet1 = statement1.executeQuery(sql);
		             
		            while (resultSet1.next()) {
		            	    String id = resultSet1.getString("id");
		            	    String data = resultSet1.getString("data");
		            	    String semana = resultSet1.getString("dia_semana");
		            	    System.out.println("ID: " + id + ", Data: " + data + ", Dia da Semana: " + semana);
				            
		            }	
		            statement1.close();
		            resultSet1.close();
//		            
					break;
				case 2:
					Statement statement2 = conn.createStatement();
					String consulta2 = "SELECT municipio FROM acidentes ";
		            ResultSet resultSet2 = statement2.executeQuery(consulta2);
		             
		             List<String> municipios = new ArrayList<>();
		                   
			         while(resultSet2.next()) {
		            	 String muni = resultSet2.getString("municipio");
		            	 municipios.add(muni);
		             }
			          
		             System.out.println( "Munícipio com mais registros de acidentes: " + retornaElementRepetido(municipios));
			         statement2.close();
			         resultSet2.close();
		             
					break;
				case 3:	
			         Statement statement3 = conn.createStatement();
					System.out.print("Municipio: ");
					String municipio = leia.nextLine();
					String consulta3 = "SELECT data,pessoas,mortos,feridos,latitude,longitude FROM acidentes WHERE municipio = " + "'" + municipio + "'";
		            ResultSet resultSet3 = statement3.executeQuery(consulta3);
	                   
			         while(resultSet3.next()) {
		            	 	String data = resultSet3.getString("data");
		            	    int pessoas = resultSet3.getInt("pessoas");
		            	    int mortos = resultSet3.getInt("mortos");
		            	    int feridos = resultSet3.getInt("feridos");
		            	    String latitude = resultSet3.getString("latitude");
		            	    String longitude = resultSet3.getString("longitude");	
		            	    
		            	    System.out.println("Data: " + data + ", Pessoas: " + pessoas + ", Mortos: " + mortos + ", Feridos: " + feridos + " ,latitude: " + latitude + " , longitude: " + longitude);	  
		             } 
		             statement3.close();
		             resultSet3.close();
					
					break;
		
				case 4:
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
					
					System.out.println("BR: ");
		             String brEscolhido = leia.nextLine(); 
		             
		             Statement statement6 = conn.createStatement();
		             String consulta6 = "SELECT causa_acidente, tipo_acidente FROM acidentes where br = " + "'"+ brEscolhido + "'";
		             ResultSet resultSet6 = statement6.executeQuery(consulta6);
		             
		             List<String> causas = new ArrayList<>();
		             List<String> tipos = new ArrayList<>();
		             
		             
		             while(resultSet6.next()) {
			            	
		            	    String causa = resultSet6.getString("causa_acidente");
		            	    String tipo = resultSet6.getString("tipo_acidente");
		            	
		            	    causas.add(causa);
		            	    tipos.add(tipo);    
		             }
		             
		             String causaRepetido = retornaElementRepetido(causas);
		             String tipoRepetido = retornaElementRepetido(tipos);
		             System.out.println("Causa Recorrente: " + causaRepetido);
		             System.out.println("Tipo Recorrente: " +   tipoRepetido);
		             statement6.close();
		             resultSet6.close();
					break;
					
				case 7:
					System.out.println("Encerrado.");
					break;
					
				default:
					System.out.println("Ocorreu um erro. Insira uma opção válida.");
					break;
				}
	     } while (option != 7);

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
	    

