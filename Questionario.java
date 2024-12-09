import java.util.ArrayList;
import java.util.List;
import javax.smartcardio.ResponseAPDU;

class Opcao {
    private String texto;

    public Opcao(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}

class Questao {
    private String texto;
    private List<Opcao> opcoes;

    public Questao(String texto) {
        this.texto = texto;
        this.opcoes = new ArrayList<>();
    }

    public void addOpcao(Opcao opcao) {
        opcao.add(opcao);
    }

    public String getTexto(){
        return texto;
    }

    public List<Opcao> getOpcoes() {
        return opcoes;
    }
}

class Resposta {
    private Questao questao;
    private Opcao opcaoSelecionada;

    public Resposta(Questao questao, Opcao opcaoSelecionada) {
        this.questao = questao;
        this.opcaoSelecionada = opcaoSelecionada;
    }

    public Questao getQuestao() {
        return questao;
    }

    public Opcao getOpcaoSelecionada() {
        return opcaoSelecionada;
    }
}

class Enquete {
    private List<Questao> questoes;
    private List<Resposta> respostas;

    public Enquete() {
        this.questoes = new ArrayList<>();
        this.response = new ArrayList<>();
    }

    public void addQuestao(Questao questao) {
        questoes.add(questao);
    }

    public void addResposta(Resposta resposta) {
        respostas.add(resposta);
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }
}

public class Questionario {
    public static void main(String[] args) {
        Enquete enquete = new Enquete();

        Questao q1 = new Questao("Quantos anos voce tem?");
        q1.addOpcao(new Opcao("18"));
        q1.addOpcao(new Opcao("19"));
        q1.addOpcao(new Opcao("20"));
        q1.addOpcao(new Opcao("21"));

        Questao q2 = new Questao("Qual seu filme favorito?");
        q2.addOpcao(new Opcao("Filme A"));
        q2.addOpcao(new Opcao("Filme B"));
        q2.addOpcao(new Opcao("Filme C"));
        q2.addOpcao(new Opcao("Filme D"));

        enquete.addQuestao(q1);
        enquete.addQuestao(q2);

        Resposta r1 = new Resposta(q1, q1.getOpcoes().get(0));
        Resposta r2 = new Resposta(q2, q2.getOpcoes().get(2));

        enquete.addResposta(r1);
        enquete.addResposta(r2);

        for (Questao questao : enquete.getQuestoes()) {
            System.out.println("Questao: " + questao.getTexto());
            for (Opcao opcao : questao.getOpcoes()) {
                System.out.println(" - " + opcao.getTexto());
            }
        }

        System.out.println("\nRespostas:");
        for (Resposta resposta : enquete.getRespostas()) {
            System.out.println("Para a questao '" + resposta.getQuestao().getTexto + "', a resposta foi: " + resposta.getOpcaoSelecionada().getTexto());
        }

    }      

}