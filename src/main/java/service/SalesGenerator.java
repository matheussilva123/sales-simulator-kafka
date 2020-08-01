package service;

import Serializer.SaleSerializer;
import model.Sale;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

public class SalesGenerator {

    private static Random rand = new Random();
    private static long operation = 0;
    private static BigDecimal valueTicket = BigDecimal.valueOf(500);


    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SaleSerializer.class.getName());


        try {
            KafkaProducer<String, Sale> producer = new KafkaProducer<String, Sale>(properties);

            while (true) {
                Sale sale = generateSale();
                ProducerRecord<String, Sale> record = new ProducerRecord<String, Sale>("sale-ticket", sale);
                producer.send(record);
                Thread.sleep(200);
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static Sale generateSale() {
        long client = rand.nextLong();
        int quantityTickets = rand.nextInt(10);

        return new Sale(operation++, client, quantityTickets, valueTicket.multiply(BigDecimal.valueOf(quantityTickets)));
    }

}
