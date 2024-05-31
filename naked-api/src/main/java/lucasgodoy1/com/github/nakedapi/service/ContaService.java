package lucasgodoy1.com.github.nakedapi.service;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Conta;
import lucasgodoy1.com.github.nakedapi.entity.DadosPessoais;
import lucasgodoy1.com.github.nakedapi.repository.ContaRepository;
import lucasgodoy1.com.github.nakedapi.repository.DadosPessoaisRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class ContaService {
    private final ContaRepository contaRepository;
    private final DadosPessoaisRepository dadosPessoaisRepository;
    private static final Random random = new Random();


    //torna a senha passada em um hash
    public static String encoder(String senha) {
        BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
        return encoderSenha.encode(senha);
    }

    //comapra a senah hash do usuario com o hash no bd
    public static Boolean compararSenha(String requestSenha, String senhaRegistrada) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(requestSenha, senhaRegistrada);
    }

    public static String geraNumeroConta(int origin, int bound, int length) {
        if (bound <= origin) {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        StringBuilder numeroConta = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(bound - origin) + origin;
            numeroConta.append(digit);
        }
        return numeroConta.toString();
    }


    public Conta salvarComId(Conta conta , Long id){
        DadosPessoais  dados = dadosPessoaisRepository.findById(id).get();
        conta.setNomeCompleto(dados.getNomeCompleto());
        contaRepository.save(conta);
        return conta;
    }

    public Conta encontrePorID(Long id){
        Conta u = contaRepository.findById(id).get();
        return u;
    }


}


