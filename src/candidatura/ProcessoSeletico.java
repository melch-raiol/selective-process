package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletico {
    public static void main(String[] args) {
        contatoComCandidato();
    }

    static void contatoComCandidato() {
        String[] candidatos = { "Ana", "Bia", "Carlos", "Daniel", "Eva" };
        for (String candidato : candidatos) {
            entrarEmContato(candidato);
        }
    }

    static void entrarEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }
        } while (continuarTentando && tentativasRealizadas > 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com candidato " + candidato + " na " + tentativasRealizadas);
        } else {
            System.out.println("Não conseguimos contato com candidato " + candidato + " números de tentativa "
                    + tentativasRealizadas);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void selecaoCandidatos() {
        String[] candidatos = { "Ana", "Bia", "Carlos", "Daniel", "Eva", "Farnanda", "Gustavo", "Hélio", "Igor",
                "João" };

        int candidatosSelecionados = 0;
        int candidatosAtuais = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtuais < candidatos.length) {
            String candidato = candidatos[candidatosAtuais];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + ", solicitou salário de " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatosAtuais++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com uma contra proposta");
        } else {
            System.out.println("Aguardar o resultado dos demais candidatos");
        }
    }
}
