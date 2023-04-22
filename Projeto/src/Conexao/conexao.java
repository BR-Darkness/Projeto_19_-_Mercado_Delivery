package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TARDIS
 */
public class conexao 
{
    
    private static Connection   Cnn;
    private static final String URL="jdbc:mysql://localhost:3306/class?zeroDateTimeBehavior=convertToNull ";
    private static final String USER="root";
    private static final String PASS="";
    
    public static Connection getConexao() 
    { // throws SystemError{
        if(Cnn == null)
        {
            try 
            {
                try 
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Cnn = DriverManager.getConnection(URL, USER, PASS);
                    JOptionPane.showMessageDialog(null, "Conectado ao Banco de Dados");
                } 
                
                catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao Banco de Dados");
                }
                
            } 
            
            catch (ClassNotFoundException ex) 
            {
                JOptionPane.showMessageDialog(null, "Não Conectado, Driver do Banco de Dados não encontrado");   
            }
        }
        
        return Cnn;
    }
    
    public static void CloseConexao() 
    {
        if(Cnn != null)
        {
            try 
            {
                Cnn.close();
                Cnn = null;
            } 
            
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Erro ao fechar Banco de Dados");
            }
        }
    }
}
