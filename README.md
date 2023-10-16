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