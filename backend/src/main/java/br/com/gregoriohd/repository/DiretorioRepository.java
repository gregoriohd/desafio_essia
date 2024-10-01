package br.com.gregoriohd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gregoriohd.entity.Diretorio;

@Repository
public interface DiretorioRepository extends JpaRepository<Diretorio, Long>{
	
//	@Query("SELECT d FROM Diretorio d WHERE d.diretorioPai IS NULL")
    List<Diretorio> findByDiretorioPaiIsNull();

}
