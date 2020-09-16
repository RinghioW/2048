import javax.swing.*;
import java.awt.*;

public class Pannello extends JFrame {

    private Gioco2048 mygame = new Gioco2048();


    public static void main(String[] args){
        EventQueue.invokeLater(Pannello::new);
    }


    public Pannello() {
        initUI();
    }

    private void initUI() {
        setTitle("2048");
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Matrice griglia = new Matrice(mygame);
        initGriglia(griglia);
        initButtons(griglia);
        initInstructions();
    }


    private void initGriglia(Matrice griglia) {
        griglia.setBounds(500, 100, 300, 300);
        add(griglia);
        griglia.setVisible(true);
    }


    private void initButtons(Matrice griglia) {

        MyButton b1 = new MyButton(mygame, griglia, 'a');
        MyButton b2 = new MyButton(mygame, griglia,'w');
        MyButton b3 = new MyButton(mygame, griglia, 's');
        MyButton b4 = new MyButton(mygame, griglia,'d');
        setLayout(null);
        b1.setBounds(450, 500, 100, 30);
        b2.setBounds(600, 450, 100, 30);
        b3.setBounds(600, 550, 100, 30);
        b4.setBounds(750, 500, 100, 30);
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        JButton bR = new JButton("RETRY");
        bR.setBounds(350, 250, 100, 30);
        bR.setVisible(true);
        bR.addActionListener(e -> {
            mygame.reset();
            griglia.update();
            b1.setMyText();
            b2.setMyText();
            b3.setMyText();
            b4.setMyText();
        });
        add(bR);


    }



    private void initInstructions(){
        JLabel instructions = new JLabel("You win by reaching 2048. You lose if you no longer have available moves.");
        instructions.setVisible(true);
        instructions.setBounds(450, 40, 450, 50);
        add(instructions);

    }










}


