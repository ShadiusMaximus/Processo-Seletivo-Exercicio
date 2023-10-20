package edu.leoni;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo 
{
    //main
    public static void main( String[] args )
    {
        String [] candidatos = {"LEONI","KAIAN","FILLIPHO","MARCIA","JAVIER"};
        for (String candidato : candidatos) {
            entrarEmContato(candidato);
        }
    }

    //métodos auxiliares

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static double valorPretendidoAleatorio() {
        return ThreadLocalRandom.current().nextDouble(1900, 2100);
    }

    //métodos

    static void entrarEmContato (String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
            tentativasRealizadas++;
            else
            System.out.println("Contato Realizado!");
        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        else
            System.out.println("Não conseguimos contato com " + candidato + ". A quantidade máxima de tentativas foi atingida");
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"LEONI","KAIAN","FILLIPHO","MARCIA","JAVIER"};

        for (String candidato : candidatos) {
            System.out.println("O candidato " + candidato + " foi selecionado");    
        }
    }

    
    static void selecionarCandidatos() {
        String [] candidatos = {"LEONI","KAIAN","FILLIPHO","MARCIA","JAVIER","ASTOLFO","EDMUNDO","AUGUSTO","DEMIFIEND","ASUKA","MOMOTARO","ABNER","MOMONOSUKE","ZORO","ANNO","DANIEL","SON","DANIELA","MARLON","JAIR","LUIS","EDUARDO"};


        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendidoAleatorio();

            System.out.println("O candidato" + candidato + " Solicitou este valor mensal " +salarioPretendido );
            if(salarioBase >= salarioPretendido) {
                System.out.println("Candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            else {
                System.out.println("Candidato " + candidato + " foi negado para a vaga");
            }
            candidatosAtual++;
            
        }
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if(salarioBase==salarioPretendido) {
            System.out.println("Ligar para o candidato com contra-proposta");
       } else{
            System.out.println("Aguardando o resultado dos demais candidatos");
       }
    }
}
