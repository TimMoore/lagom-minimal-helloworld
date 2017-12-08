:: From https://play2-maven-plugin.github.io/play2-maven-plugin/1.0.0-rc1/custom-distribution.html
set /p pid=< RUNNING_PID
taskkill /F /PID %pid%
del RUNNING_PID
