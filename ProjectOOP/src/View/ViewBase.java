package ProjectOOP.src.View;


import ProjectOOP.src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBase {
    public static String userInputString;
    public static int sanChungKhoanHienTai;
    public static int countTagView = 0;
    public static JTextArea outputTextField = new JTextArea(3, 1);
    public static JColorChooser buttonColorChooser = new JColorChooser(Color.blue);
    static JTextField inputTextField = new JTextField(1);
    JColorChooser backGroundColorChooser = new JColorChooser(Color.green);
    JComboBox sanChungKhoan = new JComboBox(new String[]{"San Ha Noi", "San Ho Chi Minh"});
    private Color setPanelColor;
    private Color buttonColor;
    private Font viewFont = new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 20);

    //# Ham hien thi giao dien App
    public static void ShowFrame() {
        JPanel createPanel = new JPanel();
        ViewBase viewBase = new ViewBase();
        viewBase.CreateMainFrame(1280, 680, "PROJECT OOP", createPanel);
    }

    //# Hien thi ket qua
    public static void ShowData(String outputData) {
        outputTextField.selectAll();
        outputTextField.replaceSelection("");
        outputTextField.append(outputData);
    }

    private void CreateMainComponent(JPanel panel) {
        backGroundColorChooser.setColor(0, 153, 76);
        setPanelColor = backGroundColorChooser.getColor();
        buttonColorChooser.setColor(102, 178, 255);
        buttonColor = buttonColorChooser.getColor();

        JButton chooseButton = new JButton("Chon Tag");
        JButton caculateButton = new JButton("Xu ly");

        JLabel lb = new JLabel();

        outputTextField.setFont(viewFont);
        outputTextField.setEditable(false);
        outputTextField.setLineWrap(true);
        outputTextField.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputTextField);
        scrollPane.setBounds(80, 220, 600, 220);

        JLabel getInput = new JLabel("Search: ");
        getInput.setFont(viewFont);
        JLabel resultLabel = new JLabel("Result ");
        resultLabel.setFont(viewFont);
        JLabel sanChungKhoanLabel = new JLabel("Chọn sàn: ");
        sanChungKhoanLabel.setFont(viewFont);
        JLabel hotTagLabel = new JLabel("HOT: ");
        hotTagLabel.setFont(viewFont);

        JLabel nameProject = new JLabel("TEAM CHỨNG KHOÁN");
        nameProject.setForeground(Color.black);

        JComboBox listMenuBox = new JComboBox(new String[]{"ACM", "BLF", "BTS"});

        inputTextField.setBounds(80, 100, 450, 30);
        inputTextField.setFont(viewFont);

        listMenuBox.setBounds(80, 500, 300, 30);
        listMenuBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextField.setText(listMenuBox.getSelectedItem().toString());

            }
        });
        panel.add(listMenuBox);
        sanChungKhoan.setBounds(380, 170, 300, 27);

        chooseButton.setBounds(80, 170, 100, 25);
        chooseButton.setBackground(buttonColor);

        caculateButton.setBounds(550, 100, 100, 30);
        caculateButton.setBackground(buttonColor);

        getInput.setBounds(10, 79, 150, 70);
        getInput.setForeground(Color.black);

        resultLabel.setBounds(10, 270, 100, 100);
        resultLabel.setForeground(Color.black);

        sanChungKhoanLabel.setBounds(270, 170, 100, 25);
        sanChungKhoanLabel.setForeground(Color.black);

        nameProject.setFont(new Font("SansSerif", Font.BOLD, 40));
        nameProject.setBounds(460, 0, 480, 80);

        panel.add(sanChungKhoan);
        panel.setLayout(null);
        panel.setBackground(setPanelColor);

        lb.setBounds(840, 100, 500, 400);
        hotTagLabel.setBounds(15, 505, 60, 20);

        lb.setIcon(new ImageIcon("ProjectOOP/src/View/workshop.png"));
        caculateButton.setIcon(new ImageIcon("ProjectOOP/src/View/search.png"));

        panel.add(lb);
        panel.add(resultLabel);
        panel.add(getInput);
        panel.add(inputTextField);
        panel.add(chooseButton);
        panel.add(caculateButton);
        panel.add(sanChungKhoanLabel);
        panel.add(lb);
        panel.add(nameProject);
        panel.add(scrollPane);
        panel.add(hotTagLabel);

        SetAction(chooseButton, 1);
        SetAction(caculateButton, 2);
    }

    public void CreateMainFrame(int width, int height, String nameFrame, JPanel panel) {
        JFrame createFrame = new JFrame(nameFrame);
        createFrame.setSize(width, height);
        createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        createFrame.add(panel);
        CreateMainComponent(panel);
        createFrame.setVisible(true);

    }

    //#Tao action cho cac button
    private void SetAction(JButton nameButton, int ID) {
        nameButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (ID == 1) {
                    if (countTagView == 0) {
                        TagView.CreateTagWindow();
                        countTagView++;
                    }
                } else if (ID == 2) {
                    userInputString = ViewBase.inputTextField.getText().toUpperCase();
                    if (userInputString.length() != 3) {
                        {
                            new SpawmError("Vui lòng nhập đúng 3 ký tự", "Error");
                            return;
                        }
                    }
                    sanChungKhoanHienTai = sanChungKhoan.getSelectedIndex();
                    Controller.request();
                }
            }
        });
    }

}

