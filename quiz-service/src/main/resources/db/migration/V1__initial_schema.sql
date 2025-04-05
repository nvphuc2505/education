CREATE TABLE quizzes (

    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    question_type        VARCHAR(255) NOT NULL,
    question            VARCHAR(255) NOT NULL,
    answers             TEXT[] NOT NULL,
    correct_answer       VARCHAR(255) NOT NULL,
    created_date        TIMESTAMP NOT NULL,
    last_modified_date  TIMESTAMP NOT NULL

);