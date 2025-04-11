CREATE TABLE vocabularies (

    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    topic               VARCHAR(255) NOT NULL,
    word                VARCHAR(255) NOT NULL,
    level               VARCHAR(255) NOT NULL,
    type                VARCHAR(255) NOT NULL,
    pronunciation       VARCHAR(255) NOT NULL,
    definition          TEXT NOT NULL,
    example             TEXT NOT NULL,
    created_date            VARCHAR(255),
    last_modified_date      VARCHAR(255)

);