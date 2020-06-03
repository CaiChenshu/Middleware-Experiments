import javax.jms.DeliveryMode;
import javax.jms.TextMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
 
 
/**Publisher
 * @author wanghuadong 
 * @createDate 2013-6-19 ����04:34:36
 * @file TopicSender.java
 * @project ActiveMQ-5.8
 * @version 1.0
 */
public class TopicSender {
    
    // ���ʹ���
    public static final int SEND_NUM = 2;
   
    public static final String BROKER_URL = "tcp://localhost:61616";
    
    public static final String DESTINATION = "MyTopic";
    
      
    public static void sendMessage(TopicSession session, TopicPublisher publisher) throws Exception {
        for (int i = 1; i < SEND_NUM; i++) {
            
            TextMessage message = session.createTextMessage("ʹ��ActiveMq������Ϣ" +i);
            
           System.out.println("ʹ��ActiveMq������Ϣ" +i);
            
            publisher.send(message);
        }
    }
    
    public static void run() throws Exception {
        
        TopicConnection connection = null;
        TopicSession session = null;
        try {
            // �������ӹ���
            TopicConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // ͨ����������һ������
            connection = factory.createTopicConnection();
          
            // ��������
            connection.start();
            // ����һ��session�Ự
            
            session = connection.createTopicSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            // ����һ����Ϣ����
            Topic topic = session.createTopic(DESTINATION);
            // ������Ϣ������
            TopicPublisher publisher = session.createPublisher(topic);
            // ���ó־û�ģʽ
            publisher.setDeliveryMode(DeliveryMode.PERSISTENT);
            sendMessage(session, publisher);
            // �ύ�Ự
            //session.commit();
            
        } catch (Exception e) {
            throw e;
        } finally {
            // �ر��ͷ���Դ
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        TopicSender.run();
    }
}