package ra.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    private JavaMailSender mailSender;
    @KafkaListener(topics = "order-create", groupId = "order-create-groupId")
    public void sendOrderConfirmation(OrderCreateDto request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("baby10051999@gmail.com"); // địa chỉ gửi
        message.setTo(request.getUserEmail());           // địa chỉ nhận
        message.setSubject("Xác nhận đơn hàng");
        message.setText("Cảm ơn bạn đã đặt hàng! Đơn hàng của bạn đã được xác nhận và đang được xử lý.");

        mailSender.send(message);
    }
}