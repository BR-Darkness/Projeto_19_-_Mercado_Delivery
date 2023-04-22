package Componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <b>Explicação:</b> <br>
 * Criei essa função de ComboBox devido ao 
 * JComboBox apresentar um problema de exibição dentro de JPanels com
 * layout null (aparentemente ele entra em conflito com o layout do JPanel
 * e não exibi a borda com o botão drop down).<br><br>
 * <b>Uso: </b> <br>
 * CustomComboBox <i>Nome_da_variavel</i> = new CustomComboBox (width, height, Itens, cor);<br><br>
 * <b>width: </b> <br>
 * int - Largura da CustomComboBox.<br>
 * <b>height: </b> <br>
 * int - Altura da CustomComboBox.<br>
 * <b>Itens []: </b> <br>
 * String - Array dos Itens da CustomComboBox.<br>
 * <b>cor: </b> <br>
 * Color - Cor da caixa de seleção da CustomComboBox.
 * 
 * @author Galindo
 */

public class CustomComboBox extends JPanel
{   
    private final ImageIcon Icone_drop_down = new ImageIcon(getClass().getResource("/Icones/Icone_drop_down.png"));
    private final JLabel    Imagem          = new JLabel(Icone_drop_down);
    public  JLabel          Item_Escolhido  = new JLabel();
    private JComboBox       ComboBox;
    
    //Teste JavaDoc: Tentar tornar o uso mais claro para o restante do grupo.
    /**
     * @param width     int - Largura da CustomComboBox.
     * @param height    int - Altura da CustomComboBox.
     * @param Itens  String - Array dos Itens da CustomComboBox.
     * @param cor     Color - Cor da caixa de seleção da CustomComboBox.
     */
    public CustomComboBox(int width, int height, String Itens[], Color cor) 
    {         
        //Componentes:
        ComboBox = new JComboBox(Itens);
        
        //Painel da ComboBox Customizada:
        this.setSize(width, height);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        //ComboBox Customizada:
        ComboBox.setSize(this.getWidth(), height);
        ComboBox.setLocation(0, 0);
        ComboBox.setBackground(Color.white);
        ComboBox.setBorder(BorderFactory.createLineBorder(Color.black));
        ComboBox.setSelectedIndex(0);
        ComboBox.setToolTipText("Selecione uma opção.");
        ComboBox.setLayout(null); //Remove de vez a seta bugada.
        ComboBox.setBorder(null);
        ComboBox.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Item_Escolhido.setText(ComboBox.getSelectedItem().toString());
            }
        });   
        
        this.add(ComboBox);
        
        //Imagem do Icone drop down: 
        Imagem.setSize(20, height);
        Imagem.setLocation(this.getWidth() - 20, 0);
        Imagem.setBackground(cor);
        Imagem.setOpaque(true);
        
        ComboBox.add(Imagem);
        
        //Seta o Item selecionado como o primeiro do array ao chamar o componente:
        Item_Escolhido.setText(ComboBox.getSelectedItem().toString());
    }    
}