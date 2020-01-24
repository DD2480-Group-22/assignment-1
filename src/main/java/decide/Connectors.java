package decide;

import java.io.Serializable;

public enum Connectors implements Serializable {
    NOTUSED, ORR, ANDD;

    /**
     * Returns the {@code String} representation of the enums. The function throws {@code IllegalArgumentException} if
     * it could not match the enum with a {@code String} representation.
     * @return The {@code String} representation
     */
    @Override
    public String toString() {
        switch(this){
            case NOTUSED:
                return "NOTUSED";
            case ORR :
                return "ORR";
            case ANDD:
                return "ANDD";
        }
        throw new IllegalArgumentException("Couldn't find a String represent of the given enum");
    }
}
