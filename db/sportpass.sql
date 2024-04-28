DROP SCHEMA IF EXISTS sportPass;
CREATE SCHEMA sportPass DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE sportPass;

CREATE TABLE paketi (
id BIGINT AUTO_INCREMENT,
naziv VARCHAR (20) NOT NULL,
brojTreninga INT NOT NULL,
trajanje INT NOT NULL,
cena DECIMAL (6 , 2) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE clanarine(
id BIGINT AUTO_INCREMENT,
idPaket BIGINT NOT NULL,
korisnickoIme VARCHAR (50) NOT NULL,
datum DATE NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (idPaket) REFERENCES paketi (id)
);




# paketi: naziv, treninga mesečno, meseci, cena
'Basic S', 12, 1, 2800.00
'Classic S', 16, 1, 3600.00
'Elite S', 31, 1, 5200.00
'Basic M', 12, 3, 6300.00
'Classic M', 16, 3, 8100.00
'Elite M', 31, 3, 11700.00

# članarine: paket, korisnik, početak
PRVI, 'korisnik1', '2023-01-01'
PRVI, 'korisnik1', '2023-02-01'
PRVI, 'korisnik2', '2023-02-01'
DRUGI, 'korisnik1', '2023-03-01'
TREĆI, 'korisnik2', '2023-03-01'
ČETVRTI, 'korisnik1', '2023-04-01'
ČETVRTI, 'korisnik2', '2023-04-01'
ČETVRTI, 'korisnik3', '2023-01-01'
PETI, 'korisnik3', '2023-04-01'
PETI, 'korisnik4', '2023-01-01'
PETI, 'korisnik4', '2023-04-01'
ŠESTI, 'korisnik5', '2023-01-01'
