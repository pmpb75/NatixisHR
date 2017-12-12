package exercicio4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	
	public static void select(Connection conn, String BI) {
		 String sql ="select BI, Nome, Data_Nascimento, Morada, Categoria"
                         + ", Funcao  from funcionarios where BI=?";

	        //creating PreparedStatement object to execute query
	        PreparedStatement preStatement;
			try {
				preStatement = conn.prepareStatement(sql);
				preStatement.setString(1,BI);
				 ResultSet result = preStatement.executeQuery();
				 int nr=0;
				 if(!result.next())
					 System.out.println("Funcionário inexistente");
			        while(result.next()){
			                nr++;
			            System.out.println("Funcionário : " + result.getString("BI") + " " 
			                + result.getString("Nome")+ " " + result.getString("Morada")
                                        + " " + result.getString("Data_Nascimento") + 
                                        " " + result.getString("Categoria") 
                                        + " " + result.getString("Funcao"));
			        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	}
	
	public static void insert(Connection conn, String BI, String Data_Nascimento, String Nome, String Morada, String Categoria, String Funcao) {
		String sql ="insert into funcionarios (BI, Data_Nascimento, Nome, "
                        + "Categoria, Morada, Funcao)" + "values(?,?,?,?,?,?)";
		PreparedStatement preStatement;
        try {
                preStatement = conn.prepareStatement(sql);
                preStatement.setString(1,BI);
                preStatement.setString(2,Data_Nascimento);
	        preStatement.setString(3,Nome);
	        preStatement.setString(4,Morada);
                preStatement.setString(5,Categoria);
                preStatement.setString(6,Funcao);
	        preStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	public static void update(Connection conn, String BI, String Morada) {
		
		String sql = "update funcionarios set Morada=? where BI=?";
		PreparedStatement preStatement;
        try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(2,BI);
	        preStatement.setString(1,Morada);
	        preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static void remove(Connection conn, String BI) {
		String sql = "delete from funcionarios where BI=?";
		PreparedStatement preStatement;
        try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1,BI);
		    preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	
	

	public static void main(String[] args) throws SQLException, IOException {
		 String url = "jdbc:mysql://localhost:3306/natixishr";
	        Properties props = new Properties();
	        props.setProperty("user", "root");
	        props.setProperty("password", "");
	      
	        Connection conn = DriverManager.getConnection(url,props);
	        Scanner in = new Scanner(System.in);
	        int j = 0;
	        String BI, Data_Nascimento;
	        String Nome;
	        String Morada, Categoria, Funcao;
	       
	        
	       while(j == 0) {
	        	
	        	System.out.println("Escolha uma opção");
	        	System.out.println("1 - Consultar por BI");
	        	System.out.println("2 - Inserir novo funcionário");
	        	System.out.println("3 - Atualizar Morada");
	        	System.out.println("4 - Remover funcionário");
	        	System.out.println("0 - Sair");
	        	int i = in.nextInt();
	        	switch(i) {
		        	case 0:{System.out.println("Exiting");
		        			j = 1;
		        			break;
		        			}
		        	case 1: {System.out.println("Insira o BI");
		        			BI = in.next();
		        			select(conn, BI);
		        			System.out.println("Prima enter para continuar");
		        			System.in.read();
		        			break;}
		        	case 2: {System.out.println("Insira o BI");
		        			BI = in.next();
		        			System.out.println("Insira o Nome");
		        			Nome = in.next();
                                                System.out.println("Insira a Data de Nascimento");
                                                Data_Nascimento = in.next();
		        			System.out.println("Insira a Morada");
		        			Morada = in.next();
                                                System.out.println("Insira a Categoria");
                                                Categoria = in.next();
                                                System.out.println("Insira a Função");
                                                Funcao = in.next();
		        			insert(conn, BI, Data_Nascimento, Nome, Morada, Categoria, Funcao);
		        			break;}
		        	case 3: {System.out.println("Insira o BI");
        					BI = in.next();
        					System.out.println("Insira a Morada");
		        			Morada = in.next();
		        			update(conn, BI, Morada);
        					break;}
		        	case 4: {System.out.println("Insira o BI");
		        			BI = in.next();
		        			remove(conn, BI);
		        			break;}
		        	
		        
		        	default:{ System.out.println("Opção inválida");
		        			break;}
	        	}
	        }
	        in.close();

	}

}
