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


## Compile and Run (Example: SingleThreaded Server)

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
```


## 📈 Load Testing with JMeter

The server was load-tested using [Apache JMeter](https://jmeter.apache.org/) to simulate high-concurrency client traffic.

### 🔧 Test Setup
- **Tool:** Apache JMeter (TCP Sampler)
- **Load:** Simulated up to 300,000 requests per minute (~5,000 req/sec)
- **Environment:** Local machine, single server instance
- **Tests Conducted On:**
  - Basic multithreaded server (new thread per connection)
  - Thread pool-based server using `ExecutorService`

### 📊 Results Comparison

| Metric                     | Basic Multithreaded | Thread Pool Version |
|----------------------------|---------------------|----------------------|
| **Avg Response Time**      | 3605 ms             | **1880 ms** ✅        |
| **Error Rate**             | 12.34%              | **6.09%** ✅          |
| **Max Throughput**         | **~735 req/sec**    | ~650 req/sec         |
| **Total Samples**          | 21,823              | 18,656               |

> ✅ The thread pool server reduced error rate by ~50% and cut average response time in half, demonstrating improved stability and scalability under heavy load.