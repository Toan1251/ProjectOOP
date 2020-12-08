package ProjectOOP.src.View;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class OpenFile {
	static File openFile;
    public OpenFile() {
	    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showOpenDialog(null);
        //Khi đóng cửa sổ sẽ lấy được File được chọn thông qua biến openFile
        if (returnValue == JFileChooser.APPROVE_OPTION) {
		    openFile = fileChooser.getSelectedFile();
        }
    }
}
