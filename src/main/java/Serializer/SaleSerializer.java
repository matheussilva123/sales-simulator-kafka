package Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Sale;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class SaleSerializer implements Serializer<Sale> {


    public byte[] serialize(String topic, Sale sale) {
        try {
            return new ObjectMapper().writeValueAsBytes(sale);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {

    }
}
