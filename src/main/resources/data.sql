INSERT INTO shelters (name)
VALUES ('Unknown');

INSERT INTO shelters (name)
VALUES ('Лапки');

INSERT INTO shelters (name)
VALUES ('Ножки');

INSERT INTO persons (name)
VALUES ('Unknown');

INSERT INTO persons (name)
VALUES ('Саша');

INSERT INTO persons (name)
VALUES ('Маша');

INSERT INTO pets (name, shelter_id)
VALUES ('Пенни', 2);

INSERT INTO pets (name, shelter_id)
VALUES ('Ленни', 1);

INSERT INTO person_questions (question)
VALUES ('Где вы живете?');

INSERT INTO person_answers (answer, person_question_id)
VALUES ('Большая квартира', 1);

INSERT INTO person_answers (answer, person_question_id)
VALUES ('Средняя квартира', 1);

INSERT INTO person_answers (answer, person_question_id)
VALUES ('Маленькая квартира', 1);

INSERT INTO person_answers (answer, person_question_id)
VALUES ('Дом за городом', 1);

INSERT INTO pet_questions (question)
VALUES ('Какого размера?');

INSERT INTO pet_answers (answer, pet_question_id)
VALUES ('Большого', 1);

INSERT INTO pet_answers (answer, pet_question_id)
VALUES ('Среднего', 1);

INSERT INTO pet_answers (answer, pet_question_id)
VALUES ('Маленького', 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (1, 1, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (1, 2, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (1, 3, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (2, 1, -1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (2, 2, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (2, 3, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (3, 1, -1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (3, 2, -1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (3, 3, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (4, 1, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (4, 2, 1);

INSERT INTO combinations (person_answer_id, pet_answer_id, result)
VALUES (4, 3, 1);

INSERT INTO pet_tests (pet_answer_id, pet_id)
VALUES (3, 1);

INSERT INTO pet_tests (pet_answer_id, pet_id)
VALUES (3, 2);

INSERT INTO person_tests (person_answer_id, person_id)
VALUES (3, 1);

INSERT INTO combination_result (pet_id, person_id, result)
VALUES (1, 1, 1);

INSERT INTO user_role (role_type)
VALUES ('ROLE_USER');

INSERT INTO user_role (role_type)
VALUES ('ROLE_SUPER_USER');

INSERT INTO application_user (username, password, role_id, person_id)
VALUES ('admin', '$2a$10$C4Tg3QM48STBOmB51lP3PedtHUxy2Kb1wb2Dx3zkK59y2sjyuq6k6', 2, 1);

