package io.github.rodolfobortolozo.lms.service;

import io.github.rodolfobortolozo.lms.model.Parametro;
import io.github.rodolfobortolozo.lms.repository.EstudanteRepository;
import io.github.rodolfobortolozo.lms.repository.ParametroRepository;
import org.springframework.stereotype.Service;

@Service
public class ParametroService {

    private final ParametroRepository parametroRepository;

    private final Long ID_PADRAO_PARAMETRO = 1L;

    public ParametroService(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;
    }

    public Parametro retornaParametros(){
        return parametroRepository.findById(ID_PADRAO_PARAMETRO)
                .orElseThrow( () -> new RuntimeException("Nenhum parametro Cadastrado") );
    }
}
