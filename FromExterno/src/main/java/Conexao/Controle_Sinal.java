package Conexao;

import java.sql.SQLException;
import modelo.Modelo_Sinais;

/**
 * @author INOVA GleSantoro
 */
public class Controle_Sinal {

    Modelo_Sinais tm = new Modelo_Sinais();
    Dao_Sinal td = new Dao_Sinal();

    public Controle_Sinal() {
    }

 
    /**
     * *************************************************************
     * CONSULTAR SINAIS
     * **************************************************************
     */
    public void consultaControleAlimentacao(Object... valor) {
        try {
            td.consultaDaoAlimentacao(valor);
        } catch (SQLException e) {
            System.out.println("Controle Consulta Tabela Alimentação " + e);
        }
    }

    public void consultaControleSensor(Object... valor) {
        try {
            td.consultaDaoSensor(valor);
        } catch (SQLException e) {
            System.out.println("Controle Consulta Tabela Sensor " + e);
        }
    }

    public void consultaControleAtuador(Object... valor) {
        try {
            td.consultaDaoAtuador(valor);
        } catch (SQLException e) {
            System.out.println("Controle Consulta Tabela Atuador " + e);
        }
    }


}
