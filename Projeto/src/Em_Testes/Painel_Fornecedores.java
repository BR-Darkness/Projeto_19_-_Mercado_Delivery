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

public class Painel_Fornecedores extends JPanel
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
    private JLabel      lblID_Fornecedor_Consulta, lblProduto_Consulta;
    private JTextField  txtID_Fornecedor_Consulta, txtProduto_Consulta;
    private JButton     btnConsultarFornecedor, btnConsultaProduto;
    
    //Componentes:
    private JLabel      lblNome, lblSexo, lblEndereco, lblCidade;
    private JTextField  txtNome, txtSexo, txtEndereco, txtCidade;
    private JLabel      lblBairro, lblUF;
    private JTextField  txtBairro, txtCEP, txtUF;
    private JButton     btnInserir, btnDeletar, btnEditar, btnCancelar;
    private JPanel      pnlDados; 
            
    public Painel_Fornecedores() 
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
        
        //lblID_Fornecedor:
        lblID_Fornecedor_Consulta = new JLabel("Nome do Fornecedor: ");
        lblID_Fornecedor_Consulta.setSize(130, 20);
        lblID_Fornecedor_Consulta.setLocation(10, 5);
        lblID_Fornecedor_Consulta.setForeground(Color.white);

        pnlConsulta.add(lblID_Fornecedor_Consulta);
        
        //txtID_Fornecedor_Consulta:
        txtID_Fornecedor_Consulta = new JTextField(10);
        txtID_Fornecedor_Consulta.setSize(360, 20);
        txtID_Fornecedor_Consulta.setLocation(140, 5);
        txtID_Fornecedor_Consulta.setHorizontalAlignment(txtID_Fornecedor_Consulta.CENTER);
        txtID_Fornecedor_Consulta.setBorder(Borda_Consulta);
        
        pnlConsulta.add(txtID_Fornecedor_Consulta);
        
        //btnConsultaFornecedor:
        btnConsultarFornecedor = new JButton(Icone_Pesquisar);
        btnConsultarFornecedor.setSize(30, 30);
        btnConsultarFornecedor.setLocation(505, 0);
        btnConsultarFornecedor.setBackground(Cor_Painel_Consulta);
        btnConsultarFornecedor.setBorder(null);
        btnConsultarFornecedor.setFocusPainted(false);
        btnConsultarFornecedor.setToolTipText("Realiza uma consulta no banco de dados através do ID do Fornecedor.");
        btnConsultarFornecedor.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnConsultarFornecedor.setBackground(Color.gray);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnConsultarFornecedor.setBackground(Cor_Painel_Consulta);
            }
            
            public void mouseClicked(MouseEvent mouse)
            {
                /*Aguardando Banco de dados.*/
            }
        });
        
        pnlConsulta.add(btnConsultarFornecedor);
        
        //lblProduto_Consulta:
        lblProduto_Consulta = new JLabel("ID do Fornecedor: ");
        lblProduto_Consulta.setSize(110, 20);
        lblProduto_Consulta.setLocation(545, 5);
        lblProduto_Consulta.setForeground(Color.white);
        
        pnlConsulta.add(lblProduto_Consulta);
        
        //txtProduto_Consulta:
        txtProduto_Consulta = new JTextField();
        txtProduto_Consulta.setSize(105, 20);
        txtProduto_Consulta.setLocation(660, 5);
        txtProduto_Consulta.setBorder(Borda_Consulta);
        
        pnlConsulta.add(txtProduto_Consulta);
        
        //btnConsultaProduto:
        btnConsultaProduto = new JButton(Icone_Pesquisar);
        btnConsultaProduto.setSize(30, 30);
        btnConsultaProduto.setLocation(getWidth() - 30, 0);
        btnConsultaProduto.setBackground(Cor_Painel_Consulta);
        btnConsultaProduto.setBorder(null);
        btnConsultaProduto.setFocusPainted(false);
        btnConsultaProduto.setToolTipText("Realiza uma consulta no banco de dados através do nome do Fornecedor.");
        btnConsultaProduto.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnConsultaProduto.setBackground(Color.gray);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnConsultaProduto.setBackground(Cor_Painel_Consulta);
            }
            
            public void mouseClicked(MouseEvent mouse)
            {
                /*Aguardando Banco de dados.*/
            }
        });
        
        pnlConsulta.add(btnConsultaProduto);
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
        
        //lblNome:
        lblNome = new JLabel("Nome do fornecedor: ");
        lblNome.setSize(150, 20);
        lblNome.setLocation(10, 10);
        
        pnlDados.add(lblNome);
        
        //txtNome:
        txtNome = new JTextField();
        txtNome.setSize(170, 20);
        txtNome.setLocation(140, 10);
        
        pnlDados.add(txtNome);
        
        //lblSexo:
        lblSexo = new JLabel("Sexo: ");
        lblSexo.setSize(50, 20);
        lblSexo.setLocation(320, 10);
        
        pnlDados.add(lblSexo);
                
        //cbxSexo:
        String cbxSexoItens [] = {"Feminino", "Masculino"};
        
        //A CustomComboBox ira retornar o valor aqui:
        txtSexo = new JTextField(); 
        
        CustomComboBox cbxSexo = new CustomComboBox(100, 20, cbxSexoItens, Color.gray);
        cbxSexo.setLocation(375, 10);
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
        txtCidade.setLocation(375, 40);
        
        pnlDados.add(txtCidade);
        
        //lblUF:
        lblUF = new JLabel("UF: ");
        lblUF.setSize(25, 20);
        lblUF.setLocation(495, 10);
        
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
        cbxUF.setLocation(525, 10);
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
        txtCEP = new JTextField();
        txtCEP.setSize(100, 20);
        txtCEP.setLocation(375, 70);
        
        pnlDados.add(txtCEP);
        
  
        
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
        {"ID Fornecedor", "Nome", "Sexo", "UF", "Endereço", "Cidade",
        "Bairro", "CEP"};
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
              false, false
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