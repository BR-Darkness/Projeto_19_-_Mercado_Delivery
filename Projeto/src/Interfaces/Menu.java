package Interfaces;

import Componentes.Sistema_de_Temas;
import Em_Testes.Painel_Fornecedores;
import Em_Testes.Painel_Veiculos;
import Interfaces_Menu.*;

import javax.swing.*;
import java.awt.*;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.Border;

public class Menu extends JFrame
{
    //Sistema de Temas (BETA)
    //String Temas [] = {"Classico", "Azul", "Verde", "Vermelho", "Rosa", "Amarelo", "Esmeralda", "Preto"};
    //int a = JOptionPane.showOptionDialog(null, "Escolha uma opção: ", "Sistema de Temas (BETA)", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Temas, Temas[0]);
 
    //Interfaces:
    Login Tela_Login = new Login();
    //Sistema de temas desativado, não deu para finalizar a tempo.
    public Sistema_de_Temas Tema = new Sistema_de_Temas(0);

    //Cores:
    public  Color Cor_Menu_Superior         = Tema.Cor_Menu_Superior;
    public  Color Cor_Menu_Lateral          = Tema.Cor_Menu_Lateral;
    public  Color Cor_Fundo                 = Tema.Cor_Fundo;
    public  Color Cor_Botoes                = Tema.Cor_Botoes;
    
    public  Color Cor_Fonte_Menu_Superior   = Tema.Cor_Fonte_Menu_Superior;
    public  Color Cor_Fonte_Menu_Lateral    = Tema.Cor_Fonte_Menu_Lateral;
    public  Color Cor_Fonte_Paineis         = Tema.Cor_Fonte_Paineis;
    public  Color Cor_Fonte_Botoes          = Tema.Cor_Fonte_Botoes;
    
    public  Border Borda_Fundo              = Tema.Borda_Fundo;
    public  Border Borda_Paineis            = Tema.Borda_Paineis;
    
    //Icones:
    private final ImageIcon Icone_Aplicativo  = new ImageIcon(getClass().getResource("/Icones/Icone_Aplicativo.png"));
    
    //Icones Grupo Vendas:
    private final ImageIcon Icone_Nova_Venda  = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Nova_Venda.png"));
    private final ImageIcon Icone_Clientes    = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Clientes.png"));
    private final ImageIcon Icone_Historico   = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Historico.png"));
    
    //Icone Grupo Estoque:
    private final ImageIcon Icone_Produtos        = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Produtos.png"));
    private final ImageIcon Icone_Lotes           = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Lotes.png"));
    private final ImageIcon Icone_Fornecedores    = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Fornecedores.png"));
    
    //Icone Grupo Veiculos:
    private final ImageIcon Icone_Veiculos        = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Veiculos.png"));
    
    //Icone Grupo Funcionarios:
    private final ImageIcon Icone_Funcionarios    = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Funcionarios.png"));
    
    //Icone Grupo Relatorios:
    private final ImageIcon Icone_Relatorio       = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Relatorio.png"));
    
    //Icone Grupo Logoff:
    private final ImageIcon Icone_Logoff          = new ImageIcon(getClass().getResource("/Icones_Menu/Icone_Logoff.png"));
    
    //Componentes:
    private final JPanel pnlJanelas, Menu_Lateral;
    private final JLabel lblVendas, lblEstoque, lblEntregas;
    private final JLabel lblFuncionarios, lblRelatorios, lblSair;   
    private final JPanel Grupo_Vendas, Grupo_Estoque, Grupo_Entregas;
    private final JPanel Grupo_Gerente, Grupo_Relatorios, Grupo_Logoff;
    private final JButton btnNova_Venda, btnClientes, btnHistorico_Vendas;
    private final JButton btnProdutos, btnLotes, btnFornecedores, btnVeiculos;
    private final JButton btnFuncionarios, btnRelatorio_Vendas, btnLogoff;
    private String Janela_Aberta; //Responsavel por saber o painel aberto
    
