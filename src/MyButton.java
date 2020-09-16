import javax.swing.*;

public class MyButton extends JButton {


    private char action;

    public MyButton(Gioco2048 mygame, Matrice m, char action){
        super();
        this.action = action;
        setMyText();
        addActionListener(e -> {
            mygame.gioca(action);
            m.update();
            if(mygame.haiVinto()){
                setText("YOU WON");
            } else {
                if (mygame.haiPerso()) {
                    setText("YOU LOST");
                }
            }
        }
        );
    }

    public void setMyText(){
        switch(action) {
            case 'a' :
                setText("LEFT");
                break;
            case 's' :
                setText("DOWN");
                break;
            case 'w' :
                setText("UP");
                break;
            case 'd' :
                setText("RIGHT");
                break;
            default:
                setText(action+"");
                break;
        }
    }

}
