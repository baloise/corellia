package ch.baloise.corellia.api.entities;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Cancellation implements Serializable {

    private static final long serialVersionUID = 10;

    @NotNull
    @Valid
    private Identifier identifier;

    @NotNull
    @Valid
    private Action action;

    @NotNull
    @JsonPropertyDescription("A code uniquely identifying the cancellation reason")
    private Integer reasonCode;

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Integer getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(Integer reasonCode) {
        this.reasonCode = reasonCode;
    }
}
