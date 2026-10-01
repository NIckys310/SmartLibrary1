# SmartLibrary

Java console application demonstrating users, books, copies, loans, and renewals.

## Requirements
- Java JDK 8 or newer.

## Compile
From the project root:

```bash
javac -d out Main.java $(find src -name "*.java")
```

On Windows PowerShell:

```powershell
javac -d out Main.java (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName })
```

## Run

```bash
java -cp out smartlibrary.Main
```
