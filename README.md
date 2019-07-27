# cljol-jvm-support

A Java library that is only a small modification from 4 of the classes
in the [Java Object
Layout](https://openjdk.java.net/projects/code-tools/jol) (JOL)
library, intended to support slightly more accurate Java object
walking than JOL.

## Usage

Currently this small library is only deployed in order to use it
within the Clojure [`cljol`
tool](https://github.com/jafingerhut/cljol).  Its API is expected to
change without warning across versions, based upon whatever seems
useful when using it within `cljol`.


## Development step reminder notes

Build:
```bash
$ lein jar
```

Install locally:
```bash
$ lein install
```

Deploy to Clojars.org:
```bash
$ lein deploy clojars
```

## License

Copyright © 2019 Aleksey Shipilev, Andy Fingerhut

The GNU General Public License (GPL) Version 2, June 1991
