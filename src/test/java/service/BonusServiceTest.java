package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("250000") ));
        
        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500") ));
        
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorcentoParaSalarioDeExatamente10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000") ));
        
        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
