package com.google.generarPdf.dal.dto;

public class RespuestaDTO {

    private boolean transaccionExitosa;
    private String mensajePantalla;

    public RespuestaDTO(boolean transaccionExitosa, String mensajePantalla) {
        this.transaccionExitosa = transaccionExitosa;
        this.mensajePantalla = mensajePantalla;
        System.out.println(transaccionExitosa + mensajePantalla);
    }

    public boolean isTransaccionExitosa() {
        return transaccionExitosa;
    }
    public void setTransaccionExitosa(boolean transaccionExitosa) {
        this.transaccionExitosa = transaccionExitosa;
    }
    public String getMensajePantalla() {
        return mensajePantalla;
    }
    public void setMensajePantalla(String mensajePantalla) {
        this.mensajePantalla = mensajePantalla;
    }
}
