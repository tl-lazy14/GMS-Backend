# Sử dụng base image là OpenJDK 17 (hoặc phiên bản khác nếu cần)
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /gms

# Copy file JAR từ dự án vào container
COPY target/gms-backend-0.0.1-SNAPSHOT.jar /gms/gms-backend-0.0.1-SNAPSHOT.jar

# Lệnh để khởi chạy ứng dụng
CMD ["java", "-jar", "/gms/gms-backend-0.0.1-SNAPSHOT.jar"]
