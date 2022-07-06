package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.Desempenho;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
        
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    
    }

    @Test
    public void reajusteDeveriaSer15PorcentoQuandoDesempenhoForBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
        
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    
    }

    @Test
    public void reajusteDeveriaSer20PorcentoQuandoDesempenhoForOtimo(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
        
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    
    }

}
