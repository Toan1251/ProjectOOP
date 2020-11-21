# ProjectOOP
Chuẩn bị xây dựng các lớp DataFileHandle, Controller và DataFileOutput

--- DataFileHandle

- Lớp DataFileHandle căn bản là không cần bất kỳ một thuộc tính nào, nó chỉ chứa các phương thức cần thiết để biến DataFileInput -> DataFileOutput

- taggingFuntions:
Là 1 bộ các hàm để Add 1 số Tag kiểu Ranking (Top10 klgd, Top10 tăng, Top10 giảm, .....) cho 1 số đơn vị dữ liệu
của cả tập DataFileInput (Có thể xây dựng 1 lớp mới chuyên để Add các Tag kiểu Ranking)

- makeSentencesFuntions:
Tương tự taggingFunctions để xây dựng bộ các câu cần thiết cho một số đơn vị dữ liệu có các Tag đặc biệt (Ranking)
Cũng có thể xây dựng thành 1 Lớp riêng

- handleFile:
Nhận tham số truyền vào là 1 DataFileInput, đầu ra là 1 DataFileOutput đã được xử lý đầy đủ


--- Controller

- Lớp Controler cũng không cần bất kỳ 1 thuộc tính nào, nó sẽ chỉ chịu trách nhiệm truyền, gửi thông điệp và dữ liệu tới View và DataFileOutput

- sentRequest(DataFileOutput data, Object Request):
gửi một yêu cầu Request tới DataFileOutput, trả về một Đoạn văn phù hợp với Request

- sentData(View view, Object data):
gửi data nhận được từ Request tới View

- openView(View view), close(View view)
Đóng mở View


--- DataFileOutput

- chứa dữ liệu đã qua xử lý, các phương thức hỗ trợ việc tìm kiếm dữ liệu cần thiết để hiển thị lên View

- ArrayList<DataOutput>: chứa tất cả các dữ liệu đã qua xử lý
 
- tagManager: chứa tất cả các Tag có thể tìm kiếm trong DataFileOutput

- findTag(String tag):
Nhận 1 String do view gửi lên, trả về 1 Tag nếu nó tồn tại trong tagManager

- paraghaph(Tag tag):
Dựa vào Tag muốn tìm kiếm, Trả về 1 đoạn văn để gửi về View
