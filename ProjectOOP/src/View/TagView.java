package ProjectOOP.src.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;


public class TagView {
    public static void CreateTagWindow() {
        JPanel panelView;
        DefaultListModel tagListModel = new DefaultListModel();
        JButton acceptButton = new JButton("Tìm Kiếm");

        //tagListModel.addElement("Nhóm cổ phiếu Vin");
        tagListModel.addElement("Thống kê thay đổi chứng khoán");
        tagListModel.addElement("Các mã cổ phiếu tăng ngày hôm nay");
        tagListModel.addElement("Các mã cổ phiếu giảm ngày hôm nay");
        tagListModel.addElement("Top 5 cổ phiếu tăng nhiều nhất");
        tagListModel.addElement("Top 5 cổ phiếu giảm nhiều nhất");
        tagListModel.addElement("Top 5 cổ phiếu có khối lượng giao dịch lớn nhất");
        tagListModel.addElement("Nhóm cổ phiếu Hàng không");
        tagListModel.addElement("Nhóm cổ phiếu Thuỷ sản");
        tagListModel.addElement("Nhóm cổ phiếu Xăng dầu");
        tagListModel.addElement("Nhóm cổ phiếu cao su");
        tagListModel.addElement("Nhóm cổ phiếu Ngân hàng");
        tagListModel.addElement("Nhóm cổ phiếu Sắt, Thép");


        ArrayList<String> tagGroup = new ArrayList<>();

        //tagGroup.add("GroupVin");
        tagGroup.add("GroupChangeNumber");
        tagGroup.add("up");
        tagGroup.add("down");
        tagGroup.add("GroupIncreasePercent");
        tagGroup.add("GroupDecreasePercent");
        tagGroup.add("GroupTopVolume");
        tagGroup.add("GroupTopAirline");
        tagGroup.add("GroupTopFishery");
        tagGroup.add("GroupTopPetrol");
        tagGroup.add("GroupTopRubber");
        tagGroup.add("GroupTopBank");
        tagGroup.add("GroupTopSteel");
        
        
        JList tagList = new JList(tagListModel);
        tagList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tagList);
        scrollPane.setBounds(100, 100, 300, 200);


        panelView = new JPanel();
        panelView.add(scrollPane);

        acceptButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tagList.getSelectedIndex() != -1) {
                    int getTagString = tagList.getSelectedIndex();
                    ViewBase.inputTextField.setText(tagList.getSelectedValue().toString().replace("[", "").replace("]",""));
                    ViewBase.userInputString = tagGroup.get(getTagString);
                    ProjectOOP.src.Controller.Controller.request();
                }
            }
        });

        JFrame createFrame = new JFrame("Chon Tag");
        acceptButton.setBackground(new Color(102,178,255));
        acceptButton.setBounds(200, 100, 80, 50);

        createFrame.setSize(600, 400);
        createFrame.add(acceptButton);
        createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent e) {
                ViewBase.countTagView--;

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
        });
        createFrame.add(scrollPane);
        createFrame.add(acceptButton,BorderLayout.EAST);
        createFrame.setVisible(true);
    }
}

