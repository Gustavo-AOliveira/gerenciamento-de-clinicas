package med.voll.api.domain.Consulta;

import com.fasterxml.jackson.annotation.JsonCreator;
import med.voll.api.domain.Medico.Especialidade;

public enum MotivoCancelamento {

    PACIENTE_DESISTIU,
    MEDICO_CANCELOU,
    OUTROS;

    @JsonCreator
    public static MotivoCancelamento fromString(String value) {
        for (MotivoCancelamento motivoCancelamento : MotivoCancelamento.values()) {
            if (motivoCancelamento.name().equalsIgnoreCase(value)) {
                return motivoCancelamento;
            }
        }
        throw new IllegalArgumentException("Motivo de cancelamento inválido: " + value);
    }
}
