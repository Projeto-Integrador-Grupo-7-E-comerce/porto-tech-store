package com.portotechstore.portotechstore.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portotechstore.portotechstore.model.UsuarioLogin;
import com.portotechstore.portotechstore.model.UsuarioModel;
import com.portotechstore.portotechstore.repository.UsuarioRepository;
import com.portotechstore.portotechstore.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins= "*",allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@GetMapping
	public ResponseEntity<List<UsuarioModel>>getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin>Autentication(@RequestBody Optional<UsuarioLogin> userLogin){
		System.out.println("Passando aqui");
		return usuarioService.Logar(userLogin).map(resp->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<UsuarioModel>> Post(@RequestBody UsuarioModel usuarioModel){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuarioModel));
	}
}