package projetozumbi;
import java.util.Random;
public abstract class Pessoa {
    int color,x,y;
    Random random = new Random();
    int life;
    public Pessoa(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        life = 1;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void move(){
        int number = random.nextInt(4);
        switch(number){
            case 0:
                y++;
                break;
            case 1:
                y--;
                break;
            case 2:
                x++;
                break;
            case 3:
                x--;
                break; 
        }
        if(y>89) y=0;
        else if(y<0) y=89;
        else if(x>29) x=0;
        else if(x<0) x=29;
    }
}