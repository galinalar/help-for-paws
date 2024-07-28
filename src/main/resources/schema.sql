CREATE TABLE IF NOT EXISTS persons
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS shelters
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pets
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    shelter_id INT          NOT NULL,
    FOREIGN KEY (shelter_id) REFERENCES shelters(id)
);

CREATE TABLE IF NOT EXISTS person_questions
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS person_answers
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    answer      VARCHAR(255) NOT NULL,
    person_question_id INT          NOT NULL,
    FOREIGN KEY (person_question_id) REFERENCES person_questions(id)
);

CREATE TABLE IF NOT EXISTS pet_questions
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pet_answers
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    answer      VARCHAR(255) NOT NULL,
    pet_question_id INT          NOT NULL,
    FOREIGN KEY (pet_question_id) REFERENCES pet_questions(id)
);

CREATE TABLE IF NOT EXISTS combination_result
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    result      INT NOT NULL,
    pet_id INT          NOT NULL,
    person_id INT          NOT NULL,
    FOREIGN KEY (pet_id) REFERENCES pets(id),
    FOREIGN KEY (person_id) REFERENCES persons(id)
);

CREATE TABLE IF NOT EXISTS combinations
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    result      INT NOT NULL,
    pet_answer_id INT          NOT NULL,
    person_answer_id INT          NOT NULL,
    FOREIGN KEY (pet_answer_id) REFERENCES pet_answers(id),
    FOREIGN KEY (person_answer_id) REFERENCES person_answers(id)
);

CREATE TABLE IF NOT EXISTS pet_tests
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    date_completed      DATETIME,
    pet_answer_id INT          NOT NULL,
    pet_id INT          NOT NULL,
    FOREIGN KEY (pet_answer_id) REFERENCES pet_answers(id),
    FOREIGN KEY (pet_id) REFERENCES pets(id)
);

CREATE TABLE IF NOT EXISTS person_tests
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    date_completed      DATETIME,
    person_id INT          NOT NULL,
    person_answer_id INT          NOT NULL,
    FOREIGN KEY (person_id) REFERENCES persons(id),
    FOREIGN KEY (person_answer_id) REFERENCES person_answers(id)
);

CREATE TABLE IF NOT EXISTS user_role
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
   role_type VARCHAR(255)          NOT NULL
);

CREATE TABLE IF NOT EXISTS application_user
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    username      VARCHAR(255) NOT NULL,
     password VARCHAR(255)          NOT NULL,
    role_id INT          NOT NULL,
    person_id INT          ,
    FOREIGN KEY (person_id) REFERENCES persons(id),
    FOREIGN KEY (role_id) REFERENCES user_role(id)
);