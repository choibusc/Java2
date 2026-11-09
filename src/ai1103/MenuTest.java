package ai1103;

import center.SetFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class MenuTest extends JFrame {

    JTextArea textArea = new JTextArea();
    JFileChooser fileChooser = new JFileChooser();
    JFrame frame;
    String[] iconFileNames = {"new", "open", "close"};
    Color[] colorNames = {Color.WHITE, Color.BLUE, Color.MAGENTA};
    JButton[] btns = new JButton[6];

    public MenuTest(){
        frame = this;

        JScrollPane scrollPane = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        add(scrollPane);

        JToolBar toolBar = new JToolBar();
        add("North", toolBar);

        for (int i = 0; i < btns.length; i++) {
            if (i < 3) {
                btns[i] = new JButton(new ImageIcon("toolbar/" + iconFileNames[i] + ".png"));
            } else {
                btns[i] = new JButton("   ");
                btns[i].setBackground(colorNames[i - 3]);
            }
            btns[i].addActionListener(btnListener);
            toolBar.add(btns[i]);
        }

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // ===== File 메뉴 =====
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem closeMenuItem = new JMenuItem("Close");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeMenuItem);

        newMenuItem.addActionListener(fileListener);
        openMenuItem.addActionListener(fileListener);
        saveMenuItem.addActionListener(fileListener);
        closeMenuItem.addActionListener(fileListener);

        // ===== Edit 메뉴 =====
        JMenuItem whiteMenuItem = new JMenuItem("White");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        JMenuItem magentaMenuItem = new JMenuItem("Magenta");
        JMenuItem selectAllMenuItem = new JMenuItem("Select All");

        editMenu.add(whiteMenuItem);
        editMenu.add(blueMenuItem);
        editMenu.add(magentaMenuItem);
        editMenu.addSeparator();
        editMenu.add(selectAllMenuItem);

        whiteMenuItem.addActionListener(backgroundListener);
        blueMenuItem.addActionListener(backgroundListener);
        magentaMenuItem.addActionListener(backgroundListener);
        selectAllMenuItem.addActionListener(editListener);

        SetFrame.setFrame(this, "메뉴만들기", 500, 500);
    }

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton eBtn = (JButton) e.getSource();
            File selectedFile;

            if (eBtn == btns[0]){
                textArea.setText("");
            } else if (eBtn == btns[1]){
                fileChooser.showOpenDialog(frame);
                selectedFile = fileChooser.getSelectedFile();
                if (selectedFile != null) {
                    textArea.setText(readFile(selectedFile));
                }
            } else if (eBtn == btns[2]){
                System.exit(0);
            }

            for (int i = 0; i < colorNames.length; i++) {
                if (eBtn == btns[i + 3]) {
                    textArea.setBackground(colorNames[i]);
                }
            }
        }
    };

    ActionListener fileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            File selectedFile;
            switch (e.getActionCommand()){
                case "New":
                    textArea.setText("");
                    break;
                case "Open":
                    fileChooser.showOpenDialog(frame);
                    selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile != null) {
                        textArea.setText(readFile(selectedFile));
                    }
                    break;
                case "Save":                              // [추가] 저장 기능
                    saveFile();
                    break;
                case "Close":
                    System.exit(0);
                    break;
            }
        }
    };

    ActionListener backgroundListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = null;
            switch (e.getActionCommand()){
                case "White":
                    color = colorNames[0];
                    break;
                case "Blue":
                    color = colorNames[1];
                    break;
                case "Magenta":
                    color = colorNames[2];
                    break;
            }
            textArea.setBackground(color);
        }
    };

    // [추가] Edit 메뉴 - Select All
    ActionListener editListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Select All")) {
                textArea.requestFocus();
                textArea.selectAll();
            }
        }
    };

    public void saveFile() {
        int result = fileChooser.showSaveDialog(frame);
        if (result != JFileChooser.APPROVE_OPTION) return;

        File file = fileChooser.getSelectedFile();
        if (file == null) return;

        if (file.exists()) {
            int answer = JOptionPane.showConfirmDialog(
                    frame, "이미 존재하는 파일입니다. 덮어쓸까요?",
                    "Save", JOptionPane.YES_NO_OPTION);
            if (answer != JOptionPane.YES_OPTION) return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(frame, "저장되었습니다.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "저장 중 오류가 발생했습니다.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String readFile(File file) {
        if (file == null) return "";
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new MenuTest();
    }
}