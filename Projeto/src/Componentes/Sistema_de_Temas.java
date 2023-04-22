package Componentes;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Sistema_de_Temas 
{
    //Cores - Menus e Botões: 
    public  Color Cor_Menu_Superior = new Color(51, 51, 51, 254);
    public  Color Cor_Menu_Lateral  = new Color(86, 86, 86, 254);
    public  Color Cor_Fundo         = new Color(228, 228, 228, 254);
    public  Color Cor_Botoes        = Cor_Menu_Lateral;
    
    //Cores - Fontes:
    public  Color Cor_Fonte_Menu_Lateral    = Color.white;
    public  Color Cor_Fonte_Paineis         = Color.black;
    public  Color Cor_Fonte_Botoes          = Color.white;
    public  Color Cor_Fonte_Menu_Superior   = Color.white;

    //Bordas:
    public Border Borda_Fundo   = BorderFactory.createLineBorder(Cor_Menu_Lateral);
    public Border Borda_Paineis = BorderFactory.createLineBorder(Color.BLACK);
    
    public Sistema_de_Temas(int Tema) 
    {
        int R = 51, G = 51, B = 51;
        
        switch (Tema) 
        {
            case 1: 
            {
                Cor_Menu_Superior   = new Color(R, G, B + 10, 254);
                Cor_Menu_Lateral    = new Color(R, G, B + 20, 254);
		break;
            }
            
            case 2: 
            {
                Cor_Menu_Superior   = new Color(R, G + 10, B, 254);
                Cor_Menu_Lateral    = new Color(R, G + 20, B, 254);
		break;
            }
	
            case 3: 
            {
                Cor_Menu_Superior   = new Color(R + 10, G, B, 254);
                Cor_Menu_Lateral    = new Color(R + 20, G, B, 254);
                break;
            }
            
            case 4: 
            {
                Cor_Menu_Superior   = new Color(R + 10, G, B + 10, 254);
                Cor_Menu_Lateral    = new Color(R + 20, G, B + 20, 254);
		break;
            }
            
            case 5: 
            {
                Cor_Menu_Superior   = new Color(R + 10, G + 10, B, 254);
                Cor_Menu_Lateral    = new Color(R + 20, G + 20, B, 254);
		break;
            }
	
            case 6: 
            {
                Cor_Menu_Superior   = new Color(R, G + 10, B + 10, 254);
                Cor_Menu_Lateral    = new Color(R, G + 20, B + 20, 254);
                break;
            }
            
            case 7: 
            {
                Cor_Menu_Superior   = new Color(R, G, B, 254);
                Cor_Menu_Lateral    = new Color(R, G, B, 254);
                break;
            }
            
            default:
            {
                
            }
	}
        
        Cor_Botoes          = Cor_Menu_Lateral;
        Borda_Fundo         = BorderFactory.createLineBorder(Cor_Menu_Lateral);
    } 
}