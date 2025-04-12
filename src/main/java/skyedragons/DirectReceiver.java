package skyedragons;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//监听的队列名称 TestDirectQueue
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }



    // 错误示例：使用Map接收自定义对象
    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message) {
        System.out.println("Unhandled message type: " + message.getClass());
    }

}

