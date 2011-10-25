import static org.junit.Assert.*;

import org.junit.Test;

public class CiclistaTest {

	@Test
	public void deveCalcularValoresSimples() throws CiclistaException {
		double resultado = Ciclista.calcularVelocidadeMedia(10, 1);
		assertEquals(10, resultado, 0);
	}

	@Test
	public void deveCalcularValoresComVirgulas() throws CiclistaException {
		double resultado = Ciclista.calcularVelocidadeMedia(10.4, 1.6);
		assertEquals(6.5, resultado, 0);
	}

	@Test
	public void deveCalcularValoresComDistanciaIgualAZero()
			throws CiclistaException {
		double resultado = Ciclista.calcularVelocidadeMedia(0, 1.6);
		assertEquals(0, resultado, 0);
	}

	@Test(expected = CiclistaException.class)
	public void deveCalcularVelocidadeNegativo() throws CiclistaException {
		double resultado = Ciclista.calcularVelocidadeMedia(-30, 1);
	}

	@Test(expected = CiclistaException.class)
	public void deveRetornarErro() throws CiclistaException {
		double resultado = Ciclista.calcularVelocidadeMedia(50, 0);
	}

	@Test(expected = CiclistaException.class)
	public void deveRetornarErroComTempoNegativo() throws CiclistaException {
		double resultado = Ciclista.calcularVelocidadeMedia(50, -3);
	}

	@Test
	public void deveCalcularValoresSimples2() throws CiclistaException {
		String entradaString = ("10 1");
		double[] valorConvertido = Ciclista
				.interpretarValoresDeVelocidadeTempo(entradaString);
		double[] valorEsperado = new double[2];
		valorEsperado[0] = 10;
		valorEsperado[1] = 1;
		assertArrayEquals(valorEsperado, valorConvertido, 0);
	}

	@Test
	public void deveInterpretarValoresComVirgulas() throws CiclistaException {
		String entradaString = ("10.4 1.2");
		double[] valorConvertido = Ciclista
				.interpretarValoresDeVelocidadeTempo(entradaString);
		double[] valorEsperado = new double[2];
		valorEsperado[0] = 10.4;
		valorEsperado[1] = 1.2;
		assertArrayEquals(valorEsperado, valorConvertido, 0);
	}

	@Test
	public void deveInterpretarValoresComDistanciaIgualAZero()
			throws CiclistaException {
		String entradaString = ("0 1.2");
		double[] valorConvertido = Ciclista
				.interpretarValoresDeVelocidadeTempo(entradaString);
		double[] valorEsperado = new double[2];
		valorEsperado[0] = 0;
		valorEsperado[1] = 1.2;
		assertArrayEquals(valorEsperado, valorConvertido, 0);
	}

	@Test
	public void deveInterpretarDistanciaNegativo() throws CiclistaException {
		String entradaString = ("-10 1");
		double[] valorConvertido = Ciclista
				.interpretarValoresDeVelocidadeTempo(entradaString);
		double[] valorEsperado = new double[2];
		valorEsperado[0] = -10;
		valorEsperado[1] = 1;
		assertArrayEquals(valorEsperado, valorConvertido, 0);
	}

	@Test
	public void deveInterpretarVelocidadeTempoNegativo()
			throws CiclistaException {
		String entradaString = ("10 -1");
		double[] valorConvertido = Ciclista
				.interpretarValoresDeVelocidadeTempo(entradaString);
		double[] valorEsperado = new double[2];
		valorEsperado[0] = 10;
		valorEsperado[1] = -1;
		assertArrayEquals(valorEsperado, valorConvertido, 0);
	}

	@Test(expected = CiclistaException.class)
	public void deveInterpretarValoresNulos() throws CiclistaException {
		double[] valorConvertido = Ciclista
				.interpretarValoresDeVelocidadeTempo("");
	}

}
