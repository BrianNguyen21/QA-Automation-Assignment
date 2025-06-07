# PowerShell script to download required JAR dependencies
Write-Host "Downloading required JAR dependencies..." -ForegroundColor Green

# Create lib directory
New-Item -ItemType Directory -Force -Path "lib"

# Download URLs
$seleniumUrl = "https://repo1.maven.org/maven2/org/seleniumhq/selenium/selenium-java/4.11.0/selenium-java-4.11.0.jar"
$testngUrl = "https://repo1.maven.org/maven2/org/testng/testng/7.8.0/testng-7.8.0.jar"
$webdriverManagerUrl = "https://repo1.maven.org/maven2/io/github/bonigarcia/webdrivermanager/5.4.1/webdrivermanager-5.4.1.jar"
$commonsLangUrl = "https://repo1.maven.org/maven2/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar"

# Download JARs
Write-Host "Downloading Selenium..." -ForegroundColor Yellow
Invoke-WebRequest -Uri $seleniumUrl -OutFile "lib/selenium-java-4.11.0.jar"

Write-Host "Downloading TestNG..." -ForegroundColor Yellow
Invoke-WebRequest -Uri $testngUrl -OutFile "lib/testng-7.8.0.jar"

Write-Host "Downloading WebDriverManager..." -ForegroundColor Yellow
Invoke-WebRequest -Uri $webdriverManagerUrl -OutFile "lib/webdrivermanager-5.4.1.jar"

Write-Host "Downloading Commons Lang..." -ForegroundColor Yellow
Invoke-WebRequest -Uri $commonsLangUrl -OutFile "lib/commons-lang3-3.12.0.jar"

Write-Host "Dependencies downloaded successfully!" -ForegroundColor Green
Write-Host "JARs are in the 'lib' folder" -ForegroundColor Cyan 