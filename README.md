# Reproduction for issue with ScalaTest run duration with concurrentRestrictions

This repo provides a reproduction for an issue that arises when multiple
projects run ScalaTest tests in parallel and there are concurrent restrictions
on test. The run duration reported by ScalaTest will be wrong.

To reproduce, run `test` in sbt, and see in the console:

    sbt:sbt-concurrent-restrictions-test> test
    [info] Hello:
    [info] hello
    [info] - should hello (1 second, 2 milliseconds)
    [info] World:
    [info] world
    [info] - should world (3 seconds, 6 milliseconds)
    [info] Run completed in 4 seconds, 123 milliseconds.
    [info] Total number of tests run: 1
    [info] Suites: completed 1, aborted 0
    [info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0
    [info] All tests passed.
    [info] Run completed in 4 seconds, 124 milliseconds.
    [info] Total number of tests run: 1
    [info] Suites: completed 1, aborted 0
    [info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0
    [info] All tests passed.
    [success] Total time: 4 s, completed 11 Mar 2024, 14:28:21

Clearly, the test runs should have taken respectively 1 and 3 seconds,
not 4.
