package lasalle.edu.mx.biblioteca.service;

import lasalle.edu.mx.biblioteca.model.UsuarioModel;
import java.util.List;
import org.springframework.stereotype.Service;


public interface UsuarioService {
    public void registrarUsuario(UsuarioModel usuarioModel);

    List getUsuario();

    public List registrarUsuario();
    public UsuarioModel getUsuario(String curp);
    public void updateUsuario (UsuarioModel usuarioModel, String curp);
    public void deleteUsuario (String curp);
    public void deleteAllUsuario();

}
