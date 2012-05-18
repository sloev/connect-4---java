package connect4;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;

/**
 *
 * @author jgjpro
 */
public class ellipse extends JFrame {
    private int x;
    private int y;
    private Color color;
    private int player;
    
    public ellipse(int tempx, int tempy, int temp_player){
        x=tempx;
        y=tempy;
        player=temp_player;
        
        setTitle("hello");
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        //g.drawOval(200, 200, 100, 100);
        g.fillOval(150,150,100,100);
    }
    /*
    public static void main(String args[]){
        ellipse Circle = new ellipse();
        Circle.paint(null);
    }
    */
    
}
