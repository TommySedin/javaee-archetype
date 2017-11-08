# javaee-archetype

Klona detta repo, kör sedan dessa:

```
cd javaee-archetype
mvn clean install
cd <ditt workspace>
mvn archetype:generate -DarchetypeGroupId=se.adopi.edu -DarchetypeArtifactId=javaee-archetype -DarchetypeVersion=1.0 -DgroupId=<ditt groupId> -DartifactId=<ditt artifactId>
```

Du får ett par felmeddelanden som dessa. Inte kommit på vad de beror på än, men verkar funka ändå:
```
[WARNING] Archetype not found in any catalog. Falling back to central repository.
[WARNING] Don't override file
```

