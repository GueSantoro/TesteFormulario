package Conexao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author INOVA GleSantoro
 */
public class ConexaoBanco {

    private static final String database_url = "jdbc:mysql://localhost:3306/manual_gt4";
    private static final String usuario = "root";
    private static final String senha = "root";

    public static java.sql.Connection abreConexao() {
     Connection con= null;
 try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(database_url, usuario, senha);
}catch (HeadlessException | ClassNotFoundException | SQLException erro){
      JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados " + erro);
    }   
        return con;
    }

    public ConexaoBanco() throws Exception {
        // Recuperar uma conexao com banco de dados     
        ConexaoBanco con = (ConexaoBanco) abreConexao();
        //testar se é nula  
        if (con!=null) {
            System.out.println("Conexão abtida com sucesso!");
            con.clone();
        }
    }
}
