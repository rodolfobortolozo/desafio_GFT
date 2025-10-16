package io.github.rodolfobortolozo.lms.service;

import io.github.rodolfobortolozo.arquitetura.core.security.JWTUtil;
import io.github.rodolfobortolozo.arquitetura.core.security.model.Usuario;
import io.github.rodolfobortolozo.arquitetura.core.security.repository.UsuarioRepository;
import io.github.rodolfobortolozo.lms.model.Estudante;
import io.github.rodolfobortolozo.lms.model.Parametro;
import io.github.rodolfobortolozo.lms.repository.EstudanteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;
    private final ParametroService  parametroService;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;


    public EstudanteService(EstudanteRepository estudanteRepository, ParametroService parametroService, PasswordEncoder passwordEncoder, JWTUtil jwtUtil, UsuarioRepository usuarioRepository) {
        this.estudanteRepository = estudanteRepository;
        this.parametroService = parametroService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
    }

    public Estudante cadastrarEstudante(Estudante estudante){

        verificarIdadeMinima(estudante);
        verificarEmailExistente(estudante);

        estudante.setSenha(passwordEncoder.encode(estudante.getSenha()));
        Estudante newEstudante = estudanteRepository.save(estudante);

        Usuario usuario= usuarioRepository.findByUsuario(newEstudante.getEmail()).get();

        String token = jwtUtil.generateToken(usuario);

        return newEstudante;
    }

    public Estudante pesquisaEstudante(Long id){
        return estudanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula do estudante não Localizado"));
    }

    private void verificarIdadeMinima(Estudante estudante){
        Parametro parametros = this.parametroService.retornaParametros();
        if(calcularIdade(estudante.getDataNascimento()) < parametros.getIdadeMinima()){
            throw new RuntimeException("Idade Minima para cadastro é de "+parametros.getIdadeMinima()+" anos ");
        }
    }

    private void verificarEmailExistente(Estudante estudante){
        if(estudanteRepository.existsByEmail(estudante.getEmail())){
            throw new RuntimeException("Email ja Cadastrado");
        }
    }

    private int calcularIdade(LocalDate dataNascimento){
        LocalDate dataAtual = LocalDate.now();

        return Period.between(dataNascimento,dataAtual).getYears();
    }

}
