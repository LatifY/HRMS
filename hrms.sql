-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public."Employees"
(
    "UserId" integer NOT NULL,
    "FirstName" character varying(30)[] NOT NULL,
    "LastName" character varying(30)[] NOT NULL,
    "TCNo" character varying(30)[] NOT NULL,
    "PositionId" integer NOT NULL,
    "DateOfBirthYear" integer NOT NULL,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."Employers"
(
    "UserId" integer NOT NULL,
    "CompanyName" character varying(60)[] NOT NULL,
    "Website" character varying(100)[] NOT NULL,
    "Phone" character varying(10)[] NOT NULL,
    "VerifiedBySystem" boolean NOT NULL,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."Personels"
(
    "UserId" integer NOT NULL,
    "FirstName" character varying(30)[] NOT NULL,
    "LastName" character varying(30)[] NOT NULL,
    "RoleId" integer NOT NULL,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."Positions"
(
    "Id" integer NOT NULL,
    "PositionName" character varying(60)[] NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."Roles"
(
    "Id" integer NOT NULL,
    "RoleName" character varying(60)[] NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."Users"
(
    "Id" integer NOT NULL,
    "Email" character varying(60)[] NOT NULL,
    "Password" character varying(60)[] NOT NULL,
    "Verified" boolean NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public.employees
(
    user_id integer NOT NULL,
    verified_by_system timestamp without time zone NOT NULL,
    company_name character varying(255) NOT NULL,
    website character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    position_id integer,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    verified_by_system boolean NOT NULL,
    website character varying(255) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.personels
(
    user_id integer NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    role_id integer,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.positions
(
    id integer NOT NULL,
    position_name character varying(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.roles
(
    id integer NOT NULL,
    role_name character varying(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    verified boolean NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public."Employees"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Users" ("Id")
    NOT VALID;


ALTER TABLE public."Employees"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Positions" ("Id")
    NOT VALID;


ALTER TABLE public."Employers"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Users" ("Id")
    NOT VALID;


ALTER TABLE public."Personels"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Roles" ("Id")
    NOT VALID;


ALTER TABLE public."Personels"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Users" ("Id")
    NOT VALID;


ALTER TABLE public.employees
    ADD FOREIGN KEY (position_id)
    REFERENCES public.positions (id)
    NOT VALID;


ALTER TABLE public.personels
    ADD FOREIGN KEY (role_id)
    REFERENCES public.roles (id)
    NOT VALID;

END;