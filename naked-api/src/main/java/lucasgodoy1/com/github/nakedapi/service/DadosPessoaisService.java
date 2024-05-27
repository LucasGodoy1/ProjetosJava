package lucasgodoy1.com.github.nakedapi.service;


import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.DadosPessoais;
import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import lucasgodoy1.com.github.nakedapi.repository.DadosPessoaisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Service
public class DadosPessoaisService {
    private final DadosPessoaisRepository dadosPessoaisRepository;


    @Transactional
    public void salvarDados(Usuario u, DadosPessoais p) {
        p.setCpf(u.getCpf());
        p.setNomeCompleto(u.getNomeCompleto());
        dadosPessoaisRepository.save(p);
    }

    @Transactional
    public DadosPessoais encontrePorID(Long id){
        DadosPessoais u = dadosPessoaisRepository.findById(id).get();
        return u;
    }

    @Transactional
    public void deleteInfoPorID(Long id){
        dadosPessoaisRepository.deleteById(id);
    }




}
