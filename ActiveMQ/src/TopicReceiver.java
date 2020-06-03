import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
 
/**Subscriber
 * @author wanghuadong
 * @createDate 2015-6-19 ����01:34:27
 * 
 * @file TopicReceiver.java
 * @project ActiveMQ-5.8
 */
public class TopicReceiver {
 
  
    public static final String BROKER_URL = "tcp://localhost:61616";

    public static final String TARGET = "MyTopic";
    
    
    public static void run() throws Exception {
        
        TopicConnection connection = null;
        TopicSession session = null;
        try {
            // �������ӹ���
            TopicConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // ͨ����������һ������
            connection = factory.createTopicConnection();
            
          connection.setClientID("ddd");
            // ��������
            connection.start();
            // ����һ��session�Ự
            session = connection.createTopicSession(Boolean.FALSE , Session.AUTO_ACKNOWLEDGE);
            // ����һ����Ϣ����
            Topic topic = session.createTopic(TARGET);
            // ������Ϣ������
          // TopicSubscriber subscriber = session.createSubscriber(topic);
            
            TopicSubscriber subscriber = session.createDurableSubscriber(topic, "ddd");
            subscriber.setMessageListener(new MessageListener() { 
                public void onMessage(Message msg) { 
                    if (msg != null) {
                        TextMessage text = (TextMessage) msg;
                        try {
                            System.out.println(text.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                } 
            }); 
          
            Thread.sleep(1000); 
            
            // �ύ�Ự
           // session.commit();
            
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
        TopicReceiver.run();
    }
}