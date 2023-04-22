package Interfaces;

import Componentes.Sistema_de_Temas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Login extends JFrame
{
    //Cores:
    private final Color Cor_Menu_Superior     = new Color(51, 51, 51, 254);
    private final Color Cor_Fundo             = new Color(86, 86, 86, 254);
    private final Color Cor_Fonte             = Color.white;
    
    //Icones:
    private final ImageIcon Icone_Aplicativo  = new ImageIcon(getClass().getResource("/Icones/Icone_Aplicativo.png"));
    private final ImageIcon Icone_Carrinho    = new ImageIcon(getClass().getResource("/Icones/Icone_Carrinho.png"));
    
    //Componentes:
    private final JLabel lblNome_Projeto, lblImagem, lblUsuario, lblSenha;
    private final JButton btnLogin;
    private final JPasswordField txtSenha;
    private final JTextField txtUsuario;
      
    public Login() 
    {
        //Janela:      
        this.setTitle("Login");
        this.setSize(300, 400);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(Cor_Fundo);                              //Obs 01
        this.setLocationRelativeTo(null);                           //Obs 02
        this.setIconImage(Icone_Aplicativo.getImage());             //Obs 03
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Menu_Superior:
        Menu_Superior();
        
        //lblImagem:
        lblImagem = new JLabel(Icone_Carrinho);
        lblImagem.setSize(100, 100);
        lblImagem.setLocation(100, 60);
        lblImagem.setBackground(Color.YELLOW);
        lblImagem.setOpaque(true);
        
        this.add(lblImagem);
        
        //lblNome_Projeto
        lblNome_Projeto = new JLabel("Mercado Delivery");
        lblNome_Projeto.setSize(260, 20);
        lblNome_Projeto.setLocation(20, 170);
        lblNome_Projeto.setForeground(Cor_Fonte);
        lblNome_Projeto.setHorizontalAlignment(JLabel.CENTER);
        lblNome_Projeto.setFont(new Font("",Font.BOLD,14));
        lblNome_Projeto.setToolTipText("Projeto - 19: Mercado Delivery.");
        
        this.add(lblNome_Projeto);
        
        //lblUsuario:
        lblUsuario = new JLabel("Usuário: ");
        lblUsuario.setSize(100, 20);
        lblUsuario.setLocation(20, 210);
        lblUsuario.setForeground(Cor_Fonte);
        
        this.add(lblUsuario);
        
        //txtUsuario:  
        txtUsuario = new JTextField();
        txtUsuario.setSize(260, 20);
        txtUsuario.setLocation(20, 240);
        txtUsuario.setHorizontalAlignment(txtUsuario.CENTER);
        txtUsuario.setBorder(null);
        txtUsuario.setToolTipText("Login do Usuário.");
        
        this.add(txtUsuario);
        
        //lblSenha:
        lblSenha = new JLabel("Senha: ");
        lblSenha.setSize(100, 20);
        lblSenha.setLocation(20, 270);
        lblSenha.setForeground(Cor_Fonte);
        
        this.add(lblSenha);
        
        //txtSenha
        txtSenha = new JPasswordField();
        txtSenha.setSize(260, 20);
        txtSenha.setLocation(20, 300);
        txtSenha.setHorizontalAlignment(txtSenha.CENTER);
        txtSenha.setBorder(null);
        txtSenha.setToolTipText("Senha do Usuário.");
                
        this.add(txtSenha);
        
        //btnLogin:
        btnLogin = new JButton("Login");
        btnLogin.setSize(260, 30);
        btnLogin.setLocation(20, 350);
        btnLogin.setBackground(Cor_Menu_Superior);
        btnLogin.setForeground(Cor_Fonte);
        btnLogin.setToolTipText("Clique aqui para logar.");
        
        this.add(btnLogin);
        
        //Nesse caso o ActionListener é melhor:
        btnLogin.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Função Temporaria até desenvolverem o banco de dados:
                if ("admin".equals(txtUsuario.getText().trim()))
                {     
                    if ("admin".equals(txtSenha.getText().trim()))
                    {
                        
                        Menu Tela_Menu = new Menu();
                        Tela_Menu.setVisible(true);
                        
                        dispose();
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                        txtUsuario.setText("");
                        txtSenha.setText("");
                        txtUsuario.requestFocus(true); 
                    }
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtUsuario.setText("");
                    txtSenha.setText("");
                    txtUsuario.requestFocus(true);
                }
            }
        });
        
        //Animações:
        btnLogin.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent mouse)
            {
                //Muda a cor ao passar o mouse:
                btnLogin.setBackground(Color.darkGray);
            }
            
            public void mouseExited(MouseEvent mouse)
            {
                //retorna a cor ao retirar o mouse:
                btnLogin.setBackground(Cor_Menu_Superior);
            }
        });
        
        //Permite executar o btnLogin ao apertar a tecla enter:
        this.getRootPane().setDefaultButton(btnLogin); 
        
    }//Fim Login()
    
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
        Menu_Superior.addMouseMotionListener(new MouseAdapter() 
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
        lblTitulo.setForeground(Cor_Fonte);
        lblTitulo.setToolTipText("Janela " + getTitle() + ".");
        
        Menu_Superior.add(lblTitulo);
        
        //btnFechar:
        btnFechar.setSize(30, 30);
        btnFechar.setLocation(Menu_Superior.getWidth() - btnFechar.getWidth(), 0);
        btnFechar.setForeground(Cor_Fonte);
        btnFechar.setBackground(Cor_Fundo);
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
                btnFechar.setBackground(Cor_Fundo);
            }
        });
        
        Menu_Superior.add(btnFechar);
        
        //btnMinimizar:
        btnMinimizar.setSize(30, 30);
        btnMinimizar.setLocation(btnFechar.getX() - btnMinimizar.getWidth(), 0);
        btnMinimizar.setForeground(Cor_Fonte);
        btnMinimizar.setBackground(Cor_Fundo);
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
                btnMinimizar.setBackground(Cor_Fundo);
            }
        });
        
        Menu_Superior.add(btnMinimizar);
        
    }//Fim Menu_Superior()
    
}