class Node {
    int valor;
    int peso;
    Node esquerdo;
    Node direito;

    public Node(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
        this.esquerdo = null;
        this.direito = null;
    }
 }

 abstract class Criteria {
    public abstract Node apply(Node referenceNode, int valor);  
 }

 class classicaCriteria extends Criteria {
    @Override
    public Node apply(Node referenceNode, int valor) {
        if(valor < referenceNode.valor) {
            return referenceNode.esquerdo;
        } else {
            return referenceNode.direito;
        }
    }
 }

class opostaCriteria extends Criteria {
    @Override
    public Node apply(Node referenceNode, int valor) {
        if (valor < referenceNode.valor) {
            return referenceNode.direito;
        } else {
            return referenceNode.esquerdo;
        }
    }
 }

 class Neuro extends Criteria {
    @Override
    public Node apply(Node referenceNode, int valor) {
        int result = referenceNode.peso * valor;
        if (result < referenceNode.valor) {
            return referenceNode.esquerdo;
        } else {
            return referenceNode.direito;
        }
    }
 }
class Arvore {
    Node raiz;
    Criteria criteria;

    public Arvore(Criteria criteria) {
        this.criteria = criteria;
        this.raiz = null;
    }

    public void insert(int valor, int peso) {
        raiz = insertRec(raiz, valor, peso);
    }

    private Node insertRec(Node node, int valor, int peso) {
        if (node == null) {
            node = new Node(valor, peso);
            return node;
        }

        Node nextNode = criteria.apply(node, valor);
        if (nextNode == node.esquerdo) {
            node.esquerdo = insertRec(node.esquerdo, valor, peso);
        } else {
            node.direito = insertRec(node.direito, valor, peso);
        }

        return node;
    }
}

public class ArvoreTeste2 {
    public static void main(String[] args) {
        Criteria classicaCriteria = new classicaCriteria();
        Arvore classicArvore = new Arvore(classicaCriteria);
        classicArvore.insert(10,2);
        classicArvore.insert(5,1);
        classicArvore.insert(15,3);

        System.out.println();

        Criteria opostaCriteria = new opostaCriteria();
        Arvore opostaArvore = new Arvore(opostaCriteria);
        opostaArvore.insert(10,2);
        opostaArvore.insert(5,1);
        opostaArvore.insert(15,3);

        Criteria neuroCriteria = new Neuro();
        Arvore neuroArvore = new Arvore(neuroCriteria);
        neuroArvore.insert(10, 2);
        neuroArvore.insert(5,1);
        neuroArvore.insert(15,3);


    }

}
