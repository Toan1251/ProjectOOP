package Bai_tap_lon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TagManager extends JFrame {
	
	
	public static void settagList(List<String> arr) {	
	}
	public static void setTag() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel ChonTag;
	private List<String> tag = new ArrayList<>();
	protected List<String> Arr;

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TagManager frame = new TagManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("rawtypes")
	public TagManager() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 260);
		ChonTag = new JPanel();
		ChonTag.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ChonTag);
		setLocationRelativeTo(null);
		
		String[] T = {"Tăng nhiều nhất","Top 3 tăng","Giảm nhiều nhất","Top 3 giảm","Nước ngoài mua","Nước ngoài bán","Thông tin sàn giao dịch","Trạng thái sàn giao dịch","Xu hướng sàn giao dịch","Trạng thái nhóm dầu khí","Cổ phiếu nhóm dầu khí","Trạng thái nhóm ngân hàng","Cổ phiếu nhóm ngân hàng","So sánh giá với giá trần","Nhóm cổ phiếu tăng","Nhóm cổ phiếu tăng nhanh","Nhóm cổ phiếu giảm","Nhóm cổ phiếu giảm mạnh","Nhóm cổ phiếu ổn định","Nhóm cổ phiếu phân hóa","Đứng giá tham chiếu","Tự trụ tăng","Tăng hết biên độ","Diễn biến trái chiều","Đồng loạt mất điểm","Tuột dốc","Chìm trong sắc đỏ"};		
		for (String index : T) {
			tag.add(index);
		}
			
		@SuppressWarnings("unchecked")
		JList list = new JList(tag.toArray());
		list.setSelectedIndex(1);
		list.setFont(new Font("Arial", Font.PLAIN, 15));
		list.setBounds(0, 0, 200, 376);		
		ChonTag.add(list);
		getContentPane().add(BorderLayout.CENTER, new JScrollPane(list));
		
		JButton chonButton = new JButton("Chọn");
		chonButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		chonButton.setBounds(221, 36, 102, 41);
		ChonTag.add(chonButton);
		chonButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				Arr = (ArrayList<String>) list.getSelectedValuesList();
				System.out.println(Arr); //test
				Tag.settagList(Arr);
				Tag.setTag();
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Chọn Tag thành công!!");
			}
		});
		
		JLabel lblNewLabel = new JLabel("Note:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(248, 138, 40, 17);
		ChonTag.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bạn có thể chọn nhiều Tag bằng cách giữ \"Ctrl+Chuột\"");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(235, 164, 79, 16);
		ChonTag.add(lblNewLabel_1);
		
	}
}
