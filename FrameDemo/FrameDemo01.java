import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;  

/**
 * 프레임을 만들고, (10, 10)에서 부터 X축으로 20, Y축으로 20 씩 증가하며 한변의 길이가 5씩 증가하도록 10개의 사각형을 그려라.
   단, (10, 10)은 유효 영역 좌표계를 기준으로 하라.
 */
public class FrameDemo01 {
    public static class MyCanvas extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);

            int x = 10;
            int y = 10;
            int size = 10;

            for(int i = 0; i < 10; i++){
                g.drawRect(x, y, size, size);
                x += 20;
                y += 20;
                size += 5;
            }
            
        }
    }
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("FrameDemo01");
        frame.setSize(400, 300);

        MyCanvas panel = new MyCanvas();
        
        frame.add(panel);
        frame.setVisible(true);
    }
}