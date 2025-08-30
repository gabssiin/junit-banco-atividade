import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Banco;

public class BancoTest {

    @BeforeEach
    public void setUp(){
        Banco bancoCompleto = new Banco("Banco Completo", 10000);
    }
    @Test
    public void balanceNewAccountTest() {
        Banco b = new Banco("777", 1000);
        assertEquals(1000, b.getBalance());
    }

    @Test
    public void depositNewAccountTest(){
        Banco d = new Banco("dep", 1000);
        d.deposit(500);
        assertEquals(1500, d.getBalance());
    }

    @Test
    public void depositInvalidTest(){
        Banco d = new Banco("dep", 1000);
        d.deposit(-500);
        assertEquals(1000, d.getBalance());
    }
    @Test
    public void withdrawNewAccountTest(){
        Banco w = new Banco("withdraw", 1000);
        w.withdraw(400);
        assertEquals(600, w.getBalance());
    }

    @Test
    public void balanceInvalidTest(){
        Banco bIn = new Banco("inv", 1000);
        bIn.withdraw(1500);
        assertFalse(false, "False deu erro ai rapaziada");

    }
}
