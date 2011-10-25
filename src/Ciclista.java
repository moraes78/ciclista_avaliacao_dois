// segunda prova de java 
//dia 24/10/2011
// alunos: Daniel , Joel , Valdir
// use linux 
//todos os direitos reservados

import java.util.Scanner;

public class Ciclista {

	public static void main(String[] args) throws CiclistaException {
		Scanner entrada = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Informe distância e tempo: ");
				String entradaString = entrada.nextLine();
				double[] valoresConvertidos = interpretarValoresDeVelocidadeTempo(entradaString);
				double velocidadeMedia = calcularVelocidadeMedia(
						valoresConvertidos[0], valoresConvertidos[1]);
				if (velocidadeMedia == 0.0) {
					System.out
							.println("Você não percorreu nenhuma distancia !!");
				} else {
					System.out.println("A velocidade media é : "
							+ velocidadeMedia + " Km/h");
				}
			} catch (Exception CiclistaException) {
				System.out
						.println("Tempo não pode ser menor ou igual a zero!!");
			}
		}
	}

	static double[] interpretarValoresDeVelocidadeTempo(String entradaString)
			throws CiclistaException {
		if (!entradaString.equals("")) {
			String[] informacaoSeparada = entradaString.split(" ");
			double[] informacao = new double[2];
			informacao[0] = Double.parseDouble(informacaoSeparada[0]);
			informacao[1] = Double.parseDouble(informacaoSeparada[1]);

			return informacao;
		} else {
			throw new CiclistaException();
		}
	}

	public static double calcularVelocidadeMedia(double d, double t)
			throws CiclistaException {
		if (t > 0.0 && d >= 0) {
			return d / t;
		} else {
			throw new CiclistaException();
		}
	}

}
