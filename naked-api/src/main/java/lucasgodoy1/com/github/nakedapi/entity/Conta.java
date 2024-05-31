package lucasgodoy1.com.github.nakedapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lucasgodoy1.com.github.nakedapi.service.TipoConta;
import lucasgodoy1.com.github.nakedapi.service.ContaService;


import java.io.Serializable;

@Getter @Setter @ToString
@RequiredArgsConstructor
@Entity
@Table(name ="tb_conta")
public class Conta implements Serializable {

    @Id
    @Column(name = "NUMERO_CONTA")
    private String numeroDaConta = ContaService.geraNumeroConta(1,10, 7);

    @Column(name = "NUMERO_AGENCIA")
    private String numeroAgencia = ContaService.geraNumeroConta(1,10, 5);

    @Column(name = "SALDO")
    private Double saldo = 0.0;

    @Column(name = "NOME")
    private String nomeCompleto;

    @Column(name = "TIPO_CONTA")
    private TipoConta tipoDaConta;

}
