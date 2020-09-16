import javax.swing.*;
import java.awt.*;

public class Matrice extends JPanel {

    Numero[][] numeri = new Numero[4][4];

    public Matrice(Gioco2048 mygame) {
        setLayout(new GridLayout(4, 4, 0, 0));
        fill(mygame);
        setBorder(BorderFactory.createLineBorder(Color.black));
        for (int i = 0; i < 4; i+=1) {
            for(int j=0; j<4; j+=1) {
                add(numeri[i][j]);
            }
        }
    }

    private void fill(Gioco2048 mygame){
        for (int i = 0; i < 4; i+=1) {
            for(int j=0; j<4; j+=1) {
                numeri[i][j] = new Numero(mygame, i, j);
            }
        }
    }

    public void update(){
        for (int i = 0; i < 4; i+=1) {
            for(int j=0; j<4; j+=1) {
                numeri[i][j].update();
            }
        }
    }

}
