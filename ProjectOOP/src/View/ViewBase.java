package ProjectOOP.src.View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;

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
	static Color setPanelColor;
	static Color buttonColor;
	public static String userInputString;
	public static JTextArea outputTextField = new JTextArea(1, 1);
	static JTextField inputTextField = new JTextField(1);
	public static JColorChooser backGroundColorChooser = new JColorChooser(Color.green);
	public static JColorChooser buttonColorChooser = new JColorChooser(Color.blue);

	// #Đặt vị trí các button, text label vào trong Panel
	private void CreateMainComponent(JPanel panel) {
		JCheckBox hottag1 = new JCheckBox("Hot tag 1", false);
		JCheckBox hottag2 = new JCheckBox("Hot tag 2", false);
		JCheckBox hottag3 = new JCheckBox("Hot tag 3", false);

		JButton chooseButton = new JButton("Chon Tag");
		JButton caculateButton = new JButton("Xu li");
		JButton openButton = new JButton("Chon File");

		JLabel lb = new JLabel();

		JScrollPane scrollPane = new JScrollPane(outputTextField);
		scrollPane.setBounds(80, 220, 600, 220);
		JLabel getInput = new JLabel("Search: ");
		JLabel nameProject = new JLabel("NAME PROJECT");
		nameProject.setForeground(Color.white);
		JComboBox listMenuBox = new JComboBox(new String[] { "Chon Tag", "Xu li", "Chon File" });
		JLabel resultLabel = new JLabel("Result ");

		hottag1.setBounds(80, 500, 120, 20);
		hottag2.setBounds(230, 500, 120, 20);
		hottag3.setBounds(380, 500, 120, 20);
		hottag1.setBackground(buttonColor);
		hottag2.setBackground(buttonColor);
		hottag3.setBackground(buttonColor);
		inputTextField.setBounds(80, 100, 450, 30);

		listMenuBox.setBounds(700, 90, 420, 25);
		chooseButton.setBounds(80, 170, 100, 25);
		chooseButton.setBackground(buttonColor);
		caculateButton.setBounds(550, 100, 100, 30);
		caculateButton.setBackground(buttonColor);
		openButton.setBounds(200, 170, 100, 25);
		openButton.setBackground(buttonColor);
		getInput.setBounds(20, 79, 150, 70);
		getInput.setForeground(Color.white);
		resultLabel.setBounds(20, 270, 100, 100);
		resultLabel.setForeground(Color.white);
		nameProject.setFont(nameProject.getFont().deriveFont(30f));
		nameProject.setBounds(500, 0, 400, 80);

		panel.setLayout(null);
		panel.setBackground(setPanelColor);

		lb.setBounds(900, 100, 500, 400);
		panel.add(lb);
		lb.setIcon(new ImageIcon("workshop.png"));

		panel.add(resultLabel);
		panel.add(getInput);
		panel.add(inputTextField);
		// panel.add(outputTextField);
		panel.add(chooseButton);
		panel.add(caculateButton);
		caculateButton.setIcon(new ImageIcon("search.png"));
		panel.add(openButton);
		panel.add(hottag1);
		panel.add(hottag2);
		panel.add(hottag3);
		panel.add(lb);
		panel.add(nameProject);
		panel.add(scrollPane);
		setAction(chooseButton, 1);
		setAction(caculateButton, 2);
		setAction(openButton, 3);
	}

	//#Tạo Frame trong đó có panel
	public void CreateMainFrame(int width, int height, String nameFrame, JPanel panel) {
		JFrame createFrame = new JFrame(nameFrame);
		createFrame.setSize(width, height);
		createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		createFrame.add(panel);
		CreateMainComponent(panel);
		createFrame.setVisible(true);

	}

	//#Tạo action cho Button, mỗi ID ứng với 1 hoạt động
	private void setAction(JButton nameButton, int ID) {
		nameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				setViewWindow(ID);
				if (ID == 1) {

				} else if (ID == 2) {
					userInputString = ViewBase.inputTextField.getText();
					System.out.println(userInputString);
				}
			}
		});
	}

	//# Mở cửa sổ mới tùy thuộc vào ID
	private static void setViewWindow(int ID) {
		switch (ID) {
			case 1: {
				TagView chooseTagView = new TagView();
				break;
			}
			case 2: {

				break;
			}
			case 3: {
				OpenFile chooseFile = new OpenFile();
				break;
			}
			default:
				throw new RuntimeException("Unexpected value: " + ID);
		}

	}

	// # Ham hien thi giao dien App
	public static void main(String args[]) {
//	public void showFrame() {
		backGroundColorChooser.setColor(0, 153, 76);
		setPanelColor = backGroundColorChooser.getColor();
		buttonColorChooser.setColor(102, 178, 255);
		buttonColor = buttonColorChooser.getColor();
		ViewBase viewBase = new ViewBase();
		viewBase.CreateMainFrame(1280, 680, "PROJECT OOP", createPanel);
	}

	//# Hàm hiển thị kết quả
	public static void showData(String outputData) {
		outputTextField.setText(outputData);
	}

}
