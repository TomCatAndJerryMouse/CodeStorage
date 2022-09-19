package cn.ty.util.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class MsgProducer {
    private final static String TOPIC_NAME = "Allen-Reclica-topic1";
 
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.92.151:9092");
//     （1）acks=0： 表示producer不需要等待任何broker确认收到消息的回复，就可以继续发送下一条消息。性能最高，但是最容易丢消息。
//     （2）acks=1： 至少要等待leader已经成功将数据写入本地log，但是不需要等待所有follower是否成功写入。就可以继续发送下一条消息。这种情况下，如果follower没有成功备份数据，而此时leader又挂掉，则消息会丢失。默认值就是1.
//     （3）acks=-1或all： 需要等待 min.insync.replicas(默认为1，推荐配置大于等于2) 这个参数配置的副本个数都成功写入日志，这种策略会保证只要有一个备份存活就不会丢失数据。这是最强的数据保证。一般除非是金融级别，或跟钱打交道的场景才会使用这种配置。
        props.put(ProducerConfig.ACKS_CONFIG, "1");
//        发送失败会重试，默认重试间隔100ms，重试能保证消息发送的可靠性，但是也可能造成消息重复发送，比如网络抖动，所以需要在接收者那边做好消息接收的幂等性处理。
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        //3. 重试间隔这里的配置用来指定，对于以上2中的重试， 间隔多久重试一次
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
        //设置发送消息的本地缓冲区，如果设置了该缓冲区，消息会先发送到本地缓冲区，可以提高消息发送性能，默认值是33554432，即32MB。
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
//        kafka本地线程会从缓冲区取数据，批量发送到broker，
//        设置批量发送消息的大小，默认值是16384，即16kb，就是说一个batch满了16kb就发送出去
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
//        缓存最长等待时间对应上面设置的缓存发送大小，如果没有到16k不能一直卡在这里，所以需要设置，等待到一定的时间就是缓存没有达到也将消息发出去。
//        所以对应4，5，6的关系如下， 对应生产者端发出的消息，不是每条都马上发到服务器上去，而是先发到本地缓冲区里面去。另外的一个线程会往这个缓冲去里面去拿数据， 一但拿到的数据满了16k就往外发一批。不满16k但是到了10ms也发一批
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10);//#等待时间超过10毫秒不管有没有满16k都发一次
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
 
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
 
        for (int i = 1; i <= 5; i++) {
            String msg = "orderAmount:1000,"+"orderID:orderID00"+ i +",productid:10"+i;;
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME , 0, "orderID00" + i, msg);
            RecordMetadata metadata = producer.send(producerRecord).get();
            System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"+ metadata.partition() + "|offset-" + metadata.offset());
        }
        Thread.sleep(2000);
        producer.close();
    }
//    public static void main(String[] arg){
//        Properties prop = new Properties();
//        prop.put("bootstrap.servers","192.168.92.151:9092");
//        AdminClient adminClient = AdminClient.create(prop);
//        List<NewTopic> topicList = new ArrayList<>();
//        NewTopic topic = new NewTopic("my-first-topic", 1, (short)1);
//        topicList.add(topic);
//        adminClient.createTopics(topicList);
//    }
}