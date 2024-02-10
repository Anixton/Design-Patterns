import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private java.util.List<Position> positions;

    public GamePanel() {
        positions = new ArrayList<>();
        setPreferredSize(new Dimension(500, 500));
    }

    public void addPosition(Position position) {
        positions.add(position);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Position position : positions) {
            g.fillOval(position.getX() * 50, position.getY() * 50, 10, 10);
        }
    }
}