# Asset Management System

Aplikasi untuk mengelola asset

Berikut ini adalah tahapan untuk menjalankan aplikasi :

## Step 1 : Generate JAR file

Masuk ke directory menggunakan command berikut

```bash
cd asset-service
```

Jalankan command dibawah ini untuk generate JAR file

```bash
mvn clean package
```
Ulangi langkah tersebut untuk semua service, dalam project ini total memiliki 7 service :

1. **registry-service**
2. **gateway-service**
3. **asset-service**
4. **technician-service**
5. **maintenance-service**
6. **email-service**
7. **scheduler-service**

## Step 2 : Build Docker

Jalankan command dibawah ini untuk build semua service yang telah didefinisikan pada **docker-compose.yml**

```bash
docker-compose build
```
Kemudian untuk melakukan generate container dan menjalankan aplikasi, gunakan command dibawah ini

```bash
docker-compose up
```
## API Documentation

## Get All Assets

### Request

`GET /assets`

### Response

   ```
   [
    {
        "id": "848360bc-0da4-403e-b5b9-67e9248960f0",
        "serialNumber": "10921",
        "assetName": null,
        "description": "This is Asset of Zanomori",
        "location": "Jakarta",
        "inUse": true,
        "purchasePrice": 1000000.0,
        "purchaseDate": "2023-01-20",
        "warrantyEndDate": "2023-01-20",
        "maintenanceNotes": "Nothing"
    },  
    {
        "id": "342a1a3e-cc5a-4977-ba07-aab059587edd",
        "serialNumber": "MCRV-1",
        "assetName": "Laptop Lenovo Z11",
        "description": "This is Asset of Zanomori",
        "location": "Kanto Pusat Jakarta Selatan",
        "inUse": true,
        "purchasePrice": 1.2E7,
        "purchaseDate": "2023-01-20",
        "warrantyEndDate": "2023-01-20",
        "maintenanceNotes": "Perlu dilakukan maintenance berkala"
    }
]
   ```

## Create Asset

### Request

`POST /assets`

Request Body : 
```
{
    "serialNumber": "MCRV-1",
    "assetName": "Lampu",
    "description": "This is Asset of Zanomori",
    "location": "Kanto Pusat Jakarta Selatan",
    "inUse": true,
    "purchasePrice": 12000000,
    "purchaseDate": "2023-01-20",
    "warrantyEndDate": "2023-01-20",
    "maintenanceNotes": "Perlu dilakukan maintenance berkala"
}
```

### Response

    {
    "id": "decd3e32-734b-46dd-a6d0-b59539f1b727",
    "message": "Asset created successfully"
    }

## Update Asset

### Request

`POST /assets`

Request Body :
```
{
    "id": "342a1a3e-cc5a-4977-ba07-aab059587edd",
    "serialNumber": "MCRV-1",
    "assetName": "Laptop Lenovo Z11",
    "description": "This is Asset of Zanomori",
    "location": "Kanto Pusat Jakarta Selatan",
    "inUse": true,
    "purchasePrice": 12000000,
    "purchaseDate": "2023-01-20",
    "warrantyEndDate": "2023-01-20",
    "maintenanceNotes": "Perlu dilakukan maintenance berkala"
}
```

### Response

    {
      "id": "342a1a3e-cc5a-4977-ba07-aab059587edd",
      "message": "Asset updated successfully"
    }
