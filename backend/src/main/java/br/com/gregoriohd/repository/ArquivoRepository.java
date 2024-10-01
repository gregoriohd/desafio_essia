package br.com.gregoriohd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gregoriohd.entity.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{

}
