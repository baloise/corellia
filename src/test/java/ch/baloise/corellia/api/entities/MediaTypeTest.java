package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediaTypeTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  void fromLowerCase() throws IOException {
    Document.MediaType mediaType = objectMapper.readValue("\"application_pdf\"", Document.MediaType.class);
    assertEquals(Document.MediaType.APPLICATION_PDF, mediaType);
  }

  @Test
  void fromUpperCase() throws IOException {
    Document.MediaType mediaType = objectMapper.readValue("\"APPLICATION_PDF\"", Document.MediaType.class);
    assertEquals(Document.MediaType.APPLICATION_PDF, mediaType);
  }

  @Test
  void fromUnknownValue() throws IOException {
    JsonMappingException jsonMappingException = Assertions.assertThrows(JsonMappingException.class, () -> {
      objectMapper.readValue("\"SOMETHING\"", Document.MediaType.class);
    });

    assertEquals(jsonMappingException.getCause().getClass(), IllegalArgumentException.class);
  }

  @Test
  void fromEmptyString() throws IOException {
    // com.fasterxml.jackson.databind.JsonMappingException - not nice, but no chance to get between jackson and json mapping in the static fatory method of MediaType
    JsonMappingException jsonMappingException = Assertions.assertThrows(JsonMappingException.class, () -> {
      objectMapper.readValue("\"\"", Document.MediaType.class);
    });
    assertEquals(jsonMappingException.getCause().getClass(), IllegalArgumentException.class);
  }
}

