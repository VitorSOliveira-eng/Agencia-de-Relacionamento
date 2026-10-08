public class CelulaAreaInteresse {
    int codigoArea;
    CelulaAreaInteresse proximo;
    public CelulaAreaInteresse(int codigoArea){
        this.codigoArea = codigoArea;
        this.proximo =null;

    }
    public CelulaAreaInteresse(){
        this.proximo = null;
    }
}
