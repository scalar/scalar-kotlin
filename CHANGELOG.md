# Changelog

## [0.2.0](https://github.com/scalar/scalar-kotlin/compare/v0.1.0...v0.2.0) (2026-11-25)


### ⚠ BREAKING CHANGES

* **api:** request-shape post /v1/sdks body.languages — required in before only (review: direction-dependent; read the hunk)
* **api:** 27 breaking changes to the SDK surface.
    - operation-coverage delete /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage delete /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage delete /v1/mcp/servers/{}/installations/{}/access-group — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{}/installations — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage patch /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage patch /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage post /v1/mcp/servers/{}/installations/{}/access-group — operation only in before (breaking: the new snapshot no longer has it)
    - response-shape get /v1/mcp/servers→[].createdAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape get /v1/mcp/servers→[].updatedAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape get /v1/mcp/servers→[].id — field only in before (breaking: removed; uid, domain, namespace (and 1 more) appeared in its place, likely a rename)
    - response-shape post /v1/mcp/servers→.server.createdAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape post /v1/mcp/servers→.server.updatedAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape post /v1/mcp/servers→.server.id — field only in before (breaking: removed; uid, domain, namespace appeared in its place, likely a rename)
    - response-shape post /v1/mcp/servers→.installation — field only in before (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/McpInstallation.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerDeleteParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerRetrieveParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerUpdateParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/installations/InstallationCreateAccessGroupParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationDeleteAccessGroupParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationDeleteParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationListParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationRetrieveParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationUpdateParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/McpInstallationListItem.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
* **api:** 9 breaking changes to the SDK surface.
    - Added required property `sdk.current`.
    - Property `sdk.currentVersion` type changed from `version` to `string`.
    - Added required property `sdk.latestVersion`.
    - Removed optional property `sdk.apiVersion`.
    - Property `sdk_version.version` type changed from `version` to `string`.
    - Property `sdk_version.createdAt` is now required.
    - Removed required property `sdk_version.apiVersion`.
    - Removed required property `sdk_version.status`.
    - Removed optional property `sdk_version.publishedAt`.
* **api:** Added required property `github_project.chatInsightsEnabled`.

### Features

* **api:** add property github_project.chatInsightsEnabled ([1e51bb0](https://github.com/scalar/scalar-kotlin/commit/1e51bb065c88d85b09c28be82c65f9da8bd839f4))
* **api:** add property sdk.current (+9 more changes) ([d05adcf](https://github.com/scalar/scalar-kotlin/commit/d05adcfa4a64ae06da6c5529171c2790e9b45f62))
* **api:** initial SDK generation ([541ea93](https://github.com/scalar/scalar-kotlin/commit/541ea9362dc289ba323950f433078c30347891be))
* **api:** update SDK surface (2 changes) ([e60ce5a](https://github.com/scalar/scalar-kotlin/commit/e60ce5a2b22b7b98aa47cd8a84ab60cef53944e7))
* **api:** update SDK surface (3 changes) ([c71035f](https://github.com/scalar/scalar-kotlin/commit/c71035f6e9051808aed193a527d3343db6f58476))
* **api:** update SDK surface (35 changes) ([acfec85](https://github.com/scalar/scalar-kotlin/commit/acfec85caf9333e7c5c2fafbe7bb433fc6b3d735))


### Chores

* **api:** regenerate SDK ([eec85ab](https://github.com/scalar/scalar-kotlin/commit/eec85abb81e47ac69f4ebe518bc97eb901788dfd))
* **api:** regenerate SDK ([ffc5123](https://github.com/scalar/scalar-kotlin/commit/ffc51231165c35a8a83dcff1c4beb4a84d2bb12e))
* **api:** regenerate SDK ([6a4f2cc](https://github.com/scalar/scalar-kotlin/commit/6a4f2cc33695647fbfbcfa58f554d85841a8d88f))
* **api:** update generated SDK content ([b097f7c](https://github.com/scalar/scalar-kotlin/commit/b097f7cf6dcfa1e6320d8425890f9c06073497cf))
