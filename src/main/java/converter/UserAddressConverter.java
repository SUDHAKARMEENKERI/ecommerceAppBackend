package converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import model.UserAddress;

import java.io.IOException;

@Converter(autoApply = true)
public class UserAddressConverter implements AttributeConverter<UserAddress, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(UserAddress address) {
        try {
            return objectMapper.writeValueAsString(address);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert UserAddress to JSON", e);
        }
    }

    @Override
    public UserAddress convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, UserAddress.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert JSON to UserAddress", e);
        }
    }
}
