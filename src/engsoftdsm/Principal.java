package engsoftdsm;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        MaquinaCafe minhaMaquina = new MaquinaCafe();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("--- Bem-vindo a cafeteria Guillermo&Gusttavo Cavalcante ---");
            
            for (int i = 0; i < minhaMaquina.getListaSabores().size(); i++) {
                Sabor s = minhaMaquina.getListaSabores().get(i);
 
                System.out.println((i + 1) + ". " + s.getNome() + 
                                   " - R$ " + s.getPreco() + 
                                   " | Status: " + s.getStatusLuz());
            }
            System.out.println("Escolha seu sabor:");
            
            int escolha = sc.nextInt();
            
            System.out.println("Digite seu saldo:");
            double saldoDoCliente = sc.nextDouble();
            
            if (escolha < 1 || escolha > 6) {
                System.out.println("Opção inválida! Reinicie a máquina.");
            } else {
                System.out.println("Escolha o método de pagamento (1- Pix, 2- Cartão):");
                int tipoPagamento = sc.nextInt();
                
                MetodoPagamento pagamento;
                if (tipoPagamento == 1) {
                    pagamento = new Pix();
                } else {
                    pagamento = new Cartao();
                }
                
                minhaMaquina.realizarVenda(escolha - 1, pagamento, saldoDoCliente);
            }
        }
    }
    
}
