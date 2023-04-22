package Interfaces_Menu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Teste_JTable extends JPanel
{
    private JLabel lblTeste01, lblTeste02;
    private JTextField txtTeste01, txtTeste02;
    private JPanel Painel_da_Tabela;
    private JTable Tabela;
    private DefaultTableModel Modelo_da_Tabela;
    
    public Teste_JTable() 
    {
        this.setSize(800, 585);
        this.setLayout(null);
        
        //lblTeste01:
        lblTeste01 = new JLabel("Teste 01: ");
        lblTeste01.setSize(100, 20);
        lblTeste01.setLocation(10, 10);
        
        this.add(lblTeste01);
        
        //lblTeste02:
        lblTeste02 = new JLabel("Teste 02: ");
        lblTeste02.setSize(100, 20);
        lblTeste02.setLocation(10, 40);
        
        this.add(lblTeste02);
        
        //txtTeste01:
        txtTeste01 = new JTextField();
        txtTeste01.setSize(100, 20);
        txtTeste01.setLocation(110, 10);
        
        this.add(txtTeste01);
        
        //txtTeste02:
        txtTeste02 = new JTextField();
        txtTeste02.setSize(100, 20);
        txtTeste02.setLocation(110, 40);
        
        this.add(txtTeste02);
                
        //Tabela:
        Tabela_Teste01();
        
    }
    
    public void Tabela_Teste01()
    {
        String [] Colunas = {"Nome", "Telefone", "Email"};
        String [] [] Linhas = 
        {
            {"Teste L - 01 C - 01", "Teste L - 01 C - 02", "Teste L - 01 C - 03"},
            {"Teste L - 02 C - 01", "Teste L - 02 C - 02", "Teste L - 02 C - 03"},
            {"Teste L - 03 C - 01", "Teste L - 03 C - 02", "Teste L - 03 C - 03"}
        };
        
        //Painel_da_Tabela:
        Painel_da_Tabela = new JPanel();
        Painel_da_Tabela.setSize(getWidth() - 20, 475);
        Painel_da_Tabela.setLocation(10, 100);
        Painel_da_Tabela.setLayout(new GridLayout());
        
        this.add(Painel_da_Tabela);
        
        //Modelo_da_Tabela:
        Modelo_da_Tabela = new DefaultTableModel(Linhas, Colunas)
        {
            boolean[] Editavel = new boolean[]{ false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) 
            {
                return Editavel[columnIndex];
            }
        };
        Modelo_da_Tabela.setNumRows(30);
        
        //Tabela:
        Tabela = new JTable(Modelo_da_Tabela);
        Tabela.setSize(Painel_da_Tabela.getWidth(), Painel_da_Tabela.getHeight());
        Tabela.setLocation(10, 10);
        Tabela.setAutoCreateColumnsFromModel(true);
        
        //for para evitar que o usuário minimize demais a coluna:
        for (int i = 0; i < 3; i++)
        {
            Tabela.getColumnModel().getColumn(i).setMinWidth(100);
        };
        
        Painel_da_Tabela.add(Tabela);
        
        //scrTeste01:
        JScrollPane scrTeste01 = new JScrollPane(Tabela);
        scrTeste01.setSize(Painel_da_Tabela.getWidth(), Painel_da_Tabela.getHeight());
        
        Painel_da_Tabela.add(scrTeste01);
    }
}