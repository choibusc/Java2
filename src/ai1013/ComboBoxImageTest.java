package ai1013;

import center.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxImageTest extends JFrame {

    JLabel lbl = new JLabel();

    public ComboBoxImageTest() {
        setTitle("문자열 입력 컴포넌트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] items = {"강아지", "고양이", "토끼", "미어캣", "코알라"};
        JComboBox comboBox = new JComboBox(items);
        comboBox.addItemListener(comboListener);

        add(comboBox);
        add(lbl);

        // 첫 번째 항목(강아지) 이미지 기본 표시
        lbl.setIcon(new ImageIcon("pets/pet01.png"));

        int w = 250, h = 250;
        int[] locations = CenterFrame.getLocation(w, h);
        setBounds(locations[0], locations[1], w, h); // setLocation(x,y) + setSize(w, h)
        setVisible(true);
    }

    ItemListener comboListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // 선택이 새로 이루어진 순간(SELECTED)에만 실행
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ImageIcon icon = null;
                int imgPath = 0;
                String selectedItem = (String) e.getItem();

                switch (selectedItem) {
                    case "강아지":
                        imgPath = 1;
                        break;
                    case "고양이":
                        imgPath = 2;
                        break;
                    case "토끼":
                        imgPath = 3;
                        break;
                    case "미어캣":
                        imgPath = 4;
                        break;
                    case "코알라":
                        imgPath = 5;
                        break;
                }

                icon = new ImageIcon("pets/pet0" + imgPath + ".png");
                lbl.setIcon(icon);
            }
        }
    };

    public static void main(String[] args) {
        new ComboBoxImageTest();
    }
}