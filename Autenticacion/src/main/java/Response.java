package org.integrador4.ps.auth_service;

import org.integrador4.ps.auth_service.model.Usuario;

public class Response {
    private Usuario usuario;

    public Response(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
