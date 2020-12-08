package ProjectOOP.src.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;


public class TagView extends Frame{
	static JPanel panelView;
	java.util.List<String> selectedTagList;
	
	public TagView(){
	//TagList là menu gồm các Tag có sẵn
	 DefaultListModel tagListModel = new DefaultListModel();
	 JButton acceptButton = new JButton("Accept");		
	 //Add các Tag vào TagList
	 tagListModel.addElement("Tag 1");
	 tagListModel.addElement("Tag 2");
	 tagListModel.addElement("Tag 3");
	 tagListModel.addElement("Tag 4");
	 tagListModel.addElement("Tag 5");
	 JList tagList = new JList(tagListModel);
	 tagList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
	 JScrollPane scrollPane = new JScrollPane(tagList);	 
	 scrollPane.setBounds(100, 100, 300, 200);
     panelView = new JPanel();
     panelView.add(scrollPane);
     acceptButton.addActionListener(new ActionListener() {
		//Khi nhấn Button sẽ lấy được chuỗi String gồm các Tag đã được chọn
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tagList.getSelectedIndex()!=-1) 
	         { 					
	        String saveDataString=	String.valueOf(tagList.getSelectedValuesList());	       
	        selectedTagList = tagList.getSelectedValuesList();
	         }
		}});
    //Tạo Frame
    JFrame createFrame = new JFrame("Chon Tag"); 
	createFrame.setSize(600, 400);
	acceptButton.setBounds(createFrame.getSize().width/2+200, createFrame.getSize().height-100, 80, 50);
	createFrame.add(acceptButton);
	createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	createFrame.add(scrollPane);
	//Tạo Layout và add button vào
	setLayout(new BorderLayout());
	createFrame.add(acceptButton,BorderLayout.EAST);
	createFrame.setVisible(true);
	}
}

