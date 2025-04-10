package lasalle.edu.mx.biblioteca.controller;

import lasalle.edu.mx.biblioteca.model.UsuarioModel;
import lasalle.edu.mx.biblioteca.service.UsuarioService;
import lasalle.edu.mx.biblioteca.utils.CustomResponse;
import org.aspectj.apache.bcel.generic.RET;
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
                    new CustomResponse(HttpStatus.OK,
                            usuarioService.getUsuario(curp),
                            "Show all matches",200));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            usuarioService.getUsuario(curp),
                            "Error"+e,400)
            );
        }
    }

    @PutMapping("/{curp}/actualizar")
    public ResponseEntity<Object> updateEstudiante(@RequestBody UsuarioModel usuarioModel, @PathVariable (value = "curp")String curp){
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try{
            if(usuarioService.getUsuario(curp)==null){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,"",
                                "This action can't execute, not found estuent with curp "+curp,
                                204)
                );
            }

            usuarioService.updateUsuario(usuarioModel,curp);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Estudiante actualizado exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }catch(Exception e){
            customResponse.setMessage("Error"+e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }
    @DeleteMapping("/{curp}/borrar")
    public ResponseEntity<Object> deleteEstudiante(@PathVariable String curp){
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();
        try{
            usuarioService.getUsuario(curp);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Estudiante eliminado exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
        catch(Exception e){
            customResponse.setMessage("Error"+e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
