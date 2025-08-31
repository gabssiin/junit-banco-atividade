import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Banco;

public class BancoTest {
    Banco bancoCompleto;

    @BeforeEach
    public void setUp() {
        bancoCompleto = new Banco("Banco Completo", 1000);
    }

    @Test // saldo inicial de conta recém criada
    public void balanceNewAccountTest() {
        // se não existisse o setup Banco b = new Banco("777", 1000);
        assertEquals(1000, bancoCompleto.getBalance());

    }

    @Test // teste de deposito nessa mesma conta
    public void depositNewAccountTest() {
        // Banco d = new Banco("dep", 1000);
        bancoCompleto.deposit(500);
        assertEquals(1500, bancoCompleto.getBalance());
    }

    @Test // teste para se caso invalido, no caso número negativo em deposito
    public void depositInvalidTest() {
        // Banco d = new Banco("dep", 1000);
        bancoCompleto.deposit(-500);
        assertEquals(1000, bancoCompleto.getBalance());
    }

    @Test // saque bem sucedido
    public void saqueValidoTest() {
        Boolean ret = bancoCompleto.withdraw(100);
        assertTrue(ret);
        assertEquals(900, bancoCompleto.getBalance());
    }

    @Test // saque falho por saldo insuficiente
    public void withdrawInvalidBalanceTest() {
        boolean ret = bancoCompleto.withdraw(1500);
        assertFalse(ret);
        assertEquals(1000, bancoCompleto.getBalance());
    }

    @Test // saque falho no valor negativo
    public void withdrawInvalidNegativeBalanceTest(){
        bancoCompleto.withdraw(-200);
        assertEquals(1000, bancoCompleto.getBalance());
    }
}
