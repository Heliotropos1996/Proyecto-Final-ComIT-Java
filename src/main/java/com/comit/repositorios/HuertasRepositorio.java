package com.comit.repositorios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.modelo.Huerta;


@Repository
public interface HuertasRepositorio extends JpaRepository<Huerta, Long>{

		List<Huerta> findByBorrado(Boolean borrado);
}

