package br.com.gregoriohd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gregoriohd.entity.Diretorio;
import br.com.gregoriohd.repository.DiretorioRepository;

@Service
public class DiretorioService {
	
	@Autowired
	private DiretorioRepository diretorioRepository;

	public List<Diretorio> listarDiretorios() {
		return diretorioRepository.findByDiretorioPaiIsNull();
	}

	public Diretorio salvarDiretorio(Diretorio diretorio) {
		return diretorioRepository.save(diretorio);
	}

	public void deletarDiretorio(Long id) {
		diretorioRepository.deleteById(id);
	}

	public Optional<Diretorio> buscarPorId(Long id) {
		return diretorioRepository.findById(id);
	}

}
