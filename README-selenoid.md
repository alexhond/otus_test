ДЗ #4: Разворачивание и подключение Selenoid

Цель:
Необходимо подключить Selenoid и перенести существующие тесты на использование Selenoid.
Добавить возможность запускать тесты на mobile chrome.


Описание/Пошаговая инструкция выполнения домашнего задания:
Необходимо подключить Selenoid и перенести существующие тесты на использование Selenoid
Добавить возможность запускать тесты на mobile chrome


Критерии оценки:
Максимальная оценка 10 баллов

2 за подключение Selenoid
2 балла за написанные тесты проверки Backend при помощи RestAssured
4 балла за использование Citrus
2 балла реализацию Stub сервера для Backend
2 балла за не выполненное условие
1 бал за каждое действие преподавателя для запуска тестов
Сдача:
Сдача ДЗ через git в ветве homework_4


-----------------------------



# // Создать сеть
docker network create selenoid_1
docker network create selenoid_2

# // спулить images
docker pull selenoid/chrome:104.0
docker pull selenoid/chrome:103.0
docker pull selenoid/opera:86.0

# //запуск докера (Windows)
$current = $PWD -replace "\\", "/" -replace "C", "c"
docker run -d --name selenoid_1 -p 4445:4444 --net=selenoid_1 -v //var/run/docker.sock://var/run/docker.sock -v ${current}/selenoid:/etc/selenoid:ro aerokube/selenoid -limit=12 -capture-driver-logs -max-timeout=0h30m0s -container-network=selenoid_1
docker run -d --name selenoid_2 -p 4446:4444 --net=selenoid_2 -v //var/run/docker.sock://var/run/docker.sock -v ${current}/selenoid:/etc/selenoid:ro aerokube/selenoid -limit=12 -capture-driver-logs -max-timeout=0h30m0s -container-network=selenoid_2
docker run -d --name ggr -v ${current}/selenoid/ggr_config:/etc/grid-router:ro --net host aerokube/ggr:latest-release -guests-allowed -guests-quota "test" -verbose -quotaDir /etc/grid-router/quota

# // Запуск ggr
$current = $PWD -replace "\\", "/" -replace "C", "c"
selenoid/ggr_windows_amd64.exe -guests-allowed -guests-quota "test" -verbose -quotaDir ${current}/selenoid/ggr_config/quota/

# // Запуск ggr-ui
$current = $PWD -replace "\\", "/" -replace "C", "c"
selenoid/ggr-ui_windows_amd64.exe -quota-dir ${current}/selenoid/ggr_config/quota/

# // Запуск selenoid-ui
$current = $PWD -replace "\\", "/" -replace "C", "c"
selenoid/selenoid-ui_windows_amd64.exe --selenoid-uri http://127.0.0.1:8888 -listen ":8090" -allowed-origin "*"

# // Запуск nginx

[//]: # (docker pull nginx)

[//]: # (docker run -d --name nginx -v ${current}/selenoid/nginx:/etc/nginx/conf.d/ -v /sys/fs/cgroup:/sys/fs/cgroup:ro -v /etc/localtime:/etc/localtime:ro --restart always --privileged --net host nginx:latest)

Выполнить команду cd selenoid\nginx-1.22.0\nginx-1.22.0\
выполнить команду start nginx.exe

Чтобы остановить сервер nginx:
taskkill /f /im nginx.exe