DROP TABLE IF EXISTS "MusicSchema"."Album";
DROP TABLE IF EXISTS "MusicSchema"."Singer";

CREATE TABLE "MusicSchema"."Singer"
(
    first_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    id serial NOT NULL,
    last_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT "Singer_pkey" PRIMARY KEY (id)
);

CREATE TABLE "MusicSchema"."Album"
(
    id serial,
    title character varying(50) COLLATE pg_catalog."default",
    singer_id integer,
    release_date date,
    CONSTRAINT "Album_pkey" PRIMARY KEY (id),
    CONSTRAINT f_key_singer_id FOREIGN KEY (singer_id)
        REFERENCES "MusicSchema"."Singer" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


insert into "MusicSchema"."Singer" (first_name, last_name, birth_date)
values ('John', 'Mayer', '1977-10-16');

insert into "MusicSchema"."Singer" (first_name, last_name, birth_date)
values ('Eric', 'Clapton', '1945-03-30');

insert into "MusicSchema"."Singer" (first_name, last_name, birth_date)
values ('John', 'Butler', '1975-04-01');

insert into "MusicSchema"."Album" (singer_id, title, release_date)
values (1, 'The Search For Everything', '2017-01-20');

insert into "MusicSchema"."Album" (singer_id, title, release_date)
values (1, 'Battle Studies', '2009-11-17');

insert into "MusicSchema"."Album" (singer_id, title, release_date)
values (2, ' From The Cradle ', '1994-09-13');


GRANT ALL ON SEQUENCE "MusicSchema"."Album_id_seq" TO prospring5;
GRANT ALL ON SEQUENCE "MusicSchema"."Singer_id_seq" TO prospring5;
GRANT ALL ON TABLE "MusicSchema"."Album" TO prospring5;
GRANT ALL ON TABLE "MusicSchema"."Singer" TO prospring5;





