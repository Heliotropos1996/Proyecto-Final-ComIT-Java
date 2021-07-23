package com.comit.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.modelo.Huertas;
import com.comit.modelo.Vendedor;
@Repository
public interface HuertasRepositorio extends JpaRepository<Huertas, Long>{

}