    public Menu() 
    {     
        //Janela:
        this.setTitle("Menu");
        this.setSize(1000, 615);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(Cor_Fundo);
        this.setLocationRelativeTo(null);
        this.setIconImage(Icone_Aplicativo.getImage()); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Menu_Superior:
        Menu_Superior();
    
        //pnlJanelas:
        pnlJanelas = new JPanel();
        pnlJanelas.setSize(800, 585);
        pnlJanelas.setLocation(200, 30);
        pnlJanelas.setLayout(null);
        pnlJanelas.setBackground(Cor_Fundo);
        pnlJanelas.setBorder(Borda_Fundo);
        
        this.add(pnlJanelas);
    
        //Menu_Lateral:
        Menu_Lateral = new JPanel();
        Menu_Lateral.setSize(200, this.getHeight() - 30);
        Menu_Lateral.setLocation(0, 30);
        Menu_Lateral.setLayout(null);
        Menu_Lateral.setAutoscrolls(true);
        Menu_Lateral.setBackground(Cor_Menu_Lateral);
        
        this.add(Menu_Lateral);
        
    //--------------------------------------------------------------------------
    
        //Grupo_Vendas: Dividindo em Paineis para melhor manutenção
        Grupo_Vendas = new JPanel();
        Grupo_Vendas.setSize(Menu_Lateral.getWidth(), 150);
        Grupo_Vendas.setLocation(0, 0);
        Grupo_Vendas.setLayout(null);
        Grupo_Vendas.setBackground(Cor_Menu_Lateral);
        
        Menu_Lateral.add(Grupo_Vendas);
        
        //lblVendas:
        lblVendas = new JLabel("Area de Vendas: ");
        lblVendas.setSize(Menu_Lateral.getWidth() - 20, 20);
        lblVendas.setLocation(12, 5);
        lblVendas.setForeground(Cor_Fonte_Menu_Lateral);
        
        Grupo_Vendas.add(lblVendas);
        
        //btnNova_Venda:
        btnNova_Venda = new JButton("Nova Venda", Icone_Nova_Venda);
        btnNova_Venda.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnNova_Venda.setLocation(10, 30);
        btnNova_Venda.setHorizontalAlignment(JButton.LEFT);
        btnNova_Venda.setFocusPainted(false);
        btnNova_Venda.setBackground(Cor_Botoes);
        btnNova_Venda.setForeground(Cor_Fonte_Botoes);
        btnNova_Venda.setToolTipText("Abre o painel de Vendas.");
        btnNova_Venda.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnNova_Venda")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnNova_Venda";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Erro_404 Painel_Erro_404 = new Painel_Erro_404();
                    pnlJanelas.add(Painel_Erro_404);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Vendas.add(btnNova_Venda);
        
        //btnClientes:
        btnClientes = new JButton("Clientes", Icone_Clientes);
        btnClientes.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnClientes.setLocation(10, 70);
        btnClientes.setHorizontalAlignment(JButton.LEFT);
        btnClientes.setFocusPainted(false);
        btnClientes.setBackground(Cor_Botoes);
        btnClientes.setForeground(Cor_Fonte_Botoes);
        btnClientes.setToolTipText("Abre o painel de Clientes.");
        btnClientes.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnClientes")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnClientes";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Clientes Painel_Clientes = new Painel_Clientes();
                    pnlJanelas.add(Painel_Clientes);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Vendas.add(btnClientes);
        
        //btnHistorico_Vendas:
        btnHistorico_Vendas = new JButton("Histórico de Vendas", Icone_Historico);
        btnHistorico_Vendas.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnHistorico_Vendas.setLocation(10, 110);
        btnHistorico_Vendas.setHorizontalAlignment(JButton.LEFT);
        btnHistorico_Vendas.setFocusPainted(false);
        btnHistorico_Vendas.setBackground(Cor_Botoes);
        btnHistorico_Vendas.setForeground(Cor_Fonte_Botoes);
        btnHistorico_Vendas.setToolTipText("Abre o painel de Historico de Vendas.");
        btnHistorico_Vendas.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnHistorico_Vendas")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnHistorico_Vendas";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Historico_de_Vendas Painel_Historico_de_Vendas = new Painel_Historico_de_Vendas();
                    pnlJanelas.add(Painel_Historico_de_Vendas);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Vendas.add(btnHistorico_Vendas);      
    //--------------------------------------------------------------------------
    
        //Grupo_Estoque: Dividindo em Paineis para melhor manutenção
        Grupo_Estoque = new JPanel();
        Grupo_Estoque.setSize(Menu_Lateral.getWidth(), 150);
        Grupo_Estoque.setLocation(0, 150);
        Grupo_Estoque.setLayout(null);
        Grupo_Estoque.setBackground(Cor_Menu_Lateral);
        
        Menu_Lateral.add(Grupo_Estoque);
        
        //lblVendas:
        lblEstoque = new JLabel("Controle de Estoque: ");
        lblEstoque.setSize(Menu_Lateral.getWidth() - 20, 20);
        lblEstoque.setLocation(12, 5);
        lblEstoque.setForeground(Cor_Fonte_Menu_Lateral);
        
        Grupo_Estoque.add(lblEstoque);
        
        //btnProdutos:
        btnProdutos = new JButton("Produtos", Icone_Produtos);
        btnProdutos.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnProdutos.setLocation(10, 30);
        btnProdutos.setHorizontalAlignment(JButton.LEFT);
        btnProdutos.setFocusPainted(false);
        btnProdutos.setBackground(Cor_Botoes);
        btnProdutos.setForeground(Cor_Fonte_Botoes);
        btnProdutos.setToolTipText("Abre o painel de Produtos.");
        btnProdutos.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnProdutos")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnProdutos";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Erro_404 Painel_Erro_404 = new Painel_Erro_404();
                    pnlJanelas.add(Painel_Erro_404);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Estoque.add(btnProdutos);
        
        //btnLotes:
        btnLotes = new JButton("Lotes", Icone_Lotes);
        btnLotes.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnLotes.setLocation(10, 70);
        btnLotes.setHorizontalAlignment(JButton.LEFT);
        btnLotes.setFocusPainted(false);
        btnLotes.setBackground(Cor_Botoes);
        btnLotes.setForeground(Cor_Fonte_Botoes);
        btnLotes.setToolTipText("Abre o painel de Lotes.");
        btnLotes.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnLotes")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnLotes";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Erro_404 Painel_Erro_404 = new Painel_Erro_404();
                    pnlJanelas.add(Painel_Erro_404);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Estoque.add(btnLotes);
        
        //btnFornecedores:
        btnFornecedores = new JButton("Fornecedores", Icone_Fornecedores);
        btnFornecedores.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnFornecedores.setLocation(10, 110);
        btnFornecedores.setHorizontalAlignment(JButton.LEFT);
        btnFornecedores.setFocusPainted(false);
        btnFornecedores.setBackground(Cor_Botoes);
        btnFornecedores.setForeground(Cor_Fonte_Botoes);
        btnFornecedores.setToolTipText("Abre o painel de Fornecedores.");
        btnFornecedores.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnFornecedores")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnFornecedores";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Fornecedores Painel_Fornecedores = new Painel_Fornecedores();
                    pnlJanelas.add(Painel_Fornecedores);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Estoque.add(btnFornecedores);
        
    //--------------------------------------------------------------------------
    
        //Grupo_Entregas: Dividindo em Paineis para melhor manutenção
        Grupo_Entregas = new JPanel();
        Grupo_Entregas.setSize(Menu_Lateral.getWidth(), 70);
        Grupo_Entregas.setLocation(0, 300);
        Grupo_Entregas.setLayout(null);
        Grupo_Entregas.setBackground(Cor_Menu_Lateral);
        
        Menu_Lateral.add(Grupo_Entregas);
        
        //lblEntregas:
        lblEntregas = new JLabel("Area de Transporte: ");
        lblEntregas.setSize(Menu_Lateral.getWidth() - 20, 20);
        lblEntregas.setLocation(12, 5);
        lblEntregas.setForeground(Cor_Fonte_Menu_Lateral);
        
        Grupo_Entregas.add(lblEntregas);
        
        //btnVeiculos:
        btnVeiculos = new JButton("Veiculos", Icone_Veiculos);
        btnVeiculos.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnVeiculos.setLocation(10, 30);
        btnVeiculos.setHorizontalAlignment(JButton.LEFT);
        btnVeiculos.setFocusPainted(false);
        btnVeiculos.setBackground(Cor_Botoes);
        btnVeiculos.setForeground(Cor_Fonte_Botoes);
        btnVeiculos.setToolTipText("Abre o painel de Veiculos.");
        btnVeiculos.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnVeiculos")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnVeiculos";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Veiculos Painel_Veiculos = new Painel_Veiculos();
                    pnlJanelas.add(Painel_Veiculos);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Entregas.add(btnVeiculos);
        
    //--------------------------------------------------------------------------
        
        //Grupo_Gerente: Dividindo em Paineis para melhor manutenção
        Grupo_Gerente = new JPanel();
        Grupo_Gerente.setSize(Menu_Lateral.getWidth(), 70);
        Grupo_Gerente.setLocation(0, 370);
        Grupo_Gerente.setLayout(null);
        Grupo_Gerente.setBackground(Cor_Menu_Lateral);
        
        Menu_Lateral.add(Grupo_Gerente);
        
        //lblFuncionarios:
        lblFuncionarios = new JLabel("Gestão de Funcionários: ");
        lblFuncionarios.setSize(Menu_Lateral.getWidth() - 20, 20);
        lblFuncionarios.setLocation(12, 5);
        lblFuncionarios.setForeground(Cor_Fonte_Menu_Lateral);
        
        Grupo_Gerente.add(lblFuncionarios);
        
        //btnFuncionarios:
        btnFuncionarios = new JButton("Funcionários", Icone_Funcionarios);
        btnFuncionarios.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnFuncionarios.setLocation(10, 30);
        btnFuncionarios.setHorizontalAlignment(JButton.LEFT);
        btnFuncionarios.setFocusPainted(false);
        btnFuncionarios.setBackground(Cor_Botoes);
        btnFuncionarios.setForeground(Cor_Fonte_Botoes);
        btnFuncionarios.setToolTipText("Abre o painel de Funcionarios (Apenas Gerente).");
        btnFuncionarios.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!"btnFuncionarios".equals(Janela_Aberta))
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnFuncionarios";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Usuarios Painel_Usuarios = new Painel_Usuarios();
                    pnlJanelas.add(Painel_Usuarios);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Gerente.add(btnFuncionarios);
        
