# Diagrama MER

![Diagrama MER](main/DiagramaMER)


# 🏢 Banco de Dados - ImobiliariaDB

---

## 🏗️ Criação do Banco e Tabelas

```sql
CREATE DATABASE ImobiliariaDB;
USE ImobiliariaDB;

-- Tabela de Clientes
CREATE TABLE Cliente (
    ClienteId INT IDENTITY(1,1) PRIMARY KEY,
    Nome NVARCHAR(100) NOT NULL,
    Documento NVARCHAR(20) NOT NULL UNIQUE, -- CPF ou CNPJ
    Telefone NVARCHAR(20),
    Email NVARCHAR(100)
);

-- Tabela de Imóveis
CREATE TABLE Imovel (
    ImovelId INT IDENTITY(1,1) PRIMARY KEY,
    Endereco NVARCHAR(200) NOT NULL,
    Tipo NVARCHAR(50) NOT NULL, -- Casa, Apartamento, Comercial
    Quartos INT,
    Banheiros INT,
    VagasGaragem INT,
    Area DECIMAL(10,2),
    Disponivel BIT DEFAULT 1 -- 1 = Disponível, 0 = Ocupado
);

-- Tabela de Contratos
CREATE TABLE Contrato (
    ContratoId INT IDENTITY(1,1) PRIMARY KEY,
    ClienteId INT NOT NULL,
    ImovelId INT NOT NULL,
    ValorMensal DECIMAL(10,2) NOT NULL,
    DataInicio DATE NOT NULL,
    DataFim DATE NOT NULL,

    CONSTRAINT FK_Contrato_Cliente FOREIGN KEY (ClienteId) REFERENCES Cliente(ClienteId),
    CONSTRAINT FK_Contrato_Imovel FOREIGN KEY (ImovelId) REFERENCES Imovel(ImovelId)
);
```
# 📥 Inserts - ImobiliariaDB

---

