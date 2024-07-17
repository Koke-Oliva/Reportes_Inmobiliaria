package com.reportes.controller;

import com.reportes.model.Usuario;
import com.reportes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuarios", description = "API para operaciones de usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Operation(summary = "Registrar nuevo usuario", description = "Registra un nuevo usuario")
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioService.save(usuario));
    }
    
    @Operation(summary = "Registrar lista de usuarios", description = "Registra una lista de usuarios")
    @PostMapping("/registerList")
    public ResponseEntity<List<Usuario>> registerList(@RequestBody List<Usuario> usuarios) {
        usuarios.forEach(usuario -> usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword())));
        List<Usuario> savedUsuarios = usuarioService.saveAll(usuarios);
        return ResponseEntity.ok(savedUsuarios);
    }
    
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios")
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }
    
    @Operation(summary = "Actualizar usuario por su id", description = "Actualiza a un usuario")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        if (usuario.getPassword() != null) {
            usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        }
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @Operation(summary = "Elimina a un usuario por su id", description = "Elimina a un usuario")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();

}

}