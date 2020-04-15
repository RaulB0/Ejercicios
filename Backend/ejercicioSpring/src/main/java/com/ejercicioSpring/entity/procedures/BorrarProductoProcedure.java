package com.ejercicioSpring.entity.procedures;


import org.springframework.data.jpa.repository.query.Procedure;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(
        name = "BORRAR_PRODUCTO",
        procedureName = "BORRAR_PRODUCTO",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMCODIGO", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name="MSGERROR", type = String.class)
        }
)
public class BorrarProductoProcedure {
    @Id
    private String msgError;

    public BorrarProductoProcedure() {
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
}
