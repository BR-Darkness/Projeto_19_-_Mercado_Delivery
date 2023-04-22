package Em_Testes;

import Componentes.CustomComboBox;
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

public class Painel_Veiculos extends JPanel
{
    //Icones: 
    private ImageIcon   Icone_Pesquisar     = new ImageIcon(getClass().getResource("/Icones/Icone_Pesquisar.png"));
    private ImageIcon   Icone_Adicionar     = new ImageIcon(getClass().getResource("/Icones/Icone_Adicionar.png"));
    private ImageIcon   Icone_Excluir       = new ImageIcon(getClass().getResource("/Icones/Icone_Excluir.png"));
    private ImageIcon   Icone_Editar        = new ImageIcon(getClass().getResource("/Icones/Icone_Editar.png"));
    private ImageIcon   Icone_Cancelar      = new ImageIcon(getClass().getResource("/Icones/Icone_Cancelar.png"));
    private ImageIcon   Icone_Atualizar     = new ImageIcon(getClass().getResource("/Icones/Icone_Atualizar.png"));
    
    //Cores:
    private Color       Cor_Painel_Consulta = new Color(86, 86, 86, 254);
    private Color       Cor_Painel_Dados    = new Color(225, 225, 225, 254);
    private Color       Cor_Botoes          = new Color(86, 86, 86, 254);
    
    //Bordas:
    private Border      Borda_Paineis       = BorderFactory.createLineBorder(new Color(128, 128, 128, 254));
    private Border      Borda_Consulta      = BorderFactory.createLineBorder(new Color(86, 86, 86, 254));
    
    //Componentes Painel Consulta:
    private JLabel      lblID_Usuario_Consulta, lblNome_Consulta;
    private JTextField  txtID_Usuario_Consulta, txtNome_Consulta;
    private JButton     btnConsultarID, btnConsultaNome;
    
    //Componentes:
    private JLabel      lblNome, lblSexo, lblEndereco, lblCidade;
    private JTextField  txtNome, txtSexo, txtEndereco, txtCidade;
    private JLabel      lblBairro, lblCEP, lblUF, lblRG, lblCPF;
    private JTextField  txtBairro, txtCEP, txtUF, txtRG, txtCPF;
    private JLabel      lblTelefone, lblCelular, lblLogin, lblSenha;
    private JTextField  txtTelefone, txtCelular, txtLogin, txtSenha;
    private JButton     btnInserir, btnDeletar, btnEditar, btnCancelar;
    private JPanel      pnlDados;
    private JFormattedTextField ftxtCEP;
            
    public Painel_Veiculos() 
    {
        //Janela:
        this.setLocation(0, 0);
        this.setSize(800, 585);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(new Color(86,86,86), 1));
        this.setBackground(new Color(228, 228, 228, 254));
        
        //Painel de Consulta:
        Consulta();
        
        //Dados:
        Dados();
        
