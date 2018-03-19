CREATE TABLE Agente (
  idAgente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  dtContratacao DATE NULL,
  tempoServico INTEGER UNSIGNED NULL,
  PRIMARY KEY(idAgente)
);

CREATE TABLE Categoria (
  idCategoria INTEGER UNSIGNED NOT NULL,
  descricaiCategoria VARCHAR(50) NULL,
  PRIMARY KEY(idCategoria)
);

CREATE TABLE Infracao (
  idInfracao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idAgente INTEGER UNSIGNED NOT NULL,
  idLocalInfracao INTEGER UNSIGNED NOT NULL,
  idTipoInfracao INTEGER UNSIGNED NOT NULL,
  placa VARCHAR(7) NOT NULL,
  velocidade INTEGER UNSIGNED NULL,
  PRIMARY KEY(idInfracao),
  INDEX Infracoes_FKIndex1(placa),
  INDEX Infracoes_FKIndex2(idTipoInfracao),
  INDEX Infracoes_FKIndex3(idLocalInfracao),
  INDEX Infracoes_FKIndex4(idAgente)
);

CREATE TABLE LocalInfracao (
  idLocalInfracao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descricaoLocalInfracao VARCHAR(100) NULL,
  velocidadePermitida DOUBLE NULL,
  PRIMARY KEY(idLocalInfracao)
);

CREATE TABLE Modelo (
  idModelo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idCategoria INTEGER UNSIGNED NOT NULL,
  descricaoModelo VARCHAR(50) NULL,
  PRIMARY KEY(idModelo),
  INDEX Modelo_FKIndex1(idCategoria)
);

CREATE TABLE Proprietario (
  cpfProprietario INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(100) NULL,
  endereco VARCHAR(100) NULL,
  bairro VARCHAR(100) NULL,
  cidade VARCHAR(100) NULL,
  uf VARCHAR(2) NULL,
  sexo VARCHAR(1) NULL,
  dtNascimento DATE NULL,
  PRIMARY KEY(cpfProprietario)
);

CREATE TABLE Telefone (
  numero INTEGER UNSIGNED NOT NULL,
  ddd INTEGER UNSIGNED NOT NULL,
  cpfProprietario INTEGER UNSIGNED NOT NULL,
  idTipoTelefone INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(numero, ddd, cpfProprietario),
  INDEX Telefones_FKIndex1(cpfProprietario),
  INDEX Telefones_FKIndex2(idTipoTelefone)
);

CREATE TABLE TipoInfracao (
  idTipoInfracao INTEGER UNSIGNED NOT NULL,
  descricaoTipoInfracao VARCHAR(50) NULL,
  valor DOUBLE NULL,
  PRIMARY KEY(idTipoInfracao)
);

CREATE TABLE TipoTelefone (
  idTipoTelefone INTEGER UNSIGNED NOT NULL,
  descricaoTipoTelefone VARCHAR(20) NULL,
  PRIMARY KEY(idTipoTelefone)
);

CREATE TABLE Veiculos (
  placa VARCHAR(7) NOT NULL,
  cpfProprietario INTEGER UNSIGNED NOT NULL,
  idModelo INTEGER UNSIGNED NOT NULL,
  uf VARCHAR(2) NOT NULL,
  PRIMARY KEY(placa),
  INDEX Veiculos_FKIndex1(idModelo),
  INDEX Veiculos_FKIndex2(cpfProprietario)
);

