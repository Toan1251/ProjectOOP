import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class SpawmError {
public SpawmError()
{
	
}
public SpawmError(String internetNoti,String nameFrame) //#internetNoti là tên lỗi, nameFrame là tên của cửa sổ hiện lỗi 
{
	JFrame internetFrame = new JFrame(nameFrame);
	internetFrame.setSize(500, 200);
	JTextField stringInternet = new JTextField(internetNoti);
	stringInternet.setBounds(100, 100, 200, 50);
	JPanel newJPanel = new JPanel();
	JOptionPane optionPane = new JOptionPane();
	optionPane.showMessageDialog(internetFrame,internetNoti,nameFrame,JOptionPane.ERROR_MESSAGE);
	
}

}