    //--------------------------------------------------------------------------
    
        //Grupo_Relatorios: Dividindo em Paineis para melhor manutenção
        Grupo_Relatorios = new JPanel();
        Grupo_Relatorios.setSize(Menu_Lateral.getWidth(), 70);
        Grupo_Relatorios.setLocation(0, 440);
        Grupo_Relatorios.setLayout(null);
        Grupo_Relatorios.setBackground(Cor_Menu_Lateral);
        
        Menu_Lateral.add(Grupo_Relatorios);
        
        //lblRelatorios:
        lblRelatorios = new JLabel("Area de Relatórios: ");
        lblRelatorios.setSize(Menu_Lateral.getWidth() - 20, 20);
        lblRelatorios.setLocation(12, 5);
        lblRelatorios.setForeground(Cor_Fonte_Menu_Lateral);
        
        Grupo_Relatorios.add(lblRelatorios);
        
        //btnRelatorio_Vendas:
        btnRelatorio_Vendas = new JButton("Relatório de Vendas", Icone_Relatorio);
        btnRelatorio_Vendas.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnRelatorio_Vendas.setLocation(10, 30);
        btnRelatorio_Vendas.setHorizontalAlignment(JButton.LEFT);
        btnRelatorio_Vendas.setFocusPainted(false);
        btnRelatorio_Vendas.setBackground(Cor_Botoes);
        btnRelatorio_Vendas.setForeground(Cor_Fonte_Botoes);
        btnRelatorio_Vendas.setToolTipText("Abre o painel de Relatório de Vendas.");
        btnRelatorio_Vendas.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(Janela_Aberta != "btnRelatorio_Vendas")
                {
                    //falando que o botão já foi pressionado:
                    Janela_Aberta = "btnRelatorio_Vendas";
                    
                    //Removendo componentes do painel janelas:
                    pnlJanelas.removeAll();
                    
                    //chamando painel:
                    Painel_Erro_404 Painel_Erro_404 = new Painel_Erro_404();
                    pnlJanelas.add(Painel_Erro_404);
                    
                    //redesenhando painel Janelas:
                    pnlJanelas.repaint();
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Janela já aberta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Grupo_Relatorios.add(btnRelatorio_Vendas);
        
    //--------------------------------------------------------------------------
        //Grupo_Logoff: Acabou as ideias de grupos
        Grupo_Logoff = new JPanel();
        Grupo_Logoff.setSize(Menu_Lateral.getWidth(), 80);
        Grupo_Logoff.setLocation(0, 510);
        Grupo_Logoff.setLayout(null);
        Grupo_Logoff.setBackground(Cor_Menu_Lateral);
        
        Menu_Lateral.add(Grupo_Logoff);
        
        //lblSair:
        lblSair = new JLabel("Sair: ");
        lblSair.setSize(Menu_Lateral.getWidth() - 20, 20);
        lblSair.setLocation(12, 5);
        lblSair.setForeground(Cor_Fonte_Menu_Lateral);
        
        Grupo_Logoff.add(lblSair);
        
        //btnLogoff:
        btnLogoff = new JButton("Fazer Logoff", Icone_Logoff);
        btnLogoff.setSize(Menu_Lateral.getWidth() - 20, 30); //Melhor Manutenção
        btnLogoff.setLocation(10, 30);
        btnLogoff.setHorizontalAlignment(JButton.LEFT);
        btnLogoff.setFocusPainted(false);
        btnLogoff.setBackground(Cor_Botoes);
        btnLogoff.setForeground(Cor_Fonte_Botoes);
        btnLogoff.setToolTipText("Clique para fazer logoff e voltar a tela de Login.");
        btnLogoff.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Tela_Login.setVisible(true);
            }
        });

        Grupo_Logoff.add(btnLogoff);
    //--------------------------------------------------------------------------   
        //Testes:
