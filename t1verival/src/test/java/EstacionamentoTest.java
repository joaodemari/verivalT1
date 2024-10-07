import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.t1verival.Estacionamento;

public class EstacionamentoTest {

    @ParameterizedTest
    @CsvSource({
        "'2024-10-08T08:00', '2024-10-08T08:10', false, 0.0",
        "'2024-10-08T08:00', '2024-10-08T08:50', false, 5.90",
        "'2024-10-08T08:00', '2024-10-08T11:00', false, 10.90",
        "'2024-10-08T08:00', '2024-10-09T09:00', true, 25.00",
       "'2024-10-08T08:00', '2024-10-10T09:00', false, 100.00",
    })
    void testCalculoValor(String entradaStr, String saidaStr, boolean clienteVIP, double valorEsperado) {
        LocalDateTime entrada = LocalDateTime.parse(entradaStr);
        LocalDateTime saida = LocalDateTime.parse(saidaStr);
        Estacionamento estacionamento = new Estacionamento(entrada, saida, clienteVIP);

        assertEquals(valorEsperado, estacionamento.calcularValor());
    }
}