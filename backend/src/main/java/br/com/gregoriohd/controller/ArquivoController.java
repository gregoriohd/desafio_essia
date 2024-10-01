package br.com.gregoriohd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gregoriohd.entity.Arquivo;
import br.com.gregoriohd.service.ArquivoService;

@RestController
@RequestMapping("/api/arquivos")
public class ArquivoController {

	@Autowired
	private ArquivoService arquivoService;

	@GetMapping
	public List<Arquivo> listar() {
		return arquivoService.listarArquivos();
	}

	@PostMapping("/diretorios/{diretorioId}")
	public Arquivo criar(@PathVariable Long diretorioId, @RequestBody Arquivo arquivo) {
		Arquivo novoArquivo = arquivoService.salvarArquivo(diretorioId, arquivo);
		return novoArquivo;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		arquivoService.deletarArquivo(id);
		return ResponseEntity.noContent().build();
	}

}
