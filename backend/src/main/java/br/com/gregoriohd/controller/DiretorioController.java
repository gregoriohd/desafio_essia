package br.com.gregoriohd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gregoriohd.entity.Diretorio;
import br.com.gregoriohd.service.DiretorioService;

@RestController
@RequestMapping("/api/diretorios")
@CrossOrigin(origins = "*")
public class DiretorioController {

	@Autowired
	private DiretorioService diretorioService;

	@GetMapping
	public List<Diretorio> listar() {
		return diretorioService.listarDiretorios();
	}

	@PostMapping
	public Diretorio criar(@RequestBody Diretorio diretorio) {
		return diretorioService.salvarDiretorio(diretorio);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		diretorioService.deletarDiretorio(id);
		return ResponseEntity.noContent().build();
	}

}
