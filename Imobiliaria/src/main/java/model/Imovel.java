package model;

public class Imovel {
    private int imovelId;
    private String endereco;
    private String tipo;
    private int quartos;
    private int banheiros;
    private int vagasGaragem;
    private double area;
    private boolean disponivel;

    public Imovel() {}

    public Imovel(String endereco, String tipo, int quartos, int banheiros, int vagasGaragem, double area, boolean disponivel) {
        this.endereco = endereco;
        this.tipo = tipo;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.vagasGaragem = vagasGaragem;
        this.area = area;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public int getImovelId() { return imovelId; }
    public void setImovelId(int imovelId) { this.imovelId = imovelId; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getQuartos() { return quartos; }
    public void setQuartos(int quartos) { this.quartos = quartos; }
    public int getBanheiros() { return banheiros; }
    public void setBanheiros(int banheiros) { this.banheiros = banheiros; }
    public int getVagasGaragem() { return vagasGaragem; }
    public void setVagasGaragem(int vagasGaragem) { this.vagasGaragem = vagasGaragem; }
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
