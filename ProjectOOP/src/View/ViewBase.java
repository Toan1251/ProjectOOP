package ProjectOOP.src.View;



import ProjectOOP.src.Controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JScrollPane;
import javax.swing.JColorChooser;
public class ViewBase {
    private Color setPanelColor;
    private Color buttonColor;
    static  JComboBox mainmenu= new JComboBox(new String[] { "ACM", "BLF", "BTS", "MAS", "VCS" });
    static  String[] listMenuBox =  new String[] { "ACM", "BLF", "BTS", "MAS", "VCS" };
    static  String[] saiGon =  new String[] {"VPS", "VIP", "TNT", "VIC", "FMC"};

    private Font viewFont = new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 20);

    public static String userInputString;
    public static int sanChungKhoanHienTai;
    public static int countTagView=0;
    public static JTextArea outputTextField = new JTextArea(3, 1);
    public static JColorChooser buttonColorChooser = new JColorChooser(Color.blue);
    static JTextField inputTextField = new JTextField(1);
    JColorChooser backGroundColorChooser = new JColorChooser(Color.green);
    JComboBox sanChungKhoan = new JComboBox(new String[] {"Sàn Hà Nội","Sàn Hồ Chí Minh"});


    private void CreateMainComponent(JPanel panel) {
        backGroundColorChooser.setColor(0, 153, 76);
        setPanelColor=backGroundColorChooser.getColor();
        buttonColorChooser.setColor(102,178,255);
        buttonColor=buttonColorChooser.getColor();

        JButton chooseButton = new JButton("Chọn Tag");
        JButton caculateButton = new JButton("Xử lý");

        JLabel lb = new JLabel();
        JLabel lb2 = new JLabel();

        outputTextField.setFont(viewFont);
        outputTextField.setEditable(false);
        outputTextField.setLineWrap(true);
        outputTextField.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputTextField);
        scrollPane.setBounds(850, 160, 580, 600);

        JLabel getInput = new JLabel("Tìm kiếm mã chứng khoán: ");
        getInput.setFont(viewFont);

        JLabel resultLabel = new JLabel("Kết quả ");
        resultLabel.setFont(new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 30));

        JLabel sanChungKhoanLabel = new JLabel("Chọn sàn: ");
        sanChungKhoanLabel.setFont(viewFont);

        JLabel hotTagLabel = new JLabel("Tìm kiếm nhiều nhất: ");
        hotTagLabel.setFont(viewFont);

        JLabel nameProject = new JLabel("TIN CHỨNG KHOÁN");
        nameProject.setForeground(Color.black);




        inputTextField.setBounds(80, 100, 450, 30);
        inputTextField.setFont(viewFont);

        mainmenu.setBounds(80, 250, 450, 33);
        mainmenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextField.setText(mainmenu.getSelectedItem().toString());

            }
        });
       //q panel.add(listMenuBox);
        sanChungKhoan.setBounds(80, 170, 450, 33);
        sanChungKhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sanChungKhoanHienTai=sanChungKhoan.getSelectedIndex();
                ChangeMenụ̣();
            }
        });

        chooseButton.setBounds(550, 170, 100, 30);
        chooseButton.setBackground(buttonColor);

        caculateButton.setBounds(550, 100, 100, 30);
        caculateButton.setBackground(buttonColor);

        getInput.setBounds(80, 50, 290, 70);
        getInput.setForeground(Color.black);

        resultLabel.setBounds(1060, 69, 250, 100);
        resultLabel.setForeground(Color.black);


        sanChungKhoanLabel.setBounds(80, 140, 100, 25);
        sanChungKhoanLabel.setForeground(Color.black);

        nameProject.setFont(new Font("SansSerif",Font.BOLD , 40));
        nameProject.setBounds(460, 0, 480, 80);

        panel.add(sanChungKhoan);
        panel.setLayout(null);
        panel.setBackground(setPanelColor);

        lb.setBounds(60, 200, 800, 700);
        hotTagLabel.setBounds(80,220,250,20);

        lb2.setBounds(390, 200, 800, 700);

        lb.setIcon(new ImageIcon("ProjectOOP/src/View/workshop.png"));
        lb2.setIcon(new ImageIcon("ProjectOOP/src/View/chungkhoan.png"));
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
        panel.add(lb2);
        panel.add(mainmenu);

        SetAction(chooseButton, 1);
        SetAction(caculateButton, 2);
    }


    public  void CreateMainFrame(int width, int height, String nameFrame, JPanel panel) {
        JFrame createFrame = new JFrame(nameFrame);
        createFrame.setSize(width, height);
        createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        createFrame.add(panel);
        CreateMainComponent(panel);
        createFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        createFrame.setVisible(true);

    }

    //#Tao action cho cac button
    private void SetAction(JButton nameButton, int ID) {
        nameButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if(ID==1)
                { if(countTagView==0)
                {TagView.CreateTagWindow();
                    countTagView++;
                }
                }
                else if (ID == 2)
                {
                    userInputString = ViewBase.inputTextField.getText().toUpperCase();
                    if(userInputString.length()!=3 ){
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
    //# Ham hien thi giao dien App
    public static void ShowFrame()
    {
        JPanel createPanel = new JPanel();
        ViewBase viewBase = new ViewBase();
        viewBase.CreateMainFrame(1678, 1024, "PROJECT OOP", createPanel);
    }
    //# Hien thi ket qua
    public static void ShowData(String outputData) {
        outputTextField.selectAll();
        outputTextField.replaceSelection("");
        outputTextField.append(outputData);
    }
    private static void ChangeMenụ̣()
    {
        if(sanChungKhoanHienTai==0)
        {
           for(int i=0;i<5;i++) {
               mainmenu.removeItemAt(0);
               mainmenu.addItem(listMenuBox[i]);
           }
        }
        else {
            for(int i=0;i<5;i++) {
                {  mainmenu.removeItemAt(0);
                mainmenu.addItem(saiGon[i]);}
        }

    }

}}
