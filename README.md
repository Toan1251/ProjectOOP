# ProjectOOP
Linh:

Sửa lại các hàm get set, contructor nếu muốn quản lý và lưu trữ Tag bằng ArrayList thay vì Set
Sửa lại các lỗi (nếu có) xảy ra khi ép kiểu Set về Tag
Biến TagManager tồn tại trong lớp DataTagging là công cụ để quản lý Tag của các câu liên quan đến 1 đơn vị dữ liệu, còn TagManager trong DataFileOutput để quản lý việc hiển thị các Tag khả dụng cho người dùng. Vì vậy hàm findTag sẽ nhận 1 String từ người dùng. Hàm findTag của bạn hiện tại chưa hề sử dụng String do người dùng gửi đến để thực hiện tìm kiếm trong TagManager, vì vậy bạn cần phải sửa lại hàm này 

Hiếu:
Nếu được thì đ/c có thể Comment Code bằng tiếng ziệt được không, tôi bị Mind Break bởi trình độ Engrich của đ/c mất
Cái trường thứ 2 của Dữ liệu không phải ID đâu nó là YYYY/MM/DD đấy, mặc dù giống hệt nhau nhưng đồng chí có thể làm thêm về đoạn phân tích cái dãy đấy thành dữ liệu kiểu Date không
Tôi rất vui nếu đ/c thay vì tạo ra luôn 1 package mới thì cứ vứt nó vào package model đi, DataFileOutput thì vẫn cần có vài hàm xử lý do những người khác viết mà
Cuối cùng là trong lớp DataFileInput của đ/c phải bổ sung thêm 1 object CSVParser vào nhé không thì các lớp khác không lấy được Data từ đấy đâu
