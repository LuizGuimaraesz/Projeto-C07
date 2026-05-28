DROP DATABASE IF EXISTS gestao_frota;
CREATE DATABASE gestao_frota;
USE gestao_frota;

-- ========================

CREATE TABLE Veiculo (
    id_veiculo INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL UNIQUE,
    capacidade_carga DECIMAL(10,2) NOT NULL
);

CREATE TABLE Rastreador (
    id_rastreador INT AUTO_INCREMENT PRIMARY KEY,
    id_veiculo INT NOT NULL UNIQUE,
    numero_serie VARCHAR(50) NOT NULL UNIQUE,
    data_ativacao DATE NOT NULL,
    FOREIGN KEY (id_veiculo) REFERENCES Veiculo(id_veiculo) ON DELETE CASCADE
);

CREATE TABLE Motorista (
    id_motorista INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    status_ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE Dependente (
    id_dependente INT AUTO_INCREMENT,
    id_motorista INT,
    nome_dependente VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_dependente, id_motorista),
    FOREIGN KEY (id_motorista) REFERENCES Motorista(id_motorista) ON DELETE CASCADE
);

CREATE TABLE Viagem (
    id_viagem INT AUTO_INCREMENT PRIMARY KEY,
    id_veiculo INT NOT NULL,
    id_motorista INT NOT NULL,
    data_hora_saida DATETIME NOT NULL,
    destino VARCHAR(200) NOT NULL,
    FOREIGN KEY (id_veiculo) REFERENCES Veiculo(id_veiculo),
    FOREIGN KEY (id_motorista) REFERENCES Motorista(id_motorista)
);

CREATE TABLE Oficina (
    id_oficina INT AUTO_INCREMENT PRIMARY KEY,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    rua VARCHAR(100),
    numero VARCHAR(10),
    bairro VARCHAR(50),
    cep VARCHAR(10)
);

CREATE TABLE Manutencao (
    id_manutencao INT AUTO_INCREMENT PRIMARY KEY, 
    id_veiculo INT NOT NULL,
    id_oficina INT NOT NULL,
    data_servico DATE NOT NULL,
    custo_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_veiculo) REFERENCES Veiculo(id_veiculo),
    FOREIGN KEY (id_oficina) REFERENCES Oficina(id_oficina)
);

-- ========================

INSERT INTO Veiculo (placa, capacidade_carga) VALUES 
('ABC-1234', 15000.00), ('XYZ-5678', 8000.00), ('DEF-9012', 22000.00), ('GHI-3456', 12000.00), ('JKL-7890', 5000.00);

INSERT INTO Rastreador (id_veiculo, numero_serie, data_ativacao) VALUES 
(1, 'RST-99901', '2026-01-10'), (2, 'RST-99902', '2026-01-15'), (3, 'RST-99903', '2026-02-01'), (4, 'RST-99904', '2026-02-20'), (5, 'RST-99905', '2026-03-05');

INSERT INTO Motorista (nome, cpf, data_nascimento, status_ativo) VALUES
('Carlos Silva', '123.456.789-01', '1985-04-12', TRUE),
('Ana Beatriz Santos', '234.567.890-12', '1990-08-22', TRUE),
('Marcos Oliveira', '345.678.901-23', '1978-11-05', TRUE),
('Juliana Costa', '456.789.012-34', '1993-02-28', TRUE),
('Ricardo Almeida', '567.890.123-45', '1982-07-19', FALSE); 

INSERT INTO Dependente (id_motorista, nome_dependente) VALUES
(1, 'Pedro Silva'),       
(1, 'Maria Luiza Silva'), 
(2, 'Lucas Santos'),      
(3, 'Gabriel Oliveira'), 
(5, 'Beatriz Almeida');   

INSERT INTO Viagem (id_veiculo, id_motorista, data_hora_saida, destino) VALUES
(1, 1, '2026-05-10 08:00:00', 'São Paulo - SP'),
(2, 2, '2026-05-12 14:30:00', 'Rio de Janeiro - RJ'),
(3, 3, '2026-05-15 06:15:00', 'Belo Horizonte - MG'),
(4, 4, '2026-05-18 21:00:00', 'Curitiba - PR'),
(5, 1, '2026-05-20 10:00:00', 'Campinas - SP');

INSERT INTO Oficina (cnpj, rua, numero, bairro, cep) VALUES
('11.222.333/0001-11', 'Av. das Nações', '1500', 'Centro', '01000-000'),
('22.333.444/0001-22', 'Rua Industrial', '45', 'Distrito Industrial', '13000-000'),
('33.444.555/0001-33', 'Rua dos Mecânicos', '820', 'Oficinas', '30000-000'),
('44.555.666/0001-44', 'Av. Brasil', '210', 'Jardim América', '80000-000'),
('55.666.777/0001-55', 'Rua São José', '99', 'Vila Nova', '18000-000');

INSERT INTO Manutencao (id_veiculo, id_oficina, data_servico, custo_total) VALUES
(1, 1, '2026-02-15', 450.00),
(2, 2, '2026-03-01', 1200.50),
(3, 3, '2026-03-22', 890.00),
(4, 4, '2026-04-05', 350.00),
(5, 5, '2026-04-18', 2100.00);

-- ========================

CREATE ROLE IF NOT EXISTS 'role_gestor_frota';

GRANT SELECT, INSERT, UPDATE, DELETE ON gestao_frota.* TO 'role_gestor_frota';

CREATE USER IF NOT EXISTS 'user_caua'@'localhost' IDENTIFIED BY 'CauaGrupo3!';

GRANT 'role_gestor_frota' TO 'user_caua'@'localhost';
SET DEFAULT ROLE 'role_gestor_frota' TO 'user_caua'@'localhost';

FLUSH PRIVILEGES;

SELECT * FROM Manutencao;