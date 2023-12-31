PGDMP     6    #                {           archivio    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    32917    archivio    DATABASE     {   CREATE DATABASE archivio WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Italian_Italy.1252';
    DROP DATABASE archivio;
                postgres    false            �            1259    32942    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    32982    libri    TABLE     �   CREATE TABLE public.libri (
    isbn bigint NOT NULL,
    annopubblicazione integer NOT NULL,
    numeropagine integer NOT NULL,
    titolo character varying(255),
    autore character varying(255),
    genere character varying(255)
);
    DROP TABLE public.libri;
       public         heap    postgres    false            �            1259    32989    prestiti    TABLE     �   CREATE TABLE public.prestiti (
    id bigint NOT NULL,
    datainizioprestito date,
    datarestituzioneeffettiva date,
    datarestituzioneprevista date,
    elementoprestato_isbn bigint,
    utente_numerotessera bigint
);
    DROP TABLE public.prestiti;
       public         heap    postgres    false            �            1259    32994 	   readablex    TABLE     �   CREATE TABLE public.readablex (
    isbn bigint NOT NULL,
    annopubblicazione integer NOT NULL,
    numeropagine integer NOT NULL,
    titolo character varying(255)
);
    DROP TABLE public.readablex;
       public         heap    postgres    false            �            1259    32999    riviste    TABLE     �   CREATE TABLE public.riviste (
    isbn bigint NOT NULL,
    annopubblicazione integer NOT NULL,
    numeropagine integer NOT NULL,
    titolo character varying(255),
    periodicita integer
);
    DROP TABLE public.riviste;
       public         heap    postgres    false            �            1259    33004    utenti    TABLE     �   CREATE TABLE public.utenti (
    numerotessera bigint NOT NULL,
    cognome character varying(255),
    datanascita date,
    nome character varying(255)
);
    DROP TABLE public.utenti;
       public         heap    postgres    false                      0    32982    libri 
   TABLE DATA           ^   COPY public.libri (isbn, annopubblicazione, numeropagine, titolo, autore, genere) FROM stdin;
    public          postgres    false    215   w                 0    32989    prestiti 
   TABLE DATA           �   COPY public.prestiti (id, datainizioprestito, datarestituzioneeffettiva, datarestituzioneprevista, elementoprestato_isbn, utente_numerotessera) FROM stdin;
    public          postgres    false    216   �                 0    32994 	   readablex 
   TABLE DATA           R   COPY public.readablex (isbn, annopubblicazione, numeropagine, titolo) FROM stdin;
    public          postgres    false    217   n                 0    32999    riviste 
   TABLE DATA           ]   COPY public.riviste (isbn, annopubblicazione, numeropagine, titolo, periodicita) FROM stdin;
    public          postgres    false    218   �                 0    33004    utenti 
   TABLE DATA           K   COPY public.utenti (numerotessera, cognome, datanascita, nome) FROM stdin;
    public          postgres    false    219   �                  0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 66, true);
          public          postgres    false    214            v           2606    32988    libri libri_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.libri
    ADD CONSTRAINT libri_pkey PRIMARY KEY (isbn);
 :   ALTER TABLE ONLY public.libri DROP CONSTRAINT libri_pkey;
       public            postgres    false    215            x           2606    32993    prestiti prestiti_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.prestiti
    ADD CONSTRAINT prestiti_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.prestiti DROP CONSTRAINT prestiti_pkey;
       public            postgres    false    216            z           2606    32998    readablex readablex_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.readablex
    ADD CONSTRAINT readablex_pkey PRIMARY KEY (isbn);
 B   ALTER TABLE ONLY public.readablex DROP CONSTRAINT readablex_pkey;
       public            postgres    false    217            |           2606    33003    riviste riviste_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.riviste
    ADD CONSTRAINT riviste_pkey PRIMARY KEY (isbn);
 >   ALTER TABLE ONLY public.riviste DROP CONSTRAINT riviste_pkey;
       public            postgres    false    218            ~           2606    33010    utenti utenti_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.utenti
    ADD CONSTRAINT utenti_pkey PRIMARY KEY (numerotessera);
 <   ALTER TABLE ONLY public.utenti DROP CONSTRAINT utenti_pkey;
       public            postgres    false    219                       2606    33011 $   prestiti fk8l3tks5duqclum58gtd4p1yom    FK CONSTRAINT     �   ALTER TABLE ONLY public.prestiti
    ADD CONSTRAINT fk8l3tks5duqclum58gtd4p1yom FOREIGN KEY (utente_numerotessera) REFERENCES public.utenti(numerotessera);
 N   ALTER TABLE ONLY public.prestiti DROP CONSTRAINT fk8l3tks5duqclum58gtd4p1yom;
       public          postgres    false    219    3198    216               s   x���!�0Faݝb' k�� !`3��d���h��_>�XI�(i4�R���Z�♖u�)_5?�q��䛍�&��0-A�2��`Z�i�E�B�.D�a�`؅�]H؅�sν���         d   x�}˹�0C��e={Sl���:,�(�Ïy����K�ߧ��|2���D]�n�j]�(�_��[���@�؋�`�1Q�ֽ�BMv�E�x~H� 7�*            x������ � �         c   x�}б�0 �ڞ�	Pb�6�D�4�HQ�G�ׯk>�X2�H���=�v�~�aϒ�2E���ŉ����Ȓ@�P*ȠCA���t�ҡcT���{�         @   x�3��.��˯���4200�50�50�tI,�LI�26�'kb�W����1^Y��2��=... ��9�     