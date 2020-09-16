//versione 1.1


public class Gioco2048{

    private int[][] t = new int[4][4];

    public Gioco2048(){
        start();
    }


    private void start(){
        int i = (int) (Math.random()*15 + 1);
        int j = (int) (Math.random()*i);
        t[i/4][i%4] = 2;
        t[j/4][j%4] = 2;
    }

    public void gioca(char i){
        int[][] vecchia = copyOf(t);
        switch (i) {
            case 's':
                muovi();
                break;
            case 'a':
                ruotadx();
                muovi();
                ruotasx();
                break;
            case 'w':
                capovolgi();
                muovi();
                capovolgi();
                break;
            case 'd':
                ruotasx();
                muovi();
                ruotadx();
                break;
            default:
                break;
        }
        if(differenti(vecchia, t)) {
            aggiungi();
        }
    }

    public void reset(){
        for(int i = 0; i<4; i+=1){
            for(int j=0; j<4; j+=1){
                t[i][j] = 0;
            }
        }
        start();
    }


    private void muovi() { //funziona solo in un verso: la matrice va girata!!
        for(int j = 0; j<t.length; j+=1){
           compact(j, t.length-1, t.length-1);
           merge(j);
           compact(j, t.length-1, t.length-1);
        }
    }

    private boolean differenti(int[][] vecchia, int[][] nuova){
        for(int i=0; i<4; i+=1){
            for(int j=0; j<4; j+=1){
                if(vecchia[i][j] != nuova[i][j]){ return true; }
            }
        }
        return false;
    }

    private void compact(int j, int i, int p){
        if(i>0){
            if(t[i][j] == 0 && t[i-1][j] != 0){
                t[p][j] = t[i-1][j];
                t[i-1][j] = 0;
                compact(j, i-1, p-1);
            }
            if(t[i][j] != 0){
                compact(j, i-1, p-1);
            }
            compact(j, i-1, p);
        }
    }

    private void merge(int j){ //
      for(int i=t.length-1; i>0; i-=1){
          if(t[i][j] == t[i-1][j]){
              t[i][j] *= 2;
              t[i-1][j] = 0;
          }
      }
    }

    private void aggiungi(){
        int i = (int) (Math.random()*4);
        int j = (int) (Math.random()*4);
        if(t[i][j] == 0){
            t[i][j] = Math.random() < 0.95? 2 : 4;
        } else {
            aggiungi();
        }
    }


    public boolean haiVinto(){
        for(int i=0; i<t.length; i+=1){
            for(int j=0; j<t.length; j+=1){
                if(t[i][j] == 2048){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean haiPerso() {
        for(int i=0; i<4; i+=1){
            for(int j = 0; j<4; j+=1){
                if(t[i][j] == 0){
                    return false;
                }
                if(i != 0 && t[i][j] == t[i-1][j]){
                    return false;
                }
                if(j != 0 && t[i][j] == t[i][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void ruotadx(){
        rotazione(0);
    }

    private void rotazione(int i){
        if(i != 16){
            int temp = t[i/4][i%4];
            rotazione(i+1);
            t[(4-1) - i%4][i/4] = temp;
        }
    }

    private void ruotasx(){
        ruotadx();
        ruotadx();
        ruotadx();
    }

    private void capovolgi(){
        ruotadx();
        ruotadx();
    }

    public int getNum(int i, int j){
        return t[i][j];
    }

    private int[][] copyOf(int[][] vecchia){
        int[][] nuova = new int[4][4];
        for(int i=0; i<4; i+=1){
            for(int j=0; j<4; j+=1){
               nuova[i][j] = vecchia[i][j];
            }
        }
        return nuova;
    }

}

