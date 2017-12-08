# Lagom Minimal "Hello, world"

The simplest thing that could possibly work: a service with a single call

## Running locally

1.  Ensure you have Java 8 and Maven 3.3.1 or later installed.
2.  Clone this project:
    ```
    git clone https://github.com/TimMoore/lagom-minimal-helloworld.git
    ```
3.  Enter the directory:
    ```
    cd lagom-minimal-helloworld
    ```
4.  Start the Lagom development environment:
    ```
    mvn lagom:runAll
    ```
5.  Wait until you see these lines in the console:
    ```
    17:38:37.264 [info] play.api.Play [] - Application started (Dev)
    [INFO] Service hello-impl listening for HTTP on 0:0:0:0:0:0:0:0:57797
    [INFO] (Service started, press enter to stop and go back to the console...)
    ```
4.  Open a new terminal tab and use `curl` to exercise the service:
    ```
    $ curl http://localhost:9000/hello/Alice
    Hello, Alice!
    $ curl http://localhost:9000/hello/Bob
    Hello, Bob!
    $ curl http://localhost:9000/hello/Carol
    Hello, Carol!

    ```

    The names aren't hard-coded, you can use anything you want in the last URL component.

    You can also test it in your web browser with the same URL pattern.

5.  In the first terminal, press `enter` to exit the Lagom development environment.

## Running tests

```
mvn test
```

This runs `HelloServiceTest` using JUnit.

## Packaging for deployment

```
mvn package
```

This creates a zip file at `hello-impl/target/hello-impl-1.0-SNAPSHOT-production-dist.zip`.

## Running in production mode

```
$ cd /tmp # or anywhere
$ unzip lagom-minimal-helloworld/hello-impl/target/hello-impl-1.0-SNAPSHOT-production-dist.zip # using the path to the directory where you cloned the project
cd hello
$ bin/start -Dplay.http.secret.key=xxxxx # you can set this value to whatever you want... Play requires it but Lagom doesn't use it
$ curl http://localhost:9000/hello/World
Hello, World!
# Interact with it as much as you want, then...
bin/stop # shut down the running server
```

### Note on production mode `ServiceLocator`

Lagom requires a `ServiceLocator` to be specified in production, but in this service it is never used.

This is handled in `ConfigurationServiceLocatorModule`, where it binds a `ConfigurationServiceLocator`. This implementation reads service locations from `application.conf`, but since this service does not communicate externally, no services need to be configured.

See [Lagom Production Overview](https://www.lagomframework.com/documentation/1.4.x/java/ProductionOverview.html) for details.
