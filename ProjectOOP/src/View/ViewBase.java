package ProjectOOP.src.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;

import javax.sound.midi.ControllerEventListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileSystemView;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
public class ViewBase {
	private static JPanel createPanel;
	public List<String> dataTag = new ArrayList<String>();
	
	Color setPanelColor;
	Color buttonColor;
	Font viewFont = new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 20);
	
	public static String userInputString;
    static int sanChungKhoanHienTai;
    
	//TODO: Lưu DataFileOutput của sàn Hà Nội và Hồ Chí Minh. Khi Hàm SendRequest gọi sẽ lấy 1 DataFileOutput của 1 sàn.
	//  static DataFileOutput SAN_HA_NOI;            
	//  static DataFileOutput SAN_HO_CHI_MINH;    
	
    public static JTextArea outputTextField = new JTextArea(3, 1);
    public static JColorChooser buttonColorChooser = new JColorChooser(Color.blue);
	static JTextField inputTextField = new JTextField(1);
    JColorChooser backGroundColorChooser = new JColorChooser(Color.green);
    JComboBox sanChungKhoan = new JComboBox(new String[] {"San Ha Noi","San Ho Chi Minh"});
	
    public static void main(String[] args) {
		ViewBase obj = new ViewBase();
		obj.ShowFrame(); 
		ShowData("");
	}
	

	private void CreateMainComponent(JPanel panel) {
		 backGroundColorChooser.setColor(0, 153, 76);
		 setPanelColor=backGroundColorChooser.getColor();
		 buttonColorChooser.setColor(102,178,255);
		 buttonColor=buttonColorChooser.getColor();
		
		JButton chooseButton = new JButton("Chon Tag");
		JButton caculateButton = new JButton("Xu ly");
		JButton hotTagButton = new JButton("Xu ly hot tag");
		
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
		JLabel sanChungKhoanLabel = new JLabel("Chon san: ");
		sanChungKhoanLabel.setFont(viewFont);
		
		JLabel nameProject = new JLabel("NAME PROJECT");
		nameProject.setForeground(Color.black);
		
		JComboBox listMenuBox = new JComboBox(new String[] { "Tag 1", "Tag 2", "Tag 3" });		
		
		inputTextField.setBounds(80, 100, 450, 30);
		inputTextField.setFont(viewFont);
		
		listMenuBox.setBounds(80, 500, 300, 30);
		panel.add(listMenuBox);
		sanChungKhoan.setBounds(380, 170, 300, 27);		
		
		chooseButton.setBounds(80, 170, 100, 25);
		chooseButton.setBackground(buttonColor);
		
		caculateButton.setBounds(550, 100, 100, 30);
		caculateButton.setBackground(buttonColor);
		
		hotTagButton.setBounds(400, 500, 120, 30);
		hotTagButton.setBackground(buttonColor);
		
		getInput.setBounds(10, 79, 150, 70);
		getInput.setForeground(Color.black);
		
		resultLabel.setBounds(10, 270, 100, 100);
		resultLabel.setForeground(Color.black);
		
		sanChungKhoanLabel.setBounds(270, 170, 100, 25);
		sanChungKhoanLabel.setForeground(Color.black);
		
		nameProject.setFont(new Font("SansSerif",Font.BOLD , 40));
		nameProject.setBounds(500, 0, 400, 80);

		panel.add(sanChungKhoan);
		panel.setLayout(null);
		panel.setBackground(setPanelColor);

		lb.setBounds(900, 100, 500, 400);
				
		lb.setIcon(new ImageIcon("ProjectOOP/src/View/workshop.png"));
		caculateButton.setIcon(new ImageIcon("ProjectOOP/src/View/search.png"));
		
		panel.add(lb);
		panel.add(resultLabel);
		panel.add(getInput);
		panel.add(inputTextField);
		panel.add(chooseButton);
		panel.add(caculateButton);
		panel.add(sanChungKhoanLabel);
		panel.add(hotTagButton);
		panel.add(lb);
		panel.add(nameProject);
        panel.add(scrollPane);
        
		SetAction(chooseButton, 1);
		SetAction(caculateButton, 2);
		SetAction(hotTagButton, 3);
	}
	

	public  void CreateMainFrame(int width, int height, String nameFrame, JPanel panel) {
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
				SetViewWindow(ID);
				if (ID == 2)
				{ 
					userInputString =ViewBase.inputTextField.getText();
					
					//Sàn chứng khoán được chọn sẽ được kiểm tra index của nó trong ComboBox. Lưu lại vào biến sanChungKhoanHienTai
					//Quy theo ID: 0-Sàn Hà Nội, ID:1-Sàn HCM
					sanChungKhoanHienTai = sanChungKhoan.getSelectedIndex();
					System.out.println(userInputString);
					System.out.println(sanChungKhoanHienTai);
				}
			}
		});
	}
	
//# Tao cua so moi tu cac button 
	private static void SetViewWindow(int ID) {
		if(ID==1)
			{TagView.CreateTagWindow();
		}
		else if(ID==2){
			SendRequest(userInputString,sanChungKhoanHienTai);
		}
		else if(ID==3) {
		}

	}
	//# Ham hien thi giao dien App
	public void ShowFrame()
	{

		 ViewBase viewBase = new ViewBase(); 
		 viewBase.CreateMainFrame(1280, 680, "PROJECT OOP", createPanel);
	}
//# Hien thi ket qua	
	public static void ShowData(String outputData) {
		outputTextField.append(outputData);
	}
	private static void SendRequest(String data,int chonSanChungKhoan) {	
		if(chonSanChungKhoan==0)
		{
		//	SAN_HA_NOI.find(data);
		}
		else if(chonSanChungKhoan==1)
		{
		//	SAN_HO_CHI_MINH.find(data);
		}
	}
	
}
