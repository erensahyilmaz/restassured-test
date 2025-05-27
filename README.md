# REST Assured API Test Project

Bu proje, REST Assured framework'ü kullanarak API testlerini gerçekleştiren bir Java Maven projesidir. JSONPlaceholder API'si üzerinde POST ve GET istekleri test edilmektedir.

## 🚀 Özellikler

- **POST Testleri**: Yeni post kayıtları oluşturma testleri
- **GET Testleri**: Mevcut post kayıtlarını getirme testleri
- **Response Validation**: HTTP status kodları, content type ve response body validasyonları
- **Performance Testing**: Response time ölçümü ve doğrulama
- **Comprehensive Logging**: Detaylı request/response loglama

## 📋 Gereksinimler

- Java 17+
- Maven 3.6+
- İnternet bağlantısı (JSONPlaceholder API'sine erişim için)

## 🛠️ Kullanılan Teknolojiler

- **REST Assured 5.4.0**: API test framework'ü
- **JUnit 5 (Jupiter) 5.9.3**: Test framework'ü
- **Hamcrest 2.2**: Assertion matchers
- **Maven**: Dependency management ve build tool

## 📦 Kurulum

1. Projeyi klonlayın:
```bash
git clone <repository-url>
cd rest-assured-test-project
```

2. Maven dependencies'leri yükleyin:
```bash
mvn clean install
```

## 🧪 Test Çalıştırma

Tüm testleri çalıştırmak için:
```bash
mvn test
```

Belirli bir test sınıfını çalıştırmak için:
```bash
mvn test -Dtest=RestAssuredTest
```

Belirli bir test metodunu çalıştırmak için:
```bash
mvn test -Dtest=RestAssuredTest#testPost1
```

## 📝 Test Senaryoları

### 1. testPost1()
- **Amaç**: Detaylı bir post kaydı oluşturma
- **Endpoint**: `POST /posts`
- **Validasyonlar**:
  - Status code: 201
  - Content type: application/json
  - Response body field validations
  - Response time < 1000ms

### 2. testPost2()
- **Amaç**: Basit bir post kaydı oluşturma
- **Endpoint**: `POST /posts`
- **Validasyonlar**:
  - Status code: 201
  - Content type: application/json
  - Specific field value validations
  - Response time < 1000ms

### 3. testGetPostById()
- **Amaç**: ID'ye göre post kaydı getirme
- **Endpoint**: `GET /posts/1`
- **Validasyonlar**:
  - Status code: 200
  - Content type: application/json
  - Field existence and value validations
  - Response time < 2000ms

## 📊 Test Çıktı Örneği

```
1.POST Test çalıştı.
Request method:	POST
Request URI:	https://jsonplaceholder.typicode.com/posts
...
{
    "id": 101,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum...",
    "userId": 1
}
1.POST Yanıt süresi: 234 ms
```

## 🔧 Konfigürasyon

### Base URI
Testler `https://jsonplaceholder.typicode.com` base URI'sini kullanmaktadır. Bu değer her test metodunda ayarlanmaktadır.

### Headers
- POST istekleri için: `Content-type: application/json`
- GET istekleri için: `Accept: application/json`

### Timeout Değerleri
- POST testleri: 1000ms
- GET testleri: 2000ms

## 📁 Proje Yapısı

```
├── pom.xml
└── src/
    └── test/
        └── java/
            └── RestAssuredTest.java
```


**Not**: Bu testler JSONPlaceholder API'sini kullanmaktadır, bu nedenle gerçek veri değişiklikleri yapılmaz ve test amaçlıdır.
