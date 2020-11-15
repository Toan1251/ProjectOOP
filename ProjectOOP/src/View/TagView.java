package View;

import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileSystemView;


public class TagView extends ViewBase{
	static JPanel panelView;
	static String splitStrings;
public TagView(){
	
	 DefaultListModel tagListModel = new DefaultListModel();
	 JButton acceptButton = new JButton("Accept");		 
	 tagListModel.addElement("Tag 1");
	 tagListModel.addElement("Tag 2");
	 tagListModel.addElement("Tag 3");
	 tagListModel.addElement("Tag 4");
	 tagListModel.addElement("Tag 5");
	 JList tagList = new JList(tagListModel);
	 tagList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	 tagList.setSelectedIndex(0);
	 tagList.setVisibleRowCount(3);
	 JScrollPane scrollPane = new JScrollPane(tagList);	 
	 scrollPane.setBounds(100, 100, 300, 200);
    panelView = new JPanel();
    panelView.add(scrollPane);
    acceptButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tagList.getSelectedIndex()!=-1) 
	         { 					
	        String saveDataString=	String.valueOf(tagList.getSelectedValuesList());
	       
	        splitStrings = saveDataString;
	        	System.out.println(splitStrings);
	         }
		}});
          	
    JFrame createFrame = new JFrame("Chon Tag"); 
	createFrame.setSize(600, 400);
	acceptButton.setBounds(createFrame.getSize().width/2+200, createFrame.getSize().height-100, 80, 50);
	createFrame.add(acceptButton);
	createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	createFrame.add(scrollPane);
	createFrame.setVisible(true);

	}
}
