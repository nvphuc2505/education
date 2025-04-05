CREATE TABLE vocabulary (

    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    topic               VARCHAR(255) NOT NULL,
    word                VARCHAR(255) NOT NULL,
    word_type           VARCHAR(255) NOT NULL,
    pronunciation       VARCHAR(255) NOT NULL,
    meaning             VARCHAR(255) NOT NULL,
    example             VARCHAR(255) NOT NULL,
    created_date        TIMESTAMP,
    last_modified_date  TIMESTAMP

);