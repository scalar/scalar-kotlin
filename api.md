# Scalar Kotlin API

Complete reference of every operation, grouped by resource. See [the README](./README.md) for usage and configuration.

## Contents

- [`Registry`](#registry)
  - [List all API Documents](#list-all-api-documents)
  - [List API Documents in a namespace](#list-api-documents-in-a-namespace)
  - [Create API Document](#create-api-document)
  - [Update API Document metadata](#update-api-document-metadata)
  - [Delete API Document](#delete-api-document)
  - [Get API Document](#get-api-document)
  - [Update API Document version](#update-api-document-version)
  - [Delete API Document version](#delete-api-document-version)
  - [Get API Document version metadata](#get-api-document-version-metadata)
  - [Create API Document version](#create-api-document-version)
  - [Add access group](#add-access-group)
  - [Remove access group](#remove-access-group)
- [`Schemas`](#schemas)
  - [List all shared components](#list-all-shared-components)
  - [Create a shared component](#create-a-shared-component)
  - [Update shared component metadata](#update-shared-component-metadata)
  - [Delete a shared component](#delete-a-shared-component)
  - [`Schemas Version`](#schemas-version)
    - [Get a shared component document](#get-a-shared-component-document)
    - [Delete a shared component version](#delete-a-shared-component-version)
    - [Create a shared component version](#create-a-shared-component-version)
  - [`Schemas AccessGroup`](#schemas-accessgroup)
    - [Add shared component access group](#add-shared-component-access-group)
    - [Remove shared component access group](#remove-shared-component-access-group)
- [`LoginPortals`](#loginportals)
  - [Get a login portal](#get-a-login-portal)
  - [Update portal metadata](#update-portal-metadata)
  - [Delete a login portal](#delete-a-login-portal)
  - [Create a portal](#create-a-portal)
  - [List all portals](#list-all-portals)
- [`AccessGroups`](#accessgroups)
  - [Create an access group](#create-an-access-group)
  - [Get an access group](#get-an-access-group)
  - [Update an access group](#update-an-access-group)
  - [Delete an access group](#delete-an-access-group)
  - [`AccessGroups Domains`](#accessgroups-domains)
    - [Add an allowed email domain](#add-an-allowed-email-domain)
    - [Remove an allowed email domain](#remove-an-allowed-email-domain)
- [`Rules`](#rules)
  - [List all rules](#list-all-rules)
  - [Create a rule](#create-a-rule)
  - [Update rule metadata](#update-rule-metadata)
  - [Delete a rule](#delete-a-rule)
  - [Get a rule](#get-a-rule)
  - [Add rule access group](#add-rule-access-group)
  - [Remove rule access group](#remove-rule-access-group)
- [`Themes`](#themes)
  - [List all themes](#list-all-themes)
  - [Create a theme](#create-a-theme)
  - [Update theme metadata](#update-theme-metadata)
  - [Update theme document](#update-theme-document)
  - [Delete a theme](#delete-a-theme)
  - [Get a theme](#get-a-theme)
- [`Teams`](#teams)
  - [List teams](#list-teams)
  - [`Teams Members`](#teams-members)
    - [List team members](#list-team-members)
    - [Change a member role](#change-a-member-role)
    - [Remove a member](#remove-a-member)
  - [`Teams Invites`](#teams-invites)
    - [Invite a member](#invite-a-member)
    - [Resend an invite](#resend-an-invite)
    - [Cancel an invite](#cancel-an-invite)
- [`ScalarDocs`](#scalardocs)
  - [List all projects](#list-all-projects)
  - [Create a project](#create-a-project)
  - [Publish a project](#publish-a-project)
  - [List all docs projects](#list-all-docs-projects)
  - [Create a docs project](#create-a-docs-project)
  - [Get a docs project](#get-a-docs-project)
  - [Update a docs project](#update-a-docs-project)
  - [Delete a docs project](#delete-a-docs-project)
  - [Publish a docs project](#publish-a-docs-project)
  - [Read the site config](#read-the-site-config)
  - [Write the site config](#write-the-site-config)
  - [Get the site domains](#get-the-site-domains)
  - [Check domain DNS](#check-domain-dns)
- [`Namespaces`](#namespaces)
  - [List namespaces](#list-namespaces)
- [`Authentication`](#authentication)
  - [Exchange token](#exchange-token)
  - [Get current user](#get-current-user)
- [`Sdks`](#sdks)
  - [List all SDKs](#list-all-sdks)
  - [Create an SDK](#create-an-sdk)
  - [Get an SDK](#get-an-sdk)
  - [Update an SDK](#update-an-sdk)
  - [Delete an SDK](#delete-an-sdk)
  - [Build an SDK](#build-an-sdk)
  - [`Sdks Versions`](#sdks-versions)
    - [Create an SDK version](#create-an-sdk-version)
    - [Delete an SDK version](#delete-an-sdk-version)
  - [`Sdks Repositories`](#sdks-repositories)
    - [Link a repository](#link-a-repository)
    - [Unlink a repository](#unlink-a-repository)
    - [Update publishing settings](#update-publishing-settings)
- [`Mcp`](#mcp)
  - [`Mcp Servers`](#mcp-servers)
    - [List all MCP servers](#list-all-mcp-servers)
    - [Create an MCP server](#create-an-mcp-server)
    - [Get an MCP server](#get-an-mcp-server)
    - [Update an MCP server](#update-an-mcp-server)
    - [Delete an MCP server](#delete-an-mcp-server)
    - [`Mcp Servers Installations`](#mcp-servers-installations)
      - [List installations](#list-installations)
      - [Get an installation](#get-an-installation)
      - [Update an installation](#update-an-installation)
      - [Delete an installation](#delete-an-installation)
      - [Add an access group](#add-an-access-group)
      - [Remove an access group](#remove-an-access-group)

## Setup

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()
```

## `Registry`

Registry

### List all API Documents

List all API documents across every namespace the caller can access.

| Direction | Type |
| --- | --- |
| Request | [`RegistryListAllApiDocumentsParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryListAllApiDocumentsParams.kt) |
| Response | [`List<ApiDocument>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/ApiDocument.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryListAllApiDocumentsParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val registry = client.registry().listAllApiDocuments(RegistryListAllApiDocumentsParams.none())

println(registry)
```

### List API Documents in a namespace

List API documents in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`RegistryListApiDocumentsParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryListApiDocumentsParams.kt) |
| Response | [`List<ApiDocument>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/ApiDocument.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryListApiDocumentsParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = RegistryListApiDocumentsParams.builder().namespace("acme").build()
val registry = client.registry().listApiDocuments(params)

println(registry)
```

### Create API Document

Create an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryCreateApiDocumentParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryCreateApiDocumentParams.kt) |
| Response | [`RegistryCreateApiDocumentResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryCreateApiDocumentResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryCreateApiDocumentParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryCreateApiDocumentParams.builder()
        .namespace("acme")
        .title("Acme API")
        .version("1.2.0")
        .slug("acme-api")
        .document(
            "{\"openapi\":\"3.1.0\",\"info\":{\"title\":\"Acme API\",\"version\":\"1.2.0\"},\"paths\":{}}"
        )
        .build()
val registry = client.registry().createApiDocument(params)

println(registry)
```

### Update API Document metadata

Update metadata for an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryUpdateApiDocumentParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryUpdateApiDocumentParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryUpdateApiDocumentParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = RegistryUpdateApiDocumentParams.builder().namespace("acme").slug("acme-api").build()
val registry = client.registry().updateApiDocument(params)

println(registry)
```

### Delete API Document

Delete an API document and all versions.

| Direction | Type |
| --- | --- |
| Request | [`RegistryDeleteApiDocumentParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryDeleteApiDocumentParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryDeleteApiDocumentParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = RegistryDeleteApiDocumentParams.builder().namespace("acme").slug("acme-api").build()
val registry = client.registry().deleteApiDocument(params)

println(registry)
```

### Get API Document

Get a specific API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryRetrieveApiDocumentVersionParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryRetrieveApiDocumentVersionParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryRetrieveApiDocumentVersionParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryRetrieveApiDocumentVersionParams.builder()
        .namespace("acme")
        .slug("acme-api")
        .semver("1.2.0")
        .build()
val registry = client.registry().retrieveApiDocumentVersion(params)

println(registry)
```

### Update API Document version

Update the registry file content for an API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryUpdateApiDocumentVersionParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryUpdateApiDocumentVersionParams.kt) |
| Response | [`RegistryUpdateApiDocumentVersionResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryUpdateApiDocumentVersionResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryUpdateApiDocumentVersionParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryUpdateApiDocumentVersionParams.builder()
        .namespace("acme")
        .slug("acme-api")
        .semver("1.2.0")
        .document(
            "{\"openapi\":\"3.1.0\",\"info\":{\"title\":\"Acme API\",\"version\":\"1.2.0\"},\"paths\":{}}"
        )
        .build()
val registry = client.registry().updateApiDocumentVersion(params)

println(registry)
```

### Delete API Document version

Delete a specific API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryDeleteApiDocumentVersionParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryDeleteApiDocumentVersionParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryDeleteApiDocumentVersionParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryDeleteApiDocumentVersionParams.builder()
        .namespace("acme")
        .slug("acme-api")
        .semver("1.2.0")
        .build()
val registry = client.registry().deleteApiDocumentVersion(params)

println(registry)
```

### Get API Document version metadata

Get metadata (uid, content shas, version sha, tags) for a specific API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryListApiDocumentVersionMetadataParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryListApiDocumentVersionMetadataParams.kt) |
| Response | [`ManagedDocVersion`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/ManagedDocVersion.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryListApiDocumentVersionMetadataParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryListApiDocumentVersionMetadataParams.builder()
        .namespace("acme")
        .slug("acme-api")
        .semver("1.2.0")
        .build()
val registry = client.registry().listApiDocumentVersionMetadata(params)

println(registry)
```

### Create API Document version

Create a new API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryCreateApiDocumentVersionParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryCreateApiDocumentVersionParams.kt) |
| Response | [`ManagedDocVersion`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/ManagedDocVersion.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.RegistryCreateApiDocumentVersionParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryCreateApiDocumentVersionParams.builder()
        .namespace("acme")
        .slug("acme-api")
        .version("1.2.0")
        .document(
            "{\"openapi\":\"3.1.0\",\"info\":{\"title\":\"Acme API\",\"version\":\"1.2.0\"},\"paths\":{}}"
        )
        .build()
val registry = client.registry().createApiDocumentVersion(params)

println(registry)
```

### Add access group

Add an access group to an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryCreateApiDocumentAccessGroupParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryCreateApiDocumentAccessGroupParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.AccessGroup
import com.scalar.api.models.registry.RegistryCreateApiDocumentAccessGroupParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryCreateApiDocumentAccessGroupParams.builder()
        .namespace("acme")
        .slug("acme-api")
        .accessGroup(AccessGroup.builder().accessGroupSlug("acme-api").build())
        .build()
val registry = client.registry().createApiDocumentAccessGroup(params)

println(registry)
```

### Remove access group

Remove an access group from an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryDeleteApiDocumentAccessGroupParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/registry/RegistryDeleteApiDocumentAccessGroupParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.AccessGroup
import com.scalar.api.models.registry.RegistryDeleteApiDocumentAccessGroupParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RegistryDeleteApiDocumentAccessGroupParams.builder()
        .namespace("acme")
        .slug("acme-api")
        .accessGroup(AccessGroup.builder().accessGroupSlug("acme-api").build())
        .build()
val registry = client.registry().deleteApiDocumentAccessGroup(params)

println(registry)
```

## `Schemas`

Schemas

### List all shared components

List schemas in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`SchemaListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/SchemaListParams.kt) |
| Response | [`List<Schema>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/Schema.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.schemas.SchemaListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = SchemaListParams.builder().namespace("acme").build()
val schema = client.schemas().list(params)

println(schema)
```

### Create a shared component

Create a schema in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`SchemaCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/SchemaCreateParams.kt) |
| Response | [`Uid`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/Uid.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.schemas.SchemaCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    SchemaCreateParams.builder()
        .namespace("acme")
        .title("Customer")
        .version("1.2.0")
        .slug("customer")
        .document(
            "{\"type\":\"object\",\"properties\":{\"name\":{\"type\":\"string\",\"examples\":[\"Acme\"]}}}"
        )
        .build()
val schema = client.schemas().create(params)

println(schema)
```

### Update shared component metadata

Update schema metadata.

| Direction | Type |
| --- | --- |
| Request | [`SchemaUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/SchemaUpdateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.schemas.SchemaUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = SchemaUpdateParams.builder().namespace("acme").slug("customer").build()
val schema = client.schemas().update(params)

println(schema)
```

### Delete a shared component

Delete a schema and all related versions.

| Direction | Type |
| --- | --- |
| Request | [`SchemaDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/SchemaDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.schemas.SchemaDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = SchemaDeleteParams.builder().namespace("acme").slug("customer").build()
val schema = client.schemas().delete(params)

println(schema)
```

### `Schemas Version`

Schemas

#### Get a shared component document

Get a specific schema version document.

| Direction | Type |
| --- | --- |
| Request | [`VersionRetrieveParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/version/VersionRetrieveParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.schemas.version.VersionRetrieveParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    VersionRetrieveParams.builder().namespace("acme").slug("customer").semver("1.2.0").build()
val version = client.schemas().version().retrieve(params)

println(version)
```

#### Delete a shared component version

Delete a schema version.

| Direction | Type |
| --- | --- |
| Request | [`VersionDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/version/VersionDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.schemas.version.VersionDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    VersionDeleteParams.builder().namespace("acme").slug("customer").semver("1.2.0").build()
val version = client.schemas().version().delete(params)

println(version)
```

#### Create a shared component version

Create a schema version.

| Direction | Type |
| --- | --- |
| Request | [`VersionCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/version/VersionCreateParams.kt) |
| Response | [`VersionCreateResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/version/VersionCreateResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.schemas.version.VersionCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    VersionCreateParams.builder()
        .namespace("acme")
        .slug("customer")
        .version("1.2.0")
        .document(
            "{\"type\":\"object\",\"properties\":{\"name\":{\"type\":\"string\",\"examples\":[\"Acme\"]}}}"
        )
        .build()
val version = client.schemas().version().create(params)

println(version)
```

### `Schemas AccessGroup`

Schemas

#### Add shared component access group

Add an access group to a schema.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/accessGroup/AccessGroupCreateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.AccessGroup
import com.scalar.api.models.schemas.accessGroup.AccessGroupCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    AccessGroupCreateParams.builder()
        .namespace("acme")
        .slug("customer")
        .accessGroup(AccessGroup.builder().accessGroupSlug("acme-api").build())
        .build()
val accessGroup = client.schemas().accessGroup().create(params)

println(accessGroup)
```

#### Remove shared component access group

Remove an access group from a schema.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/schemas/accessGroup/AccessGroupDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.AccessGroup
import com.scalar.api.models.schemas.accessGroup.AccessGroupDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    AccessGroupDeleteParams.builder()
        .namespace("acme")
        .slug("customer")
        .accessGroup(AccessGroup.builder().accessGroupSlug("acme-api").build())
        .build()
val accessGroup = client.schemas().accessGroup().delete(params)

println(accessGroup)
```

## `LoginPortals`

Login Portals

### Get a login portal

Get a login portal by slug.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalRetrieveParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/loginPortals/LoginPortalRetrieveParams.kt) |
| Response | [`LoginPortalRetrieveResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/loginPortals/LoginPortalRetrieveResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.loginPortals.LoginPortalRetrieveParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = LoginPortalRetrieveParams.builder().slug("acme-login").build()
val loginPortal = client.loginPortals().retrieve(params)

println(loginPortal)
```

### Update portal metadata

Update metadata for a login portal.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/loginPortals/LoginPortalUpdateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.loginPortals.LoginPortalUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = LoginPortalUpdateParams.builder().slug("acme-login").build()
val loginPortal = client.loginPortals().update(params)

println(loginPortal)
```

### Delete a login portal

Delete a login portal.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/loginPortals/LoginPortalDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.loginPortals.LoginPortalDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = LoginPortalDeleteParams.builder().slug("acme-login").build()
val loginPortal = client.loginPortals().delete(params)

println(loginPortal)
```

### Create a portal

Create a login portal for the current team.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/loginPortals/LoginPortalCreateParams.kt) |
| Response | [`Uid`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/Uid.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.loginPortals.LoginPortalCreateParams
import com.scalar.api.models.loginPortals.LoginPortalEmail
import com.scalar.api.models.loginPortals.LoginPortalPage

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    LoginPortalCreateParams.builder()
        .title("Acme Private Documentation")
        .slug("acme-login")
        .email(
            LoginPortalEmail.builder()
                .logo("")
                .logoSize("100")
                .buttonText("Login")
                .message("Click to access private documentation hosted by scalar.com")
                .title("Private Docs")
                .mainColor("#2a2f45")
                .mainBackground("#f6f6f6")
                .cardColor("#2a2f45")
                .cardBackground("#fff")
                .buttonColor("#fff")
                .buttonBackground("#0f0f0f")
                .build()
        )
        .page(
            LoginPortalPage.builder()
                .title("Scalar Private Docs")
                .description("Login to access your documentation")
                .head("")
                .script("")
                .theme("")
                .companyName("")
                .logo("")
                .logoUrl("")
                .favicon("")
                .termsLink("")
                .privacyLink("")
                .formTitle("Scalar Private Docs")
                .formDescription("Login to access your documentation")
                .formImage("")
                .build()
        )
        .build()
val loginPortal = client.loginPortals().create(params)

println(loginPortal)
```

### List all portals

List all login portals for the current team.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/loginPortals/LoginPortalListParams.kt) |
| Response | [`List<LoginPortal>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/loginPortals/LoginPortal.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.loginPortals.LoginPortalListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val loginPortal = client.loginPortals().list(LoginPortalListParams.none())

println(loginPortal)
```

## `AccessGroups`

Access Groups

### Create an access group

Create a group for the current team. Requires docs edit permission and the access groups billing feature. Domains are exact email domains, without wildcards or implicit subdomain matching.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/AccessGroupCreateParams.kt) |
| Response | [`AccessGroupCreateResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/AccessGroupCreateResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.accessGroups.AccessGroupCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val accessGroup = client.accessGroups().create(AccessGroupCreateParams.none())

println(accessGroup)
```

### Get an access group

Get a group and its email and domain allowlists by slug.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupRetrieveParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/AccessGroupRetrieveParams.kt) |
| Response | [`AccessGroupRetrieveResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/AccessGroupRetrieveResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.accessGroups.AccessGroupRetrieveParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = AccessGroupRetrieveParams.builder().slug("acme-api").build()
val accessGroup = client.accessGroups().retrieve(params)

println(accessGroup)
```

### Update an access group

Update group metadata. Requires docs edit permission. After changing the slug, use the new slug in subsequent requests.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/AccessGroupUpdateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.accessGroups.AccessGroupUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = AccessGroupUpdateParams.builder().pathSlug("acme-api").build()
val accessGroup = client.accessGroups().update(params)

println(accessGroup)
```

### Delete an access group

Delete a group and remove its project assignments. Requires docs edit permission.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/AccessGroupDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.accessGroups.AccessGroupDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = AccessGroupDeleteParams.builder().slug("acme-api").build()
val accessGroup = client.accessGroups().delete(params)

println(accessGroup)
```

### `AccessGroups Domains`

Access Groups

#### Add an allowed email domain

Allow an exact email domain in a group. Requires docs edit permission. A group supports up to 1000 domains.

| Direction | Type |
| --- | --- |
| Request | [`DomainCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/domains/DomainCreateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.accessGroups.domains.DomainCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = DomainCreateParams.builder().slug("acme-api").domain("example.com").build()
val domain = client.accessGroups().domains().create(params)

println(domain)
```

#### Remove an allowed email domain

Remove an exact email domain from a group. Requires docs edit permission. Other allowed domains and emails are preserved.

| Direction | Type |
| --- | --- |
| Request | [`DomainDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/accessGroups/domains/DomainDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.accessGroups.domains.DomainDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = DomainDeleteParams.builder().slug("acme-api").domain("example.com").build()
val domain = client.accessGroups().domains().delete(params)

println(domain)
```

## `Rules`

Rules

### List all rules

List all rulesets in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`RuleListRulesetsParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/RuleListRulesetsParams.kt) |
| Response | [`List<Rule>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/Rule.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.rules.RuleListRulesetsParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = RuleListRulesetsParams.builder().namespace("acme").build()
val rule = client.rules().listRulesets(params)

println(rule)
```

### Create a rule

Create a rule in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`RuleCreateRulesetParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/RuleCreateRulesetParams.kt) |
| Response | [`Uid`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/Uid.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.rules.RuleCreateRulesetParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RuleCreateRulesetParams.builder()
        .namespace("acme")
        .title("Acme API Rules")
        .slug("acme-rules")
        .document("extends: [\"spectral:oas\"]\nrules:\n  info-contact: warn\n")
        .build()
val rule = client.rules().createRuleset(params)

println(rule)
```

### Update rule metadata

Update rule metadata by slug.

| Direction | Type |
| --- | --- |
| Request | [`RuleUpdateRulesetParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/RuleUpdateRulesetParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.rules.RuleUpdateRulesetParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = RuleUpdateRulesetParams.builder().pathNamespace("acme").pathSlug("acme-rules").build()
val rule = client.rules().updateRuleset(params)

println(rule)
```

### Delete a rule

Delete a rule by slug.

| Direction | Type |
| --- | --- |
| Request | [`RuleDeleteRulesetParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/RuleDeleteRulesetParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.rules.RuleDeleteRulesetParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = RuleDeleteRulesetParams.builder().namespace("acme").slug("acme-rules").build()
val rule = client.rules().deleteRuleset(params)

println(rule)
```

### Get a rule

Get a rule document by slug.

| Direction | Type |
| --- | --- |
| Request | [`RuleRetrieveRulesetDocumentParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/RuleRetrieveRulesetDocumentParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.rules.RuleRetrieveRulesetDocumentParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RuleRetrieveRulesetDocumentParams.builder().namespace("acme").slug("acme-rules").build()
val rule = client.rules().retrieveRulesetDocument(params)

println(rule)
```

### Add rule access group

Grant an access group to a rule.

| Direction | Type |
| --- | --- |
| Request | [`RuleCreateRulesetAccessGroupParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/RuleCreateRulesetAccessGroupParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.AccessGroup
import com.scalar.api.models.rules.RuleCreateRulesetAccessGroupParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RuleCreateRulesetAccessGroupParams.builder()
        .namespace("acme")
        .slug("acme-rules")
        .accessGroup(AccessGroup.builder().accessGroupSlug("acme-api").build())
        .build()
val rule = client.rules().createRulesetAccessGroup(params)

println(rule)
```

### Remove rule access group

Remove an access group from a rule.

| Direction | Type |
| --- | --- |
| Request | [`RuleDeleteRulesetAccessGroupParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/rules/RuleDeleteRulesetAccessGroupParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.registry.AccessGroup
import com.scalar.api.models.rules.RuleDeleteRulesetAccessGroupParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RuleDeleteRulesetAccessGroupParams.builder()
        .namespace("acme")
        .slug("acme-rules")
        .accessGroup(AccessGroup.builder().accessGroupSlug("acme-api").build())
        .build()
val rule = client.rules().deleteRulesetAccessGroup(params)

println(rule)
```

## `Themes`

Themes

### List all themes

List all team themes.

| Direction | Type |
| --- | --- |
| Request | [`ThemeListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/themes/ThemeListParams.kt) |
| Response | [`List<Theme>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/themes/Theme.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.themes.ThemeListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val theme = client.themes().list(ThemeListParams.none())

println(theme)
```

### Create a theme

Create a team theme.

| Direction | Type |
| --- | --- |
| Request | [`ThemeCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/themes/ThemeCreateParams.kt) |
| Response | [`Uid`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/Uid.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.themes.ThemeCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    ThemeCreateParams.builder()
        .name("Acme Theme")
        .slug("acme-theme")
        .document(":root { --scalar-color-1: #1f2937; }")
        .build()
val theme = client.themes().create(params)

println(theme)
```

### Update theme metadata

Update theme metadata.

| Direction | Type |
| --- | --- |
| Request | [`ThemeUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/themes/ThemeUpdateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.themes.ThemeUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ThemeUpdateParams.builder().slug("acme-theme").build()
val theme = client.themes().update(params)

println(theme)
```

### Update theme document

Replace the theme document.

| Direction | Type |
| --- | --- |
| Request | [`ThemeReplaceDocumentParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/themes/ThemeReplaceDocumentParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.themes.ThemeReplaceDocumentParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    ThemeReplaceDocumentParams.builder()
        .slug("acme-theme")
        .document(":root { --scalar-color-1: #1f2937; }")
        .build()
val theme = client.themes().replaceDocument(params)

println(theme)
```

### Delete a theme

Delete a theme by slug.

| Direction | Type |
| --- | --- |
| Request | [`ThemeDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/themes/ThemeDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.themes.ThemeDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ThemeDeleteParams.builder().slug("acme-theme").build()
val theme = client.themes().delete(params)

println(theme)
```

### Get a theme

Get the theme document by slug.

| Direction | Type |
| --- | --- |
| Request | [`ThemeRetrieveParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/themes/ThemeRetrieveParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.themes.ThemeRetrieveParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ThemeRetrieveParams.builder().slug("acme-theme").build()
val theme = client.themes().retrieve(params)

println(theme)
```

## `Teams`

Teams

### List teams

List all available teams

| Direction | Type |
| --- | --- |
| Request | [`TeamListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/TeamListParams.kt) |
| Response | [`List<Team>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/Team.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.teams.TeamListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val team = client.teams().list(TeamListParams.none())

println(team)
```

### `Teams Members`

Teams

#### List team members

List the members of the current team, along with the invites still outstanding.

| Direction | Type |
| --- | --- |
| Request | [`MemberListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/members/MemberListParams.kt) |
| Response | [`MemberListResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/members/MemberListResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.teams.members.MemberListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val member = client.teams().members().list(MemberListParams.none())

println(member)
```

#### Change a member role

Change what a member of the current team is allowed to do.

| Direction | Type |
| --- | --- |
| Request | [`MemberUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/members/MemberUpdateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.teams.invites.Role
import com.scalar.api.models.teams.members.MemberUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = MemberUpdateParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").role(Role.OWNER).build()
val member = client.teams().members().update(params)

println(member)
```

#### Remove a member

Remove someone from the current team.

| Direction | Type |
| --- | --- |
| Request | [`MemberDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/members/MemberDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.teams.members.MemberDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = MemberDeleteParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").build()
val member = client.teams().members().delete(params)

println(member)
```

### `Teams Invites`

Teams

#### Invite a member

Invite someone to the current team by email.

| Direction | Type |
| --- | --- |
| Request | [`InviteMemberParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/invites/InviteMemberParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.teams.invites.InviteMemberParams
import com.scalar.api.models.teams.invites.Role

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = InviteMemberParams.builder().email("alex@example.com").role(Role.OWNER).build()
val invite = client.teams().invites().member(params)

println(invite)
```

#### Resend an invite

Send the invite email again.

| Direction | Type |
| --- | --- |
| Request | [`InviteResendParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/invites/InviteResendParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.teams.invites.InviteResendParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = InviteResendParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").build()
val invite = client.teams().invites().resend(params)

println(invite)
```

#### Cancel an invite

Withdraw an invite that has not been accepted.

| Direction | Type |
| --- | --- |
| Request | [`InviteCancelParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/teams/invites/InviteCancelParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.teams.invites.InviteCancelParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = InviteCancelParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").build()
val invite = client.teams().invites().cancel(params)

println(invite)
```

## `ScalarDocs`

Scalar Docs

### List all projects

List all guide projects.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListGuidesParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListGuidesParams.kt) |
| Response | [`List<GithubProject>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/GithubProject.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocListGuidesParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val scalarDoc = client.scalarDocs().listGuides(ScalarDocListGuidesParams.none())

println(scalarDoc)
```

### Create a project

Create a guide project.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocCreateGuideParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocCreateGuideParams.kt) |
| Response | [`ScalarDocCreateGuideResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocCreateGuideResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocCreateGuideParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    ScalarDocCreateGuideParams.builder()
        .name("Acme Documentation")
        .isPrivate(false)
        .allowedUsers(emptyList<String>())
        .allowedDomains(emptyList<String>())
        .build()
val scalarDoc = client.scalarDocs().createGuide(params)

println(scalarDoc)
```

### Publish a project

Start a new publish process.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocPublishGuideParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocPublishGuideParams.kt) |
| Response | [`ScalarDocPublishGuideResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocPublishGuideResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocPublishGuideParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocPublishGuideParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().publishGuide(params)

println(scalarDoc)
```

### List all docs projects

List every docs project on the team.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectsParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectsParams.kt) |
| Response | [`ScalarDocListProjectsResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectsResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocListProjectsParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val scalarDoc = client.scalarDocs().listProjects(ScalarDocListProjectsParams.none())

println(scalarDoc)
```

### Create a docs project

Create a docs project. Omit `provider` to have Scalar host the repository.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocCreateProjectParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocCreateProjectParams.kt) |
| Response | [`DocsProject`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/DocsProject.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocCreateProjectParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    ScalarDocCreateProjectParams.builder()
        .name("Acme Documentation")
        .provider(ScalarDocCreateProjectParams.Provider.of("forgejo"))
        .build()
val scalarDoc = client.scalarDocs().createProject(params)

println(scalarDoc)
```

### Get a docs project

Get a single docs project by its slug.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocRetrieveProjectParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocRetrieveProjectParams.kt) |
| Response | [`DocsProject`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/DocsProject.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocRetrieveProjectParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocRetrieveProjectParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().retrieveProject(params)

println(scalarDoc)
```

### Update a docs project

Update project settings. Set `isPrivate` with `accessGroups` to put the site behind a login.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocUpdateProjectParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocUpdateProjectParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocUpdateProjectParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocUpdateProjectParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().updateProject(params)

println(scalarDoc)
```

### Delete a docs project

Delete a docs project, its deploys, its publish records and its cached builds.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocDeleteProjectParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocDeleteProjectParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocDeleteProjectParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocDeleteProjectParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().deleteProject(params)

println(scalarDoc)
```

### Publish a docs project

Start a build and deploy. The returned `publishUid` identifies the publish record.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocPublishProjectParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocPublishProjectParams.kt) |
| Response | [`ScalarDocPublishProjectResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocPublishProjectResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocPublishProjectParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocPublishProjectParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().publishProject(params)

println(scalarDoc)
```

### Read the site config

Read `scalar.config.json` straight from the project repository, without cloning it. `baseToken` is the compare-and-swap handle for a later write.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectConfigParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectConfigParams.kt) |
| Response | [`ScalarDocListProjectConfigResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectConfigResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocListProjectConfigParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocListProjectConfigParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().listProjectConfig(params)

println(scalarDoc)
```

### Write the site config

Commit `scalar.config.json` straight to the project repository. Pass the `baseToken` from the read this edit was based on; a conflict means the file moved underneath it.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocUpdateProjectConfigParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocUpdateProjectConfigParams.kt) |
| Response | [`ScalarDocUpdateProjectConfigResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocUpdateProjectConfigResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocUpdateProjectConfigParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    ScalarDocUpdateProjectConfigParams.builder()
        .slug("acme-docs")
        .content("{\"name\":\"Acme Documentation\"}")
        .build()
val scalarDoc = client.scalarDocs().updateProjectConfig(params)

println(scalarDoc)
```

### Get the site domains

The domains the project serves on — the Scalar-hosted one and the custom one, when set.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectDomainParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectDomainParams.kt) |
| Response | [`ScalarDocListProjectDomainResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectDomainResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocListProjectDomainParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocListProjectDomainParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().listProjectDomain(params)

println(scalarDoc)
```

### Check domain DNS

Whether the project custom domain points at Scalar yet. `expected` is the CNAME record to create; `found` is what resolves today. A project with no custom domain reports `verified` with no expected record, because Scalar serves its own subdomain directly.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectDomainStatusParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectDomainStatusParams.kt) |
| Response | [`ScalarDocListProjectDomainStatusResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/scalarDocs/ScalarDocListProjectDomainStatusResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.scalarDocs.ScalarDocListProjectDomainStatusParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ScalarDocListProjectDomainStatusParams.builder().slug("acme-docs").build()
val scalarDoc = client.scalarDocs().listProjectDomainStatus(params)

println(scalarDoc)
```

## `Namespaces`

Namespaces

### List namespaces

Get all namespaces for the current team

| Direction | Type |
| --- | --- |
| Request | [`NamespaceListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/namespaces/NamespaceListParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.namespaces.NamespaceListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val namespace = client.namespaces().list(NamespaceListParams.none())

println(namespace)
```

## `Authentication`

Authentication

### Exchange token

Exchange an API key for an access token.

| Direction | Type |
| --- | --- |
| Request | [`AuthenticationExchangePersonalTokenParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/authentication/AuthenticationExchangePersonalTokenParams.kt) |
| Response | [`AuthenticationExchangePersonalTokenResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/authentication/AuthenticationExchangePersonalTokenResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.authentication.AuthenticationExchangePersonalTokenParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    AuthenticationExchangePersonalTokenParams.builder()
        .personalToken("scalar_example_personal_token")
        .build()
val authentication = client.authentication().exchangePersonalToken(params)

println(authentication)
```

### Get current user

Get the authenticated user, including their available teams and theme.

| Direction | Type |
| --- | --- |
| Request | [`AuthenticationListCurrentUserParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/authentication/AuthenticationListCurrentUserParams.kt) |
| Response | [`User`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/authentication/User.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.authentication.AuthenticationListCurrentUserParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val authentication =
    client.authentication().listCurrentUser(AuthenticationListCurrentUserParams.none())

println(authentication)
```

## `Sdks`

SDKs

### List all SDKs

List every SDK on the team.

| Direction | Type |
| --- | --- |
| Request | [`SdkListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkListParams.kt) |
| Response | [`SdkListResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkListResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.SdkListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val sdk = client.sdks().list(SdkListParams.none())

println(sdk)
```

### Create an SDK

Create an SDK from an API document, targeting one or more languages.

| Direction | Type |
| --- | --- |
| Request | [`SdkCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkCreateParams.kt) |
| Response | [`Uid`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/Uid.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.SdkCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    SdkCreateParams.builder()
        .apiUid("UakgbKJ5m9gl0JDMbcJqL")
        .languages(listOf(SdkCreateParams.Language.of("typescript")))
        .build()
val sdk = client.sdks().create(params)

println(sdk)
```

### Get an SDK

Get a single SDK by its uid.

| Direction | Type |
| --- | --- |
| Request | [`SdkRetrieveParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkRetrieveParams.kt) |
| Response | [`Sdk`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/Sdk.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.SdkRetrieveParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = SdkRetrieveParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").build()
val sdk = client.sdks().retrieve(params)

println(sdk)
```

### Update an SDK

Update SDK metadata, its linked API, or its config.

| Direction | Type |
| --- | --- |
| Request | [`SdkUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkUpdateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.SdkUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = SdkUpdateParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").build()
val sdk = client.sdks().update(params)

println(sdk)
```

### Delete an SDK

Delete an SDK and every version it holds.

| Direction | Type |
| --- | --- |
| Request | [`SdkDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.SdkDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = SdkDeleteParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").build()
val sdk = client.sdks().delete(params)

println(sdk)
```

### Build an SDK

Start a build. Omit `version` to build the current work — the open draft, else the latest version — and the resolved version comes back in the response.

| Direction | Type |
| --- | --- |
| Request | [`SdkBuildParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkBuildParams.kt) |
| Response | [`SdkBuildResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/SdkBuildResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.SdkBuildParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = SdkBuildParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").build()
val sdk = client.sdks().build(params)

println(sdk)
```

### `Sdks Versions`

SDKs

#### Create an SDK version

Create a new SDK version against a specific API version.

| Direction | Type |
| --- | --- |
| Request | [`VersionCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/versions/VersionCreateParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.versions.VersionCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    VersionCreateParams.builder()
        .uid("UakgbKJ5m9gl0JDMbcJqL")
        .version("1.2.0")
        .apiVersion("1.2.0")
        .build()
val version = client.sdks().versions().create(params)

println(version)
```

#### Delete an SDK version

Permanently delete one version of an SDK.

| Direction | Type |
| --- | --- |
| Request | [`VersionDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/versions/VersionDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.versions.VersionDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = VersionDeleteParams.builder().uid("UakgbKJ5m9gl0JDMbcJqL").version("1.2.0").build()
val version = client.sdks().versions().delete(params)

println(version)
```

### `Sdks Repositories`

SDKs

#### Link a repository

Link one language target to a GitHub repository, so builds sync there.

| Direction | Type |
| --- | --- |
| Request | [`RepositoryLinkParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/repositories/RepositoryLinkParams.kt) |
| Response | [`RepositoryLinkResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/repositories/RepositoryLinkResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.repositories.RepositoryLinkParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RepositoryLinkParams.builder()
        .uid("UakgbKJ5m9gl0JDMbcJqL")
        .language(RepositoryLinkParams.Language.of("typescript"))
        .repositoryId(123456789L)
        .baseBranch("main")
        .build()
val repository = client.sdks().repositories().link(params)

println(repository)
```

#### Unlink a repository

Unlink one language target from its repository.

| Direction | Type |
| --- | --- |
| Request | [`RepositoryUnlinkParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/repositories/RepositoryUnlinkParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.repositories.RepositoryUnlinkParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RepositoryUnlinkParams.builder()
        .uid("UakgbKJ5m9gl0JDMbcJqL")
        .language(RepositoryUnlinkParams.Language.of("typescript"))
        .build()
val repository = client.sdks().repositories().unlink(params)

println(repository)
```

#### Update publishing settings

Toggle publish-on-merge and the release settings for a linked target.

| Direction | Type |
| --- | --- |
| Request | [`RepositoryUpdatePublishingParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/sdks/repositories/RepositoryUpdatePublishingParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.sdks.repositories.RepositoryUpdatePublishingParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    RepositoryUpdatePublishingParams.builder()
        .uid("UakgbKJ5m9gl0JDMbcJqL")
        .language(RepositoryUpdatePublishingParams.Language.of("typescript"))
        .publishOnMerge(true)
        .build()
val repository = client.sdks().repositories().updatePublishing(params)

println(repository)
```

## `Mcp`

### `Mcp Servers`

MCP

#### List all MCP servers

List every MCP server on the team.

| Direction | Type |
| --- | --- |
| Request | [`ServerListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/ServerListParams.kt) |
| Response | [`List<McpServer>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/McpServer.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.ServerListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val server = client.mcp().servers().list(ServerListParams.none())

println(server)
```

#### Create an MCP server

Create an MCP server over one or more API document versions. The response carries the server and its first installation.

| Direction | Type |
| --- | --- |
| Request | [`ServerCreateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/ServerCreateParams.kt) |
| Response | [`ServerCreateResponse`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/ServerCreateResponse.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.ServerCreateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ServerCreateParams.builder().name("Acme MCP").build()
val server = client.mcp().servers().create(params)

println(server)
```

#### Get an MCP server

Get a single MCP server by its id.

| Direction | Type |
| --- | --- |
| Request | [`ServerRetrieveParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/ServerRetrieveParams.kt) |
| Response | [`McpServer`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/McpServer.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.ServerRetrieveParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ServerRetrieveParams.builder().id("42").build()
val server = client.mcp().servers().retrieve(params)

println(server)
```

#### Update an MCP server

Update MCP server metadata and which tools it exposes.

| Direction | Type |
| --- | --- |
| Request | [`ServerUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/ServerUpdateParams.kt) |
| Response | [`McpServer`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/McpServer.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.ServerUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ServerUpdateParams.builder().id("42").build()
val server = client.mcp().servers().update(params)

println(server)
```

#### Delete an MCP server

Delete an MCP server and every installation it serves.

| Direction | Type |
| --- | --- |
| Request | [`ServerDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/ServerDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.ServerDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = ServerDeleteParams.builder().id("42").build()
val server = client.mcp().servers().delete(params)

println(server)
```

#### `Mcp Servers Installations`

MCP

##### List installations

List the installations of an MCP server. An installation is what an MCP client connects to.

| Direction | Type |
| --- | --- |
| Request | [`InstallationListParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/installations/InstallationListParams.kt) |
| Response | [`List<McpInstallationListItem>`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/installations/McpInstallationListItem.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.installations.InstallationListParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = InstallationListParams.builder().id("42").build()
val installation = client.mcp().servers().installations().list(params)

println(installation)
```

##### Get an installation

Get a single installation of an MCP server. Deprecated: address the environment by slug with the `/environments/:environment` form.

| Direction | Type |
| --- | --- |
| Request | [`InstallationRetrieveParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/installations/InstallationRetrieveParams.kt) |
| Response | [`McpInstallation`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/McpInstallation.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.installations.InstallationRetrieveParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = InstallationRetrieveParams.builder().id("42").installationId("84").build()
val installation = client.mcp().servers().installations().retrieve(params)

println(installation)
```

##### Update an installation

Update an installation. Deprecated: address the environment by slug with the `/environments/:environment` form.

| Direction | Type |
| --- | --- |
| Request | [`InstallationUpdateParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/installations/InstallationUpdateParams.kt) |
| Response | [`McpInstallation`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/McpInstallation.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.installations.InstallationUpdateParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = InstallationUpdateParams.builder().id("42").installationId("84").build()
val installation = client.mcp().servers().installations().update(params)

println(installation)
```

##### Delete an installation

Delete an installation of an MCP server. Deprecated: address the environment by slug with the `/environments/:environment` form.

| Direction | Type |
| --- | --- |
| Request | [`InstallationDeleteParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/installations/InstallationDeleteParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.installations.InstallationDeleteParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params = InstallationDeleteParams.builder().id("42").installationId("84").build()
val installation = client.mcp().servers().installations().delete(params)

println(installation)
```

##### Add an access group

Let an access group reach a private installation. Requires a team admin. Deprecated: address the environment by slug with the `/environments/:environment` form.

| Direction | Type |
| --- | --- |
| Request | [`InstallationCreateAccessGroupParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/installations/InstallationCreateAccessGroupParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.installations.InstallationCreateAccessGroupParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    InstallationCreateAccessGroupParams.builder()
        .id("42")
        .installationId("84")
        .accessGroupUid("UakgbKJ5m9gl0JDMbcJqL")
        .build()
val installation = client.mcp().servers().installations().createAccessGroup(params)

println(installation)
```

##### Remove an access group

Stop an access group reaching a private installation. Requires a team admin. Deprecated: address the environment by slug with the `/environments/:environment` form.

| Direction | Type |
| --- | --- |
| Request | [`InstallationDeleteAccessGroupParams`](./scalar-kotlin-core/src/main/kotlin/com/scalar/api/models/mcp/servers/installations/InstallationDeleteAccessGroupParams.kt) |

```kotlin
import com.scalar.api.client.ScalarClient
import com.scalar.api.client.okhttp.ScalarOkHttpClient
import com.scalar.api.models.mcp.servers.installations.InstallationDeleteAccessGroupParams

val client: ScalarClient =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build()

val params =
    InstallationDeleteAccessGroupParams.builder()
        .id("42")
        .installationId("84")
        .accessGroupUid("UakgbKJ5m9gl0JDMbcJqL")
        .build()
val installation = client.mcp().servers().installations().deleteAccessGroup(params)

println(installation)
```
