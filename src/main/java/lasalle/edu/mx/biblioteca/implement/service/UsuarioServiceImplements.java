package lasalle.edu.mx.biblioteca.implement.service;

import lasalle.edu.mx.biblioteca.model.UsuarioModel;
import lasalle.edu.mx.biblioteca.repository.UsuarioRepository;
import lasalle.edu.mx.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImplements implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void registrarUsuario(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
    }

    @Override
    public List getUsuario(){
        return usuarioRepository.findAll();
    }

    @Override
    public List registrarUsuario() {
        return List.of();
    }

    @Override
    public UsuarioModel getUsuario(String curp) {
        return usuarioRepository.findByCurp(curp);
    }

    @Override
    public void updateUsuario(UsuarioModel usuarioModel, String curp) {
        usuarioModel.setCurp(curp);
        usuarioRepository.save(usuarioModel);
    }

    @Override
    public void deleteUsuario(String curp) {
        usuarioRepository.deleteById(curp);

    }

    @Override
    public void deleteAllUsuario() {
        usuarioRepository.deleteAll();
    }
}