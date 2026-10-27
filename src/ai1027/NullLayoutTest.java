package ai1027;

import center.SetFrame;

import javax.swing.*;

public class NullLayoutTest extends JFrame {
    public NullLayoutTest() {
        setLayout(null);
        int[] pointX = {50, 80, 110};
        int[] pointY = {50, 80, 110};

        int btnW = 70, btnH = 60;

        for (int i =0; i < pointX.length; i++){
            JButton btn = new JButton("버튼" + (i+1));
            btn.setBounds(pointX[i], pointY[i], btnW, btnH);
            add(btn);
        }

        SetFrame.setFrame(this, "레이아웃없는 컴포넌트배치", 250, 250);
    }

    public static void main(String[] args) {
        new NullLayoutTest();
    }
}