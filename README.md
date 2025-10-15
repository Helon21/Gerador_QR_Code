# 🧩 QR Code Generator

![Java](https://img.shields.io/badge/Java-21-007396?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?logo=docker&logoColor=white)
![AWS S3](https://img.shields.io/badge/AWS-S3-FF9900?logo=amazonaws&logoColor=white)

---

Aplicação desenvolvida em **Java 21** com **Spring Boot**, projetada para **gerar QR Codes a partir de uma URL** e enviá-los automaticamente para um **bucket S3 da AWS**. 
O projeto foi **conteinerizado com Docker**, garantindo execução simples e portabilidade entre ambientes.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Google ZXing** → Geração de QR Codes
- **AWS SDK for Java** → Upload das imagens geradas para o Amazon S3
- **Docker** → Containerização e execução isolada da aplicação
- **Maven** → Gerenciamento de dependências e build

---

## 🧩 Estrutura de Pacotes

```
src/main/java/com/helonxavier/qrcode/generator
│
├── controller/      # Endpoints REST
├── dto/             # Objetos de requisição e resposta
├── service/         # Lógica de geração e upload
├── infrastructure/  # Comunicação com a AWS S3
└── ports/           # Interfaces e contratos do domínio

```

## 🧠 Descrição do Projeto

O **QR Code Generator** é uma API REST que recebe uma URL e gera um QR Code correspondente. 
O QR Code é salvo localmente e também enviado para um **bucket S3 da AWS**, retornando o **link público** de acesso à imagem.

**Fluxo resumido:**
1. O cliente envia uma requisição `POST /qrcode` com uma URL.
2. A aplicação gera o QR Code usando **ZXing**.
3. O arquivo é enviado ao **Amazon S3** via **AWS SDK**.
4. A resposta contém o link público do QR Code.

---

## ⚙️ Configuração do Ambiente

Crie um arquivo `.env` com as seguintes variáveis de ambiente:

```properties
AWS_ACCESS_KEY_ID=seu_access_key
AWS_SECRET_ACCESS_KEY=sua_secret_key
AWS_REGION=us-east-1
AWS_S3_BUCKET_NAME=nome-do-seu-bucket
```

🐳 Executando com Docker
1. Build da imagem
   
docker build -t qrcode-generator:1.0 .

3. Executar o container

docker run -d -p 8080:8080 --name qrcode-generator qrcode-generator:1.0

A aplicação estará disponível em:
👉 http://localhost:8080

🧑‍💻 Autor
Helon Bentes Bastos Xavier | Engenharia de Software
