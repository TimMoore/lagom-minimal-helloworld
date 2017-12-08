:: From https://play2-maven-plugin.github.io/play2-maven-plugin/1.0.0-rc1/custom-distribution.html
set scriptdir=%~dp0
set basedir=%scriptdir%\..
set classpath=%basedir%/lib/*
java %* -cp "%classpath%" play.core.server.ProdServerStart %basedir%
