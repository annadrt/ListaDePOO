class Node {
    int valor;
    Node esquerdo;
    Node direito;

    public Node(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }
 }

 abstract class Criteria {
    public abstract Node apply(Node referenceNode, int valor);  
 }

 class classicaCritera extends Criteria {
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

class Arvore {
    Node raiz;
    Criteria criteria

    public Arvore(Criteria criteria) {
        this.criteria = criteria;
        this.raiz = null;
    }

    public void insert(int valor) {
        raiz = insertRec(raiz, valor);
    }

    private Node insertRec(Node node, int valor) {
        if (node == null) {
            node = new Node(valor);
            return node;
        }

        Node nextNode = criteria.apply(node, valor);
        if (nextNode == node.esquerdo) {
            node.esquerdo = insertRec(node.esquerdo, valor);
        } else {
            node.direito = insertRec(node.direito, valor);
        }

        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        Criteria classicaCriteria = new classicaCriteria();
        Arvore classicArvore = new Arvore(classicaCriteria);
        classicArvore.insert(10);
        classicArvore.insert(5);
        classicArvore.insert(15);

        System.out.println();

        Criteria opostaCriteria = new opostaCriteria();
        Arvore opostaArvore = new Arvore(opostaCriteria)

    }
}
