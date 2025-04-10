package lasalle.edu.mx.biblioteca.controller;

import lasalle.edu.mx.biblioteca.model.UsuarioModel;
import lasalle.edu.mx.biblioteca.service.UsuarioService;
import lasalle.edu.mx.biblioteca.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public CustomResponse registroUsuario(@RequestBody UsuarioModel usuarioModel){
        CustomResponse customResponse = new CustomResponse();
        usuarioService.registrarUsuario(usuarioModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("Usuario registrado exitosamente");
        return customResponse;
    }

    @GetMapping("/registro")
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios(){
        List<UsuarioModel> estudiante = usuarioService.getUsuario();
        if(estudiante.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }
    @GetMapping("/{curp}")
    public ResponseEntity<Object> getEstudiante(@PathVariable String curp){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    usuarioService.getUsuario(curp));
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
