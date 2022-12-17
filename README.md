DOKUMENTASI PROJECT 
-
---

---
POSTMAN
-
---

CARA PENGGUNAAN FITUR LOGIN

-
1. CREATE Account + Credential
2. GET Login menggunakan Password dan Email

GET All Account => http://localhost:8080/users

---

CREATE Account + Credential => http://localhost:8080/users

JSON Body 

    {
        "firstName":"Nadhil",
        "lastName":"Syarif",
        "email":"nadhila@gmail.com",
        "password":"nadhil123",
        "userBalance":"0"
    }
---
GET Login Account => http://localhost:8080/credentials



JSON Body

    {
        "email":"nad@gmail.com",
        "password":"nadhil123"
    }

___

GET All Customer => http://localhost:8080/customers

---
CREATE Customer => http://localhost:8080/customers

JSON Body

    {
        "debitId":"zx12adja",
        "pin":"121246",
        "balance":"30000000"
    }

---
ENVIRONMENT VARIABLES
-

    DB_HOST=localhost;
    DB_NAME=e_wallet_db;
    DB_PASSWORD=1234;
    DB_PORT=5432;
    DB_USERNAME=postgres;
    API_PORT=8080

