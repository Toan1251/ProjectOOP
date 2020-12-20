

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
	public static void CreateTagWindow()
	{    JPanel panelView;
		 DefaultListModel tagListModel = new DefaultListModel();
		 JButton acceptButton = new JButton("Accept");	
		 
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
	    			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tagList.getSelectedIndex()!=-1) 
		         { 					
		      //  String saveDataString=	String.valueOf(tagList.getSelectedValuesList());	       
		      //  selectedTagList = tagList.getSelectedValuesList();
					ViewBase.userInputString=String.valueOf(tagList.getSelectedValuesList());
		         }
			}});
	    
	    JFrame createFrame = new JFrame("Chon Tag"); 
		acceptButton.setBackground(Color.cyan);
		acceptButton.setBounds(200, 100, 80, 50);
		
		createFrame.setSize(600, 400);
		createFrame.add(acceptButton);
		createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createFrame.add(scrollPane);		
		createFrame.add(acceptButton,BorderLayout.EAST);
		createFrame.setVisible(true);
	}
}

