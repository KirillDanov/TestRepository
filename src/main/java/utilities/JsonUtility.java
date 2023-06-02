package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtility {
  private JsonUtility() {}

  public static <T> T getValueFromJson(String pathToFile, Class<T> classType, String keyPath) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      String jsonString = new String(Files.readAllBytes(Paths.get(pathToFile)));
      JsonNode valueNode = objectMapper.readTree(jsonString).at(keyPath);
      return objectMapper.treeToValue(valueNode, classType);
    } catch (IOException e) {
      throw new IllegalArgumentException(String.format("Failed to get %s from JSON.", keyPath), e);
    }
  }

  public static <T> T getModelFromJson(String filePath, Class<T> classType, String jsonNode) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode requiredNode =
          jsonNode.isEmpty()
              ? objectMapper.readTree(new File(filePath))
              : objectMapper.readTree(new File(filePath)).get(jsonNode);
      return objectMapper.treeToValue(requiredNode, classType);
    } catch (IOException e) {
      throw new UnsupportedOperationException("Failed to get model from JSON.", e);
    }
  }
}
