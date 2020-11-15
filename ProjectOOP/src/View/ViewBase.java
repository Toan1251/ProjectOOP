package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;

import javax.swing.DefaultListModel;
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

public class ViewBase {
	
private static  JLabel getInput = new JLabel("Search: ");
private static	JComboBox listMenuBox = new JComboBox(new String[] {"Chon Tag","Xu li","Chon File"});
private static	JLabel resultLabel = new JLabel("Result ");
private static JPanel createPanel;
private static JCheckBox hottag1 = new JCheckBox("Hot tag 1", false);
private static JCheckBox hottag2 = new JCheckBox("Hot tag 2", false);
private static JCheckBox hottag3 = new JCheckBox("Hot tag 3", false);
private static	JButton chooseButton = new JButton("Chon Tag");
private static	JButton caculateButton = new JButton("Xu li");
private static	JButton openButton = new JButton("Chon File");
private static	JTextField inputTextField = new JTextField(1);
private static	JTextArea outputTextField = new JTextArea(10,1);
static List<String> dataTag= new ArrayList<String>();
static  int setIDtag;
static JScrollPane scrollBar;
public static void main(String[] args)
{
	setBound();
	CreateMainFrame(1280, 680,"PROJECT OOP",createPanel);

}
private static void CreateMainComponent(JPanel panel)
{ 
	panel.setLayout(null);	
	//Add to panel
	panel.add(listMenuBox);
	panel.add(resultLabel);
	panel.add(getInput);
	panel.add(inputTextField);
	panel.add(outputTextField);
	panel.add(chooseButton);
	panel.add(caculateButton);
	panel.add(openButton);
	panel.add(hottag1);
	panel.add(hottag2);
	panel.add(hottag3);
	setAction(chooseButton, "", 1);
	setAction(caculateButton, "", 2);
	setAction(openButton, "", 3);
	}
public static void CreateMainFrame(int width,int height,String nameFrame, JPanel panel)
{
	JFrame createFrame = new JFrame(nameFrame); 
	createFrame.setSize(width, height);
	createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel = new JPanel();
	createFrame.add(panel);
	CreateMainComponent(panel);
	createFrame.setVisible(true);

}

private static void setAction(JButton nameButton,String printString,int ID) {
	nameButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {		
			outputTextField.setText(printString);
			System.out.println(ID);
		  setViewWindow(ID);
		  if(ID==1)
		  { 
		 
		  }
		  else if (ID==2) {
			 
		  }	
		}	
	});
}
private static void setViewWindow(int ID) {
	switch (ID) {
	case 1: {	
		 TagView chooseTagView = new TagView();
		 break;
	}
	case 2:{

				  		  
		break;
	}
	case 3:
	{
		OpenFile chooseFile = new OpenFile();
		break;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + ID);
	}
	 
}
private static void setBound()
{
	hottag1.setBounds(80, 300, 120, 20);
	hottag2.setBounds(230, 300, 120, 20);
	hottag3.setBounds(380, 300, 120, 20);
	inputTextField.setBounds(80, 85, 300, 25);
	outputTextField.setBounds(80, 200, 600, 100);	
	listMenuBox.setBounds(700,90, 400, 25);
	chooseButton.setBounds(80, 150, 100,25);
	caculateButton.setBounds(190, 150, 100, 25);
	openButton.setBounds(300, 150, 100, 25);
	getInput.setBounds(20, 75, 50, 50);
	resultLabel.setBounds(20, 190, 100, 50);
}

}

