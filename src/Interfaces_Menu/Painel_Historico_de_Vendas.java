package Interfaces_Menu;

import Componentes.CustomComboBox;
import Interfaces.Menu;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Painel_Historico_de_Vendas extends JPanel
{
    //Sistema de Temas: paineis vão herdar da tela principal
    Menu Tema = new Menu();
    
    //Icones: 
    private ImageIcon   Icone_Pesquisar     = new ImageIcon(getClass().getResource("/Icones/Icone_Pesquisar.png"));
    private ImageIcon   Icone_Adicionar     = new ImageIcon(getClass().getResource("/Icones/Icone_Adicionar.png"));
    private ImageIcon   Icone_Excluir       = new ImageIcon(getClass().getResource("/Icones/Icone_Excluir.png"));
    private ImageIcon   Icone_Editar        = new ImageIcon(getClass().getResource("/Icones/Icone_Editar.png"));
    private ImageIcon   Icone_Cancelar      = new ImageIcon(getClass().getResource("/Icones/Icone_Cancelar.png"));
    private ImageIcon   Icone_Atualizar     = new ImageIcon(getClass().getResource("/Icones/Icone_Atualizar.png"));
    
    //Cores:
    private final Color Cor_Painel_Consulta = Tema.Cor_Menu_Lateral;
    private final Color Cor_Fundo           = Tema.Cor_Fundo;
    private final Color Cor_Botoes          = Tema.Cor_Botoes;
    private final Color Cor_Fonte_Consulta  = Tema.Cor_Fonte_Menu_Lateral;
    private final Color Cor_Fonte_Botoes    = Tema.Cor_Fonte_Botoes;
    private final Color Cor_Fonte           = Tema.Cor_Fonte_Paineis;
    
    //Bordas:
    private final Border Borda_Geral = Tema.Borda_Paineis;
    private final Border Borda_Fundo = Tema.Borda_Fundo;
    
    //Componentes Painel Consulta:    
    private MaskFormatter mskData_Inicio;
            
    public Painel_Historico_de_Vendas() 
    {
        //Janela:
        this.setLocation(0, 0);
        this.setSize(800, 585);
        this.setLayout(null);
        this.setBorder(Borda_Fundo);
        this.setBackground(Cor_Fundo);
        
        //Painel de Consulta:
        Consulta();

        //Tabela:
        Tabela();
    }
    
     public void Consulta()
    {      
        /*800 X 40*/
        //Painel Consultas:
        JPanel pnlConsulta = new JPanel();
        pnlConsulta.setSize(this.getWidth(), 30);
        pnlConsulta.setLocation(0, 0);
        pnlConsulta.setLayout(null);
        pnlConsulta.setBackground(Cor_Painel_Consulta);
        
        this.add(pnlConsulta);
        
        //lblConsultaNome:
        JLabel lblConsultaNome = new JLabel("Nome: ");
        lblConsultaNome.setSize(50, 20);
        lblConsultaNome.setLocation(10, 5);
        lblConsultaNome.setForeground(Cor_Fonte_Consulta);
        
        pnlConsulta.add(lblConsultaNome);
        
        //txtConsultaNome:
        JTextField txtConsultaNome = new JTextField();
        txtConsultaNome.setSize(280, 20);
        txtConsultaNome.setLocation(60, 5);
        txtConsultaNome.setBorder(Borda_Geral);
        
        pnlConsulta.add(txtConsultaNome);
        
        //btnConsultaNome:
        JButton btnConsultaNome = new JButton(Icone_Pesquisar);
        btnConsultaNome.setSize(30, 30);
        btnConsultaNome.setLocation(345, 0);
        btnConsultaNome.setBackground(Cor_Painel_Consulta);
        btnConsultaNome.setBorder(null);
        btnConsultaNome.setFocusPainted(false);
        btnConsultaNome.setToolTipText("Realiza uma consulta no banco de dados através do nome do cliente.");
        btnConsultaNome.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnConsultaNome.setBackground(Color.gray);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnConsultaNome.setBackground(Cor_Painel_Consulta);
            }
            
            public void mouseClicked(MouseEvent mouse)
            {
                /*Aguardando Banco de dados.*/
            }
        });
        
        pnlConsulta.add(btnConsultaNome);
        
        //lblData_Inicio: Data de Início da busca.
        JLabel lblData_Inicio = new JLabel("Busca a partir da data: ");
        lblData_Inicio.setSize(150, 20);
        lblData_Inicio.setLocation(385, 5);
        lblData_Inicio.setForeground(Cor_Fonte_Consulta);
        
        pnlConsulta.add(lblData_Inicio);
        
        //txtDataInicio:
        try 
        {
            mskData_Inicio = new MaskFormatter("## / ## / ####");
            mskData_Inicio.setPlaceholder("");
        }
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
        JFormattedTextField txtDataInicio = new JFormattedTextField(mskData_Inicio);
        txtDataInicio.setSize(105, 20);
        txtDataInicio.setLocation(525, 5);
        txtDataInicio.setHorizontalAlignment(JFormattedTextField.CENTER);
        txtDataInicio.setBorder(Borda_Geral);
        
        pnlConsulta.add(txtDataInicio);
        
        //lblDataFim: Data de Fim da busca.
        JLabel lblData_Fim = new JLabel("à: ");
        lblData_Fim.setSize(20, 20);
        lblData_Fim.setLocation(640, 5);
        lblData_Fim.setForeground(Cor_Fonte_Consulta);
        
        pnlConsulta.add(lblData_Fim);
        
        //txtDataFim:
        JFormattedTextField txtDataFim = new JFormattedTextField(mskData_Inicio);
        txtDataFim.setSize(105, 20);
        txtDataFim.setLocation(660, 5);
        txtDataFim.setHorizontalAlignment(JFormattedTextField.CENTER);
        txtDataFim.setBorder(Borda_Geral);
        
        pnlConsulta.add(txtDataFim);
        
        //btnConsultaData:
        JButton btnConsultaData = new JButton(Icone_Pesquisar);
        btnConsultaData.setSize(30, 30);
        btnConsultaData.setLocation(770, 0);
        btnConsultaData.setBackground(Cor_Painel_Consulta);
        btnConsultaData.setBorder(null);
        btnConsultaData.setFocusPainted(false);
        btnConsultaData.setToolTipText("Realiza uma consulta no banco de dados.");
        btnConsultaData.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnConsultaData.setBackground(Color.gray);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnConsultaData.setBackground(Cor_Painel_Consulta);
            }
            
            public void mouseClicked(MouseEvent mouse)
            {
                /*Aguardando Banco de dados.*/
            }
        });
        
        pnlConsulta.add(btnConsultaData);
    }
    

    public void Tabela()
    {
        //Componentes:
        JPanel Painel_da_Tabela;
        JTable Tabela;
        DefaultTableModel Modelo_da_Tabela;
        
        //Linhas e Colunas para o modelo da tabela:
        String [] Colunas = 
        {
        "ID da Venda", "Data da Venda", "Cliente", "Valor da Venda"
        };
        
        String [] [] Linhas = {};
        
        //Painel_da_Tabela:
        Painel_da_Tabela = new JPanel();
        Painel_da_Tabela.setSize(getWidth() - 20, getHeight() - 50);
        Painel_da_Tabela.setLocation(10, 40);
        Painel_da_Tabela.setLayout(new GridLayout());
        
        this.add(Painel_da_Tabela);
        
        //Modelo_da_Tabela:
        Modelo_da_Tabela = new DefaultTableModel(Linhas, Colunas)
        {
            //um false para cada coluna:
            boolean[] Editavel = new boolean[]
            { 
              false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) 
            {
                return Editavel[columnIndex];
            }
        };
        
        Modelo_da_Tabela.setNumRows(0);
        
        //Tabela:
        Tabela = new JTable(Modelo_da_Tabela);
        Tabela.setSize(Painel_da_Tabela.getWidth(), Painel_da_Tabela.getHeight());
        Tabela.setLocation(10, 10);
        Tabela.setAutoCreateColumnsFromModel(true);
//        Tabela.setAutoResizeMode(0); //Desativado devido a poucas colunas.
        Tabela.setSelectionMode(0); //impede de selecionar multiplas linhas.

        //for para evitar que o usuário minimize demais as colunas:
        for (int i = 0; i < Colunas.length; i++)
        {
            Tabela.getColumnModel().getColumn(i).setMinWidth(110);
        };

        Painel_da_Tabela.add(Tabela);
        
        //Scroll_da_Tabela:
        JScrollPane Scroll_da_Tabela = new JScrollPane
        (Tabela, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Scroll_da_Tabela.setSize(Painel_da_Tabela.getWidth(), Painel_da_Tabela.getHeight());
        Scroll_da_Tabela.getViewport().setBackground(Cor_Fundo);
        Scroll_da_Tabela.setBorder(Borda_Geral);
        
        Painel_da_Tabela.add(Scroll_da_Tabela);
    }
    
}