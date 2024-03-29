package med.voll.api.domain.Medico;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Especialidade {
    ORTOPEDIA,
    CARDIOLOGIA,
    GINECOLOGIA,
    DERMATOLOGIA;

    @JsonCreator
    public static Especialidade fromString(String value) {
        for (Especialidade especialidade : Especialidade.values()) {
            if (especialidade.name().equalsIgnoreCase(value)) {
                return especialidade;
            }
        }
        throw new IllegalArgumentException("Especialidade inválida: " + value);
    }
}
