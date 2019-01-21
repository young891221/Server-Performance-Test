# Server Framework Benchmark
Server Frameworks performance test using `wrk`. You can test other benchmark tool.

### Netty
```bash
Running 10s test @ http://127.0.0.1:8080
  10 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     8.53ms   13.14ms 251.05ms   93.27%
    Req/Sec     6.64k     1.75k   43.49k    87.49%
  655954 requests in 10.10s, 62.56MB read
  Socket errors: connect 0, read 532, write 0, timeout 0
Requests/sec:  64937.55
Transfer/sec:      6.19MB
```

```bash
Running 10s test @ http://127.0.0.1:8080
  5 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     7.42ms   12.39ms 257.04ms   94.46%
    Req/Sec    15.39k     4.84k   72.86k    85.05%
  761819 requests in 10.08s, 72.65MB read
  Socket errors: connect 0, read 511, write 1, timeout 0
Requests/sec:  75561.34
Transfer/sec:      7.21MB
```

### armeria(worker = 16)
```bash
Running 10s test @ http://127.0.0.1:8080
  10 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    54.52ms   86.27ms 645.25ms   84.52%
    Req/Sec     6.30k     4.87k   48.60k    81.97%
  602525 requests in 10.08s, 53.44MB read
  Socket errors: connect 0, read 272, write 0, timeout 0
Requests/sec:  59799.41
Transfer/sec:      5.30MB
```

```bash
Running 10s test @ http://127.0.0.1:8080
  5 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    38.65ms   64.12ms 563.87ms   85.54%
    Req/Sec    13.01k    12.42k   68.54k    79.33%
  613855 requests in 10.10s, 54.44MB read
  Socket errors: connect 0, read 370, write 0, timeout 0
Requests/sec:  60798.65
Transfer/sec:      5.39MB
```

### vertx
```bash
Running 10s test @ http://127.0.0.1:8080
  10 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.46ms    2.21ms  54.81ms   80.59%
    Req/Sec     7.08k     0.99k    9.30k    84.10%
  704981 requests in 10.08s, 55.13MB read
  Socket errors: connect 0, read 410, write 0, timeout 0
Requests/sec:  69936.25
Transfer/sec:      5.47MB
```

```bash
Running 10s test @ http://127.0.0.1:8080
  5 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.23ms    1.96ms  51.32ms   88.49%
    Req/Sec    15.22k     1.97k   20.19k    88.38%
  756694 requests in 10.10s, 59.17MB read
  Socket errors: connect 0, read 328, write 0, timeout 0
Requests/sec:  74903.29
Transfer/sec:      5.86MB
```

### spring boot undertow(worker = 200)
```bash
Running 10s test @ http://127.0.0.1:8080
  10 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    25.06ms   36.06ms 377.58ms   88.40%
    Req/Sec     3.00k     0.85k    9.53k    81.14%
  295578 requests in 10.09s, 43.41MB read
  Socket errors: connect 0, read 375, write 0, timeout 0
Requests/sec:  29302.00
Transfer/sec:      4.30MB
```

```bash
Running 10s test @ http://127.0.0.1:8080
  5 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    39.10ms   67.70ms 496.82ms   86.02%
    Req/Sec     6.91k     6.56k   30.56k    83.51%
  292281 requests in 10.07s, 42.93MB read
  Socket errors: connect 0, read 379, write 0, timeout 0
Requests/sec:  29015.60
Transfer/sec:      4.26MB
```

### webflux(worker = 8)
```bash
Running 10s test @ http://127.0.0.1:8080
  10 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    45.98ms  154.04ms   2.00s    96.63%
    Req/Sec     1.93k   343.93     3.26k    83.50%
  191662 requests in 10.08s, 16.82MB read
  Socket errors: connect 0, read 470, write 0, timeout 61
Requests/sec:  19013.30
Transfer/sec:      1.67MB

```

```bash
Running 10s test @ http://127.0.0.1:8080
  5 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    52.54ms  155.69ms   1.99s    96.45%
    Req/Sec     3.33k     0.91k    4.89k    76.60%
  165644 requests in 10.08s, 14.53MB read
  Socket errors: connect 0, read 448, write 0, timeout 71
Requests/sec:  16425.25
Transfer/sec:      1.44MB

```