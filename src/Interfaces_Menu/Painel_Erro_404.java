package Interfaces_Menu;

import java.awt.Color;
import javax.swing.*;

public class Painel_Erro_404 extends JPanel
{    
    //Icones:
    ImageIcon Icone_Erro_404 = new ImageIcon(getClass().getResource("/Icones/Icone_Erro_404.png"));
    
    public Painel_Erro_404() 
    {
        //Janela:
        this.setSize(800, 585);
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setBackground(new Color(51,51,51,254));
        
        //lblErro404:
        JLabel lblErro404 = new JLabel(Icone_Erro_404);
        lblErro404.setSize(100, 100);
        lblErro404.setLocation(350, 190);
        
        this.add(lblErro404);
        
        //lblErro404:
        JLabel lblMensagem = new JLabel("Erro 404: Programador não encontrado.");
        lblMensagem.setSize(300, 50);
        lblMensagem.setLocation(250, 290);
        lblMensagem.setForeground(Color.white);
        lblMensagem.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(lblMensagem);
    } 
}