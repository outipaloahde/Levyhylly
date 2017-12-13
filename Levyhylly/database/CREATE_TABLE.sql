CREATE TABLE kayttaja(
kayttaja varchar(20) not null PRIMARY KEY,
salasana varchar(100) not null,
Nimi varchar(40) not null
);

CREATE TABLE levy(
levyId smallint(6) not null auto_increment PRIMARY KEY,
levyArtisti varchar(100) not null,
levyNimi varchar(100) not null,
julkaisuVuosi smallint(4) not null,
formaatti varchar(100) not null,
levyYhtio varchar(100) not null,
genre varchar(100)
);


