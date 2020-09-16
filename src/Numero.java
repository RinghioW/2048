import javax.swing.*;
import java.awt.*;

public class Numero extends JTextArea {

    private Gioco2048 mygame;
    private int i;
    private int j;

    public Numero(Gioco2048 mygame, int i, int j) {
        this.mygame = mygame;
        this.i = i;
        this.j = j;
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("", 0, 20));
        update();
        setEditable(false);
    }

    public void update(){
        setText(" " + mygame.getNum(i, j) + " ");
        switch (mygame.getNum(i, j)){
            case 0 :
                setText("    ");
                setBackground(Color.white);
                break;
            case 2 :
                setBackground(Color.lightGray);
                break;
            case 4 :
                setBackground(Color.orange);
                break;
            case 8 :
                setBackground(Color.cyan.darker());
                break;
            case 16 :
                setBackground(Color.pink);
                break;
            case 32 :
                setBackground(Color.yellow.darker());
                break;
            case 64 :
                setBackground(Color.blue.brighter());
                break;
            case 128 :
                setBackground(Color.magenta);
                break;
            case 256 :
                setBackground(Color.cyan);
                break;
            case 512 :
                setBackground(Color.green);
                break;
            case 1024 :
                setBackground(Color.red);
                break;
            case 2048 :
                setBackground(Color.yellow);
                break;
        }
    }
}
