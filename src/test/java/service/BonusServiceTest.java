package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class, 
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("250000") )));
        //Um modo de verificar se o assert está executando um throw
        
        //Outro modo para verificar se o teste de Exception falhou
        // try{
        //     service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("250000") ));
        //     fail("Nao deu a exception!");
        // } catch (Exception ex){
                // assertEquals("Funcionario com salario maior do que 10000 nao pode receber bonus", e.getMessage());
        // }
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
