package ch.baloise.corellia.api.entities;

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

}
