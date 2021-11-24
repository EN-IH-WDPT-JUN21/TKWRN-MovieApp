<p align="center">
   <img src="https://github.com/EN-IH-WDPT-JUN21/TKWRN-MovieApp/blob/main/nullLogo.png?raw=true">
</p>

<i><b>Spring and Angular based Movie Search platform implementing IMDB API </b></i>

### Features 
- search for movies
- view movie details, cast list and related movies
- create and edit playlists
- view playlist details
- register and login 
- view and update user details

### How to use

1. Clone the repository
```
git clone https://github.com/EN-IH-WDPT-JUN21/TKWRN-MovieApp.git
```
2. Run the main class of each service in the order:
    - discovery-service
    - gateway-service
    - user-service
    - search-service
    - playlist-service
    

3. Navigate to TKWRN-FrontEnd folder and start the server 

```
   npm start 
```

4. Navigate to localhost/4200


5. Database setup
```
   create database ironhackhomework5;
   
   use ironhackhomework5;
   
   CREATE USER 'ironhacker'@'localhost' IDENTIFIED BY '1r0nH@ck3r';
   
   GRANT ALL PRIVILEGES ON *.* TO 'ironhacker'@'localhost';
   
   FLUSH PRIVILEGES;
```


4. Admin login credentials:

   
   ```
   name = Anna or Shaun or Sebastian or Ula
   password = admin
   ```
   
5. Avatars
   Please only use files with names 1.png to 7.png


### Service ports
| Port | Service
| :--- | :--- 
| 8761 | discovery-service
| 8000 | gateway-service
| 8200 | playlist-service
| 8300 | user-service
| 8400 | search-service

### APIs

- [IMDB](https://imdb-api.com/api)

### playlist-service

| Endpoint | Method | Description | Path Params
| :--- | :--- | :--- | :--- 
| /api/playlists| `GET` | Get all playlists | None
| /api/playlists/{id} | `GET` | Get playlist by id | `id=[long]`
| /api/playlists/new | `POST` | Add new playlist | None
| /api/playlists/update/{id} | `PUT` | Update playlist | `id=[long]`
| /api/playlists/addmovie/{id}" | `PUT` | Add movie to playlist | `id=[long]`
| /api/playlists/delete/{id} | `DELETE` | Delete playlist| `id=[long]`

### user-service

| Endpoint | Method | Description | Path Params
| :--- | :--- | :--- | :--- 
| /api/users | `GET` | Get all users | None
| /api/users/{username} | `GET` | Get user by username| `username=[String]`
| /api/users/new | `POST` | Add new user | None
| /api/users/update/{username} | `PUT` | Update user | `username=[String]`

### search-service 

| Endpoint | Method | Description | Path Params
| :--- | :--- | :--- | :--- 
| /api/search/title/{type}/{title:[a-zA-Z &+-]*} | `GET` | Get movies by title | `type=[String]`, `title=[String]`
| /api/search/title/{id} | `GET` | Get title by titleId | `id=[String]`
| /api/search/person/{name:[a-zA-Z &+-]*} | `GET` | Get person by name | `name=[String]`
| /api/search/personId/{id} | `GET` | Get person by nameId | `id=[String]`


<br/>

<p align="center">Those who seek the Null are bound to find it</p>
<p align="center"><i>from "The Scary Adventures of Zandwubbervitch and Null von String"</i></p>




