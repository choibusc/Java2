package ai1013;

import center.CenterFrame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FlowLayoutTest extends JFrame {

    List<JButton> list = new ArrayList<>();
    Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
    boolean flag = true;

    public FlowLayoutTest() {
        setTitle("FlowLayout 연습");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        for (int i = 0; i < 5; i++) {
            JButton btn = new JButton("Btn " + (i + 1));
            btn.addActionListener(btnListener);
            list.add(btn);
            add(btn);
        }

        int w = 250, h = 250;
        Point point = CenterFrame2.getLocation(w, h);
        setBounds(point.x, point.y, w, h);
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedBtn = (JButton) e.getSource();
            if (flag) {
                selectedBtn.setBackground(colors[list.indexOf(selectedBtn)]);
                flag = false;
            } else {
                selectedBtn.setBackground(Color.LIGHT_GRAY);
                flag = true;
            }
        }
    };

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}