        //Tabela:
        Tabela();
    }
    
     public void Consulta()
    {
        //Painel Consultas:
        JPanel pnlConsulta = new JPanel();
        pnlConsulta.setSize(this.getWidth(), 30);
        pnlConsulta.setLocation(0, 0);
        pnlConsulta.setLayout(null);
        pnlConsulta.setBackground(Cor_Painel_Consulta);
        
        this.add(pnlConsulta);
        
        //lblID_Usuario:
        lblID_Usuario_Consulta = new JLabel("ID do Veiculo: ");
        lblID_Usuario_Consulta.setSize(90, 20);
        lblID_Usuario_Consulta.setLocation(10, 5);
        lblID_Usuario_Consulta.setForeground(Color.white);

        pnlConsulta.add(lblID_Usuario_Consulta);
        
        //txtID_Usuario_Consulta:
        txtID_Usuario_Consulta = new JTextField(10);
        txtID_Usuario_Consulta.setSize(100, 20);
        txtID_Usuario_Consulta.setLocation(100, 5);
        txtID_Usuario_Consulta.setHorizontalAlignment(txtID_Usuario_Consulta.CENTER);
        txtID_Usuario_Consulta.setBorder(Borda_Consulta);
        
        pnlConsulta.add(txtID_Usuario_Consulta);
        
        //btnConsultaID:
        btnConsultarID = new JButton(Icone_Pesquisar);
        btnConsultarID.setSize(30, 30);
        btnConsultarID.setLocation(205, 0);
        btnConsultarID.setBackground(Cor_Painel_Consulta);
        btnConsultarID.setBorder(null);
        btnConsultarID.setFocusPainted(false);
        btnConsultarID.setToolTipText("Realiza uma consulta no banco de dados através do ID do Veiculo.");
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
        lblNome_Consulta = new JLabel("Nome do Veiculo: ");
        lblNome_Consulta.setSize(110, 20);
        lblNome_Consulta.setLocation(245, 5);
        lblNome_Consulta.setForeground(Color.white);
        
        pnlConsulta.add(lblNome_Consulta);
        
        //txtNome_Consulta:
        txtNome_Consulta = new JTextField();
        txtNome_Consulta.setSize(410, 20);
        txtNome_Consulta.setLocation(355, 5);
        txtNome_Consulta.setBorder(Borda_Consulta);
        
        pnlConsulta.add(txtNome_Consulta);
        
        //btnConsultaNome:
        btnConsultaNome = new JButton(Icone_Pesquisar);
        btnConsultaNome.setSize(30, 30);
        btnConsultaNome.setLocation(getWidth() - 30, 0);
        btnConsultaNome.setBackground(Cor_Painel_Consulta);
        btnConsultaNome.setBorder(null);
        btnConsultaNome.setFocusPainted(false);
        btnConsultaNome.setToolTipText("Realiza uma consulta no banco de dados através do nome do Veiculo.");
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
        //pnlDados:
        pnlDados = new JPanel();
        pnlDados.setSize(this.getWidth() - 20, 175);
        pnlDados.setLocation(10, 40);
        pnlDados.setLayout(null);
        pnlDados.setBorder(Borda_Paineis);
        pnlDados.setBackground(new Color(228, 228, 228, 254));
        
        this.add(pnlDados);

     //----MASCARA--------------------------------------------------  
        
        //lblNome:
        lblNome = new JLabel("Nome: ");
        lblNome.setSize(50, 20);
        lblNome.setLocation(10, 10);
        
        pnlDados.add(lblNome);
        
        //txtNome:
        MaskFormatter F_Mascara = new MaskFormatter(); 
        try
         {
            F_Mascara.setMask("#####-###"); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter('_'); //Caracter para preencimento 
        }
        
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro na Mascara");
        }  
        
        JTextField txtNome = new JTextField();
        txtNome.setSize(250, 20);
        txtNome.setLocation(60, 10);
        
        pnlDados.add(txtNome);
        
        //lblSexo:
        lblSexo = new JLabel("Sexo: ");
        lblSexo.setSize(50, 20);
        lblSexo.setLocation(320, 10);
        
        pnlDados.add(lblSexo);
                
        //cbxSexo:
        String cbxSexoItens [] = {"Feminino", "Masculino"};
        
        //A CustomComboBox ira retornar o valor aqui:
        txtSexo = new JTextField(null); 
        
        CustomComboBox cbxSexo = new CustomComboBox(100, 20, cbxSexoItens, Color.gray);
        cbxSexo.setLocation(370, 10);
        pnlDados.add(cbxSexo);
        
        //lblEndereco
        lblEndereco = new JLabel("Endereço: ");
        lblEndereco.setSize(65, 20);
        lblEndereco.setLocation(10, 40);
        
        pnlDados.add(lblEndereco);
        
        //txtEndereco:
        txtEndereco = new JTextField();
        txtEndereco.setSize(230, 20);
        txtEndereco.setLocation(80, 40);
        
        pnlDados.add(txtEndereco);
        
        //lblCidade:
        lblCidade = new JLabel("Cidade: ");
        lblCidade.setSize(50, 20);
        lblCidade.setLocation(320, 40);
        
        pnlDados.add(lblCidade);
        
        //txtCidade:
        txtCidade = new JTextField();
        txtCidade.setSize(150, 20);
        txtCidade.setLocation(370, 40);
        
        pnlDados.add(txtCidade);
        
        //lblUF:
        lblUF = new JLabel("UF: ");
        lblUF.setSize(25, 20);
        lblUF.setLocation(530, 40);
        
        pnlDados.add(lblUF);
        
        //cbxUF:
        String cbxUFItens [] = 
        {
            "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
            "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR",
            "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"
        };
        
        //A CustomComboBox ira retornar o valor aqui:
        txtUF = new JTextField(""); 
        
        CustomComboBox cbxUF = new CustomComboBox(75, 20, cbxUFItens, Color.gray);
        cbxUF.setLocation(555, 40);
