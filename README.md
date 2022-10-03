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

Конфигурация:

-Dbrowser=указать браузер (chrome, firefox, opera)

_Доступные конфигурации_

**Поиск курсов по названию:**

opera: clean test -Dtest=MainPageCoursesTest#click_popular_course+click_recommendation_course+click_specialization_course -Dbrowser=opera

firefox: clean test -Dtest=MainPageCoursesTest#click_popular_course+click_recommendation_course+click_specialization_course -Dbrowser=firefox

chrome: clean test -Dtest=MainPageCoursesTest#click_popular_course+click_recommendation_course+click_specialization_course -Dbrowser=chrome

_Проверка курсов стартующих раньше всех и позже всех:_

**Курсы стартующие раньше всех:**

_opera: clean test -Dtest=MainPageCoursesTest#test_min_date_specializations_courses+test_min_date_recommendation_courses+test_min_date_popular_courses -Dbrowser=opera

_firefox: clean test -Dtest=MainPageCoursesTest#test_min_date_specializations_courses+test_min_date_recommendation_courses+test_min_date_popular_courses -Dbrowser=firefox

_chrome: clean test -Dtest=MainPageCoursesTest#test_min_date_specializations_courses+test_min_date_recommendation_courses+test_min_date_popular_courses -Dbrowser=chrome

**Курсы стартующие позже всех:**

_opera: clean test -Dtest=MainPageCoursesTest#test_max_date_specializations_courses+test_max_date_recommendation_courses+test_max_date_popular_courses -Dbrowser=opera

_firefox: clean test -Dtest=MainPageCoursesTest#test_max_date_specializations_courses+test_max_date_recommendation_courses+test_max_date_popular_courses -Dbrowser=firefox

_chrome:clean test -Dtest=MainPageCoursesTest#test_max_date_specializations_courses+test_max_date_recommendation_courses+test_max_date_popular_courses -Dbrowser=chrome
