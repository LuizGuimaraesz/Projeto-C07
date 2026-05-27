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

-- ========================

INSERT INTO Veiculo (placa, capacidade_carga) VALUES 
('ABC-1234', 15000.00), ('XYZ-5678', 8000.00), ('DEF-9012', 22000.00), ('GHI-3456', 12000.00), ('JKL-7890', 5000.00);

INSERT INTO Rastreador (id_veiculo, numero_serie, data_ativacao) VALUES 
(1, 'RST-99901', '2026-01-10'), (2, 'RST-99902', '2026-01-15'), (3, 'RST-99903', '2026-02-01'), (4, 'RST-99904', '2026-02-20'), (5, 'RST-99905', '2026-03-05');

-- ========================

CREATE ROLE IF NOT EXISTS 'role_gestor_frota';

GRANT SELECT, INSERT, UPDATE, DELETE ON gestao_frota.* TO 'role_gestor_frota';

CREATE USER IF NOT EXISTS 'user_caua'@'localhost' IDENTIFIED BY 'CauaGrupo3!';

GRANT 'role_gestor_frota' TO 'user_caua'@'localhost';
SET DEFAULT ROLE 'role_gestor_frota' TO 'user_caua'@'localhost';

FLUSH PRIVILEGES;