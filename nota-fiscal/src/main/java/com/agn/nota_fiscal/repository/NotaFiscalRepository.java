package com.agn.nota_fiscal.repository;

import com.agn.nota_fiscal.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
}
