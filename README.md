Домашнее задание
ДЗ #1: Автотест со своими ожиданиями

Цель:
Реализовать на практике полученные знания, с использованием Actions и своих ожиданий.


Описание/Пошаговая инструкция выполнения домашнего задания:
Необходимо создать проект в Maven'e и реализовать:

Фабрику (WebDriverFactory), которая будет получать значение из окружения и запускать соответствующий браузер
Браузеры: Chrome, Firefox, Opera
Реализовать подсветку элементов перед нажатием, после нажатия вернуть данные в исходное состояние
На главно странице Otus'a снизу найти список курсов(популярные курсы, специализации, рекомендации) и реализовать:
Метод фильтр по названию курса
Метод выбора курса, стартующего раньше всех/позже всех (при совпадении дат - выбрать любой) при помощи reduce
Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions

Критерии оценки:
Максимальная оценка 10 баллов.

2 Балла за реализацию фабрики
2 балла за подсветку элементов, +2 балла за возврат страницы в исходное состояние
1 бал за реализацию фильтра, +1 бал за реализацию reduce'ра
2 балла за реализацию Actions и выбора цвета
1 бал за каждое вмешательство преподавателя для запуска/работы тестов
2 балла за не реализованное задание
Сдача:
Сдача происходит через git.
Необходимо приложить инструкцию (вариант, написать в readme.md) по запуску.

Запуск автотестов:
Проверка курсов:
-mvn clean test -DincludeTest=checkPopularTest
-mvn clean test -DincludeTest=check_recommendation_course
-mvn clean test -DincludeTest=check_specialization_course

Проверка курсов стартующех раньге всех и позже всех:
Курсы стартующие раньше всех:
-mvn clean test -DincludeTest=test_min_date_specializations_courses
-mvn clean test -DincludeTest=test_min_date_recommendation_courses
-mvn clean test -DincludeTest=test_min_date_popular_courses
Курсы стартующие позже всех:
-mvn clean test -DincludeTest=test_max_date_specialization_courses
-mvn clean test -DincludeTest=test_max_date_recommendation_courses
-mvn clean test -DincludeTest=test_max_date_popular_courses
