set SERVICE_NAME=SampleServiceCaner
set PR_INSTALL=C:\Caner\ia64\prunsrv.exe
set PACKAGE_NAME=com.csinc.caner.windowsservice.SampleService
 
REM Service log configuration
set PR_LOGPREFIX=%SERVICE_NAME%
set PR_LOGPATH=c:\logs
set PR_STDOUTPUT=c:\logs\stdout.txt
set PR_STDERROR=c:\logs\stderr.txt
set PR_LOGLEVEL=Error
 
REM Path to java installation
set PR_JVM=C:\Program Files\Java\jre1.8.0_131\bin\server\jvm.dll
set PR_CLASSPATH=C:\Caner\SampleService.jar
 
REM Startup configuration
set PR_STARTUP=auto
set PR_STARTMODE=jvm
set PR_STARTCLASS=com.csinc.caner.windowsservice.SampleService
set PR_STARTMETHOD=start
 
REM Shutdown configuration
set PR_STOPMODE=jvm
set PR_STOPCLASS=com.csinc.caner.windowsservice.SampleService
set PR_STOPMETHOD=stop
 
REM JVM configuration
set PR_JVMMS=256
set PR_JVMMX=1024
set PR_JVMSS=4000
set PR_JVMOPTIONS=-Duser.language=DE;-Duser.region=de
 
REM Install service
prunsrv.exe //IS//%SERVICE_NAME%
