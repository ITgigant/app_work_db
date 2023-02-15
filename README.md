# Application for working with the database

### Установка

1) Разархивируйте скачанный архив в любую папку на вашем ПК;
2) Откройте файлы через IntelliJ IDEA;

Для запуска необходимо:
- В IntelliJ IDEA во вкладке run выбрать Edit configurations
- В Edit configurations добавить локальный сервер Tomcat 9.0, скачать его можно по ссылке: https://tomcat.apache.org/ . Справа внизу появится кнопка Fix, нажать ее и выбрать из списка war exploded. Далее необходимо очистить поле Application context и нажать ОК 
- В классе SpringConfig необходимо указать данные для подключения к базе данных postgresql(те же, что в классе readXmlToPostgres проекта, который расположен в репозитории parser)
- Запустить программу и обратиться в браузере к адресу http://localhost:8080/table/page/0 
