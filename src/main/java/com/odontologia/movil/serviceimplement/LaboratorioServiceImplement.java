package com.odontologia.movil.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odontologia.movil.entidades.Laboratorio;
import com.odontologia.movil.repository.LaboratorioRepository;
import com.odontologia.movil.service.LaboratorioService;



@Service
public class LaboratorioServiceImplement implements LaboratorioService {
	
	 private final LaboratorioRepository laboratorioRepository;

	    @Autowired
	    public LaboratorioServiceImplement(LaboratorioRepository laboratorioRepository) {
	        this.laboratorioRepository = laboratorioRepository;
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public List<Laboratorio> findAll() {
	        return laboratorioRepository.findAll();
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Optional<Laboratorio> findById(Integer id) {
	        return laboratorioRepository.findById(id);
	    }

	    @Override
	    @Transactional
	    public Laboratorio save(Laboratorio laboratorio) {
	        return laboratorioRepository.save(laboratorio);
	    }

	    @Override
	    @Transactional
	    public void deleteById(Integer id) {
	        laboratorioRepository.deleteById(id);
	    }

}
