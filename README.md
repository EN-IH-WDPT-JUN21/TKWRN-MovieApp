### Testing H2 Database 
```
   JDBC URL: jdbc:h2:~/movies;AUTO_SERVER=TRUE
   username: knights
   password: ni
```
### Service ports
| Port | Service
| :--- | :--- 
| 8761 | discovery-service
| 8000 | gateway-service
| 8100 | movie-service
| 8200 | playlist-service
| 8300 | user-service
| 8400 | search-service

### movie-service

| Endpoint | Method | Description | Path Params
| :--- | :--- | :--- | :--- 
| /api/movies/get | `GET` | Get all movies | None
| /api/movies/get/{id} | `GET` | Get movie by id | `id=[long]`
| /api/movies/new | `POST` | Add new movie | None
| /api/movies/update/{id} | `PUT` | Update movie | `id=[long]`
| /api/movies/delete/{id} | `DELETE` | Delete movie | `id=[long]`

### playlist-service

| Endpoint | Method | Description | Path Params
| :--- | :--- | :--- | :--- 
| /api/playlists/get | `GET` | Get all playlists | None
| /api/playlists/get/{id} | `GET` | Get playlist by id | `id=[long]`
| /api/playlists/new | `POST` | Add new playlist | None
| /api/playlists/update/{id} | `PUT` | Update playlist | `id=[long]`
| /api/playlists/delete/{id} | `DELETE` | Delete playlist| `id=[long]`

### user-service

| Endpoint | Method | Description | Path Params
| :--- | :--- | :--- | :--- 
| /api/users/get | `GET` | Get all users | None
| /api/users/get/{id} | `GET` | Get user by id | `id=[long]`
| /api/users/new | `POST` | Add new user | None
| /api/users/update/{id} | `PUT` | Update user | `id=[long]`
| /api/users/delete/{id} | `DELETE` | Delete user | `id=[long]`

### search-service 

| Endpoint | Method | Description | Path Params
| :--- | :--- | :--- | :--- 
| /api/search/get/{X} | `GET` | Get movie by X | None

### APIs

- [IMDB](https://imdb-api.com/api)
- [RandomUser](https://randomuser.me/api)

### Extra Resources
1. Sending email & SMS from spring app
- [Spring email](https://www.baeldung.com/spring-email)
- [Mailtrap&Spring](https://mailtrap.io/blog/spring-send-email/)
- [Twillio&Spring](https://www.baeldung.com/java-sms-twilio)



