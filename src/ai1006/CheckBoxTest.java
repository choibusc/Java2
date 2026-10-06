package ai1006;

import center.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxTest extends JFrame {

    public CheckBoxTest() {
        setTitle("CheckBox 컴포넌트 연습");

        // 레이아웃: 컴포넌트를 보기좋게 배치 (FlowLayout 적용)
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JCheckBox check1 = new JCheckBox("선택하세요.");

        // 체크박스 클릭시 이벤트 처리 동작 추가
        check1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check1.isSelected()) {
                    JOptionPane.showMessageDialog(null, "CheckBox에 체크(ON) 되어 있네요.");
                } else {
                    JOptionPane.showMessageDialog(null, "CheckBox 해제(OFF) 되었습니다.");
                }
            }
        });

        add(check1);

        int w = 300, h = 200;
        setSize(w, h);

        // CenterFrame 형변환 적용하여 중앙 배치
        int[] location = (int[]) (Object) CenterFrame.getLocation(w, h);
        setLocation(location[0], location[1]);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxTest();
    }
}