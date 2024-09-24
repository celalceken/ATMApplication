--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: UserAccount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."UserAccount" (
                                      id integer NOT NULL,
                                      "accountNumber" integer NOT NULL,
                                      balance real NOT NULL,
                                      "customerId" integer NOT NULL,
                                      password integer
);


ALTER TABLE public."UserAccount" OWNER TO postgres;

--
-- Name: UserAccount_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."UserAccount_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."UserAccount_id_seq" OWNER TO postgres;

--
-- Name: UserAccount_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."UserAccount_id_seq" OWNED BY public."UserAccount".id;


--
-- Name: Customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Customer" (
                                   id integer NOT NULL,
                                   firstname character varying(40) NOT NULL,
                                   lastname character varying(40) NOT NULL
);


ALTER TABLE public."Customer" OWNER TO postgres;

--
-- Name: CustomerAccount; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."CustomerAccount" AS
SELECT "Customer".firstname,
       "Customer".lastname,
       "UserAccount"."accountNumber",
       "UserAccount".balance,
       "UserAccount".password
FROM (public."UserAccount"
    JOIN public."Customer" ON (("UserAccount"."customerId" = "Customer".id)));


ALTER TABLE public."CustomerAccount" OWNER TO postgres;

--
-- Name: Customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Customer_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Customer_id_seq" OWNER TO postgres;

--
-- Name: Customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Customer_id_seq" OWNED BY public."Customer".id;


--
-- Name: UserAccount id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."UserAccount" ALTER COLUMN id SET DEFAULT nextval('public."UserAccount_id_seq"'::regclass);


--
-- Name: Customer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Customer" ALTER COLUMN id SET DEFAULT nextval('public."Customer_id_seq"'::regclass);


--
-- Data for Name: UserAccount; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."UserAccount" VALUES
                                     (1, 1, 200, 1, 1),
                                     (3, 3, 407, 3, 3),
                                     (2, 2, 116, 2, 2);


--
-- Data for Name: Customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Customer" VALUES
                                  (2, 'Elif', 'Çınar'),
                                  (3, 'Mehmet', 'Yılmaz'),
                                  (1, 'Ömer', 'Demir');


--
-- Name: UserAccount_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."UserAccount_id_seq"', 3, true);


--
-- Name: Customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Customer_id_seq"', 3, true);


--
-- Name: UserAccount UserAccount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."UserAccount"
    ADD CONSTRAINT "UserAccount_pkey" PRIMARY KEY (id);


--
-- Name: Customer Customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Customer"
    ADD CONSTRAINT "Customer_pkey" PRIMARY KEY (id);


--
-- Name: UserAccount lnk_Customer_UserAccount; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."UserAccount"
    ADD CONSTRAINT "lnk_Customer_UserAccount" FOREIGN KEY ("customerId") REFERENCES public."Customer"(id) MATCH FULL;


--
-- PostgreSQL database dump complete
--
