# ScriptEngine

Script Engine based on the [FlowScript](http://github.com/carldata/flow-script).

Provides REST API for executing scripts
 
## Running the server
 
 ```bash
sbt assembly
java -jar target/scala-2.12/script-engine-assembly-0.1.0.jar 
docker build -t script-engine:0.1.0 .
docker run -p 8080:8080 script-engine:0.1.0
 ```
 
In separate terminal execute function:

```bash
curl -H "Content-Type: application/json" -X POST -d '{"function":"Test1.main","x":23}' http://localhost:8080/api/execute
```

This should return (Check script 'scripts/Test1.fs' for the details):

```bash
{result: 23}
```

## Installing flow-script dependencies

Since FlowScript is not yet published to the external repository, it is necessary to publish flow-script project 
to the local repository with the command (do it inside the flow-script project)
 
```bash
sbt publish-local
```

# Join in!

We are happy to receive bug reports, fixes, documentation enhancements,
and other improvements.

Please report bugs via the
[github issue tracker](http://github.com/carldata/script-engine/issues).



# Redistributing

Script Engine source code is distributed under the Apache-2.0 license.

**Contributions**

Unless you explicitly state otherwise, any contribution intentionally submitted
for inclusion in the work by you, as defined in the Apache-2.0 license, shall be
licensed as above, without any additional terms or conditions.