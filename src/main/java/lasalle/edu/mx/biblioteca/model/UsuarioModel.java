package lasalle.edu.mx.biblioteca.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
        public UsuarioModel() {

        }
        @Id
        @Column(length = 18, unique = true)
        @NotNull
        @Size(min=18,max=18)
        @Pattern(regexp = "^[A-Z]{4}[0-9]{6}[HM]{1}[A-Z]{5}[0-9]{2}$", message = "CURP no válido")
        private String curp;

        @NotNull
        @Size(min=2, max=100)
        private String nombre;

        @NotNull
        @Size(min=2, max=100)
        private String apellidos;

        @NotNull
        @Size(min=1, max=1)
        @Pattern(regexp="(M|F)$", message= "El género debe ser 'M' o 'F'")
        private String genero;

        @NotNull
        @Temporal(TemporalType.DATE)
        private Date fechaNacimiento;


        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getGenero() {
            return genero;
        }

        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public UsuarioModel(String apellidos, String curp, String nombre, String genero, Date fechaNacimiento) {
            this.apellidos = apellidos;
            this.curp = curp;
            this.nombre = nombre;
            this.genero = genero;
            this.fechaNacimiento = fechaNacimiento;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }
}