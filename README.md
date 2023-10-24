# DoAnNganh

## Tóm tắt đồ án

Hệ thống tư vấn tuyển sinh được tạo ra nhằm giúp ích cho các sinh viên đang có nhu cầu tìm hiểu về trường đồng thời giải đáp được các thắc mắc mà sinh viên đang gặp.

## Chức năng chính

Dự án bao gồm các chức năng như sau:

- Tài khoản sinh viên

* Đăng ký
* Đăng nhập
* Xem thông tin cơ bản của trang web và thông tin từ những trang web khác
* Bình luận
* Quên/Đổi mật khẩu
* Đặt câu hỏi thắc mắc trong thời gian được admin cho phép
* Đặt câu hỏi cho những buổi livestream trước khi bắt đầu
* Nhắn tin trực tiếp với người tư vấn của nhà trường

- Tài khoản admin

* Thêm/sửa/xóa tất cả thông tin của hệ thống

## Cài đặt môi trường

### Yêu cầu

- JDK: Bạn có thể tải JDK từ trang chính của Oracle hoặc sử dụng một phiên bản OpenJDK. Đảm bảo tương thích với NetBeans IDE mà bạn đang sử dụng (Dự án này sử dụng JDK 11 Link tải: [TaiJDK](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html))
- NetBeans IDE: Dự án được phát triển bằng NetBeans, vì vậy bạn nên cài đặt NetBeans IDE để mở và quản lý mã nguồn của dự án.
- MySQL: Để sử dụng cơ sở dữ liệu, bạn cần cài đặt và cấu hình MySQL Server trên máy tính của bạn. Link tải:
  [Taimysql](https://www.mysql.com/downloads/) và [Taimysqlworkbench](https://dev.mysql.com/downloads/workbench/)

- Node.js: Bạn có cài ở https://nodejs.org/fr phiên bản có đuôi LTS
- Visual Studio Code Link tải: [Taivisualcode](https://code.visualstudio.com/download)

### Cài đặt

- Tạo database tên ouadmissions -> Server -> Data Import -> Import from Self-Contained File -> Browser đến thư mục chứa server, rồi chọn file có đuôi .sql -> Chọn tên database mới tạo ở mục Default Target Schema -> Start import
- Mở file server bằng NetBeans, sau đó vào Other Sources -> databases.properties -> sửa username, password theo mysql workbench (Ví dụ: hibernate.connection.username=root, hibernate.connection.password=Thanh@123)
- Sau đó bấm run project
- Mở file client bằng Visual Studio Code, chọn Terminal -> new Terminal -> npm install -> npm start

## Ghi chú

- Tài khoản sinh viên:

* username:Thanh1
* password:123456

- Tài khoản người tư vấn:

* username:mhoang
* password:123456

# Lưu ý: Vui lòng chờ một xíu cho trang web được được hiện thị đầy đủ dữ liệu

- Tài khoản admin:

* username:admin
* password:123

## Liên hệ

Nếu bạn cần hỗ trợ hoặc có bất kỳ câu hỏi nào liên quan đến dự án này, vui lòng liên hệ qua email: 2051052120thanh@ou.edu.vn hoặc thông qua số điện thoại: 0335013375
