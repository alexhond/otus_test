# language: ru
@smoke
Функционал: Страница категории курса

  @get_course
  Сценарий: Страница курса открывается успешно
    Пусть Я открываю браузер "chrome"
    Если Открыть страницу урока "java-professional"
    Тогда Страница урока "Java Developer. Professional" открыта
