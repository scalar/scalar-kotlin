---
name: scalar-kotlin-sdk
description: "Kotlin SDK for Scalar API. Use when writing Kotlin code that calls Scalar API with the com.scalar.api package: installing it, constructing and authenticating the client, and calling API operations."
---

# Scalar Kotlin SDK

Generated Kotlin client for Scalar API, published as `com.scalar.api`. Use the generated client instead of hand-writing HTTP requests.

## Install

Add the dependency to your Gradle build:

```kotlin
implementation("com.scalar.api:scalar-kotlin:0.2.0") // x-release-please-version
```

Or declare it in your Maven `pom.xml`:

```xml
<dependency>
  <groupId>com.scalar.api</groupId>
  <artifactId>scalar-kotlin</artifactId>
  <version>0.2.0</version> <!-- x-release-please-version -->
</dependency>
```

Or build the SDK from source, with JDK 21 installed:

```sh
./gradlew :scalar-kotlin:build
```

## Client setup and authentication

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()
```

Provide credentials using the options below. Environment variables are read automatically when the target runtime supports them:

- `bearerAuth` (env: `BEARER_AUTH`) — Credential for the BearerAuth client option.
- `oAuth2` (env: `SCALAR_OAUTH_TOKEN`) — Authorization code with PKCE (S256), for apps acting on behalf of a Scalar user. Each scope implies the weaker ones.

## Calling operations

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryListAllApiDocumentsParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val registry = client.registry().listAllApiDocuments(RegistryListAllApiDocumentsParams.none())

println(registry)
```

Method names, parameter shapes, and response types are generated from the API description — do not guess them. Look up the exact call signature in [api.md](./api.md) before writing a call.

## Error handling

Non-success responses throw generated API errors. Error objects expose status, headers, response body, and request metadata where the target runtime supports it.

```kotlin
import com.scalar.api.errors.ScalarServiceException

try {
    val registry = client.registry().listAllApiDocuments(RegistryListAllApiDocumentsParams.none())
} catch (err: ScalarServiceException) {
    println("${err.statusCode()} ${err.body()}")
    throw err
}
```

## Requirements

- Java 8 or later

## Reference files

- [README.md](./README.md) — full feature tour: client options, request options, retries and timeouts, logging.
- [api.md](./api.md) — complete catalogue of every operation with request and response types.
