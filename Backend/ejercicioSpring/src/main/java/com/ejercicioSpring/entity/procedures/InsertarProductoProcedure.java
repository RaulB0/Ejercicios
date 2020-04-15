package com.ejercicioSpring.entity.procedures;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedStoredProcedureQuery(
        name = "INSERTAR_PRODUCTO",
        procedureName = "INSERTAR_PRODUCTO",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMCODIGO", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMNOMBRE", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMCOLOR", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name="FECHA_CREACION", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name="MSGERROR", type = String.class)
        }
)
public class InsertarProductoProcedure {
    @Id
    private String msgError;

    public InsertarProductoProcedure() {
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        msgError = msgError;
    }
}
