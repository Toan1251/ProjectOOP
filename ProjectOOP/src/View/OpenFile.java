package View;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class OpenFile {
public OpenFile() {
	JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    int returnValue = fileChooser.showOpenDialog(null); 
    if (returnValue == fileChooser.APPROVE_OPTION) {
		File openFile = fileChooser.getSelectedFile();
    }
}
}
