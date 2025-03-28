# Java Web Server Implementations

This repository includes three Java-based web server implementations:

1. **Single-Threaded**
2. **Multi-Threaded**
3. **Thread-Pooled** (Fixed Thread Pool)

Each version demonstrates a different approach to handling client connections—from basic blocking I/O to concurrent processing using threads and thread pools.

## 🚀 How to Run

All servers listen on **port `8010`**. Make sure you compile and run the files from their respective directories, or set your classpaths accordingly.

### ✅ Prerequisites

- Java 11 or higher
- A terminal or a Java-compatible IDE (e.g., VS Code, IntelliJ)


## 🛠️ Compile and Run (Example: SingleThreaded Server)

```bash
# Compile
cd SingleThreaded
javac Server.java
javac Client.java

# Run
# In one terminal
java Server

# In another terminal
java Client