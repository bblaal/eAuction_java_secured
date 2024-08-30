# eAuction_java

eAuction java component to provide backend service to the consumer. It has the below endpoints


## API Documentation:

###  Franchisee Controller

* **Endpoint**: `/franchisee/api/v1/getFranchisee/{franchiseeId}`

* **Method**: GET

* **Response Structure**:
Returns a JSON object of matching franchisee

    ```
    {
        "franchiseeId": "BB1001",
        "franchiseeName": "BBLaal",
        "balance": 120000.0,
        "franchiseeEmail": "suvro1319@gmail.com",
        "franchiseeContact": "8972416245",
        "password": null
    }
    ```

* **Endpoint**: `/franchisee/api/v1/franchisees`

* **Method**: GET

* **Response Structure**: 
Returns an array with Franchisee List


    ```
    [
        {
            "franchiseeId": "BB1001",
            "franchiseeName": "BBLaal",
            "balance": 120000.0,
            "franchiseeEmail": "suvro1319@gmail.com",
            "franchiseeContact": "8972416245",
            "password": null
        },
        {
            "franchiseeId": "RM1002",
            "franchiseeName": "Real Madrid",
            "balance": 230000.0,
            "franchiseeEmail": "isomsuvra@gmail.com",
            "franchiseeContact": "8972416245",
            "password": null
        }
    ]
    ```

* **Endpoint**: `/franchisee/api/v1/franchisees`

* **Method**: POST

* **Request Body**: Franchisee details JSON Request body


    ```
    {
        "franchiseeId": "SG1003",
        "franchiseeName": "Somsuvra Ganguly",
        "balance": 170000.0,
        "franchiseeEmail": "suvro1319@gmail.com",
        "franchiseeContact": "8972416245",
        "password": null
    }
    ```

* **Response Status**: 200


###  Players Controller

* **Endpoint**: `/players/api/v1/players/{playerId}`

* **Method**: GET

* **Response Structure**:
Returns a JSON object of matching player


    ```
    {
        "playerId": "1001",
        "playerName": "Virat Kohli",
        "playerDOB": "16/01/1995",
        "playerEmail": "isomsuvra@gmail.com",
        "playerContact": "8972416245",
        "playerSpeciality": "230000",
        "playerLocation": "Delhi"
    }
    ```

* **Endpoint**: `/players/api/v1/players`

* **Method**: GET

* **Response Structure**:
Returns an array with Players List


    ```
    [
        {
            "playerId": "1001",
            "playerName": "Virat Kohli",
            "playerDOB": "16/01/1995",
            "playerEmail": "isomsuvra@gmail.com",
            "playerContact": "8972416245",
            "playerSpeciality": "230000",
            "playerLocation": "Delhi"
        },
        {
            "playerId": "1002",
            "playerName": "Somsuvra Ganguly",
            "playerDOB": "16/01/1995",
            "playerEmail": "isomsuvra@gmail.com",
            "playerContact": "8972416245",
            "playerSpeciality": "230000",
            "playerLocation": "Kolkata"
        }
    ]
    ```

* **Endpoint**: `/players/api/v1/addPlayers`

* **Method**: POST

* **Request Body**: Players details JSON Request body


    ```
    {
        "playerId": "1010",
        "playerName": "Virat Kohli",
        "playerDOB": "16/01/1995",
        "playerEmail": "isomsuvra@gmail.com",
        "playerContact": "8972416245",
        "playerSpeciality": "Batsman",
        "playerLocation": "Delhi"
    }
    ```

* **Response Status**: 200
