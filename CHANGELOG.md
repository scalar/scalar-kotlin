# Changelog

## [0.2.0](https://github.com/scalar/scalar-kotlin/compare/v0.1.0...v0.2.0) (2026-11-13)


### ⚠ BREAKING CHANGES

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


### Chores

* **api:** regenerate SDK ([ffc5123](https://github.com/scalar/scalar-kotlin/commit/ffc51231165c35a8a83dcff1c4beb4a84d2bb12e))
* **api:** regenerate SDK ([6a4f2cc](https://github.com/scalar/scalar-kotlin/commit/6a4f2cc33695647fbfbcfa58f554d85841a8d88f))
