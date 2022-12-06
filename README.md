# Academy TA

**Docente:** Fabio Ziviello

**Version Academy TA :** 1.0

**Version ReadMe:** 1.0

### Lanciare TestSuite da MAVEN
 Creare file .xml nella cartella xml
 mvn test -Dsuite.name="fileName"
 mvn test -Dgroups="web"

### Generazione Report
 Creare la cartella testreportdir

`npm install`

`node generate_report.js`

### MAC ENV VARIABLE
nano ~/.bash_profile

nano ~/.zshrc

**SAVE IN TO FILE**:

export ANDROID_HOME=/Users/"NOME_UTENTE"/Library/Android/sdk/

export PATH=$ANDROID_HOME/platform-tools:$PATH

export PATH=$ANDROID_HOME/tools:$PATH

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home

export PATH=$JAVA_HOME/bin:$PATH

### LINK UTILI
- Link ChromeDriver      :  `https://chromedriver.storage.googleapis.com/index.html`
- Link GeckoDriver       :  `https://github.com/mozilla/geckodriver/releases`
- Link IEDriver          :  `https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver`
- Link JSON to JavaClass :  `http://www.jsonschema2pojo.org`
- Lin SonarCuber         :   `https://www.sonarqube.org`
