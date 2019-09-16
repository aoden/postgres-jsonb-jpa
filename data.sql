-- Table: public."employee"

-- DROP TABLE public."employee";

CREATE TABLE public."employee"
(
    id bigint NOT NULL DEFAULT nextval('s1'::regclass),
    info jsonb,
    CONSTRAINT "employee_pkey" PRIMARY KEY (id)
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