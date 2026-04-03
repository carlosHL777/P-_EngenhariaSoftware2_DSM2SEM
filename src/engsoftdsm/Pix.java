package engsoftdsm;

public class Pix implements MetodoPagamento{

    @Override
    public boolean processar(double valor) {
        System.out.println("---Gerando QR Code---");
        return true;
    }
}
