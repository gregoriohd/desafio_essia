package br.com.gregoriohd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregoriohd.entity.Arquivo;
import br.com.gregoriohd.entity.Diretorio;
import br.com.gregoriohd.repository.ArquivoRepository;
import br.com.gregoriohd.repository.DiretorioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ArquivoService {

	@Autowired
	private ArquivoRepository arquivoRepository;

	@Autowired
	private DiretorioRepository diretorioRepository;

	public List<Arquivo> listarArquivos() {
		return arquivoRepository.findAll();
	}

	public Arquivo salvarArquivo(Long diretorioId, Arquivo arquivo) {
		Diretorio diretorio = diretorioRepository.findById(diretorioId)
				.orElseThrow(() -> new EntityNotFoundException("Diretório não encontrado"));
		
		// Associa o arquivo ao diretório
		arquivo.setDiretorio(diretorio);
		
		return arquivoRepository.save(arquivo);
	}

	public void deletarArquivo(Long id) {
		arquivoRepository.deleteById(id);
	}

	public Optional<Arquivo> buscarPorId(Long id) {
		return arquivoRepository.findById(id);
	}
}
