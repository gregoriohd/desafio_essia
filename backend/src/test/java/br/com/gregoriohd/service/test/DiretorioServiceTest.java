package br.com.gregoriohd.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.gregoriohd.entity.Diretorio;
import br.com.gregoriohd.repository.DiretorioRepository;
import br.com.gregoriohd.service.DiretorioService;

public class DiretorioServiceTest {

	@Mock
	private DiretorioRepository diretorioRepository;
	
	@InjectMocks
    private DiretorioService diretorioService;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void deveCriarDiretorioSemDiretorioPai() {
        // Arrange
        Diretorio diretorio = new Diretorio();
        diretorio.setNome("Documentos");

        when(diretorioRepository.save(any(Diretorio.class))).thenReturn(diretorio);

        // Act
        Diretorio resultado = diretorioService.salvarDiretorio(diretorio);

        // Assert
        assertEquals("Documentos", resultado.getNome());
        assertNull(resultado.getDiretorioPai());
        verify(diretorioRepository, times(1)).save(any(Diretorio.class));
    }
    
    @Test
    void deveCriarDiretorioComDiretorioPai() {
        // Arrange
        Diretorio diretorioPai = new Diretorio();
        diretorioPai.setId(1L);
        diretorioPai.setNome("Raiz");

        Diretorio diretorio = new Diretorio();
        diretorio.setNome("Subdiretório");
        diretorio.setDiretorioPai(diretorioPai);

        //when(diretorioRepository.findById(1L)).thenReturn(Optional.of(diretorioPai));
        when(diretorioRepository.save(any(Diretorio.class))).thenReturn(diretorio);

        // Act
        Diretorio resultado = diretorioService.salvarDiretorio(diretorio);

        // Assert
        assertEquals("Subdiretório", resultado.getNome());
        assertNotNull(resultado.getDiretorioPai());
        assertEquals("Raiz", resultado.getDiretorioPai().getNome());
        verify(diretorioRepository, times(1)).save(any(Diretorio.class));
        //verify(diretorioRepository, times(0)).findById(1L);
    }

}
