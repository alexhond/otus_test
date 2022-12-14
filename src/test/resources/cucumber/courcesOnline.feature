# language: ru
Функционал: Подготовительные курсы, выбрать самый дорогой и самый дешевый курс при помощи filter и вывод информации о нем в консоль.

  @max_price
  Сценарий: Поиск самых дорогих курсов
    Пусть Я открываю браузер "chrome"
    Если Открыть страницу подготовительных курсов
    Тогда Найти самый дорогой курс и вывести информацию на консоль

  @min_price
  Сценарий: Поиск самых дешевых курсов
    Пусть Я открываю браузер "chrome"
    Если Открыть страницу подготовительных курсов
    Тогда Найти самый дешевый курс и вывести информацию на консоль