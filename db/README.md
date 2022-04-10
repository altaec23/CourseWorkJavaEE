# Скрипты базы данных

## Локальный запуск

### Обновление схемы базы данных

Обновить БД:
```
./gradlew liquibaseUpdate
```
        
Откатить 1 последние изменение:
```
./gradlew liquibaseRollbackCount -PliquibaseCommandValue=1
```
Очистить БД:
```
./gradlew liquibaseDropAll
```
    
> Настройки соединения с БД хранятся в файле **gradle.properties** 

Обновить БД с переопределением параметров подключения:
```
./gradlew liquibaseUpdate -Puser=myuser -Ppass=mypassword -Phost=myhost -Pport=myport -Pdatabase=mydatabase
```