## 🏠 Imóveis
```sql
INSERT INTO Imovel (Endereco, Tipo, Quartos, Banheiros, VagasGaragem, Area, Disponivel) VALUES
('Rua das Flores, 100 - São Paulo/SP', 'Apartamento', 2, 1, 1, 65.50, 1),
('Av. Brasil, 200 - Rio de Janeiro/RJ', 'Casa', 3, 2, 2, 120.00, 1),
('Rua Central, 300 - Belo Horizonte/MG', 'Comercial', 0, 1, 0, 80.00, 1),
('Rua Verde, 400 - Porto Alegre/RS', 'Apartamento', 1, 1, 1, 45.00, 1),
('Av. Atlântica, 500 - Florianópolis/SC', 'Casa', 4, 3, 2, 180.00, 1),
('Rua Azul, 600 - Curitiba/PR', 'Apartamento', 3, 2, 1, 95.00, 1),
('Av. Paulista, 700 - São Paulo/SP', 'Comercial', 0, 2, 0, 150.00, 1),
('Rua das Palmeiras, 800 - Recife/PE', 'Casa', 2, 2, 1, 110.00, 1),
('Av. Beira Mar, 900 - Fortaleza/CE', 'Apartamento', 3, 3, 2, 130.00, 1),
('Rua Amarela, 1000 - Salvador/BA', 'Casa', 5, 4, 3, 220.00, 1),
('Av. Independência, 1100 - Campinas/SP', 'Apartamento', 2, 2, 1, 75.00, 1),
('Rua Santos, 1200 - Goiânia/GO', 'Casa', 3, 2, 2, 140.00, 1),
('Av. Marfim, 1300 - Manaus/AM', 'Comercial', 0, 1, 0, 95.00, 1),
('Rua Cristal, 1400 - Natal/RN', 'Apartamento', 2, 2, 1, 85.00, 1),
('Av. Central, 1500 - Vitória/ES', 'Casa', 4, 3, 2, 200.00, 1),
('Rua Ouro, 1600 - São Luís/MA', 'Apartamento', 1, 1, 1, 50.00, 1),
('Av. Diamante, 1700 - Belém/PA', 'Casa', 2, 1, 1, 100.00, 1),
('Rua Safira, 1800 - Campo Grande/MS', 'Apartamento', 2, 2, 1, 70.00, 1),
('Av. Esmeralda, 1900 - João Pessoa/PB', 'Casa', 3, 3, 2, 160.00, 1),
('Rua Pérola, 2000 - Teresina/PI', 'Apartamento', 3, 2, 2, 110.00, 1);

INSERT INTO Cliente (Nome, Documento, Telefone, Email) VALUES
('Ana Souza', '11111111111', '(11) 98888-1111', 'ana.souza@email.com'),
('Bruno Lima', '22222222222', '(11) 97777-2222', 'bruno.lima@email.com'),
('Carlos Mendes', '33333333333', '(21) 96666-3333', 'carlos.mendes@email.com'),
('Daniela Ferreira', '44444444444', '(31) 95555-4444', 'daniela.ferreira@email.com'),
('Eduardo Oliveira', '55555555555', '(41) 94444-5555', 'eduardo.oliveira@email.com'),
('Fernanda Costa', '66666666666', '(51) 93333-6666', 'fernanda.costa@email.com'),
('Gabriel Santos', '77777777777', '(61) 92222-7777', 'gabriel.santos@email.com'),
('Helena Martins', '88888888888', '(71) 91111-8888', 'helena.martins@email.com'),
('Igor Carvalho', '99999999999', '(81) 90000-9999', 'igor.carvalho@email.com'),
('Juliana Ribeiro', '10101010101', '(91) 98877-0000', 'juliana.ribeiro@email.com'),
('Kleber Rocha', '11111111112', '(11) 97766-1122', 'kleber.rocha@email.com'),
('Larissa Almeida', '12121212121', '(21) 96655-2233', 'larissa.almeida@email.com'),
('Marcos Vinicius', '13131313131', '(31) 95544-3344', 'marcos.vinicius@email.com'),
('Natália Barros', '14141414141', '(41) 94433-4455', 'natalia.barros@email.com'),
('Otávio Nunes', '15151515151', '(51) 93322-5566', 'otavio.nunes@email.com'),
('Paula Andrade', '16161616161', '(61) 92211-6677', 'paula.andrade@email.com'),
('Rafael Teixeira', '17171717171', '(71) 91100-7788', 'rafael.teixeira@email.com'),
('Sabrina Moura', '18181818181', '(81) 90099-8899', 'sabrina.moura@email.com'),
('Thiago Pinto', '19191919191', '(91) 98888-9900', 'thiago.pinto@email.com'),
('Vanessa Silva', '20202020202', '(11) 97777-0011', 'vanessa.silva@email.com');

INSERT INTO Contrato (ClienteId, ImovelId, ValorMensal, DataInicio, DataFim) VALUES
(1, 1, 1800.00, '2024-01-01', '2024-12-31'),
(2, 2, 2500.00, '2024-02-01', '2025-01-31'),
(3, 3, 3200.00, '2024-03-01', '2025-02-28'),
(4, 4, 1400.00, '2024-04-01', '2025-03-31'),
(5, 5, 4000.00, '2024-05-01', '2025-04-30'),
(6, 6, 2300.00, '2024-06-01', '2025-05-31'),
(7, 7, 6000.00, '2024-07-01', '2025-06-30'),
(8, 8, 2100.00, '2024-08-01', '2025-07-31'),
(9, 9, 3500.00, '2024-09-01', '2025-08-31'),
(10, 10, 5000.00, '2024-10-01', '2025-09-30'),
(11, 11, 1900.00, '2024-11-01', '2025-10-31'),
(12, 12, 2800.00, '2024-12-01', '2025-11-30'),
(13, 13, 4200.00, '2025-01-01', '2025-12-31'),
(14, 14, 2000.00, '2025-02-01', '2026-01-31'),
(15, 15, 4800.00, '2025-03-01', '2026-02-28'),
(16, 16, 1600.00, '2025-04-01', '2026-03-31'),
(17, 17, 2200.00, '2025-05-01', '2026-04-30'),
(18, 18, 2700.00, '2025-06-01', '2026-05-31'),
(19, 19, 3600.00, '2025-07-01', '2026-06-30'),
(20, 20, 3100.00, '2025-08-01', '2026-07-31');

