# ScriptEngine

[![Build status](https://travis-ci.org/carldata/script-engine.svg?branch=master)](https://travis-ci.org/carldata/script-engine)

Script Engine based on the [FlowScript](http://github.com/carldata/flow-script).

Provides REST API for executing scripts
 
## Running server
 
 ```bash
 sbt run
 ```
 
Example function execution:

```bash
curl -H "Content-Type: application/json" -X POST -d '{"function":"Test1.main","x":23}' http://localhost:8080/api/execute
```

This should return (Check script 'scripts/Test1.fs' for the details):

```bash
{result: 23}
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