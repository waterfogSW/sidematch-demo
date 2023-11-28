CREATE TABLE project
(
    id                 UUID PRIMARY KEY,
    name               VARCHAR(20)  NOT NULL,
    summary            varchar(100) NOT NULL,
    types              VARCHAR(100)[] NOT NULL,
    work_period        INTEGER      NOT NULL,
    collaboration_type VARCHAR(20)  NOT NULL,
    communication_tool VARCHAR(100) NOT NULL,
    objective          VARCHAR(100) NOT NULL,
    created_at         TIMESTAMP    NOT NULL DEFAULT NOW(),
    updated_at         TIMESTAMP    NOT NULL DEFAULT NOW(),
);

CREATE TABLE maker
(
    id                UUID PRIMARY KEY,
    name              VARCHAR(20) NOT NULL,
    introduction      TEXT,
    interest          TEXT,
    profile_image_url VARCHAR(2048),
    positions         VARCHAR(100)[] NOT NULL,
    github_url        VARCHAR(2048),
    portfolio_url     VARCHAR(2048),
    purpose           VARCHAR(100),
    created_at        TIMESTAMP   NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMP   NOT NULL DEFAULT NOW(),
);

CREATE TABLE skill
(
    id   UUID PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
);

CREATE TABLE maker_skill
(
    id       UUID PRIMARY KEY,
    maker_id UUID NOT NULL,
    skill_id UUID NOT NULL,
);
CREATE INDEX maker_id_idx ON maker_skill (maker_id);

CREATE TABLE project_skill
(
    id         UUID PRIMARY KEY,
    project_id UUID NOT NULL,
    skill_id   UUID NOT NULL,
);
CREATE INDEX project_id_idx ON project_skill (project_id);

CREATE TABLE project_maker
(
    id         UUID PRIMARY KEY,
    project_id UUID NOT NULL,
    maker_id   UUID NOT NULL,
);
CREATE INDEX project_id_idx ON project_maker (project_id);

CREATE TABLE maker_careers
(
    id              UUID PRIMARY KEY,
    is_current      BOOLEAN     NOT NULL,
    title           VARCHAR(20) NOT NULL,
    start_date_time TIMESTAMP   NOT NULL,
    end_date_time   TIMESTAMP,
);
