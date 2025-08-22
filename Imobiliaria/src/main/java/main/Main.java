package main;

import dao.ClienteDAO;
import dao.ImovelDAO;
import dao.ContratoDAO;
import model.Cliente;
import model.Imovel;
import model.Contrato;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteDAO clienteDAO = new ClienteDAO();
        ImovelDAO imovelDAO = new ImovelDAO();
        ContratoDAO contratoDAO = new ContratoDAO();

        while (true) {
            System.out.println("\n=== Sistema Imobiliária ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Imóvel");
            System.out.println("3. Cadastrar Contrato");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Imóveis");
            System.out.println("6. Listar Contratos");
            System.out.println("7. Clientes com mais contratos");
            System.out.println("8. Contratos expirando nos próximos 30 dias");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opc = sc.nextInt();
            sc.nextLine(); // consumir enter

            switch (opc) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Documento: ");
                    String doc = sc.nextLine();
                    System.out.print("Telefone: ");
                    String tel = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Cliente c = new Cliente(nome, doc, tel, email);
                    clienteDAO.inserir(c);
                    break;

                case 2:
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Tipo (Apartamento/Casa/...): ");
                    String tipo = sc.nextLine();
                    System.out.print("Quartos: ");
                    int quartos = sc.nextInt();
                    System.out.print("Banheiros: ");
                    int banheiros = sc.nextInt();
                    System.out.print("Vagas de garagem: ");
                    int vagas = sc.nextInt();
                    System.out.print("Área (m²): ");
                    double area = sc.nextDouble();
                    System.out.print("Disponível (true/false): ");
                    boolean disponivel = sc.nextBoolean();
                    sc.nextLine(); // consumir enter

                    Imovel i = new Imovel(endereco, tipo, quartos, banheiros, vagas, area, disponivel);
                    imovelDAO.inserir(i);
                    break;

                case 3:
                    System.out.print("ID do Cliente: ");
                    int clienteId = sc.nextInt();
                    System.out.print("ID do Imóvel: ");
                    int imovelId = sc.nextInt();
                    System.out.print("Valor mensal: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Data início (AAAA-MM-DD): ");
                    LocalDate inicio = LocalDate.parse(sc.nextLine());
                    System.out.print("Data fim (AAAA-MM-DD): ");
                    LocalDate fim = LocalDate.parse(sc.nextLine());

                    Contrato contrato = new Contrato(clienteId, imovelId, valor, inicio, fim);
                    contratoDAO.inserir(contrato);
                    break;

                case 4:
                    List<Cliente> clientes = clienteDAO.listar();
                    System.out.println("\n--- Clientes ---");
                    for (Cliente cl : clientes) {
                        System.out.printf("%d - %s (%s)\n", cl.getClienteId(), cl.getNome(), cl.getDocumento());
                    }
                    break;

                case 5:
                    List<Imovel> imoveis = imovelDAO.listar();
                    System.out.println("\n--- Imóveis ---");
                    for (Imovel im : imoveis) {
                        System.out.printf("%d - %s | %s | Quartos: %d | Banheiros: %d | Garagem: %d | Área: %.2f | Disponível: %b\n",
                                im.getImovelId(), im.getEndereco(), im.getTipo(), im.getQuartos(), im.getBanheiros(),
                                im.getVagasGaragem(), im.getArea(), im.isDisponivel());
                    }
                    break;

                case 6:
                    List<Contrato> contratos = contratoDAO.listar();
                    System.out.println("\n--- Contratos ---");
                    for (Contrato co : contratos) {
                        System.out.printf("%d - ClienteID: %d | ImóvelID: %d | Valor: %.2f | Início: %s | Fim: %s\n",
                                co.getContratoId(), co.getClienteId(), co.getImovelId(), co.getValorMensal(),
                                co.getDataInicio(), co.getDataFim());
                    }
                    break;

                case 7:
                    List<String> clientesMaisContratos = contratoDAO.clientesComMaisContratos();
                    System.out.println("\n=== Clientes com mais contratos ===");
                    for (String linha : clientesMaisContratos) {
                        System.out.println(linha);
                    }
                    break;

                case 8:
                    List<String> contratos30Dias = contratoDAO.contratosExpirando30Dias();
                    System.out.println("\n=== Contratos expirando nos próximos 30 dias ===");
                    for (String linha : contratos30Dias) {
                        System.out.println(linha);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
