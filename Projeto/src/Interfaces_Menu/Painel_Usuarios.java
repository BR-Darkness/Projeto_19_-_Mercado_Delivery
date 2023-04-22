package Interfaces_Menu;

import Componentes.CustomComboBox;
import Componentes.Sistema_de_Temas;
import Interfaces.Menu;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Painel_Usuarios extends JPanel
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
    private JLabel      lblID_Usuario_Consulta, lblNome_Consulta;
    private JTextField  txtID_Usuario_Consulta, txtNome_Consulta;
    private JButton     btnConsultarID, btnConsultaNome;
    
    //Componentes Painel Dados:
    private JLabel      lblNome, lblSexo, lblCargo, lblRua, lblNumeroRua;
    private JLabel      lblBairro, lblCidade, lblUF, lblCEP, lblSalario, lblRG;
    private JLabel      lblCPF, lblTelefone, lblCelular, lblLogin, lblSenha;
    private JTextField  txtNome, txtRua, txtNumeroRua, txtCidade, txtCPF;
    private JTextField  txtBairro, txtRG, txtTelefone, txtCelular, txtLogin, txtSenha;
    private CustomComboBox      cbxSexo, cbxCargo, cbxUF;
    private JFormattedTextField ftxtCEP, ftxtSalario;
    private MaskFormatter       mskCEP, mskSalario;
    private JButton     btnInserir, btnDeletar, btnEditar, btnCancelar;
            
    public Painel_Usuarios() 
    {
        //Janela:
        this.setLocation(0, 0);
        this.setSize(800, 585);
        this.setLayout(null);
        this.setBorder(Borda_Fundo);
        this.setBackground(Cor_Fundo);
        
        //Painel de Consulta:
        Consulta();
        
        //Dados:
        Dados();
        
        //Tabela:
        Tabela();
        
        //Botoes:
        Botoes();
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
        
        //lblID_Usuario:
        lblID_Usuario_Consulta = new JLabel("ID do Usuario: ");
        lblID_Usuario_Consulta.setSize(90, 20);
        lblID_Usuario_Consulta.setLocation(10, 5);
        lblID_Usuario_Consulta.setForeground(Cor_Fonte_Consulta);

        pnlConsulta.add(lblID_Usuario_Consulta);
        
        //txtID_Usuario_Consulta:
        txtID_Usuario_Consulta = new JTextField(10);
        txtID_Usuario_Consulta.setSize(100, 20);
        txtID_Usuario_Consulta.setLocation(100, 5);
        txtID_Usuario_Consulta.setHorizontalAlignment(txtID_Usuario_Consulta.CENTER);
        txtID_Usuario_Consulta.setBorder(Borda_Geral);
        
        pnlConsulta.add(txtID_Usuario_Consulta);
        
        //btnConsultaID:
        btnConsultarID = new JButton(Icone_Pesquisar);
        btnConsultarID.setSize(30, 30);
        btnConsultarID.setLocation(205, 0);
        btnConsultarID.setBackground(Cor_Painel_Consulta);
        btnConsultarID.setBorder(null);
        btnConsultarID.setFocusPainted(false);
        btnConsultarID.setToolTipText("Realiza uma consulta no banco de dados através do ID do Usúario.");
        btnConsultarID.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnConsultarID.setBackground(Color.gray);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnConsultarID.setBackground(Cor_Painel_Consulta);
            }
            
            public void mouseClicked(MouseEvent mouse)
            {
                /*Aguardando Banco de dados.*/
            }
        });
        
        pnlConsulta.add(btnConsultarID);
        
        //lblNome_Consulta:
        lblNome_Consulta = new JLabel("Nome do Usuario: ");
        lblNome_Consulta.setSize(110, 20);
        lblNome_Consulta.setLocation(245, 5);
        lblNome_Consulta.setForeground(Cor_Fonte_Consulta);
        
        pnlConsulta.add(lblNome_Consulta);
        
        //txtNome_Consulta:
        txtNome_Consulta = new JTextField();
        txtNome_Consulta.setSize(410, 20);
        txtNome_Consulta.setLocation(355, 5);
        txtNome_Consulta.setBorder(Borda_Geral);
        
        pnlConsulta.add(txtNome_Consulta);
        
        //btnConsultaNome:
        btnConsultaNome = new JButton(Icone_Pesquisar);
        btnConsultaNome.setSize(30, 30);
        btnConsultaNome.setLocation(getWidth() - 30, 0);
        btnConsultaNome.setBackground(Cor_Painel_Consulta);
        btnConsultaNome.setBorder(null);
        btnConsultaNome.setFocusPainted(false);
        btnConsultaNome.setToolTipText("Realiza uma consulta no banco de dados através do nome do Usúario.");
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
    }
    
    public void Dados()
     {
        /*650 X 175*/
        //pnlDados: 
        JPanel pnlDados = new JPanel();
        pnlDados.setSize(660, 160);
        pnlDados.setLocation(10, 40);
        pnlDados.setLayout(null);
        pnlDados.setBorder(Borda_Geral);
        pnlDados.setBackground(Cor_Fundo);
        
        this.add(pnlDados);
        
        /*Linha 01: ----------------------------------------------------------*/
        
        //lblNome:
        lblNome = new JLabel("Nome: ");
        lblNome.setSize(50, 20);
        lblNome.setLocation(10, 10);
        lblNome.setForeground(Cor_Fonte);
        
        pnlDados.add(lblNome);
        
        //txtNome:
        txtNome = new JTextField();
        txtNome.setSize(190, 20);
        txtNome.setLocation(70, 10);
        
        pnlDados.add(txtNome);
        
        //lblSexo:
        lblSexo = new JLabel("Sexo: ");
        lblSexo.setSize(50, 20);
        lblSexo.setLocation(270, 10);
        lblSexo.setForeground(Cor_Fonte);
        
        pnlDados.add(lblSexo);
                
        //cbxSexo:
        String cbxSexoItens [] = {"Feminino", "Masculino"};
        
        cbxSexo = new CustomComboBox(100, 20, cbxSexoItens, Tema.Cor_Botoes);
        cbxSexo.setLocation(330, 10);
        
        pnlDados.add(cbxSexo);
        
        //lblCargo:
        lblCargo = new JLabel("Cargo: ");
        lblCargo.setSize(50, 20);
        lblCargo.setLocation(440, 10);
        lblCargo.setForeground(Cor_Fonte);
        
        pnlDados.add(lblCargo);
        
        //cbxCargo:
        String cbxCargoItens [] =
        {
            "Vendas", "Estoque", "Entregas", "Vendas + Estoque",
            "Vendas + Entregas", "Entregas + Estoque", "Gerente"
        };
        cbxCargo = new CustomComboBox(160, 20, cbxCargoItens, Tema.Cor_Botoes);
        cbxCargo.setLocation(490, 10);
        
        pnlDados.add(cbxCargo);
        
        /*Linha 02: ----------------------------------------------------------*/
        
        //lblRua
        lblRua = new JLabel("Rua: ");
        lblRua.setSize(30, 20);
        lblRua.setLocation(10, 40);
        lblRua.setForeground(Cor_Fonte);
        
        pnlDados.add(lblRua);
        
        //txtRua:
        txtRua = new JTextField();
        txtRua.setSize(190, 20);
        txtRua.setLocation(70, 40);
        
        pnlDados.add(txtRua);
        
        //lblNumeroRua:
        lblNumeroRua = new JLabel("Número:");
        lblNumeroRua.setSize(50, 20);
        lblNumeroRua.setLocation(270, 40);
        lblNumeroRua.setForeground(Cor_Fonte);
        
        pnlDados.add(lblNumeroRua);
        
        //txtNumeroRua:
        txtNumeroRua = new JTextField();
        txtNumeroRua.setSize(100, 20);
        txtNumeroRua.setLocation(330, 40);
        
        pnlDados.add(txtNumeroRua);
        
        //lblBairro:
        lblBairro = new JLabel("Bairro: ");
        lblBairro.setSize(50, 20);
        lblBairro.setLocation(440, 40);
        lblBairro.setForeground(Cor_Fonte);
        
        pnlDados.add(lblBairro);
        
        //txtBairro:
        txtBairro = new JTextField();
        txtBairro.setSize(160, 20);
        txtBairro.setLocation(490, 40);
        
        pnlDados.add(txtBairro);
        
        /*Linha 03: ----------------------------------------------------------*/
        
        //lblCidade:
        lblCidade = new JLabel("Cidade: ");
        lblCidade.setSize(50, 20);
        lblCidade.setLocation(10, 70);
        lblCidade.setForeground(Cor_Fonte);
        
        pnlDados.add(lblCidade);
        
        //txtCidade:
        txtCidade = new JTextField();
        txtCidade.setSize(190, 20);
        txtCidade.setLocation(70, 70);
        
        pnlDados.add(txtCidade);
        
        //lblUF:
        lblUF = new JLabel("UF: ");
        lblUF.setSize(30, 20);
        lblUF.setLocation(270, 70);
        lblUF.setForeground(Cor_Fonte);
        
        pnlDados.add(lblUF);
        
        //cbxUF:
        String cbxUFItens [] = 
        {
            "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
            "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR",
            "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"
        };
        
        cbxUF = new CustomComboBox(50, 20, cbxUFItens, Tema.Cor_Botoes);
        cbxUF.setLocation(300, 70);
        
        pnlDados.add(cbxUF);

        //lblCEP:
        lblCEP = new JLabel("CEP: ");
        lblCEP.setSize(40, 20);
        lblCEP.setLocation(360, 70);
        lblCEP.setForeground(Cor_Fonte);
        
        pnlDados.add(lblCEP);
        
        //ftxtCEP:
         try 
         {
             mskCEP = new MaskFormatter("#####-###");
             mskCEP.setPlaceholderCharacter('_');
         } 
         
         catch (Exception e) 
         {
             JOptionPane.showMessageDialog(null, "Error");
         }
         
        ftxtCEP = new JFormattedTextField(mskCEP);
        ftxtCEP.setSize(80, 20);
        ftxtCEP.setLocation(400, 70);
        ftxtCEP.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        pnlDados.add(ftxtCEP);
        
        //lblSalario:
        lblSalario = new JLabel("Salário: ");
        lblSalario.setSize(50, 20);
        lblSalario.setLocation(490, 70);
        lblSalario.setForeground(Cor_Fonte);
        
        pnlDados.add(lblSalario);
        
        //txtSalario:
//        try 
//         {
//             mskSalario = new MaskFormatter();
//             mskSalario.setValidCharacters("0123456789,");
//         } 
//         
//         catch (Exception e) 
//         {
//             JOptionPane.showMessageDialog(null, "Error");
//         }
        
        ftxtSalario = new JFormattedTextField();
        ftxtSalario.setSize(110, 20);
        ftxtSalario.setLocation(540, 70);
        
        pnlDados.add(ftxtSalario);
        
        /*Linha 04: ----------------------------------------------------------*/
  
        //lblRG:
        lblRG = new JLabel("RG: ");
        lblRG.setSize(50, 20);
        lblRG.setLocation(10, 100);
        lblRG.setForeground(Cor_Fonte);
        
        pnlDados.add(lblRG);
        
        //txtRG:
        txtRG = new JTextField();
        txtRG.setSize(190, 20);
        txtRG.setLocation(70, 100);
        
        pnlDados.add(txtRG);
        
        //lblCPF:
        lblCPF = new JLabel("CPF: ");
        lblCPF.setSize(50, 20);
        lblCPF.setLocation(270, 100);
        lblCPF.setForeground(Cor_Fonte);
        
        pnlDados.add(lblCPF);
        
        //txtCPF:
        txtCPF = new JTextField();
        txtCPF.setSize(150, 20);
        txtCPF.setLocation(330, 100);
        
        pnlDados.add(txtCPF);
        
        //lblLogin:
        lblLogin = new JLabel("Login: ");
        lblLogin.setSize(50, 20);
        lblLogin.setLocation(490, 100);
        lblLogin.setForeground(Cor_Fonte);
        
        pnlDados.add(lblLogin);
        
        //txtLogin:
        txtLogin = new JTextField();
        txtLogin.setSize(110, 20);
        txtLogin.setLocation(540, 100);
        
        pnlDados.add(txtLogin);
        
        /*Linha 05: ----------------------------------------------------------*/
        
        //lblTelefone:
        lblTelefone = new JLabel("Telefone: ");
        lblTelefone.setSize(60, 20);
        lblTelefone.setLocation(10, 130);
        lblTelefone.setForeground(Cor_Fonte);
        
        pnlDados.add(lblTelefone);
        
        //txtTelefone:
        txtTelefone = new JTextField();
        txtTelefone.setSize(190, 20);
        txtTelefone.setLocation(70, 130);
        
        pnlDados.add(txtTelefone);
        
        //lblCelular:
        lblCelular = new JLabel("Celular: ");
        lblCelular.setSize(60, 20);
        lblCelular.setLocation(270, 130);
        lblCelular.setForeground(Cor_Fonte);
        
        pnlDados.add(lblCelular);
        
        //txtCelular:
        txtCelular = new JTextField();
        txtCelular.setSize(150, 20);
        txtCelular.setLocation(330, 130);
        
        pnlDados.add(txtCelular);
        
        //lblSenha:
        lblSenha = new JLabel("Senha: ");
        lblSenha.setSize(50, 20);
        lblSenha.setLocation(490, 130);
        lblSenha.setForeground(Cor_Fonte);
        
        pnlDados.add(lblSenha);
        
        //txtSenha:
        txtSenha = new JTextField();
        txtSenha.setSize(110, 20);
        txtSenha.setLocation(540, 130);
        
        pnlDados.add(txtSenha);
    }
    
    public void Botoes()
    {
        //btnInserir:
        btnInserir = new JButton("Inserir", Icone_Adicionar);
        btnInserir.setSize(110, 30);
        btnInserir.setFocusPainted(false);
        btnInserir.setLocation(this.getWidth() - 120, 40);
        btnInserir.setHorizontalAlignment(JButton.LEFT);
        btnInserir.setBackground(Cor_Botoes);
        btnInserir.setForeground(Cor_Fonte_Botoes);
        btnInserir.setToolTipText("Inserir dados na tabela.");
        btnInserir.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });
        
        this.add(btnInserir);
        
        //btnDeletar:
        btnDeletar = new JButton("Deletar", Icone_Excluir);
        btnDeletar.setSize(110, 30);
        btnDeletar.setFocusPainted(false);
        btnDeletar.setLocation(this.getWidth() - 120, 80);
        btnDeletar.setHorizontalAlignment(JButton.LEFT);
        btnDeletar.setBackground(Cor_Botoes);
        btnDeletar.setForeground(Cor_Fonte_Botoes);
        btnDeletar.setToolTipText("Deletar dados da linha selecionada.");
        btnDeletar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });

        this.add(btnDeletar);
        
        //btnAlterar:
        btnEditar = new JButton("Editar", Icone_Editar);
        btnEditar.setSize(110, 30);
        btnEditar.setFocusPainted(false);
        btnEditar.setLocation(this.getWidth() - 120, 120);
        btnEditar.setHorizontalAlignment(JButton.LEFT);
        btnEditar.setBackground(Cor_Botoes);
        btnEditar.setForeground(Cor_Fonte_Botoes);
        btnEditar.setToolTipText("Editar dados da linha selecionada.");
        btnEditar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });

        this.add(btnEditar);
        
        //Separador:
        JSeparator Separador = new JSeparator();
        Separador.setSize(110, 1);
        Separador.setLocation(this.getWidth() - 120, 160);
        Separador.setBackground(Cor_Fonte);
        Separador.setForeground(Cor_Fonte);
        
        this.add(Separador);
        
        //btnCancelar:
        btnCancelar = new JButton("Cancelar", Icone_Cancelar);
        btnCancelar.setSize(110, 30);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setLocation(this.getWidth() - 120, 170);
        btnCancelar.setHorizontalAlignment(JButton.LEFT);
        btnCancelar.setBackground(Cor_Botoes);
        btnCancelar.setForeground(Cor_Fonte_Botoes);
        btnCancelar.setToolTipText("Cancelar ação.");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });

        this.add(btnCancelar);
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
        "ID usuário", "Nome", "Sexo", "Cargo", "Rua", "Número", "Bairro", "Cidade",
        "UF", "CEP", "Sálario", "RG", "CPF", "Telefone", "Celular", "Login", "Senha"
        };
        
        String [] [] Linhas = {};
        
        //Painel_da_Tabela:
        Painel_da_Tabela = new JPanel();
        Painel_da_Tabela.setSize(getWidth() - 20, 360);
        Painel_da_Tabela.setLocation(10, 215);
        Painel_da_Tabela.setLayout(new GridLayout());
        
        this.add(Painel_da_Tabela);
        
        //Modelo_da_Tabela:
        Modelo_da_Tabela = new DefaultTableModel(Linhas, Colunas)
        {
            //um false para cada coluna:
            boolean[] Editavel = new boolean[]
            { 
              false, false, false, false, false, false, false, false,
              false, false, false, false, false, false, false, false, false
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
        Tabela.setAutoResizeMode(0);
        Tabela.setSelectionMode(0); //impede de selecionar multiplas linhas.

        //for para evitar que o usuário minimize demais as colunas:
        for (int i = 0; i < 17; i++)
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