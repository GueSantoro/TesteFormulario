package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo_Sinais;

/**
 * @author INOVA GleSantoro
 */
public class Dao_Sinal {

    Modelo_Sinais tm = new Modelo_Sinais();
    ResultSet resultado;
    Connection conn;
    PreparedStatement stm;


    /*
CONSULTAR
     */
    public void consultaDaoAlimentacao(Object... valor) throws SQLException {
        String SQL_DB9 = "SELECT * FROM manual_gt4.alimentacao";
        DefaultTableModel tabela_Alimentacao = (DefaultTableModel) valor[1];
        conn = ConexaoBanco.abreConexao();
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(SQL_DB9);
            resultado = stm.executeQuery();

            if ("".equals((String) valor[0])) {
                SQL_DB9 = "SELECT * FROM manual_gt4.alimentacao";
            } else {
                SQL_DB9 = "SELECT * FROM manual_gt4.alimentacao WHERE funcao LIKE '%" + valor[0] + "%' ";
            }

            while (resultado.next()) {
                tabela_Alimentacao.addRow(
                        new Object[]{
                            resultado.getString("funcao"),
                            resultado.getString("pinos_central"),
                            resultado.getString("referencia"),
                            resultado.getString("conectorgt3")
                        });
            }
            stm.close();

        } catch (SQLException e) {
            System.out.println("DAO Consulta Tabela Alimentação " + e);
        }

    }

    public void consultaDaoSensor(Object... valor) throws SQLException {
        String SQL_DB25M = "SELECT * FROM manual_gt4.sensor";
        DefaultTableModel tabela_Sensor = (DefaultTableModel) valor[1];
        conn = ConexaoBanco.abreConexao();
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(SQL_DB25M);
            resultado = stm.executeQuery();

            if ("".equals((String) valor[0])) {
                SQL_DB25M = "SELECT * FROM manual_gt4.sensor";
            } else {
                SQL_DB25M = "SELECT * FROM manual_gt4.sensor WHERE funcao LIKE '%" + valor[0] + "%' ";
            }

            while (resultado.next()) {
                tabela_Sensor.addRow(
                        new Object[]{
                            resultado.getString("funcao"),
                            resultado.getString("pinos_central"),
                            resultado.getString("referencia"),
                            resultado.getString("conectorgt3")
                        });
            }
            stm.close();

        } catch (SQLException e) {
            System.out.println("DAO Consulta Tabela Sensor " + e);
        }

    }


    public void consultaDaoAtuador(Object... valor) throws SQLException {
        String SQL_DB25F = "SELECT * FROM manual_gt4.atuador";
        DefaultTableModel tabela_Atuador = (DefaultTableModel) valor[1];
        conn = ConexaoBanco.abreConexao();
        try {
            stm = ConexaoBanco.abreConexao().prepareStatement(SQL_DB25F);
            resultado = stm.executeQuery();

            if ("".equals((String) valor[0])) {
                SQL_DB25F = "SELECT funcao, pinos_central, referencia, conectorgt3 FROM manual_gt4.atuador";
            } else {
                SQL_DB25F = "SELECT funcao, pinos_central, referencia, conectorgt3 FROM manual_gt4.atuador WHERE funcao LIKE '%" + valor[0] + "%' ";
            }

            while (resultado.next()) {
                tabela_Atuador.addRow(
                        new Object[]{
                            resultado.getString("funcao"),
                            resultado.getString("pinos_central"),
                            resultado.getString("referencia"),
                            resultado.getString("conectorgt3")
                        });
            }
            stm.close();

        } catch (SQLException e) {
            System.out.println("DAO Consulta Tabela Atuador " + e);
        }

    }

}
