package com.odontologia.movil.serviceimplement;

import com.odontologia.movil.service.TipoPersonaService;

import com.odontologia.movil.entidades.TipoPersona;
import com.odontologia.movil.repository.TipoPersonaRepository;
import com.odontologia.movil.service.TipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPersonaServiceImplement implements TipoPersonaService{
	
	private final TipoPersonaRepository tipoPersonaRepository;

    @Autowired
    public TipoPersonaServiceImplement(TipoPersonaRepository tipoPersonaRepository) {
        this.tipoPersonaRepository = tipoPersonaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoPersona> findAll() {
        return tipoPersonaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoPersona> findById(Integer id) {
        return tipoPersonaRepository.findById(id);
    }

    @Override
    @Transactional
    public TipoPersona save(TipoPersona tipoPersona) {
        return tipoPersonaRepository.save(tipoPersona);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        tipoPersonaRepository.deleteById(id);
    }

}
