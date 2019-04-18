package ch.baloise.corellia.api.entities;

import java.util.List;

public class ValidationError {
  private String path;
  private List<Rule> rules;

  public enum Rule {
    REQUIRED, SIZE, INVALID_VALUE
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public List<Rule> getRules() {
    return rules;
  }

  public void setRules(List<Rule> rules) {
    this.rules = rules;
  }
}
