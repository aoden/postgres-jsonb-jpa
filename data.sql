-- Table: public."employee"

-- SEQUENCE: public.s1

-- DROP SEQUENCE public.s1;

CREATE SEQUENCE public.s1
    INCREMENT 1
    START 13
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- SEQUENCE: public.s2

-- DROP SEQUENCE public.s2;

CREATE SEQUENCE public.s2
    INCREMENT 1
    START 4
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- DROP TABLE public."employee";

CREATE TABLE public."employee"
(
    id bigint NOT NULL DEFAULT nextval('s1'::regclass),
    info jsonb,
    CONSTRAINT "employee_pkey" PRIMARY KEY (id)
)

-- DROP TABLE public.company;

CREATE TABLE public.company
(
    id bigint NOT NULL DEFAULT nextval('s2'::regclass),
    name character varying(100),
    location character varying(100),
    employees jsonb,
    type character varying(100),
    CONSTRAINT company_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public."employee"
    OWNER to postgres;

INSERT INTO public."employee"(info)
	VALUES ('{
    "age": "25",
    "skills": [
        "scala",
        "nodejs",
        "python"
    ],
    "address": "hcm",
    "position": "dev",
    "additional_info": {
        "external": false
    }
}');
INSERT INTO public."employee"(info)
	VALUES ('{
    "age": "20",
    "skills": [
        "java",
        "nodejs",
        "python",
        "angular",
        "ruby"
    ],
    "address": "hcm",
    "position": "dev",
    "additional_info": {
        "external": false
    }
}');
INSERT INTO public."employee"(info)
	VALUES ('{
    "age": "30",
    "address": "singapore",
    "position": "qc"
}');
INSERT INTO public."employee"(info)
	VALUES ('{
    "age": "25",
    "phone": "123456",
    "address": "hcm",
    "position": "qc"
}');
INSERT INTO public."employee"(info)
	VALUES ('{
    "age": "25",
    "phone": "123456",
    "address": "hanoi",
    "position": "qc"
}');
INSERT INTO public."employee"(info)
	VALUES ('{
    "age": "20",
    "skills": [
        "java",
        "nodejs",
        "python",
        "angular"
    ],
    "address": "hcm",
    "position": "dev",
    "additional_info": {
        "external": false
    }
}');