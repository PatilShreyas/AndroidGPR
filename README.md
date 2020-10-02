# Android Library - Release with _Github Package Registry_ 

- Demonstration of deploying Android library to the GitHub Package Registry using GitHub Actions CI/CD.
- In this example, whenever git tag is pushed to the GitHub branch then automatically library is published to the GitHub package registry and GitHub release is created (in draft mode).

## Workflow

Refer [`release.yml`](/.github/workflows/release.yml) workflow which is GitHub Actions workflow for publishing package and creating draft release.
 
## Library configuration

```gradle
...
apply plugin: 'maven-publish'  // 1. Apply plugin

// 2. Declare library details
ext {
    mGroupId = "com.example"
    mArtifactId = "simple-library"
    mVersionCode = 1
    mVersionName = "0.2.0"

    mLibraryName = "SimpleLibrary"
    mLibraryDescription = "Simple Library for simple things!"
}

android {...}

dependencies {...}


// 3. Declare task for creation of android sources.
task androidSourcesJar(type: Jar) {
    archiveClassifier.set('sources')
    from android.sourceSets.main.java.srcDirs
}

// 4. Make configuration for publishing artifact.
afterEvaluate {
    publishing {
        publications {
            maven(MavenPublication) {
                groupId mGroupId
                artifactId mArtifactId
                version mVersionName

                from components.release

                artifact androidSourcesJar

                pom {
                    name = mLibraryName
                    description = mLibraryDescription
                }
            }
        }

        // 5. Update repository details and credentials.
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/PatilShreyas/AndroidGPR")
                credentials {
                    username = System.getenv("GPR_USER")
                    password = System.getenv("GPR_KEY")
                }
            }
        }
    }
}

// Assembling should be performed before publishing package
publish.dependsOn assemble
```
