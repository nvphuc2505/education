CREATE TABLE quizzes (
    id                  SERIAL PRIMARY KEY NOT NULL,
    -- question            JSONB,
    type                VARCHAR(255) NOT NULL,
    difficulty          VARCHAR(255) NOT NULL,
    duration            TEXT NOT NULL,
    status              VARCHAR(255) NOT NULL,
    created_date        TIMESTAMP ,
    last_modified_date  TIMESTAMP 
);

CREATE TABLE questions (
    id                  SERIAL PRIMARY KEY NOT NULL,
    content             TEXT NOT NULL,
    choices             TEXT[] NOT NULL,
    correct_index       INT NOT NULL,
    quiz_id             INT NOT NULL REFERENCES quizzes(id) ON DELETE CASCADE
)