//        Grupo_Vendas.setBackground(new Color(120, 100, 100, 254));
//        Grupo_Estoque.setBackground(new Color(100, 120, 100, 254));
//        Grupo_Entregas.setBackground(new Color(100, 100, 120, 254));
//        Grupo_Gerente.setBackground(new Color(120, 120, 100, 254));
//        Grupo_Relatorios.setBackground(new Color(100, 120, 120, 254));
//        Grupo_Logoff.setBackground(new Color(120, 100, 120, 254));
        
    }//Fim Menu()
    
    int x, y;
    
    private void Menu_Superior()
    {
        //Icones:
        ImageIcon Icone_Aplicativo_Pequeno  = new ImageIcon(getClass().getResource("/Icones/Icone_Aplicativo_Pequeno.png"));
        ImageIcon Icone_Minimizar           = new ImageIcon(getClass().getResource("/Icones/Icone_Minimizar.png"));
        ImageIcon Icone_Fechar              = new ImageIcon(getClass().getResource("/Icones/Icone_Fechar.png"));
        
        //Criando dentro da função pois será chamado em outras janelas:
        JPanel Menu_Superior        = new JPanel();
        JLabel lblTitulo            = new JLabel(getTitle());
        JLabel lblIcone_Programa    = new JLabel(Icone_Aplicativo_Pequeno);
        JButton btnFechar           = new JButton(Icone_Fechar);
        JButton btnMinimizar        = new JButton(Icone_Minimizar);
                
        //Menu_Superior:
        Menu_Superior.setSize(this.getWidth(), 30);
        Menu_Superior.setLocation(0, 0);
        Menu_Superior.setLayout(null);
        Menu_Superior.setBackground(Cor_Menu_Superior);        
        Menu_Superior.addMouseMotionListener(new MouseMotionAdapter() 
        {           
            //Variaveis que pegam o tamanho da tela:
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();    
            
            public void mouseDragged(MouseEvent mouse) 
            {
                //Pega a localização do mouse e seta para a janela:
                setLocation(mouse.getLocationOnScreen().x - getWidth() / 2, mouse.getLocationOnScreen().y - 15);

                //Tentativa de evitar que o usuario arraste a janela para fora da tela:
                if(getX() >= width - 30 || getY() >= height - 70)
                {
                    if(getX() >= width - 30)
                    {
                        setLocation( getX() - 30, getY() );
                        
                        if(getY() >= height - 70)
                        {
                            setLocation( getX(), getY() - 70);
                        }                      
                    }
                    
                    else if(getY() >= height - 70)
                    {
                        setLocation( getX(), getY() - 70 );
                    }
                }
            }
        });//Fim do MouseMotionListener
        
        add(Menu_Superior);
        
        //lblIcone_Programa:
        lblIcone_Programa.setSize(30, 30);
        lblIcone_Programa.setLocation(0, 0);
        lblIcone_Programa.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent mouse)
            {
                //O JOptionPane será substituido por um formulario de créditos:
                ImageIcon Icone_Creditos = new ImageIcon(getClass().getResource("/Icones/Icone_Creditos.png"));
                String Creditos = "Desenvolvido por: \nVitor Galindo";
                JOptionPane.showMessageDialog(null, Creditos, "Projeto - 19", JOptionPane.PLAIN_MESSAGE, Icone_Creditos);
            }
        });
        lblIcone_Programa.setToolTipText("Clique aqui para mais informações.");
        
        Menu_Superior.add(lblIcone_Programa);
        
        //lblTitulo:
        lblTitulo.setSize(35, 30);
        lblTitulo.setLocation(lblIcone_Programa.getWidth(), 0);
        lblTitulo.setForeground(Cor_Fonte_Menu_Lateral);
        lblTitulo.setToolTipText("Janela " + getTitle() + ".");
        
        Menu_Superior.add(lblTitulo);
        
        //btnFechar:
        btnFechar.setSize(30, 30);
        btnFechar.setLocation(Menu_Superior.getWidth() - btnFechar.getWidth(), 0);
        btnFechar.setForeground(Cor_Fonte_Menu_Superior);
        btnFechar.setBackground(Cor_Menu_Superior);
        btnFechar.setFocusPainted(false);
        btnFechar.setBorder(null);
        btnFechar.setToolTipText("Clique aqui para Fechar.");
        btnFechar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Fecha a Janela:
                dispose();
            }
        });
        
        btnFechar.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnFechar.setBackground(Color.red);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnFechar.setBackground(Cor_Menu_Superior);
            }
        });
        
        Menu_Superior.add(btnFechar);
        
        //btnMinimizar:
        btnMinimizar.setSize(30, 30);
        btnMinimizar.setLocation(btnFechar.getX() - btnMinimizar.getWidth(), 0);
        btnMinimizar.setForeground(Cor_Fonte_Menu_Superior);
        btnMinimizar.setBackground(Cor_Menu_Superior);
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setBorder(null);
        btnMinimizar.setToolTipText("Clique aqui para Minimizar.");
        btnMinimizar.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Minimizar Janela:
                setState(ICONIFIED);
            }
        });
        
        btnMinimizar.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnMinimizar.setBackground(Color.gray);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnMinimizar.setBackground(Cor_Menu_Superior);
            }
        });
        
        Menu_Superior.add(btnMinimizar);
        
    }//Fim Menu_Superior()
    
}