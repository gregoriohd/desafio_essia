package br.com.gregoriohd.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.gregoriohd.entity.Arquivo;
import br.com.gregoriohd.entity.Diretorio;
import br.com.gregoriohd.repository.ArquivoRepository;
import br.com.gregoriohd.repository.DiretorioRepository;
import br.com.gregoriohd.service.ArquivoService;

public class ArquivoServiceTest {
	
	@Mock
    private ArquivoRepository arquivoRepository;

    @Mock
    private DiretorioRepository diretorioRepository;

    @InjectMocks
    private ArquivoService arquivoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void deveCriarArquivo() {
        // Arrange
        Diretorio diretorio = new Diretorio();
        diretorio.setId(1L);
        diretorio.setNome("Documentos");

        Arquivo arquivo = new Arquivo();
        arquivo.setNome("relatorio.txt");
        arquivo.setTipo(".txt");
        arquivo.setDiretorio(diretorio);

        when(diretorioRepository.findById(1L)).thenReturn(Optional.of(diretorio));
        when(arquivoRepository.save(any(Arquivo.class))).thenReturn(arquivo);
        
        
        // Act
        Arquivo resultado = arquivoService.salvarArquivo(1L, arquivo);
        
        
        // Assert
        assertEquals("relatorio.txt", resultado.getNome());
        assertEquals(".txt", resultado.getTipo());
        assertNotNull(resultado.getDiretorio());
        assertEquals("Documentos", resultado.getDiretorio().getNome());
       // verify(diretorioRepository, times(1)).findById(1L);
        verify(arquivoRepository, times(1)).save(any(Arquivo.class));
        
    }

}
