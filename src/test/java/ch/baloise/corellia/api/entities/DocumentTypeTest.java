package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DocumentTypeTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  void fromLowerCase() throws IOException {
    Document.DocumentType documentType = objectMapper.readValue("\"application_pdf\"", Document.DocumentType.class);
    assertEquals(Document.DocumentType.CONTRACT, documentType);
  }

  @Test
  void fromUpperCase() throws IOException {
    Document.DocumentType documentType = objectMapper.readValue("\"APPLICATION_PDF\"", Document.DocumentType.class);
    assertEquals(Document.DocumentType.CONTRACT, documentType);
  }

  @Test
  void fromUnknownValue() throws IOException {
    JsonMappingException jsonMappingException = assertThrows(JsonMappingException.class, () -> {
      objectMapper.readValue("\"SOMETHING\"", Document.DocumentType.class);
    });

    assertEquals(jsonMappingException.getCause().getClass(), IllegalArgumentException.class);
  }

  @Test
  void fromEmptyString() throws IOException {
    // com.fasterxml.jackson.databind.JsonMappingException - not nice, but no chance to get between jackson and json mapping in the static fatory method of DocumentType
    JsonMappingException jsonMappingException = assertThrows(JsonMappingException.class, () -> {
      objectMapper.readValue("\"\"", Document.DocumentType.class);
    });
    assertEquals(jsonMappingException.getCause().getClass(), IllegalArgumentException.class);
  }
}

