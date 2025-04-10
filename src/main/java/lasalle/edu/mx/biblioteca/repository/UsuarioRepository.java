package lasalle.edu.mx.biblioteca.repository;

import lasalle.edu.mx.biblioteca.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,String> {
    public UsuarioModel findByCurp(String curp);
}
