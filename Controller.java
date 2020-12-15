package ProjectOOP.src.Controller;

import Model.DataFileOutput;
import View.*;

public class Controller {

	// Khởi chạy Controller
	public void start() {
		ViewBase viewbase = new ViewBase();
		viewbase.showFrame();
	}

	// Gửi Request về DataFileOutPut
	// request là String mà người dùng nhập ở Search, hoặc String ở TagView
	public String sentRequest(DataFileOutput dfo, int id) {
		String request;
		if (id == 1) {
			request = ViewBase.userInputString;
		} else if (id == 2) {
			request = TagView.tagString;
		}
		return request;
	}

	// Gửi trả dữ liệu về View
	public String sentData(ViewBase viewbase, DataFileOutput dfo) {
		String outputData = dfo.respond(request);
		return outputData;
	}

	// Hiện kết quả lên Label Result
	public void show(ViewBase viewbase) {
		DataFileOutput dfo = new DataFileOutput();
		viewbase.showData(sentData(viewbase, dfo));

	}

}
