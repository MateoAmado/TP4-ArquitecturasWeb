package responses;

import org.integrador4.ps.model.Usuario;

public class UsuarioResponse {

    private Usuario usuario;

    public UsuarioResponse(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


