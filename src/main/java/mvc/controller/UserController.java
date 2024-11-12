package mvc.controller;

import mvc.dto.UserDTO;
import mvc.model.Usuario;
import mvc.model.UsuarioIndustrial;
import mvc.model.UsuarioResidencial;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserController {

    private List<Usuario> usuarios;

    private static UserController INSTANCE;

    private final String INDUSTRIAL = "Industrial";
    private final String RESIDENCIAL = "Residencial";

    private UserController() {
        initUser();
    }

    public synchronized static UserController getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserController();
        }
        return INSTANCE;
    }

    private void initUser(){
        if(Objects.isNull(usuarios)){
            usuarios = new ArrayList<Usuario>();
        }
    }

    public UserDTO registrarUsuario (UserDTO userDto) throws Exception {
        if(Objects.nonNull(existeUsuario(userDto.getId()))){
            throw new Exception("Existe Usuario");
        }
        usuarios.add(toModel(userDto));
        return userDto;
    }

    public Usuario existeUsuario(int id) {
        int i = 0;
        Usuario user = null;
        while (i < usuarios.size() && user == null) {
            if (usuarios.get(i).getId() == id) {
                user = usuarios.get(i);
            }
            i++;
        }
        return user;
    }

    public List<UserDTO> obtenerUsuarios() {
        List<UserDTO> users = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            users.add(toDto(usuario));
        }
        return users;
    }

    public void eliminarUsuario(int id) {
        Optional<Usuario> user = Optional.ofNullable(this.existeUsuario(id));
        user.ifPresent(usuarios::remove);
    }

    public void modificarUsuario(UserDTO userDto) {
        Optional<Usuario> user = Optional.ofNullable(this.existeUsuario(userDto.getId()));
        user.ifPresent(usuario -> {
            usuarios.remove(usuario);
            usuarios.add(toModel(userDto));
        });
    }

    public static UserDTO toDto(Usuario usuario) {
        if (usuario instanceof UsuarioIndustrial usuarioIndustrial) {
            return new UserDTO(
                    usuario.getId(),
                    INSTANCE.INDUSTRIAL,
                    usuario.getCalle(),
                    usuario.getAltura(),
                    usuario.getPiso(),
                    usuario.getDpto(),
                    usuario.getCodigoPostal(),
                    usuario.getLocalidad(),
                    usuario.getProvincia(),
                    usuarioIndustrial.getRazonSocial(),
                    usuarioIndustrial.getCuit(),
                    usuarioIndustrial.getIIBB(),
                    usuarioIndustrial.getCondicionFiscal(),
                    null, // Nombre no aplica para Industrial
                    0     // DNI no aplica para Industrial
            );
        } else if (usuario instanceof UsuarioResidencial usuarioResidencial) {
            return new UserDTO(
                    usuario.getId(),
                    INSTANCE.RESIDENCIAL,
                    usuario.getCalle(),
                    usuario.getAltura(),
                    usuario.getPiso(),
                    usuario.getDpto(),
                    usuario.getCodigoPostal(),
                    usuario.getLocalidad(),
                    usuario.getProvincia(),
                    null, // RazonSocial no aplica para Residencial
                    null, // CUIT no aplica para Residencial
                    null, // IIBB no aplica para Residencial
                    null, // CondicionFiscal no aplica para Residencial
                    usuarioResidencial.getNombre(),
                    usuarioResidencial.getDni()
            );
        } else {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + usuario.getClass().getSimpleName());
        }
    }


    public Usuario toModel(UserDTO userDto){
        if (INDUSTRIAL.equalsIgnoreCase(userDto.getTipoUsuario())) {
            return new UsuarioIndustrial(
                    userDto.getId(),
                    userDto.getCalle(),
                    userDto.getAltura(),
                    userDto.getPiso(),
                    userDto.getDpto(),
                    userDto.getCodigoPostal(),
                    userDto.getLocalidad(),
                    userDto.getProvincia(),
                    userDto.getRazonSocial(),
                    userDto.getCuit(),
                    userDto.getIIBB(),
                    userDto.getCondicionFiscal()
            );
        } else if (RESIDENCIAL.equalsIgnoreCase(userDto.getTipoUsuario())) {
            return new UsuarioResidencial(
                    userDto.getId(),
                    userDto.getCalle(),
                    userDto.getAltura(),
                    userDto.getPiso(),
                    userDto.getDpto(),
                    userDto.getCodigoPostal(),
                    userDto.getLocalidad(),
                    userDto.getProvincia(),
                    userDto.getNombre(),
                    userDto.getDni()
            );
        } else {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + userDto.getTipoUsuario());
        }
    }


}
