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

`PUT /assets/{id}`

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

## Get Asset

### Request

`GET /assets/{id}`

### Response

   ```
   {
    "id": "8b81ec53-1447-459c-aff4-1042694fe3ac",
    "serialNumber": "MCRV-1",
    "assetName": "Microwave",
    "description": "This is Asset of Zanomori",
    "location": "Kanto Pusat Jakarta Selatan",
    "inUse": true,
    "purchasePrice": 3680000.0,
    "purchaseDate": "2023-01-20",
    "warrantyEndDate": "2023-01-20",
    "maintenanceNotes": "Perlu dilakukan maintenance 3 bulan sekali"
}
   ```
## Get All Technicians

### Request

`GET /technician`

### Response

   ```
  [
    {
        "id": "b51604a7-adcb-4f52-9f49-87f9d11150ab",
        "name": "Ahmad",
        "phoneNumber": "08219210201",
        "email": null
    },
    {
        "id": "98b49012-7436-4a30-8cc3-b71537a673df",
        "name": "Untung Bagus",
        "phoneNumber": "082119289921",
        "email": "muhammadzaahid24@gmail.com"
    }
]
   ```

## Delete Asset

### Request

`DELETE /assets/{id}`

### Response

   ```
   {
    "id": "8b81ec53-1447-459c-aff4-1042694fe3ac",
    "serialNumber": "MCRV-1",
    "assetName": "Microwave",
    "description": "This is Asset of Zanomori",
    "location": "Kanto Pusat Jakarta Selatan",
    "inUse": true,
    "purchasePrice": 3680000.0,
    "purchaseDate": "2023-01-20",
    "warrantyEndDate": "2023-01-20",
    "maintenanceNotes": "Perlu dilakukan maintenance 3 bulan sekali"
}
   ```

## Create Technician

### Request

`POST /technician`

Request Body :
```
{
  "name": "Adam Gozali",
  "phoneNumber": "082119289921",
  "email": "jackvincentx24@gmail.com"
}
```

### Response

    {
        "id": "dcc46279-0070-4211-b47e-8c7d2861c885",
        "message": "Technician created successfully"
    }

## Update Technician

### Request

`PUT /technician/{id}`

Request Body :
```
{
        "id": "dcc46279-0070-4211-b47e-8c7d2861c885",
        "name": "Adam Gozali",
        "phoneNumber": "082119289921",
        "email": "jackvincentx24@gmail.com"
    }
```

### Response

    {
       "id": "dcc46279-0070-4211-b47e-8c7d2861c885",
       "message": "Technician updated successfully"
    }

## Get Technician

### Request

`GET /technician/{id}`

### Response

   ```
   {
    "id": "dcc46279-0070-4211-b47e-8c7d2861c885",
    "name": "Adam Gozali",
    "phoneNumber": "082119289921",
    "email": "jackvincentx24@gmail.com"
   }
   ```

## Delete Technician

### Request

`DELETE /technician/{id}`

### Response

   ```
   {
    "id": "dcc46279-0070-4211-b47e-8c7d2861c885",
    "message": "Technician deleted successfully"
   }
   ```

## Create Maintenance

### Request

`POST /technician`

Request Body :
```
{
  "assetId": "342a1a3e-cc5a-4977-ba07-aab059587edd",
  "maintenanceDate": "2023-10-15T10:38:48.961Z",
  "cost": 400000,
  "description": "Memperbaiki kerusakan laptop"
}
```

### Response
```
{
  "id": "c58bf9dd-9da1-435e-9313-15352e9cace5",
  "message": "Maintenance created successfully"
}
```

## Update Maintenance

### Request

`PUT /maintenance/{id}`

Request Body :
```
{
    "id": "c58bf9dd-9da1-435e-9313-15352e9cace5",
    "assetId" : "6f9197eb-aaeb-4400-9f77-bb8ae2424009",
    "maintenanceDate": "2023-10-12T04:04:38.465+00:00",
    "cost": 250000,
    "description": "Memperbaiki masalah di bagian layar"
}
```

### Response
```
  {
    "id": "c58bf9dd-9da1-435e-9313-15352e9cace5",
    "message": "Maintenance record updated successfully"
  }
```
## Get Maintenance

### Request

`GET /maintenance/{id}`

### Response

   ```
  {
    "id": "c58bf9dd-9da1-435e-9313-15352e9cace5",
    "asset": {
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
    },
    "maintenanceDate": "2023-10-15T10:38:48.961+00:00",
    "cost": 400000.0,
    "description": "Memperbaiki kerusakan laptop",
    "technician": {
        "id": null,
        "name": null,
        "phoneNumber": null,
        "email": null
    }
}
   ```

## Get Maintenance by Technician

### Request

`GET /maintenance/{technicianId}`

### Response

   ```
  [
    {
        "id": "6c92ea25-47fa-4e2e-86ab-2404e4b03fb1",
        "asset": {
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
        },
        "maintenanceDate": "2023-10-12T17:51:29.077+00:00",
        "cost": 250000.0,
        "description": "Memperbaiki masalah di bagian layar",
        "technician": {
            "id": "98b49012-7436-4a30-8cc3-b71537a673df",
            "name": "Untung Bagus",
            "phoneNumber": "082119289921",
            "email": "muhammadzaahid24@gmail.com"
        }
    },
  ]
   ```

## Get Maintenance by Date Range

### Request

`GET /maintenance/?startDate=02-10-2023&endDate=16-10-2023`

### Response

   ```
  [
    {
        "id": "6c92ea25-47fa-4e2e-86ab-2404e4b03fb1",
        "asset": {
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
        },
        "maintenanceDate": "2023-10-12T17:51:29.077+00:00",
        "cost": 250000.0,
        "description": "Memperbaiki masalah di bagian layar",
        "technician": {
            "id": "98b49012-7436-4a30-8cc3-b71537a673df",
            "name": "Untung Bagus",
            "phoneNumber": "082119289921",
            "email": "muhammadzaahid24@gmail.com"
        }
    },
  ]
   ```

## Assign Technician to Maintain

### Request

`PUT /assign-technician/{maintenanceId}/technicianId`

### Response

   ```
   {
    "maintenanceId": "c58bf9dd-9da1-435e-9313-15352e9cace5",
    "technicianId": "98b49012-7436-4a30-8cc3-b71537a673df",
    "message": "successfully assigned Untung Bagus to carry out maintenance on Laptop assets"
}
   ```

## Delete maintenance

### Request

`DELETE /maintenance/{id}`

### Response

   ```
   {
    "id": "dcc46279-0070-4211-b47e-8c7d2861c885",
    "message": "Maintenancedeleted successfully"
   }
   ```

## Get Total Maintenance Cost

### Request

`GET /maintenance/total-maintenance-cost`

### Response

   ```
   1300000.0
   ```

