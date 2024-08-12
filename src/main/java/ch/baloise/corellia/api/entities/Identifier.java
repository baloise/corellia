package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

public class Identifier {

  public enum IdentifierType {
    INT, EXT;

    private static Map<String, Identifier.IdentifierType> ELEMENTS_MAP = Stream.of(Identifier.IdentifierType.values()).collect(
        Collectors.toMap(Enum::name, Function.identity()));

    @JsonCreator // This is the factory method and must be static
    public static Identifier.IdentifierType fromString(String string) {
      final String upperCaseString = StringUtils.isEmpty(string) ? "" : string.toUpperCase();
      return Optional.ofNullable(ELEMENTS_MAP.get(upperCaseString)).orElseThrow(() -> new IllegalArgumentException("cannot convert to Enumtype: " + string));
    }
  }

  @NotNull
  @JsonPropertyDescription("Id depending on the type.")
  private String id;

  @NotNull
  @JsonPropertyDescription("The type of the id. EXT or INT.")
  private IdentifierType type;

  public Identifier() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public IdentifierType getType() {
    return type;
  }

  public void setType(IdentifierType type) {
    this.type = type;
  }
}