//        txtUF.setText(cbxUF.Item_Escolhido.getText()); //adicionar ao btn.
        
        pnlDados.add(cbxUF);

        /*175 X 630*/
        //lblBairro:
        lblBairro = new JLabel("Bairro: ");
        lblBairro.setSize(50, 20);
        lblBairro.setLocation(10, 70);
        
        pnlDados.add(lblBairro);
        
        //txtBairro:
        txtBairro = new JTextField();
        txtBairro.setSize(250, 20);
        txtBairro.setLocation(60, 70);
        
        pnlDados.add(txtBairro);
        
        //lblCep:
        lblBairro = new JLabel("CEP: ");
        lblBairro.setSize(35, 20);
        lblBairro.setLocation(320, 70);
        
        pnlDados.add(lblBairro);
        
        //txtCEP: /*Substituir por JFormatedTextField*/
        ftxtCEP = new JFormattedTextField(F_Mascara);
        ftxtCEP.setSize(100, 20);
        ftxtCEP.setLocation(360, 70);
        ftxtCEP.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        pnlDados.add(ftxtCEP);
        
               
        //lblRG:
        lblRG = new JLabel("RG: ");
        lblRG.setSize(30, 20);
        lblRG.setLocation(470, 70);
        
        pnlDados.add(lblRG);
        
        //txtRG:
        txtRG = new JTextField();
        txtRG.setSize(130, 20);
        txtRG.setLocation(500, 70);
        
        pnlDados.add(txtRG);  

        /*--------------------------------------------------*/

    //--------------------------------------------------------------------------    
        
        //btnInserir:
        btnInserir = new JButton("Inserir", Icone_Adicionar);
        btnInserir.setSize(110, 30);
        btnInserir.setFocusPainted(false);
        btnInserir.setLocation(pnlDados.getWidth() - 120, 10);
        btnInserir.setHorizontalAlignment(JButton.LEFT);
        btnInserir.setBackground(Cor_Botoes);
        btnInserir.setForeground(Color.white);
        btnInserir.setToolTipText("Inserir dados na tabela.");
        btnInserir.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });
        
        pnlDados.add(btnInserir);
        
        //btnDeletar:
        btnDeletar = new JButton("Deletar", Icone_Excluir);
        btnDeletar.setSize(110, 30);
        btnDeletar.setFocusPainted(false);
        btnDeletar.setLocation(pnlDados.getWidth() - 120, 50);
        btnDeletar.setHorizontalAlignment(JButton.LEFT);
        btnDeletar.setBackground(Cor_Botoes);
        btnDeletar.setForeground(Color.white);
        btnDeletar.setToolTipText("Deletar dados da linha selecionada.");
        btnDeletar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });

        pnlDados.add(btnDeletar);
        
        //btnAlterar:
        btnEditar = new JButton("Editar", Icone_Editar);
        btnEditar.setSize(110, 30);
        btnEditar.setFocusPainted(false);
        btnEditar.setLocation(pnlDados.getWidth() - 120, 90);
        btnEditar.setHorizontalAlignment(JButton.LEFT);
        btnEditar.setBackground(Cor_Botoes);
        btnEditar.setForeground(Color.white);
        btnEditar.setToolTipText("Editar dados da linha selecionada.");
        btnEditar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });

        pnlDados.add(btnEditar);
        
        //btnCancelar:
        btnCancelar = new JButton("Cancelar", Icone_Cancelar);
        btnCancelar.setSize(110, 30);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setLocation(pnlDados.getWidth() - 120, 130);
        btnCancelar.setHorizontalAlignment(JButton.LEFT);
        btnCancelar.setBackground(Cor_Botoes);
        btnCancelar.setForeground(Color.white);
        btnCancelar.setToolTipText("Cancelar ação.");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /*Aguardando Banco de dados.*/
            }
        });

        pnlDados.add(btnCancelar);        
    }

    public void Tabela()
    {
        //Componentes:
        JPanel Painel_da_Tabela;
        JTable Tabela;
        DefaultTableModel Modelo_da_Tabela;
        
        //Linhas e Colunas para o modelo da tabela:
        String [] Colunas = 
        {"ID do Veiculo", "Nome", "Sexo", "Endereço", "Cidade", "UF",
        "Bairro", "CEP", "RG"};
        String [] [] Linhas = {};
        
        //Painel_da_Tabela:
        Painel_da_Tabela = new JPanel();
        Painel_da_Tabela.setSize(getWidth() - 20, 350);
        Painel_da_Tabela.setLocation(10, 225);
        Painel_da_Tabela.setLayout(new GridLayout());
        
        this.add(Painel_da_Tabela);
        
        //Modelo_da_Tabela:
        Modelo_da_Tabela = new DefaultTableModel(Linhas, Colunas)
        {
            //um false para cada coluna:
            boolean[] Editavel = new boolean[]
            { false, false, false, false, false, false,
              false
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
        for (int i = 0; i < Colunas.length; i++)
        {
            Tabela.getColumnModel().getColumn(i).setMinWidth(109);
        };

        Painel_da_Tabela.add(Tabela);
        
        //Scroll_da_Tabela:
        JScrollPane Scroll_da_Tabela = new JScrollPane
        (Tabela, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Scroll_da_Tabela.setSize(Painel_da_Tabela.getWidth(), Painel_da_Tabela.getHeight());
        Scroll_da_Tabela.getViewport().setBackground(new Color(228, 228, 228, 254));
        
        Painel_da_Tabela.add(Scroll_da_Tabela);
    }
    
}